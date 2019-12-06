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
         Create Person
    </h1>

    ${message}
    <br><br>
    <form method="post" action="<%=request.getContextPath()%>/person/create">
        Name:

        <input type="text" name="name"  >
        <br><br>

        Username:

        <input type="text" name="username"  >
        <br><br>

        Password:

        <input type="password" name="password"  >
        <br><br>

        Age:
        <input type="number" name="age" >
        <br><br>
        Hobby:
        <select name="idHobby">
            <c:forEach var="hobby" items="${hobbyList}">
                <option value="${hobby.id}">${hobby.name}</option>
            </c:forEach>
        </select>
        <br><br>

        <input type="submit" value="Save" />
    </form>


</center>
</body>
</html>