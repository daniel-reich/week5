<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>INDEX JSP</title>
</head>
<body>
<h1>String Thing</h1>

Enter a sentence:
<form action="/jspTest" >
    <input type="text" placeholder="Enter a sentence" name="sentence">
    <button type="submit">Test</button>
</form>

<form action="/rest/" >
    <input type="text" placeholder="Enter a sentence" name="sentence">
    <button type="submit">RestTest</button>
</form>

<table>
    <tr>
        <th># of Words</th>
        <th># of Characters</th>
        <th>Reversed</th>
        <th>Pig Latin</th>
        <th>Googled</th>
    </tr>
    <c:forEach var="sentence" items="${sentences}">
        <tr>
            <td><c:out value="${sentence.words}"/></td>
            <td><c:out value="${sentence.characters}"/></td>
            <td><c:out value="${sentence.reverse}"/></td>
            <td><c:out value="${sentence.pigLatin}"/></td>

            <td>
                <c:forEach var="word" items="${sentence.searchWords}">
                    <c:url value="http://www.google.com/search?q=" var="url"/>
                    <a href="${url}<c:out value="${word}"/>" ><c:out value="${word}"/></a>
                </c:forEach>
            </td>

        </tr>
    </c:forEach>
</table>

<c:out value="${word}" />
</body>
</html>
