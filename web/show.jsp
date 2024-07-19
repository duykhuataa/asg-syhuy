<%-- 
    Document   : show
    Created on : Jul 18, 2024, 9:42:21 PM
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
        <h1>
            This is show jsp
        </h1>

        <div>
            List of Subjects: 
            <form action="./show" method='get' id='search-form'>
                <select name='subjectToFind' onchange="document.getElementById('search-form').submit()">
                    <option value=''>All subjects</option>
                    <c:forEach items="${subjects}" var="subject">
                        <option value='${subject.getCode()}' ${param.subjectToFind == subject.getCode() ? 'selected' : ''} >
                            ${subject.getName()}
                        </option>
                    </c:forEach>
                </select>
            </form>
        </div>

        <div>
            <br/>
            List of Instructors:
            <table border="1">
                <thead>
                    <tr>
                        <th>Code</th>
                        <th>Name</th>
                        <th>Date of Birth</th>
                        <th>Gender</th>
                        <th>Subject</th>
                        <th>Select</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${instructors}" var="ins">
                        <tr>
                            <td>${ins.getCode()}</td>
                            <td>${ins.getName()}</td>
                            <td>${ins.getDob()}</td>
                            <td>${ins.getGenderString()}</td>
                            <td>${ins.getSubjectName()}</td>
                            <td>
                                <a href="./show?code=${ins.getCode()}">Select</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <div>
            <br/>
            Detail information:
            <table>
                <tr>
                    <td>Code:</td>
                    <td colspan="2">
                        <input value="${instructor.getCode()}"/>
                    </td>
                    <td>Name:</td>
                    <td colspan="2">
                        <input value="${instructor.getName()}"/>
                    </td>
                </tr>
                <tr>
                    <td>Date of Birth:</td>
                    <td colspan="2">
                        <input value="${instructor.getDob()}"/>
                    </td>
                    <td>Gender: </td>
                    <td colspan="2">
                        <input type="radio" name='gender' value='male' ${instructor.getGender() == 0 ? 'checked' : ''} />
                        Male
                        <input type="radio" name='gender' value='female' ${instructor.getGender() == 1 ? 'checked' : ''} />
                        Female
                    </td>
                </tr>
                <tr>
                    <td>Subject:</td>
                    <td colspan="2">
                        <input value="${instructor.getSubjectName()}"/>
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
