<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Single User</title>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
    </tr>
    <tr>
        <td><c:out value="${user.id}"/></td>
        <td><c:out value="${user.name}"/></td>
        <td><c:out value="${user.email}"/></td>
        <td>
            <form action="/edit" >
                <input type="hidden" value="<c:out value="${user.id}"/>" name="id">
                <button type="submit">Edit</button>
            </form>
        </td>
    </tr>


</table>
<a href="/getAllUsers">All Users</a>
<a href="/">Home</a>
</body>
</html>