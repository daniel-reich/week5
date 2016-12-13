<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
Edit User: <br>



<form action="/updateUser" >

    <input type="hidden" value=<c:out value="${user.id}"/> name="id">
    <input type="text" value="<c:out value="${user.name}"/>" name="name">
    <input type="text" value="<c:out value="${user.email}"/>" name="email">
    <button type="submit">Save</button>
</form>
<a href="/getAllUsers">All Users</a>
<a href="/">Home</a>