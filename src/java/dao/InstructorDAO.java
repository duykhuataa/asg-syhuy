package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Instructor;

public class InstructorDAO extends DAO {

    // get instructor by code
    public Instructor findByCode(String codeToFind) {
        Instructor instructor = null;

        try {
            sql = """
                  select *
                  from instructors
                  inner join subjects s on s.code = subject_code
                  where instructors.code = ?;""";
            ps = con.prepareStatement(sql);

            ps.setString(1, codeToFind);

            rs = ps.executeQuery();

            if (rs.next()) {
                String code = rs.getString("code");
                String name = rs.getString("name");
                Date dob = rs.getDate("dob");
                int gender = rs.getInt("gender");
                String subjectCode = rs.getString("subject_code");

                String subjectName = rs.getString(7);

                instructor = new Instructor(code, name, dob, gender, subjectCode);
                instructor.setSubjectName(subjectName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return instructor;
    }

    public List<Instructor> all() {
        List<Instructor> instructorList = new ArrayList<>();

        try {
            sql = """
                  select *
                  from instructors
                  inner join subjects s on s.code = subject_code;""";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                String code = rs.getString("code");
                String name = rs.getString("name");
                Date dob = rs.getDate("dob");
                int gender = rs.getInt("gender");
                String subjectCode = rs.getString("subject_code");

                String subjectName = rs.getString(7);

                Instructor instructor = new Instructor(code, name, dob, gender, subjectCode);
                instructor.setSubjectName(subjectName);

                instructorList.add(instructor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return instructorList;
    }

    // get all instructor by subject code
    public List<Instructor> findAllBySubjectCode(String subjectCodeToFind) {
        List<Instructor> instructorList = new ArrayList<>();

        try {
            sql = """
                  select *
                  from instructors
                  inner join subjects s on s.code = subject_code
                  where s.code = ?;""";
            ps = con.prepareStatement(sql);

            ps.setString(1, subjectCodeToFind);

            rs = ps.executeQuery();

            while (rs.next()) {
                String code = rs.getString("code");
                String name = rs.getString("name");
                Date dob = rs.getDate("dob");
                int gender = rs.getInt("gender");
                String subjectCode = rs.getString("subject_code");

                String subjectName = rs.getString(7);

                Instructor instructor = new Instructor(code, name, dob, gender, subjectCode);
                instructor.setSubjectName(subjectName);

                instructorList.add(instructor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return instructorList;
    }
}
