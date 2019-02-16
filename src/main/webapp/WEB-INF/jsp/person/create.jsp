<%@ page import ="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<body>
<center>
    <h1>
         Create Person
    </h1>

    ${message}
    <br><br>
    <form method="post" action="<%=request.getContextPath()%>/person/create">
        Name:

        <input type="text" name="name"  >
        <br><br>
        Age:
        <input type="number" name="age" >
        <br><br>
        Hobby:
        <select name="idHobby">
            <c:forEach var="hobby" items="${hobbyList}">
                <option value="${hobby.id}">${hobby.name}</option>
            </c:forEach>
        </select>
        <br><br>
        <input type="submit" value="Save" />
    </form>

    <br><br>
    <a href="<%=request.getContextPath()%>/person/list">Person List</a>

</center>
</body>
</html>