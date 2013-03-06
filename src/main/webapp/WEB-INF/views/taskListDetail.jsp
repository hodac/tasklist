<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail task listu</title>
</head>

<body>

  <h3>Seznam tasku v listu ${taskList.nazev}:</h3>

  <table border=1>
    <thead>
      <tr>
        <th>ID</th>
        <th>Text</th>
        <th>Priority</th>
        <th>Done</th>
        <th></th>
        <th></th>
      </tr>
    </thead>
    <c:forEach var="task" items="${taskList.tasks}">
      <tr>
        <td>${task.id}</td>
        <td>${task.text}</td>
        <td>${task.priority}</td>
        <td>${task.done}</td>
        <td><form:form method="GET" action="/task/${task.id}">
            <input type="submit" value="edit">
          </form:form>
        </td>
        <td><form:form method="DELETE"
            action="/taskListDetail/${task.id}">
            <input type="submit" value="delete">
          </form:form>
        </td>
      </tr>
    </c:forEach>
  </table>

  <form:form modelAttribute="task" method="post">
    <h3>Novy task</h3>
    <fieldset>
      <div>
        <label for="text">Text</label>
        <form:input id="text" path="text" type="text" />

        <label for="priority">Priority</label>
        <form:input id="priority" path="priority" type="text" />

        <label for="done">Done</label>
        <form:checkbox id="done" path="done" />
      </div>

      <div>
        <button type="submit">Pridat</button>
      </div>

    </fieldset>
  </form:form>

</body>
</html>