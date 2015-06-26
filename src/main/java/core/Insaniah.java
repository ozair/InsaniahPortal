package core;

import com.insaniah.URLConstants;
import com.insaniah.UnsuccessfulLoginException;
import core.InsaniahConnection;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.nodes.Document;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by LEO on 6/9/15.'
 * Use this class for deskotp application
 */
public class Insaniah implements URLConstants, InsaniahConnection{
    private String userName,
            password;
    private boolean loggedInStatus = true;
    private CloseableHttpClient client;
    private CloseableHttpResponse response;
    private HttpGet getMethod;
    private HttpPost postMethod;

    /**
     * Construct Insaniah class
     * @param userName  the matrix no of the student
     * @param password  the password of the student
     */
    public Insaniah(String userName, String password) {
        this.userName = userName;
        this.password = password;
        client = HttpClients.createDefault();
    }

    /**
     * Login using the userName and password and return true if successfully logged in, otherwise false
     *
     * @return true if successfully logged in
     */
    public boolean login() {
        try {
            HttpPost post = new HttpPost(BASE_URL);
            List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
            params.add(new BasicNameValuePair("txtMatric", userName));
            params.add(new BasicNameValuePair("txtPwd", password));
            params.add(new BasicNameValuePair("btnLogin", "Login"));
            post.setEntity(new UrlEncodedFormEntity(params));
            client.execute(post);

            _checkLogedin();
        } catch (IOException e) {
            throw new UnsuccessfulLoginException("Login error!");
        }
        return loggedInStatus;

    }

    private void _checkLogedin() throws IOException {

        Document doc = getDoc(URLConstants.CHECK_LOGIN);
        String ans = doc.body().getElementsByTag("table").get(2).getElementsByTag("td").get(0).text();
        String checkedString = "USER : "+ userName;

        if (ans.equalsIgnoreCase(checkedString))
            loggedInStatus = true;
        else
            loggedInStatus = false;

    }

    /**
     * Logout from the account
     * @throws IOException
     */
    public void logOut() throws IOException  {
        client.close();
        loggedInStatus = false;
    }

    public CloseableHttpClient getClient(){
        return client;
    }

    /**
     * Check the status of login
     * @return true if it is already logged in, otherwise false
     */
    public boolean getLoggedInStatus(){
        return loggedInStatus;
    }

    public Document getDoc(String URL) throws IOException {
        HttpGet get = new HttpGet(URL);
        response = client.execute(get);

        //getting html as a long string
        HttpEntity entity = response.getEntity();
        String resString = EntityUtils.toString(entity, "UTF-8");

        //parse html using jsoup
        //try to get matric number after login
        org.jsoup.parser.Parser p = org.jsoup.parser.Parser.htmlParser();
        Document doc = p.parseInput(resString, "");

        return doc;
    }


}
