<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Department</title>
    <style type="text/css">
        <%@include file="/WEB-INF/style.css"%>
    </style>

</head>

<body>
<h3 align="center">Update Department</h3>
<h4 align="center" style="color:black"> <button><a class="bot1" href="ListDepartment">Go back</a></button> </h4>

<form name="newName" action="UpdateDepartment" method="post" class="railway">
    <div class="stripes-block">
        <div class="line"></div>
    </div>
    <div class="form-group">
    <label for="newDepartmentName">Name</label> <input id="newDepartmentName" type="text" name="departmentname" value="" size="25"/>
    <input type="hidden" name="id" value="${pageContext.request.getParameter("id")}" size="25"/>
    </div>
    <div class="submit-block">
        <div class="submit-button">
            <input type="submit" value="Update Department"/>
        </div>
    </div>
</form>

</body>
</html>
