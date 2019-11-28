<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <title>Página Principal</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/style.css">
    </head>

    <body>
        <div class="container">
            <h1>
                Página Principal
            </h1>
            <p>Bem vindo, ${user.name}.</p>
            <p>
            <br>
                <a href="<%=request.getContextPath()%>/secure/book/">Livros </a>
                (<a href="<%=request.getContextPath()%>/secure/book/add">Adicionar</a>)
                 -
                <a href="<%=request.getContextPath()%>/secure/author/">Autores </a>
                (<a href="<%=request.getContextPath()%>/secure/author/add">Adicionar</a>)
                 -
                <a href="<%=request.getContextPath()%>/secure/publisher/">Editoras </a>
                (<a href="<%=request.getContextPath()%>/secure/publisher/add">Adicionar</a>)
            </p>
            <br>
            <a href="<%=request.getContextPath()%>/">Voltar para página inicial</a>
            <br><br>
            <a href="<%=request.getContextPath()%>/logout">Logout</a>
        </div>
    </body>
</html>