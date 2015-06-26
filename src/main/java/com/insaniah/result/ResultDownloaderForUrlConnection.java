package com.insaniah.result;

import com.insaniah.URLConstants;
import core.InsaniahUrlConnection;
import org.jsoup.nodes.Document;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LEO on 6/26/15.
 */
public class ResultDownloaderForUrlConnection {

    List<String> cookies;


    private int numOfSem;
    private final String result = "DOWNLOAD";       //fist argument of the post request
    private String[] fail_jana;                   //second argunment. this value is changing acoording to each account and each semester of the account.ie the identifier of the pdf file to be downloaded
    private boolean hasGpa[];

    public ResultDownloaderForUrlConnection(InsaniahUrlConnection urlConnection) throws IOException {
        Document doc = urlConnection.getDoc(URLConstants.RESULT_DOWNLOAD);
        this.cookies = urlConnection.cookies;
        _assignNumOfSem(doc);
        _assignFailJana(doc);
    }




    private void _assignFailJana(Document doc) {
        String[] fail_jana = new String[numOfSem];
        boolean[] hasGpa = new boolean[numOfSem];

        for (int i = 0; i < numOfSem; i++) {
            //for fail_jana
            //1,2,4 and 5 fix       change 3 to get every semester
            String value = doc.body().getElementsByTag("table").get(1).child(2).getElementsByTag("tr").get(i).child(3).child(0).attr("value");
            fail_jana[i] = value;

            //for check gpa exist
            //1 , 2 and 4 fix   change 3 to get every semester
            String checkGpa = doc.body().getElementsByTag("table").get(1).child(2).getElementsByTag("tr").get(i).child(1).text();

            if ((checkGpa.equals("1.0")) || (checkGpa.equals("2.0")) || (checkGpa.equals("3.0")) ||
                    (checkGpa.equals("4.0")) || (checkGpa.equals("5.0")) || (checkGpa.equals("6.0")) ||
                    (checkGpa.equals("7.0")) || (checkGpa.equals("8.0")) || (checkGpa.equals("9.0")) ||
                    (checkGpa.equals("10.0")) || (checkGpa.equals("11.0")) || (checkGpa.equals("12.0")) ||
                    (checkGpa.equals("13.0")) || (checkGpa.equals("14.0")) || (checkGpa.equals("15.0"))) {
                hasGpa[i] = true;
            } else
                hasGpa[i] = false;
        }

        this.fail_jana = fail_jana;
        this.hasGpa = hasGpa;

    }

    private void _assignNumOfSem(Document doc) {
        numOfSem = doc.body().getElementsByTag("table").get(1).child(2).getElementsByTag("tr").size();
    }


    public int getNumOfSem() {
        return numOfSem;
    }

    public String[] getFail() {
        return fail_jana;
    }

    public boolean[] hasGpa() {
        return hasGpa;

    }

    public void downloadFiles() throws IOException {

        String charset = "UTF-8";

        BufferedInputStream bis;
        String filePath;
        BufferedOutputStream bos;

        for (int i = 0; i < numOfSem; i++) {

            String parameter = String.format("fail_jana=%s&result=%s",
                    URLEncoder.encode(getFail()[i], charset),
                    URLEncoder.encode("DOWNLOAD", charset));

            URL url = new URL(URLConstants.RESULT_DOWNLOAD);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestProperty("Accept-Charset", charset);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            for (String cookie : cookies) {
                connection.addRequestProperty("Cookie", cookie.split(";", 2)[0]);

            }
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(parameter.getBytes(charset));


            bis = new BufferedInputStream(connection.getInputStream());
            filePath = "result" + (i + 1) + ".pdf";
            bos = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
            int inByte;
            while ((inByte = bis.read()) != -1) bos.write(inByte);
            bis.close();
            bos.close();
        }

    }


}
