package com.insaniah;

import core.InsaniahConnection;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by LEO on 6/12/15.
 */
public class ConvocationStatus {

    private String minimumCredit;
    private String creditEarned;
    private String status;

    public ConvocationStatus(InsaniahConnection insaniah) throws IOException {
        Document doc = insaniah.getDoc(URLConstants.CONVOCATION_STATUS);

        _assign(doc);

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getMinimumCredit() {
        return Integer.parseInt(minimumCredit);
    }

    public void setMinimumCredit(String minimumCredit) {
        this.minimumCredit = minimumCredit;
    }

    public int getCreditEarned() {
        return Integer.parseInt(creditEarned);
    }

    public void setCreditEarned(String creditEarned) {
        this.creditEarned = creditEarned;
    }


    public void _assign(Document doc){

        try{
            minimumCredit = doc.body().getElementsByTag("tr").get(7).child(1).text();
        }
        catch (Exception e){
            minimumCredit = "";
        }
        try{
            creditEarned = doc.body().getElementsByTag("tr").get(8).child(1).text();
        }
        catch (Exception e){
            creditEarned = "";
        }
        try{
            status = doc.body().getElementsByTag("tr").get(11).child(1).text();
        }
        catch (Exception e){
            status = "";
        }


    }





}
