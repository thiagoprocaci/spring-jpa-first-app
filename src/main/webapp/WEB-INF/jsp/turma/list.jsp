
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Listar Turmas</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <div class="container" style="margin-top: 20px">
        <div>
            <h2>Listagem das Turmas</h2>
        </div>
        <div>
            <table class="table">
                <tr>

                    <th>
                        ID
                    </th>
                    <th>
                        Descrição
                    </th>
                </tr>
                <c:forEach var="turma" items="${turmaList}">
                    <tr>
                        <td>
                            ${turma.id}
                        </td>
                        <td>
                                ${turma.descricao}
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</body>
</html>
