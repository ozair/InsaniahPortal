package com.insaniah.result;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

import java.io.File;
import java.io.IOException;

/**
 * Created by LEO on 6/22/15.
 */
public class ResultParser {
    private  String filePath;
    public ResultParser(String filePath){
        this.filePath = filePath;
    }

    public String parseToString() throws IOException {
        File file = new File(filePath);
        PDDocument document = PDDocument.load(file);
        PDFTextStripper stripper = new PDFTextStripper();
        String text = stripper.getText(document);

        return text;
    }
}
