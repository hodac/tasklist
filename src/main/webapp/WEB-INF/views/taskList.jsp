<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Seznam task listu</title>
</head>

<body>

  <h3>Existujici task listy:</h3>

  <ul>
    <c:forEach var="list" items="${taskLists}">
      <li><a href="/taskListDetail/${list.id}">${list.nazev}</a>
      </li>
    </c:forEach>
  </ul>

  <form:form modelAttribute="taskList" method="post">
    <h3>Novy task list</h3>
    <div>
      <label for="nazev">Nazev</label>
      <form:input id="nazev" path="nazev" type="text" />
    </div>

    <div>
      <button type="submit">Pridat</button>
    </div>
  </form:form>



</body>
</html>