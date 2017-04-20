<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<h2>Add user</h2>
<ul>
    <h2>Register</h2>
    <form method="POST" action="<c:out value="/citation/users/register"/>">
        First name: <input type="text" name="firstname" /> <br />
        Last name: <input type="text" name="lastname" /> <br />
        Username: <input type="text" name="username" /> <br />
        Password: <input type="password" name="password" /> <br />
        E-mail: <input type="email" name="email" /> <br />
        <input type="submit" value="Register" />
    </form>
</ul>
</body>
</html>
