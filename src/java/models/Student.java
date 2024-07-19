package models;

import java.util.Date;

public class Student {

    private String studentID;
    private String studentName;
    private Date birthDate;
    private int age;
    private int gender;
    private String subjectName;

    public Student() {
    }

    public Student(String studentID, String studentName, Date birthDate, int age, int gender, String subjectName) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.birthDate = birthDate;
        this.age = age;
        this.gender = gender;
        this.subjectName = subjectName;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

}
