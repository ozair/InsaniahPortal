package com.insaniah.programStructure;

import com.insaniah.URLConstants;
import core.InsaniahConnection;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by LEO on 6/11/15.
 */
public class ProgramStructure implements URLConstants {


    private int numOfSem;
    private int[] numOfCoursesInOneSem;

    private Course[][] courses;


    public ProgramStructure(InsaniahConnection insaniah) throws IOException {
        Document doc = insaniah.getDoc(URLConstants.PROGRAM_STRUCTURE);

        _assign(doc);
    }


    public int getNumOfCoursesInSem(int index) {
        return numOfCoursesInOneSem[index];
    }

    public int getNumOfSem() {
        return numOfSem;
    }

    public Course[][] getCourses() {
        return courses;
    }

    private void _assign(Document doc) {
        int[] numOfCoursesInOneSem = new int[0];
        numOfSem = doc.getElementsByTag("table").size() - 1;
        Course courses[][] = new Course[numOfSem][];

        for (int i = 0; i < numOfSem; i++) {   //tables

            if (i == 0) {
                numOfCoursesInOneSem = new int[numOfSem];
            }
//
            //return no of rows in specific table
            //1.table(Change)
            int numOfRowsInATable = (doc.getElementsByTag("table").get(i + 1).child(1).getElementsByTag("tr").size()) - 1;
            courses[i] = new Course[numOfRowsInATable];
            numOfCoursesInOneSem[i] = numOfRowsInATable;
            for (int j = 0; j < numOfRowsInATable; j++) {         //rows
                // 1=table       2=FIX           3=row index in specific table      4=col(,courseCode,courseName,creditHour,pre,offer etc..)
                String courseCode = doc.getElementsByTag("table").get(i + 1).child(1).child(j).child(1).ownText();
                String courseName = doc.getElementsByTag("table").get(i + 1).child(1).child(j).child(2).ownText();
                String credit = doc.getElementsByTag("table").get(i + 1).child(1).child(j).child(3).ownText();

                String pre = doc.getElementsByTag("table").get(i + 1).child(1).child(j).child(4).ownText();
                boolean statusOffers;


                //check wherether it is offered or not
                if (doc.getElementsByTag("table").get(i + 1).child(1).child(j).child(5).child(0).attr("src").equalsIgnoreCase("images/true.gif"))
                    statusOffers = true;
                else
                    statusOffers = false;
                courses[i][j] = new Course(courseCode, courseName, credit, pre, statusOffers);

                this.numOfCoursesInOneSem = numOfCoursesInOneSem;
                this.courses = courses;
            }
        }


    }

}




