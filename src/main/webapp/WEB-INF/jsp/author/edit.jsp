<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import ="java.util.*" %>

<html>
<head>
	<title>Editar Autor</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/style.css">
</head>

<body>
<div class="form-page">
    <div class="form">
    <h1>
        Editar Autor
    </h1>
    <c:if test="${message != null}">
        <p class="message"><c:out value="${message}" /></p>
    </c:if>
    <form method="post" action="<%=request.getContextPath()%>/secure/author/edit">
        <label>nome</label>
        <input type="text" name="name" value="${author.name}">
        <label>nacionalidade</label>
        <input type="text" name="nationality" value="${author.nationality}">
        <br><br>

        <input type="hidden" name="idAuthor" value="${author.id}">
        <input type="submit" class="btn" value="Salvar" />
    </form>
    <p class="footnote"><a href="<%=request.getContextPath()%>/secure/author/delete?id=${author.id}">Excluir</a>
     -
    <a href="<%=request.getContextPath()%>/secure/author/">Voltar</a></p>
    </div>

</div>
</body>
</html>