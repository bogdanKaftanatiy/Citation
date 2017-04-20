<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<h2>User information</h2>
ID: <c:out value="${user.id}" /> <br />
Username: <c:out value="${user.username}" /> <br />
Password: <c:out value="${user.password}" /> <br />
First name: <c:out value="${user.firstname}" /> <br />
Last name: <c:out value="${user.lastname}" /> <br />
Email: <c:out value="${user.email}" />
</body>
</html>
