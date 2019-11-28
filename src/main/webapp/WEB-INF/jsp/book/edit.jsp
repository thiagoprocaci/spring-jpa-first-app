<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import ="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Editar Livro</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/style.css">
</head>

<body>
<div class="form-page">
    <div class="form">
    <h1>
        Editar Livro
    </h1>
    <c:if test="${message != null}">
        <p class="message"><c:out value="${message}" /></p>
    </c:if>
    <form method="post" action="<%=request.getContextPath()%>/secure/book/edit">
        <label>nome</label>
        <input type="text" name="name" value="${book.name}">
        <label>ano de lançamento</label>
        <input type="number" name="year" value="${book.year}" >
        <label>autor</label>
        <select name="idAuthor">
            <c:forEach var="author" items="${authorList}">
                <option value="${author.id}" ${author.id == book.author.id ? 'selected' : ''}>${author.name}</option>
            </c:forEach>
        </select>
        <label>editora</label>
        <select name="idPublisher">
            <c:forEach var="publisher" items="${publisherList}">
                <option value="${publisher.id}" ${publisher.id == book.publisher.id ? 'selected' : ''}>${publisher.name}</option>
            </c:forEach>
        </select>
        <input type="hidden" name="idBook" value="${book.id}">
        <input type="submit" class="btn" value="Salvar" />
    </form>
    <p class="footnote"><a href="<%=request.getContextPath()%>/secure/book/delete?id=${book.id}">Excluir</a>
     -
    <a href="<%=request.getContextPath()%>/secure/book/">Voltar</a></p>
    </div>

</div>
</body>
</html>