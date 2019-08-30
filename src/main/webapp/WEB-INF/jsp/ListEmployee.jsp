<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Employee</title>
    <style type="text/css">
        <%@include file="/WEB-INF/style.css"%>
    </style>
</head>
<body>
<h2 align="center" style="color:Black">List Employee</h2>
<a class="bot1" href="ListDepartment">  <h2 align="center">Go Back</h2> </a>
<h3 align="center"> <button> <a class="bot1" href="AddEmployees?id=${pageContext.request.getParameter("id")}">Add Employee</a></button> </h3>

<table style="margin: auto;">
    <tr>
        <th>#</th>
        <th>firstName Employee</th>
        <th>LastName Employee</th>
        <th>age</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>

    <c:forEach items="${employees}" var="employee">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.firstName}</td>
            <td>${employee.lastName}</td>
            <td>${employee.age}</td>
            <td><a class="btn btn-update" href="UpdateEmployee?id=${employee.id}">Update</a>
            </td>
            <td><a class="btn btn-delete" href="DeleteEmployee?id=${employee.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
