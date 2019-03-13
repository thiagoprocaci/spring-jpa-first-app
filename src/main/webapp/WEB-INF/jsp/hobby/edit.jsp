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
         Edit Hobby
    </h1>

     ${message}

    <br><br>
    <form method="post" action="<%=request.getContextPath()%>/hobby/edit">
        Name:

        <input type="text" name="name" value="${hobby.name}"  >

        <br><br>
        <input type="hidden" name="id" value="${hobby.id}"  >

        <input type="submit" value="Save" />
    </form>

     <br><br>
     <a href="<%=request.getContextPath()%>/hobby/list">Hobby List</a>
     <br><br>
     <a href="<%=request.getContextPath()%>/login/logout">Logout</a>

</center>
</body>
</html>