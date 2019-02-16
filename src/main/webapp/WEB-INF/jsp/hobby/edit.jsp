<%@ page import ="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<body>
<center>
    <h1>
         Edit Hobby
    </h1>

     ${message}

    <br><br>
    <form method="post" action="<%=request.getContextPath()%>/hobby/edit">
        Name:

        <input type="text" name="name" value="${hobby.name}"  >

        <br><br>
        <input type="hidden" name="id" value="${hobby.id}"  >

        <input type="submit" value="Save" />
    </form>

     <br><br>
     <a href="<%=request.getContextPath()%>/hobby/list">Hobby List</a>


</center>
</body>
</html>