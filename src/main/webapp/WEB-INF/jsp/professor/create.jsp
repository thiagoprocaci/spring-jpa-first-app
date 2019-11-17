
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Cadastro de Professor</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container" style="margin-top: 20px">
    <div>
        <h2>Cadastro de Professor</h2>
    </div>
    <div>
        <form method="post" action="<%=request.getContextPath()%>/professor/create">
            <div class="form-group">
                <label for="nome">Nome</label>
                <input type="text" class="form-control" name="nome" id="nome"  placeholder="Entre com o nome do professor">
            </div>
            <div class="form-group">
                <label for="formacao">Formação</label>
                <input type="text" class="form-control" name="formacao" id="formacao"  placeholder="Entre com o formação do professor">
            </div>
            <div class="form-group">
                <label for="idDisciplinas">Disciplinas</label>
                <select class="form-control" name="idDisciplinas" id="idDisciplinas" multiple>
                    <c:forEach var="disciplina" items="${disciplinaList}">
                        <option value="${disciplina.id}">${disciplina.nome}</option>
                    </c:forEach>
                </select>

            </div>
            <button type="submit" class="btn btn-primary">Salvar</button>
        </form>
    </div>
</div>

</body>
</html>

