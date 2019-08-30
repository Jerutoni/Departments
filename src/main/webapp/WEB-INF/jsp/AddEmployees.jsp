<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddEmployees</title>
    <style type="text/css">
        <%@include file="/WEB-INF/style.css"%>
    </style>
</head>
<body>
<h3 align="center"><button ><a class="bot1" href="ListEmployee?id=${departmentID}">Back</a></button> </h3>

<form name="addEmployee" action="AddEmployees" method="post" class="railway">
    <div class="stripes-block">
        <div class="line"></div>
    </div>
    <div class="form-group">
    <input id=firstName type="text" name="firstName" value="" size="25"/> <label for="firstName">firstName</label> <br>
    <input id=lastName type="text" name="lastName" value="" size="25"/> <label for="lastName">lastName</label> <br>
    <input id=age type="number" name="age" value="" size="25"/> <label for="Age">Age </label> <br>
    <input type="hidden" name="departmentID" value="${departmentID}" size="25"/>
    </div>
    <div class="submit-block">
        <div class="submit-button">
    <input type="submit" value="Add employee"/>
        </div>
    </div>
</form>


</body>
</html>
