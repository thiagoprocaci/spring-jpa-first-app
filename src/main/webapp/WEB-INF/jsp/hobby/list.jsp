<%@ page import ="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<body>
<center>
    <h1>
        Hobby List
    </h1>


    <table>
     <tr>
        <th>
            Edit
        </th>
        <th>
            Id
        </th>
        <th>
            Name
        </th>
      </tr>
      <c:forEach var="hobby" items="${hobbyList}">
       <tr>
            <td>
                <a href="<%=request.getContextPath()%>/hobby/edit?id=${hobby.id}">Edit</a>
            </td>
            <td>
                <c:out value="${hobby.id}" />
            </td>
            <td>
                <c:out value="${hobby.name}" />
            </td>
        </tr>
      </c:forEach>
     </table>

      <br><br>
      <a href="<%=request.getContextPath()%>/hobby/create">Add Hobby</a>
      <br><br>
       <a href="<%=request.getContextPath()%>/person/list">Person List</a>
</center>
</body>
</html>