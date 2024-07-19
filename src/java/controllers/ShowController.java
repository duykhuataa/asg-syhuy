package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Instructor;
import services.InstructorService;
import services.SubjectService;

public class ShowController extends HttpServlet {

    private final SubjectService subjectService = new SubjectService();

    private final InstructorService instructorService = new InstructorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("subjects", subjectService.all());

        String subjectToFind = req.getParameter("subjectToFind");
        if (subjectToFind == null || subjectToFind.isEmpty()) {
            req.setAttribute("instructors", instructorService.all());
        } else {
            req.setAttribute("instructors", instructorService.findAllBySubjectCode(
                    subjectToFind
            ));
        }

        String instructorCode = req.getParameter("code");
        if (instructorCode != null && !instructorCode.isEmpty()) {
            req.setAttribute("instructor", instructorService.findByCode(instructorCode));
        }

        req.getRequestDispatcher("show.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
