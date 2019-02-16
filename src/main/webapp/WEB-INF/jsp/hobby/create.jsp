<%@ page import ="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<body>
<center>
    <h1>
         Create Hobby
    </h1>

     ${message}

    <br><br>
    <form method="post" action="<%=request.getContextPath()%>/hobby/create">
        Name:

        <input type="text" name="name"  >

        <br><br>

        <input type="submit" value="Save" />
    </form>

     <br><br>
     <a href="<%=request.getContextPath()%>/hobby/list">Hobby List</a>

</center>
</body>
</html>