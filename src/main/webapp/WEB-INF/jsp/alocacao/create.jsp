
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Cadastro de Alocação</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container" style="margin-top: 20px">
    <div>
        <h2>Cadastro de alocação</h2>
    </div>
    <div>
        <form method="post" action="<%=request.getContextPath()%>/alocacao/create">
            <div class="form-group">
                <label for="horario">Horário</label>
                <input type="text" class="form-control" name="horario" id="horario"  placeholder="Entre com o horário da alocação">
            </div>

            <div class="form-group">
                <label for="idTurma">Turma</label>
                <select class="form-control" name="idTurma" id="idTurma">
                    <c:forEach var="turma" items="${turmaList}">
                        <option value="${turma.id}">${turma.descricao}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="idProfessor">Professor</label>
                <select class="form-control" name="idProfessor" id="idProfessor">
                    <c:forEach var="professor" items="${professorList}">
                        <option value="${professor.id}">${professor.nome}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="idDisciplina">Disciplina</label>
                <select class="form-control" name="idDisciplina" id="idDisciplina">
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

