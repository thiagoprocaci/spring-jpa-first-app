<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <title>Página Inicial</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/style.css">
    </head>

    <body>
        <div class="container">
            <h1>
                Página Inicial
            </h1>
            <p>Bem vindo.</p>
            <a href="<%=request.getContextPath()%>/login">Login</a>
            <br><br>
            <a href="<%=request.getContextPath()%>/signup">Criar usuário</a>
        </div>
    </body>
</html>