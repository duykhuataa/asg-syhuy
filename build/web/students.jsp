<%-- 
    Document   : students
    Created on : Jul 19, 2024, 12:51:18 AM
    Author     : KhuatHieu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Students</h1>

        <div>
            List of students: <br/>

            Filters: <br/>
            <li>
                Gender
                <input type="radio" name='filter' value='' ${param.filter == null ? 'checked' : ''}
                       onclick="location.href = './students'"
                       />None
                <input type="radio" name='filter' value='0' ${param.filter == 0 ? 'checked' : ''}
                       onclick="location.href = './students?filter=0'"
                       />Male
                <input type="radio" name='filter' value='1' ${param.filter == 1 ? 'checked' : ''}
                       onclick="location.href = './students?filter=1'"
                       />Female
            </li> <br/>

            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Birth Date</th>
                        <th>Age</th>
                        <th>Gender</th>
                        <th>Subject</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${students}" var="student">
                        <tr>
                            <td>${student.getStudentID()}</td>
                            <td>${student.getStudentName()}</td>
                            <td>${student.getBirthDate()}</td>
                            <td>${student.getAge()}</td>
                            <td>${student.getGender() == 0 ? 'Male' : 'Female'}</td>
                            <td>${student.getSubjectName()}</td>
                            <td>
                                <a href='./students?id=${student.getStudentID()}'>
                                    Update
                                </a>
                                <form action="./students" method="post" style="display:inline;">
                                    <input type="hidden" name="action" value="delete">
                                    <input type="hidden" name="studentID" value="${student.getStudentID()}">

                                    <button type="submit">Delete</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <div>
            <br/>
            <form action="./students" method="POST">
                <input type="hidden" name='action' value="update"/>
                <input type="hidden" name='StudentID' value="${student.getStudentID()}" value="update"/>
                
                <table>
                    <tr>
                        <td>ID: </td>
                        <td colspan="2">
                            <input name='NewStudentID' value="${student.getStudentID()}" />
                        </td>
                        <td>Name: </td>
                        <td colspan="2">
                            <input name='StudentName' type="text" value="${student.getStudentName()}" />
                        </td>
                    </tr>
                    <tr>
                        <td>Birth Date: </td>
                        <td colspan="2">
                            <input name='BirthDate' type="date" value="${student.getBirthDate()}" />
                        </td>
                        <td>Age: </td>
                        <td colspan="2">
                            <input name="Age" type="text" value="${student.getAge()}" />
                        </td>
                    </tr>
                    <tr>
                        <td>Gender: </td>
                        <td colspan="2">
                            <input type="radio" name='Gender' value='0' ${student.getGender() == 0 ? 'checked' : ''} />
                            Male
                            <input type="radio" name='Gender' value='1' ${student.getGender() == 1 ? 'checked' : ''} />
                            Female
                        </td>
                        <td>Subject: </td>
                        <td colspan="2">
                            <input name='SubjectName' type="text" value="${student.getSubjectName()}" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button>
                                Save
                            </button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
