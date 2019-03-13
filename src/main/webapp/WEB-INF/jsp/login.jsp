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
         Login
    </h1>

    ${message}
    <br><br>
    <form method="post" action="<%=request.getContextPath()%>/login/doLogin">
        Username:
        <input type="text" name="username"  >
        <br><br>
        Password:
        <input type="password" name="password"  >
        <br><br>
        <input type="submit" value="Login" />
    </form>
    <br><br>
    <a href="<%=request.getContextPath()%>/person/create">Person Create</a>
</center>
</body>
</html>