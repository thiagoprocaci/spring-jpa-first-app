
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">


    <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Cadastros
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="<%=request.getContextPath()%>/medico/cadastro">Medico</a>
                <a class="dropdown-item" href="<%=request.getContextPath()%>/paciente/cadastro">Paciente</a>
                <a class="dropdown-item" href="<%=request.getContextPath()%>/exame/cadastro">Exame</a>
                <a class="dropdown-item" href="<%=request.getContextPath()%>/agendamento/cadastro">Agendamento</a>

            </div>
        </li>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Listagens
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown2">
                <a class="dropdown-item" href="<%=request.getContextPath()%>/agendamento/list">Agendamento</a>

            </div>
        </li>

    </ul>

    </div>
    </nav>
