package dao;

import java.util.ArrayList;
import java.util.List;
import models.Subject;

public class SubjectDAO extends DAO {

    // get list subjects
    public List<Subject> all() {
        // khai bao rang List nay se chua cac items co type la models.Subject
        List<Subject> subjects = new ArrayList<>();

        // SQL Statement de lay cac subjects
        sql = "select * from subjects;";
        try {
            // tao 1 PrepareStatement tu sql o tren
            ps = con.prepareStatement(sql);

            // execute statement va luu data tra ve vao rs
            rs = ps.executeQuery();

            // duyet qua tung dong data cua ResultSet
            while (rs.next()) {
                String code = rs.getString("code");
                String name = rs.getString("name");

                // tạo subject từ kết quả trả về
                Subject subject = new Subject(code, name);

                // thêm vào list subjects
                subjects.add(subject);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return subjects;
    }
}
