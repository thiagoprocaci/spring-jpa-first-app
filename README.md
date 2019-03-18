# Aplicação JPA First APP

## Classes


### Application

```
package com.tbp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}


```

### Person

```
package com.tbp.model;

import javax.persistence.*;

@Entity
@Table(name = "pessoa")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "nome")
    String name;
    @Column(name = "idade")
    Integer age;
    @ManyToOne
    @JoinColumn(name = "id_passatempo")
    Hobby favoriteHobby;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Hobby getFavoriteHobby() {
        return favoriteHobby;
    }

    public void setFavoriteHobby(Hobby favoriteHobby) {
        this.favoriteHobby = favoriteHobby;
    }
}


```
### PersonRepository

```
package com.tbp.repository;

import com.tbp.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}

```

### Hobby

```

package com.tbp.model;


import javax.persistence.*;

@Entity
@Table(name = "passatempo")
public class Hobby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "nome")
    String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


```

### HobbyRepository

```

package com.tbp.repository;

import com.tbp.model.Hobby;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HobbyRepository extends CrudRepository<Hobby, Long> {

}


```

### PersonController

```

package com.tbp.controller;

import com.tbp.model.Hobby;
import com.tbp.model.Person;
import com.tbp.repository.HobbyRepository;
import com.tbp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;


@Controller
public class PersonController {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    HobbyRepository hobbyRepository;


    @RequestMapping(value = "/person/create", method = RequestMethod.GET)
    public String createPage(Map<String, Object> model) {
        Iterable<Hobby> hobbies = hobbyRepository.findAll();
        model.put("hobbyList", hobbies);
        return "person/create";
    }

    @RequestMapping(value = "/person/create", method = RequestMethod.POST)
    public void save(@RequestParam("name") String name, @RequestParam("age") Integer age, @RequestParam("idHobby") Long idHobby,
                     Map<String, Object> model) {
        Hobby hobby = hobbyRepository.findOne(idHobby);
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        person.setFavoriteHobby(hobby);
        personRepository.save(person);

        Iterable<Hobby> hobbies = hobbyRepository.findAll();
        model.put("hobbyList", hobbies);
        model.put("message", "Person " + name + " created");
    }


    @RequestMapping(value = "/person/list", method = RequestMethod.GET)
    public String listPage(Map<String, Object> model) {
        Iterable<Person> personList = personRepository.findAll();
        model.put("personList", personList);
        return "person/list";
    }

    @RequestMapping(value = "/person/edit", method = RequestMethod.GET)
    public String editPage(@RequestParam("id") Long id, Map<String, Object> model) {
        Person person = personRepository.findOne(id);
        model.put("person", person);

        Iterable<Hobby> hobbies = hobbyRepository.findAll();
        model.put("hobbyList", hobbies);
        return "person/edit";
    }


    @RequestMapping(value = "/person/edit", method = RequestMethod.POST)
    public void update(@RequestParam("name") String name, @RequestParam("age") Integer age,
                         @RequestParam("idPerson") Long idPerson, @RequestParam("idHobby") Long idHobby,
                       Map<String, Object> model) {
        Hobby hobby = hobbyRepository.findOne(idHobby);
        Person person = personRepository.findOne(idPerson);
        person.setName(name);
        person.setAge(age);
        person.setFavoriteHobby(hobby);
        personRepository.save(person);


        Iterable<Hobby> hobbies = hobbyRepository.findAll();
        model.put("hobbyList", hobbies);
        model.put("person", person);
        model.put("message", "Person " + name + " edited");
    }

    @RequestMapping(value = "person/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("id") Long id) {
        personRepository.delete(id);
        return "redirect:/person/list";
    }

}




```

### HobbyController

```

package com.tbp.controller;

import com.tbp.model.Hobby;
import com.tbp.repository.HobbyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;


@Controller
public class HobbyController {

    @Autowired
    HobbyRepository hobbyRepository;

    @RequestMapping(value = "hobby/create", method = RequestMethod.GET)
    public String createPage() {
        return "hobby/create";
    }

    @RequestMapping(value = "hobby/list", method = RequestMethod.GET)
    public String listPage(Map<String, Object> model) {
        Iterable<Hobby> all = hobbyRepository.findAll();
        model.put("hobbyList", all);
        return "hobby/list";
    }

    @RequestMapping(value = "hobby/edit", method = RequestMethod.GET)
    public String editPage(@RequestParam("id") Long id, Map<String, Object> model) {
        Hobby hobby = hobbyRepository.findOne(id);
        model.put("hobby", hobby);
        return "hobby/edit";

    }

    @RequestMapping(value = "/hobby/create", method = RequestMethod.POST)
    public void create(@RequestParam("name") String name, Map<String, Object> model) {
        Hobby hobby = new Hobby();
        hobby.setName(name);
        hobbyRepository.save(hobby);
        model.put("message", "Hobby " + name + " created");
    }

    @RequestMapping(value = "/hobby/edit", method = RequestMethod.POST)
    public void update(@RequestParam("name") String name, @RequestParam("id") Long id, Map<String, Object> model) {
        Hobby hobby = hobbyRepository.findOne(id);
        hobby.setName(name);
        hobbyRepository.save(hobby);
        model.put("message", "Hobby " + name + " edited");
    }


}


```

### IndexController

```
package com.tbp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index() {
        return "index";
    }


}


```

## Properties

### application.properties

```
# H2 console - http://localhost:8080/jpa-app/h2
spring.h2.console.enabled=true
spring.h2.console.path=/h2


#Configuracoes do banco de dados

# url de conexao com o banco de dados
spring.datasource.url=jdbc:h2:file:~/test2;DB_CLOSE_ON_EXIT=FALSE

# nome do usuario do banco
spring.datasource.username=sa

# senha do banco de dados
spring.datasource.password=

# nome da classe Java resposavel por conectar no banco de dados
spring.datasource.driver-class-name=org.h2.Driver

# propriedade que diz para a aplicacao criar as tabelas no banco de dados.
# Tudo que estiver com @Entity vai se transformar em uma tabela
spring.jpa.hibernate.ddl-auto=update

#contexto da aplicacao
server.context-path=/jpa-app


spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp

```

## JSP

### hobby/create.jsp

```
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

```

### hobby/edit.jsp

```
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

```

### hobby/list.jsp

```
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

```

### person/create.jsp

```
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

```

### person/edit.jsp

```
<%@ page import ="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<body>
<center>
    <h1>
         Edit Person
    </h1>

    ${message}
    <br><br>
    <form method="post" action="<%=request.getContextPath()%>/person/edit">
        Name:

        <input type="text" name="name"  value="${person.name}">
        <br><br>
        Age:
        <input type="number" name="age" value="${person.age}">
        <br><br>
        Hobby:
        <select name="idHobby" >
            <c:forEach var="hobby" items="${hobbyList}">
                <option value="${hobby.id}" ${hobby.id == person.favoriteHobby.id ? 'selected' : ''}>${hobby.name}</option>
            </c:forEach>

        </select>
        <br><br>
        <input type="hidden" name="idPerson" value="${person.id}">
        <input type="submit" value="Save" />
    </form>

    <br><br>
    <a href="<%=request.getContextPath()%>/person/list">Person List</a>


</center>
</body>
</html>

```

### person/list.jsp

```
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

```

### index.jsp

```
<html>
   <head>
        <meta charset="UTF-8">
    </head>

    <body>
               <br><br>
               <a href="<%=request.getContextPath()%>/hobby/create">Add Hobby</a>
               <br><br>
                <a href="<%=request.getContextPath()%>/person/list">Person List</a>
    </body>
</html>

```

## Maven

### pom.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.tbp</groupId>
    <artifactId>jpa-first-app</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>war</packaging>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.5.4.RELEASE</version>
    </parent>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
        </dependency>
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>3.1.0</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
            <version>1.2</version>
        </dependency>

        <!-- To compile JSP files -->
        <dependency>
            <groupId>org.apache.tomcat.embed</groupId>
            <artifactId>tomcat-embed-jasper</artifactId>
        </dependency>
    </dependencies>

    <properties>
        <java.version>1.8</java.version>
    </properties>


</project>

```