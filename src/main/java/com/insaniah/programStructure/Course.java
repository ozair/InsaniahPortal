package com.insaniah.programStructure;

/**
 * Created by LEO on 6/11/15.
 */
public class Course {

    private String courseCode,
            courseName,
            creditHours,
            preRequiste;
    public boolean offer;



    public Course(String courseCode,String courseName,String creditHours,String preRequiste,boolean offer){
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.creditHours = creditHours;
        this.preRequiste = preRequiste;
        this.offer = offer;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int  getCreditHours() {

        return Integer.parseInt(creditHours);
    }

    public void setCreditHours(String creditHours) {
        this.creditHours = creditHours;
    }

    public String getPreRequiste() {
        return preRequiste;
    }

    public void setPreRequiste(String preRequiste) {
        this.preRequiste = preRequiste;
    }

    public boolean getOfferStatus() {
        return offer;
    }

    public void setOfferStatus(boolean offer) {
        this.offer = offer;
    }




}
