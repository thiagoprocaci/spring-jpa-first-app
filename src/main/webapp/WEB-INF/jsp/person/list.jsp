<%@ page import ="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<body>
<center>
    <h1>
        Person List
    </h1>


    <table>
     <tr>
        <th>
            Edit
        </th>
         <th>
            Delete
        </th>
        <th>
            Id
        </th>
        <th>
            Name
        </th>
        <th>
            Age
        </th>
        <th>
            Favorite Hobby
        </th>
      </tr>
      <c:forEach var="person" items="${personList}">
       <tr>
            <td>
                <a href="<%=request.getContextPath()%>/person/edit?id=${person.id}">Edit</a>
            </td>
            <td>
                <a href="<%=request.getContextPath()%>/person/delete?id=${person.id}">Delete</a>
            </td>
            <td>
                ${person.id}
            </td>
            <td>
                ${person.name}
            </td>
            <td>
                ${person.age}
            </td>
            <td>
                ${person.favoriteHobby.name}
            </td>
        </tr>
      </c:forEach>
     </table>

      <br><br>

      <a href="<%=request.getContextPath()%>/person/create">Add Person</a>

       <br><br>
       <a href="<%=request.getContextPath()%>/hobby/list">Hobby List</a>

</center>
</body>
</html>