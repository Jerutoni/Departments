<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UpdateEmployee</title>
    <style>
        <%@include file="/WEB-INF/style.css"%>
    </style>
</head>
<body>

<h3 align="center">Update Employee</h3>
<form name="newName" action="UpdateEmployee" method="post" class="railway">
    <div class="stripes-block">
        <div class="line"></div>
    </div>
    <div class="form-group">
    <label for="firstName">FirstName: </label> <input id="firstName" type="text" name="firstName" value="" size="25"/> <br>
    <label for="lastName">LastName: </label> <input id="lastName" type="text" name="lastName" value="" size="25"/><br>
    <label for="age">Age: </label> <input id="age" type="text" name="age" value="" size="25"/><br>
    <input type="hidden" name="employeeID" value="${employeeID}" size="25"/><br>
    </div>
    <div class="submit-block">
        <div class="submit-button">
            <input type="submit" value="Update Employee"/>
        </div>
    </div>
</form>
</body>
</html>
