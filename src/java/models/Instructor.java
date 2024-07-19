package models;

import java.util.Date;

public class Instructor {

    private String code;
    private String name;
    private Date dob;
    private int gender;
    private String subjectCode;
    
    private String subjectName;

    public Instructor() {
    }

    public Instructor(String code, String name, Date dob, int gender, String subjectCode) {
        this.code = code;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.subjectCode = subjectCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getGenderString() {
        if (this.gender == 0) {
            return "Male";
        } else {
            return "Female";
        }
    }
}
