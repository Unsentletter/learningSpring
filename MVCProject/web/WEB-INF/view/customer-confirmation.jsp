<%--
  Created by IntelliJ IDEA.
  User: Unsentletter
  Date: 28/1/18
  Time: 10:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Confirmation Page</title>
</head>
<body>
The customer is confirmed: ${customer.firstName} ${customer.lastName}
<br><br>
Free Passes: ${customer.freePasses}
<br><br>
Postcode: ${customer.postcode}
<br><br>
Course Code: ${customer.courseCode}
<br><br>
</body>
</html>
