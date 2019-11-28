<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import ="java.util.*" %>

<html>
<head>
    <title>Cadastrar Editora</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/style.css">
</head>

<body>
<div class="form-page">
    <div class="form">
    <h1>
        Cadastrar Editora
    </h1>
    <c:if test="${message != null}">
        <p class="message"><c:out value="${message}" /></p>
    </c:if>
    <form method="post" action="<%=request.getContextPath()%>/secure/publisher/add">
        <label>nome</label>
        <input type="text" name="name"  >
        <br><br>

        <input type="submit" class="btn" value="Salvar" />
    </form>
    <p class="footnote"><a href="<%=request.getContextPath()%>/secure/publisher/">Voltar</a></p>
    </div>

</div>
</body>
</html>