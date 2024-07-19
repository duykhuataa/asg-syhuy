package services;

import dao.SubjectDAO;
import java.util.List;
import models.Subject;

public class SubjectService {

    private final SubjectDAO subjectDAO = new SubjectDAO();

    public List<Subject> all() {
        return this.subjectDAO.all();
    }
}
