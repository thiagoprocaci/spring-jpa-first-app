<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import ="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Criar Usuário</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/style.css">
</head>
<body>
<div class="form-page">
    <div class="form">
    <h1>
         Criar Usuário
    </h1>
    <c:if test="${message != null}">
        <p class="message"">${message}</p>
    </c:if>
        <form method="post" action="<%=request.getContextPath()%>/signup" >
            <label>nome</label>
            <input type="text" name="name">
            <label>e-mail</label>
            <input type="email" name="email">
            <label>senha</label>
            <input type="password" name="password">
            <input type="submit" class="btn" value="Salvar" />
        </form>
        <p class="footnote">Já possui uma conta? <a href="<%=request.getContextPath()%>/login">Fazer login</a></p>
        <p class="footnote"><a href="<%=request.getContextPath()%>/">Voltar a página inicial</a></p>
    </div>
</div>
</body>
</html>