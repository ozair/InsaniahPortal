package com.insaniah.result;

/**
 * Created by LEO on 6/14/15.
 */
public class Result {

    private ResultCourse[] resultCourses;
    private int numOfCourses;
    private String pdfAsString;
    private String[] strCourses;
    private boolean hasGpa;
    private String resultName;

    private String gpaCreditHour,
            gpaTotalGrade,
            gpaAvgGrade;
    private String cgpaCreditHour,
            cgpaTotalGrade,
            cgpaAvgGrade;

    public String getGpaCreditHour() {
        return gpaCreditHour;
    }

    public String getGpaTotalGrade() {
        return gpaTotalGrade;
    }

    public String getGpaAvgGrade() {
        return gpaAvgGrade;
    }

    public String getCgpaCreditHour() {
        return cgpaCreditHour;
    }

    public String getCgpaTotalGrade() {
        return cgpaTotalGrade;
    }

    public String getCgpaAvgGrade() {
        return cgpaAvgGrade;
    }

    public ResultCourse[] getResultCourses() {
        return resultCourses;
    }

    public int getNumOfCourses() {
        return numOfCourses;
    }

    public String getResultName(){
        return resultName;
    }


    public Result(String pdfAsString, boolean hasGpa) {
        this.pdfAsString = pdfAsString;
        _assign();
    }


    private void _assign() {
        _assignResultName();
        _setNumOfCourse();
        _assignResultCourse();
        _assignGpa();
        _assignCgpa();
    }


    //set the num of courses
    //at the same time pdf is trimmed and set it to strCourses for extraction
    private void _setNumOfCourse() {
        int index = pdfAsString.indexOf("STATUS");
        String subStr = pdfAsString.substring(index);
        index = subStr.indexOf("STATUS") + 44;
        subStr = subStr.substring(index);
        subStr = subStr.substring(0, subStr.indexOf("JUMLAH"));
        subStr = subStr.trim();
        strCourses = subStr.split("\n");
        numOfCourses = strCourses.length;
    }

    private void _assignResultCourse() {
        ResultCourse[] courses = new ResultCourse[numOfCourses];
        for (int i = 0; i < courses.length; i++) {
            String courseName = "";
            String courseCode = "";
            String creditHour = "";
            String grade = "";
            String[] colOfCourse = strCourses[i].split("[ ]+");//one or more spaces






            courseCode = colOfCourse[0] + " " + colOfCourse[1];//the first two cols is a course code


            int j = 2;

            while (true) {                  //getting the course name


                if (colOfCourse[j].matches("[A-Z&-]+")) {  // if the col is not work you need to check the next col in advance //eg. Arabic Language 2
                    courseName += colOfCourse[j];
                } else {
                    if (colOfCourse[j + 1].matches("\\d")) {
                        courseName += colOfCourse[j];
                    } else
                        break;
                }
                courseName += " ";
                j++;

            }
            creditHour = colOfCourse[j];
            grade = colOfCourse[j + 1];

            courses[i] = new ResultCourse(courseCode, courseName, creditHour, grade);

        }
        this.resultCourses = courses;
    }


    private void _assignGpa() {
        if (hasGpa) {
            int startIndex = pdfAsString.indexOf("CURRENT SEMESTER") + 17;
            int endIndex = pdfAsString.indexOf("(PMS");
            String gpaStr = pdfAsString.substring(startIndex, endIndex);
            gpaStr = gpaStr.trim();
            String[] splitGpa = gpaStr.split(" ");
            gpaCreditHour = splitGpa[0];
            gpaTotalGrade = splitGpa[1];
            gpaAvgGrade = splitGpa[2];
        } else {
            gpaCreditHour = "";
            gpaTotalGrade = "";
            gpaAvgGrade = "";
        }


    }

    public void _assignCgpa() {
        if (hasGpa) {
            int startIndex1 = pdfAsString.indexOf("OVERALL") + 8;
            int endIndex1 = pdfAsString.indexOf("(PMK/CGPA)");
            String cgpa = pdfAsString.substring(startIndex1, endIndex1);
            cgpa = cgpa.trim();
            String[] splitCgpa = cgpa.split(" ");
            cgpaCreditHour = splitCgpa[0];
            cgpaTotalGrade = splitCgpa[1];
            cgpaAvgGrade = splitCgpa[2];
        }
        else {
            cgpaCreditHour = "";
            cgpaTotalGrade = "";
            cgpaAvgGrade = "";
        }

    }

    public void _assignResultName(){
        int startIndex = pdfAsString.indexOf("SEMESTER")+11;
        String ans = pdfAsString.substring(startIndex);
        String[] res = ans.split(" ",2);
        resultName = res[0].trim();

    }


}




