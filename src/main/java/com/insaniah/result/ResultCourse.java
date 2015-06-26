package com.insaniah.result;

/**
 * Created by LEO on 6/14/15.
 */
public class ResultCourse {

    private String courseCode;
    private String courseName;
    private String creditHour;
    private String grade;

    public ResultCourse(String courseCode,String courseName,String creditHour,String grade){
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.creditHour = creditHour;
        this.grade = grade;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCreditHour() {
        return creditHour;
    }

    public void setCreditHour(String creditHour) {
        this.creditHour = creditHour;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }




}
