<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import ="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<center>
    <h1>
         Edit Person
    </h1>

    ${message}
    <br><br>
    <form method="post" action="<%=request.getContextPath()%>/person/edit">
        Name:

        <input type="text" name="name"  value="${person.name}">
        <br><br>
        Age:
        <input type="number" name="age" value="${person.age}">
        <br><br>
        Hobby:
        <select name="idHobby" >
            <c:forEach var="hobby" items="${hobbyList}">
                <option value="${hobby.id}" ${hobby.id == person.favoriteHobby.id ? 'selected' : ''}>${hobby.name}</option>
            </c:forEach>

        </select>
        <br><br>
        <input type="hidden" name="idPerson" value="${person.id}">
        <input type="submit" value="Save" />
    </form>

    <br><br>
    <a href="<%=request.getContextPath()%>/person/list">Person List</a>
    <br><br>
    <a href="<%=request.getContextPath()%>/login/logout">Logout</a>

</center>
</body>
</html>