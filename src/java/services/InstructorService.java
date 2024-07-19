package services;

import dao.InstructorDAO;
import java.util.List;
import models.Instructor;

public class InstructorService {

    private final InstructorDAO instructorDAO = new InstructorDAO();

    public Instructor findByCode(String code) {
        return instructorDAO.findByCode(code);
    }

    public List<Instructor> all() {
        return instructorDAO.all();
    }

    public List<Instructor> findAllBySubjectCode(String subjectCodeToFind) {
        return instructorDAO.findAllBySubjectCode(subjectCodeToFind);
    }
}
