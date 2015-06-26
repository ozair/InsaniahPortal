package com.insaniah;

import core.InsaniahConnection;
import org.jsoup.nodes.Document;
import java.io.IOException;

/**
 * Created by LEO on 6/10/15.
 */
public class PlacementTests implements URLConstants {

    private int numOfTest;

    private PlacementTest[] tests = new PlacementTest[2];

    public PlacementTests(InsaniahConnection insaniah) throws IOException {

        Document doc = insaniah.getDoc(URLConstants.PLACEMENT_TEST);
        _assign(doc);
    }

    public PlacementTest[] getPalcementTests() {
        return tests;

    }

    private void _assign(Document doc) {
        String[] attrs = new String[3];

        String testName = doc.body().getElementsByTag("table").get(2).getElementsByTag("td").get(1).text();
        String band = doc.body().getElementsByTag("table").get(2).getElementsByTag("td").get(3).text();
        String result = doc.body().getElementsByTag("table").get(2).getElementsByTag("td").get(5).text();

        tests[0] = new PlacementTest(testName, band, result);

        testName = doc.body().getElementsByTag("table").get(4).getElementsByTag("td").get(1).text();
        band = doc.body().getElementsByTag("table").get(4).getElementsByTag("td").get(3).text();
        result = doc.body().getElementsByTag("table").get(4).getElementsByTag("td").get(5).text();
        tests[1] = new PlacementTest(testName, band, result);


    }
}
