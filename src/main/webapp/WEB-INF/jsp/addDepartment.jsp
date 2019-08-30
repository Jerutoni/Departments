<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Department</title>
    <style>
  <%@include file="/WEB-INF/style.css"%>
</style>
</head>

<body>

<h2 align="center">Add Department</h2>
<form name="name" action="addDepartment" method="post" class="railway">
    <div class="stripes-block">
        <div class="line"></div>
    </div>
    <div class="form-group">
    <label for="dep">Name</label><input id = dep type="text" name="departmentname" value="" size="25"/>
    </div>
    <div class="submit-block">
        <div class="submit-button">
            <input type="submit" value="Add department"/>
        </div>
    </div>
</form>

</body>
</html>
