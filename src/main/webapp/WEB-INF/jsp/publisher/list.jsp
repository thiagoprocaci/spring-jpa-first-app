<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import ="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Lista de Editoras</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/style.css">
</head>
<body>
    <div class="container">
    <h1>
        Lista de Editoras
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
        </tr>
        <c:forEach var="publisher" items="${publisherList}">
            <tr>
                <td>
                    <a href="<%=request.getContextPath()%>/secure/publisher/delete?id=${publisher.id}">Excluir</a>
                </td>
                <td>
                    <a href="<%=request.getContextPath()%>/secure/publisher/edit?id=${publisher.id}">Editar</a>
                </td>
                <td>
                    ${publisher.name}
                </td>
            </tr>
        </c:forEach>
    </table>

    <br><br>
    <p><a href="<%=request.getContextPath()%>/secure/publisher/add">Cadastrar Editora</a></p>
    <p><a href="<%=request.getContextPath()%>/secure/">Voltar</a></p>
    </div>
</body>
</html>