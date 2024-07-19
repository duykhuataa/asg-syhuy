package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.Student;

public class StudentDAO extends DAO {

    public void create(Student student) {
        try {
            sql = "insert into students (StudentID, StudentName, BirthDate, Age, Gender, SubjectName) "
                    + "values (?, ?, ?, ?, ?, ?)";

            ps = con.prepareStatement(sql);

            ps.setString(1, student.getStudentID());
            ps.setString(2, student.getStudentName());
            ps.setDate(3, new java.sql.Date(student.getBirthDate().getTime()));
            ps.setInt(4, student.getAge());
            ps.setInt(5, student.getGender());
            ps.setString(6, student.getSubjectName());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(String studentID, 
            String newStudentID, String studentName,
            String birthDate, String age, String gender,
            String subjectName) {

        sql = """
              update students
              set StudentName = ?, BirthDate = ?, Age = ?, Gender = ?, SubjectName = ?, StudentID = ?
              where StudentID = ?""";
        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, studentName);
            ps.setString(2, birthDate);
            ps.setString(3, age);
            ps.setString(4, gender);
            ps.setString(5, subjectName);
            ps.setString(6, newStudentID);
            ps.setString(7, studentID);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String studentID) {
        sql = "delete from students where StudentID = ?";
        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, studentID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> all() {
        List<Student> students = new ArrayList<>();

        try {
            sql = "select * from students;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                String studentID = rs.getString("StudentID");
                String studentName = rs.getString("StudentName");
                Date birthDate = rs.getDate("BirthDate");
                int age = rs.getInt("Age");
                int gender = rs.getInt("Gender");
                String subjectName = rs.getString("SubjectName");

                Student student = new Student(studentID, studentName, birthDate, age, gender, subjectName);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    public List<Student> findAllByGender(String genderToFind) {
        List<Student> students = new ArrayList<>();

        try {
            sql = "select * from students where gender=?;";
            ps = con.prepareStatement(sql);
            ps.setString(1, genderToFind);
            rs = ps.executeQuery();

            while (rs.next()) {
                String studentID = rs.getString("StudentID");
                String studentName = rs.getString("StudentName");
                Date birthDate = rs.getDate("BirthDate");
                int age = rs.getInt("Age");
                int gender = rs.getInt("Gender");
                String subjectName = rs.getString("SubjectName");

                Student student = new Student(studentID, studentName, birthDate, age, gender, subjectName);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    public Student find(String id) {
        Student student = null;

        try {
            sql = "select * from students where StudentID = ?;";
            ps = con.prepareStatement(sql);

            ps.setString(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                String studentID = rs.getString("StudentID");
                String studentName = rs.getString("StudentName");
                Date birthDate = rs.getDate("BirthDate");
                int age = rs.getInt("Age");
                int gender = rs.getInt("Gender");
                String subjectName = rs.getString("SubjectName");

                student = new Student(studentID, studentName, birthDate, age, gender, subjectName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }
}
