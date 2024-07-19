package services;

import dao.StudentDAO;
import java.util.List;
import models.Student;

public class StudentService {

    private final StudentDAO studentDAO = new StudentDAO();

    public void create(Student student) {
        studentDAO.create(student);
    }

    public void update(
            String studentID,
            String newStudentID, String studentName,
            String birthDate, String age, String gender,
            String subjectName
    ) {
        studentDAO.update(studentID, newStudentID, studentName, birthDate, age, gender, subjectName);
    }

    public void delete(String studentID) {
        studentDAO.delete(studentID);
    }

    public List<Student> all() {
        return studentDAO.all();
    }

    public Student find(String id) {
        return studentDAO.find(id);
    }

    public List<Student> findAllByGender(String gender) {
        return studentDAO.findAllByGender(gender);
    }
}
