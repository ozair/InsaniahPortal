package com.insaniah;

import core.InsaniahConnection;
import org.jsoup.nodes.Document;

import java.io.IOException;


/**
 * Created by LEO on 6/10/15.
 */
public class Taqwin implements URLConstants{

    private int numOfRow;


    private String[][] taqwinTable;
    public String test;

    public Taqwin(InsaniahConnection insaniah) throws IOException {
        Document doc = insaniah.getDoc(TAQWIN);
        _assign(doc);


    }

    public String[][] getTaqwinTable() {
        return taqwinTable;
    }

    public void setTaqwinTable(String[][] taqwinTable) {
        this.taqwinTable = taqwinTable;
    }

    private void  _assign(Document doc){

        numOfRow = doc.body().getElementsByTag("tbody").get(0).getElementsByTag("tr").size();

        String[][] table = new String[numOfRow][3];

        for(int i=0;i<numOfRow;i++){
            for(int j=0;j<3;j++){
                table[i][j] = doc.body().getElementsByTag("tr").get(i+1).child(j+1).text();
            }
        }

        taqwinTable = table;
    }

    public int getNumOfRow(){
        return numOfRow;
    }




}
