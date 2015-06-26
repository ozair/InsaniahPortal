package com.insaniah.result;

import core.Insaniah;
import com.insaniah.URLConstants;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.nodes.Document;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LEO on 6/21/15.
 */
public class ResultDownloader implements URLConstants {

    private CloseableHttpClient client;
    private int numOfSem;
    private final String result = "DOWNLOAD";       //fist argument of the post request
    private String[] fail_jana;                   //second argunment. this value is changing acoording to each account and each semester of the account.ie the identifier of the pdf file to be downloaded
    private boolean hasGpa[];                       //check is there gpa and cgpa result for each sem


    public ResultDownloader(Insaniah insaniah) throws IOException {
        client = insaniah.getClient();
        Document doc = insaniah.getDoc(URLConstants.RESULT_DOWNLOAD);
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
        HttpPost post;
        List<BasicNameValuePair> params1;
        CloseableHttpResponse response;
        HttpEntity entity;
        BufferedInputStream bis;
        String filePath;
        BufferedOutputStream bos;

        for (int i = 0; i < numOfSem; i++) {
            post = new HttpPost(URLConstants.RESULT_DOWNLOAD);
            params1 = new ArrayList<BasicNameValuePair>();
            params1.add(new BasicNameValuePair("fail_jana", getFail()[i]));
            params1.add(new BasicNameValuePair("result", "DOWNLOAD"));
            post.setEntity(new UrlEncodedFormEntity(params1));
            response = client.execute(post);
            entity = response.getEntity();

            bis = new BufferedInputStream(entity.getContent());
            filePath = "result"+(i+1)+".pdf";
            bos = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
            int inByte;
            while ((inByte = bis.read()) != -1) bos.write(inByte);
            bis.close();
            bos.close();


            System.out.println("successfully saved");
        }

    }

}
