<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import ="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Lista de Autores</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/style.css">
</head>
<body>
    <div class="container">
    <h1>
        Lista de Autores
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
                Nacionalidade
            </th>
        </tr>
        <c:forEach var="author" items="${authorList}">
            <tr>
                <td>
                    <a href="<%=request.getContextPath()%>/secure/author/delete?id=${author.id}">Excluir</a>
                </td>
                <td>
                    <a href="<%=request.getContextPath()%>/secure/author/edit?id=${author.id}">Editar</a>
                </td>
                <td>
                    ${author.name}
                </td>
                <td>
                    ${author.nationality}
                </td>
            </tr>
        </c:forEach>
    </table>

    <br><br>
    <p><a href="<%=request.getContextPath()%>/secure/author/add">Cadastrar Autor</a></p>
    <p><a href="<%=request.getContextPath()%>/secure/">Voltar</a></p>
    </div>
</body>
</html>