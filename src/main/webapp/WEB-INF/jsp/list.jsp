<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Department</title>
</head>
<body>
<h2 align="center" style="color:Black">List Departments</h2>
<h1 align="center" style="color:black">  <button>   <a class="bot1" href="${pageContext.request.contextPath}/addDepartment">Add Department</a>  </button> </h1>
</form>

<table style="margin: auto;">
    <tr>
        <th>#</th>
        <th>Name Department</th>
        <th>Update</th>
        <th>Delete Department</th>
        <th>List Employees</th>
    </tr>
    <%--@elvariable id="departments" type="java"--%>
    <c:forEach items="${departments}" var="departments">
        <tr>
            <td>${departments.departmentId}</td>
            <td>${departments.departmentName}</td>
            <td><a href="UpdateDepartment?id=${departments.departmentId}">Update</a>
            </td>
            <td><a class="btn btn-delete" href="DeleteDepartment?id=${departments.departmentId}">Delete Department</a>
            </td>
            <td><a class="btn btn-list-employees" href="ListEmployee?id=${departments.departmentId}">List Employees</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
