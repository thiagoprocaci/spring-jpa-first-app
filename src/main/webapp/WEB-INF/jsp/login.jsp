<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import ="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Login</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/style.css">
</head>
<body>
    <div class="form-page">
        <div class="form">
        <h1>
            Login
        </h1>
        <c:if test="${message != null}">
            <p class="message"><c:out value="${message}" /></p>
        </c:if>
        <form method="post" action="<%=request.getContextPath()%>/login">
            <label for="email">e-mail</label>
            <input type="email" name="email" id="email">
            <label for="password">senha</label>
            <input type="password" name="password" id="password">
            <input type="submit" class="btn" value="Realizar Login" />
        </form>
        <p class="footnote">Não está cadastrado? <a href="<%=request.getContextPath()%>/signup">Criar usuário</a></p>
        <p class="footnote"><a href="<%=request.getContextPath()%>/">Voltar a página inicial</a></p>
        </div>
    </div>
</body>
</html>