
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">


    <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Cadastros
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="<%=request.getContextPath()%>/turma/create">Turma</a>
                <a class="dropdown-item" href="<%=request.getContextPath()%>/disciplina/create">Disciplina</a>
                <a class="dropdown-item" href="<%=request.getContextPath()%>/aluno/create">Aluno</a>
                <a class="dropdown-item" href="<%=request.getContextPath()%>/professor/create">Professor</a>
                <a class="dropdown-item" href="<%=request.getContextPath()%>/alocacao/create">Alocação</a>
            </div>
        </li>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Listagens
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown2">
                <a class="dropdown-item" href="<%=request.getContextPath()%>/turma/list">Turma</a>
                <a class="dropdown-item" href="<%=request.getContextPath()%>/disciplina/list">Disciplina</a>
                <a class="dropdown-item" href="<%=request.getContextPath()%>/aluno/list">Aluno</a>
                <a class="dropdown-item" href="<%=request.getContextPath()%>/professor/list">Professor</a>

            </div>
        </li>

    </ul>

    </div>
    </nav>
