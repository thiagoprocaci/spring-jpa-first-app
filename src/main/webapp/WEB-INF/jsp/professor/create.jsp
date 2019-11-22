
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Cadastro de Professor</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="../menu/menu.jsp" />
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
                <label for="idDisciplinas">Especializado nas disciplinas</label>
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
