<%--
  Created by IntelliJ IDEA.
  User: Unsentletter
  Date: 28/1/18
  Time: 10:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customer Form</title>
    <style>
        .error{color:red}
    </style>
</head>
<body>
    <form:form action="processForm" modelAttribute="customer">
        First Name: <form:input path="firstName" />
        <br><br>
        Last Name*: <form:input path="lastName" />
        <form:errors path="lastName" cssClass="error" />
        <br><br>
        Free Passes: <form:input path="freePasses" />
        <form:errors path="freePasses" cssClass="error" />
        <br><br>
        Postcode: <form:input path="postcode" />
        <form:errors path="postcode" cssClass="error" />
        <br><br>
        Course Code: <form:input path="courseCode" />
        <form:errors path="courseCode" cssClass="error" />

        <input type="submit" value="SUBMIT" />
    </form:form>
</body>
</html>
