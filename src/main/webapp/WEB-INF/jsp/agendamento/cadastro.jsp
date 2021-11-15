
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Agendamento</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="../menu/menu.jsp" />
<div class="container" style="margin-top: 20px">
    <div>
        <h2>Agendamento</h2>
    </div>
    <div>
        <form method="post" action="<%=request.getContextPath()%>/agendamento/cadastro">

            <div class="form-group">
                <label for="idMedico">Medico</label>
                <select class="form-control" name="idMedico" id="idMedico">
                    <c:forEach var="medico" items="${medicoList}">
                        <option value="${medico.id}">${medico.nome}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="idPaciente">Paciente</label>
                <select class="form-control" name="idPaciente" id="idPaciente">
                    <c:forEach var="paciente" items="${pacienteList}">
                        <option value="${paciente.id}">${paciente.nome}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="idExame">Exame</label>
                <select class="form-control" name="idExame" id="idExame">
                    <c:forEach var="exame" items="${exameList}">
                        <option value="${exame.id}">${exame.nome}</option>
                    </c:forEach>
                </select>
            </div>
              <div class="form-group">
                <label for="horario">Horario</label>
                <input type="text" class="form-control" name="horario" id="horario"  >
            </div>
            <button type="submit" class="btn btn-primary">Salvar</button>
        </form>
    </div>
</div>

</body>
</html>

