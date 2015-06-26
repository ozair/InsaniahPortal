package com.insaniah;

import core.InsaniahConnection;
import org.jsoup.nodes.Document;
import java.io.IOException;

/**
 * Created by LEO on 6/9/15.
 */
public class StudentInfo implements URLConstants {

    private String name;
    private String matrix;
    private String programme;
    private String balance;
    private String semester;
    private String kulliyyah;
    private String status;
    private String passport;
    private String birthDay;


    public StudentInfo(InsaniahConnection in) throws IOException {
        Document doc;

        //for the first link--------------------------------
        doc = in.getDoc(STUDENT_INFO1);
        _assign1(doc);

        //for second link-----------------------------------
        doc = in.getDoc(STUDENT_INFO2);
        _assign2(doc);

        //for third link
        doc = in.getDoc(STUDENT_INFO3);
        _assign3(doc);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMatrix() {
        return matrix;
    }

    public void setMatrix(String matrix) {
        matrix = matrix;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getKulliyyah() {
        return kulliyyah;
    }

    public void setKulliyyah(String kulliyyah) {
        this.kulliyyah = kulliyyah;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getBirtdayLiteral() {
        String ans = "";
        String month = "";
        String day = birthDay.split("-")[0];
        int parseMonth = Integer.parseInt(birthDay.split("-")[1]);
        String year = birthDay.split("-")[2];

        switch (parseMonth) {
            case 1:
                month = "JANUARY";
                break;
            case 2:
                month = "FEBRUARY";
                break;
            case 3:
                month = "MARCH";
                break;
            case 4:
                month = "APRIL";
                break;
            case 5:
                month = "MAY";
                break;
            case 6:
                month = "JUNE";
                break;
            case 7:
                month = "JULY";
                break;
            case 8:
                month = "AUGUST";
                break;
            case 9:
                month = "SEPTEMBER";
                break;
            case 10:
                month = "OCTOBER";
                break;
            case 11:
                month = "NOVEMBER";
                break;
            case 12:
                month = "DECEMBER";
                break;
            default:
                month="";
        }

        ans = String.format("%s %s %s",day,month,year);
        return ans;

    }


    //assign name,matrix,pragram,balance,
    private void _assign1(Document document) {
        try {
            balance = document.body().child(0).getElementsByTag("tr").get(3).child(2).text();
        } catch (Exception e) {
            balance = "";
        }
    }

    private void _assign2(Document doc) {
//        semester = doc.body().getElementsByTag("tbody").get(1).getElementsByTag("tr").get(3).child(2).html();//same as the statement below but long traverse
        try {
            name = doc.body().getElementsByTag("tr").get(2).child(2).text();
        } catch (Exception e) {
            name = "";
        }
        try {
            matrix = doc.body().getElementsByTag("tr").get(3).child(2).text();
        } catch (Exception e) {
            matrix = "";
        }
        try {
            programme = doc.body().getElementsByTag("tr").get(4).child(2).text();
        } catch (Exception e) {
            programme = "";
        }
        try {
            semester = doc.body().getElementsByTag("tr").get(5).child(2).text();
        } catch (Exception e) {
            semester = "";
        }
        try {
            kulliyyah = doc.body().getElementsByTag("tr").get(7).child(2).text();
        } catch (Exception e) {
            kulliyyah = "";
        }
        try {
            status = doc.body().getElementsByTag("tr").get(8).child(2).text();
        } catch (Exception e) {
            status = "";
        }
    }

    private void _assign3(Document doc) {
        try {
            passport = doc.body().getElementsByTag("tr").get(3).child(1).text();
        } catch (Exception e) {
            passport = "";
        }
        try {
            birthDay = doc.body().getElementsByTag("tr").get(4).child(1).child(0).attr("value");
        } catch (Exception e) {
            birthDay = "";
        }
    }
}