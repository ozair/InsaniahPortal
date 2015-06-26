package core;

import com.insaniah.URLConstants;
import org.jsoup.nodes.Document;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by LEO on 6/26/15.
 * Use this class for android application
 */
public class InsaniahUrlConnection implements InsaniahConnection {

    //3 params to login
    private final String userName;
    private final String password;
    private String btnLoginValue = "Login";

    boolean loggedInStatus = false;

    public List<String> cookies;
    private HttpURLConnection connection;

    public InsaniahUrlConnection(String userName, String password) {
        this.userName = userName;
        this.password = password;

    }


    public boolean login() throws IOException {

        String charset = "UTF-8";


        String parameter = String.format("txtMatric=%s&txtPwd=%s&btnLogin=%s", URLEncoder.encode(userName, charset),
                URLEncoder.encode(password, charset),
                URLEncoder.encode(btnLoginValue, charset));

        URL url = new URL("http://ecampus.insaniah.edu.my/portal/login.php");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestProperty("Accept-Charset", charset);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        OutputStream outputStream = connection.getOutputStream();
        outputStream.write(parameter.getBytes(charset));
        cookies = connection.getHeaderFields().get("Set-Cookie");

        _checkLogin();

        return loggedInStatus;
    }


    private void _checkLogin() throws IOException {
        Document doc = getDoc(URLConstants.CHECK_LOGIN);
        String ans = doc.body().getElementsByTag("table").get(2).getElementsByTag("td").get(0).text();
        String checkedString = "USER : "+ userName;

        if (ans.equalsIgnoreCase(checkedString))
            loggedInStatus = true;
        else
            loggedInStatus = false;
    }


    public Document getDoc(String url) throws IOException {
        connection = (HttpURLConnection) new URL(url).openConnection();

        for (String cookie : cookies) {
            connection.addRequestProperty("Cookie", cookie.split(";", 2)[0]);

        }


        StringBuilder stringBuilder = new StringBuilder();
        String lines;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        while ((lines = bufferedReader.readLine()) != null) {
            stringBuilder.append(lines + "\n");
        }

        org.jsoup.parser.Parser p = org.jsoup.parser.Parser.htmlParser();
        Document doc = p.parseInput(stringBuilder.toString(), "");
        if (bufferedReader != null)
            bufferedReader.close();
        return doc;
    }


}
