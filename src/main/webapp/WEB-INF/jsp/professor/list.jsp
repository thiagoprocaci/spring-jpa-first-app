
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Listar Professores</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container" style="margin-top: 20px">
    <div>
        <h2>Listagem das Professores</h2>
    </div>
    <div>
        <table class="table">
            <tr>

                <th>
                    ID
                </th>
                <th>
                    Nome
                </th>
                <th>
                    Formação
                </th>
                <th>
                    Especialista em
                </th>
                <th>
                    Alocações
                </th>
            </tr>
            <c:forEach var="professor" items="${professorList}">
                <tr>
                    <td>
                            ${professor.id}
                    </td>
                    <td>
                            ${professor.nome}
                    </td>
                    <td>
                            ${professor.formacao}
                    </td>
                    <td>
                        <c:forEach var="disciplina" items="${professor.disciplinas}">
                            ${disciplina.nome} <br>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach var="alocacao" items="${professor.alocacoes}">
                            ${alocacao.turma.descricao}, ${alocacao.disciplina.nome}, ${alocacao.horario} <br>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>
