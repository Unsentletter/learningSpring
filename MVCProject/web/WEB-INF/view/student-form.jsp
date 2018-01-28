<%--
  Created by IntelliJ IDEA.
  User: Unsentletter
  Date: 27/1/18
  Time: 9:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student Registration Form</title>
</head>
<body>
    <form:form action="processForm" modelAttribute="student">
        First Name: <form:input path="firstName" />
        <br><br>
        Last Name: <form:input path="lastName" />
        <br><br>
        Country:
        <form:select path="country">
            <form:options items="${student.countryOptions}" />
        </form:select>
        <br><br>
        Favourite Language:
        <form:radiobuttons path="language" items="${student.languageOptions}" />
        <br><br>
        Operating Systems:
        Linux<form:checkbox path="operatingSystems" value="Linux"/>
        MacOS<form:checkbox path="operatingSystems" value="MacOS"/>
        Windows<form:checkbox path="operatingSystems" value="Windows"/>
        <br><br>
        <input type="submit" value="SUBMIT">
    </form:form>
</body>
</html>
