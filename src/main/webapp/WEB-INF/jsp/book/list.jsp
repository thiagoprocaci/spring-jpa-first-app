<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import ="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Lista de Livros</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/style.css">
</head>
<body>
    <div class="container">
    <h1>
        Lista de Livros
    </h1>
    <c:if test="${message != null}">
        <p class="message"><c:out value="${message}" /></p>
    </c:if>
    <table>
        <tr>
            <th>

            </th>
            <th>

            </th>
            <th>
                Nome
            </th>
            <th>
                Ano de Lançamento
            </th>
            <th>
                Autor
            </th>
            <th>
                Editora
            </th>
        </tr>
        <c:forEach var="book" items="${bookList}">
            <tr>
                <td>
                    <a href="<%=request.getContextPath()%>/secure/book/delete?id=${book.id}">Excluir</a>
                </td>
                <td>
                    <a href="<%=request.getContextPath()%>/secure/book/edit?id=${book.id}">Editar</a>
                </td>
                <td>
                    ${book.name}
                </td>
                <td>
                    ${book.year}
                </td>
                <td>
                    ${book.author.name}
                </td>
                <td>
                    ${book.publisher.name}
                </td>
            </tr>
        </c:forEach>
    </table>

    <br><br>
    <p><a href="<%=request.getContextPath()%>/secure/book/add">Cadastrar Livro</a></p>
    <p><a href="<%=request.getContextPath()%>/secure/">Voltar</a></p>
    </div>
</body>
</html>