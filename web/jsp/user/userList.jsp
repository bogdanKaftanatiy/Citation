<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<h2>All users in application</h2>
<ul>
    <c:forEach items="${users}" var="user">
        <li id="user_<c:out value="${user.id}" />">
            <div class="userInfo">
                ID: <c:out value="${user.id}" /> <br />
                Username: <c:out value="${user.username}" /> <br />
                Password: <c:out value="${user.password}" /> <br />
                First name: <c:out value="${user.firstname}" /> <br />
                Last name: <c:out value="${user.lastname}" /> <br />
                Email: <c:out value="${user.email}" />
            </div>
        </li>
    </c:forEach>
</ul>

<br />
<a href="<c:out value="/citation/users/addForm"/>">Add new User</a>
</body>
</html>
