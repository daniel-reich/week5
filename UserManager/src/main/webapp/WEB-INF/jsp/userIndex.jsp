<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
Create User: <br>
<form action="/createUser" >
    <input type="text" placeholder="Enter name" name="name">
    <input type="text" placeholder="Enter email" name="email">
    <button type="submit">Submit</button>
</form>
Get User by Email: <br>
<form action="/getUserByEmail" >
    <input type="text" placeholder="Enter email" name="email">
    <button type="submit">Submit</button>
</form>
Get User by ID: <br>
<form action="/getUserById" >
    <input type="text" placeholder="Enter ID" name="id">
    <button type="submit">Submit</button>
</form>
View all <a href="/getAllUsers">Users</a>
</body>
</html>