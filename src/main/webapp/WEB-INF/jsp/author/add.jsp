<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import ="java.util.*" %>

<html>
<head>
	<title>Cadastrar Autor</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/style.css">
</head>

<body>
<div class="form-page">
    <div class="form">
    <h1>
        Cadastrar Autor
    </h1>
    <c:if test="${message != null}">
        <p class="message"><c:out value="${message}" /></p>
    </c:if>
    <form method="post" action="<%=request.getContextPath()%>/secure/author/add">
        <label>nome</label>
        <input type="text" name="name"  >
        <label>nacionalidade</label>
        <input type="text" name="nationality" >
        <br><br>

        <input type="submit" class="btn" value="Salvar" />
    </form>
    <p class="footnote"><a href="<%=request.getContextPath()%>/secure/author/">Voltar</a></p>
    </div>

</div>
</body>
</html>