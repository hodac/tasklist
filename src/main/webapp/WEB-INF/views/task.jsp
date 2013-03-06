<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task detail</title>

</head>
<body>
  <h3>Editace tasku</h3>
  <form:form modelAttribute="task" method="put">
    <fieldset>
      <div>
        <label for="text">Text</label>
        <form:input id="text" path="text" type="text" />

        <label for="priority">Priority</label>
        <form:input id="priority" path="priority" type="text" />

        <label for="done">Done</label>
        <form:checkbox id="done" path="done" />

        <form:hidden id="id" path="id" />
        <form:hidden id="taskListId" path="taskListId" />
      </div>

      <div>
        <button type="submit">Ulozit</button>
      </div>

    </fieldset>
  </form:form>

</body>
</html>