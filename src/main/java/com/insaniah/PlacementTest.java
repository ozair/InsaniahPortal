package com.insaniah;

import org.apache.http.impl.client.CloseableHttpClient;


import java.io.IOException;

/**
 * Created by LEO on 6/10/15.
 */
public class PlacementTest implements URLConstants {

    private String testName;
    private String band;
    private String result;
    private CloseableHttpClient client;


    public PlacementTest(String test,String band,String result){
        this.testName = test;
        this.band = band;
        this.result = result;
    }

    public String getResult() {
        return result.substring(0,4);
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }






}
