package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.StudentService;

public class StudentController extends HttpServlet {

    private final StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String gender = req.getParameter("filter");
        if (gender != null && !gender.isEmpty()) {
            req.setAttribute("students", studentService.findAllByGender(gender));
        } else {
            req.setAttribute("students", studentService.all());
        }

        String studentId = req.getParameter("id");
        if (studentId != null && !studentId.isEmpty()) {
            req.setAttribute("student", studentService.find(studentId));
        }

        req.getRequestDispatcher("students.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("delete")) {
            studentService.delete(req.getParameter("StudentID"));
        }

        if (action.equals("update")) {
            PrintWriter pw = resp.getWriter();

            if (req.getParameter("NewStudentID").length() != 7) {
                pw.write("StudentID must have 7 characters");

                return;
            }

            if (Integer.parseInt(req.getParameter("Age")) <= 18) {
                pw.write("Student age must > 18");

                return;
            }

            studentService.update(req.getParameter("StudentID"),
                    req.getParameter("NewStudentID"), req.getParameter("StudentName"),
                    req.getParameter("BirthDate"), req.getParameter("Age"),
                    req.getParameter("Gender"), req.getParameter("SubjectName")
            );
        }

        resp.sendRedirect("./students");
    }

}
