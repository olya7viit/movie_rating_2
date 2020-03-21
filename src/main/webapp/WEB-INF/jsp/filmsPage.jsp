<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Films</title>
  <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>

<body>
<div>


  <div>
    <form:form method="POST" modelAttribute="filmForm">
      <h2>Добавить фильм</h2>
      <div>
        <form:input type="text" path="username" placeholder="Username"
                    autofocus="true"></form:input>
        <form:errors path="username"></form:errors>
          ${usernameError}
      </div>
      <div>
        <form:input type="password" path="password" placeholder="Password"></form:input>
      </div>
      <div>
        <form:input type="password" path="passwordConfirm"
                    placeholder="Confirm your password"></form:input>
        <form:errors path="password"></form:errors>
          ${passwordError}
      </div>
      <button type="submit">Добавить</button>
    </form:form>
  </div>


  </br></br>

  <table>
    <thead>
    <th>ID</th>
    <th>UserName</th>
    <th>Password</th>
    <th>Roles</th>
    </thead>
    <c:forEach items="${allUsers}" var="user">
      <tr>
        <td>${user.id}</td>
        <td>${user.username}</td>
        <td>${user.password}</td>
        <td>
          <c:forEach items="${user.roles}" var="role">${role.name}; </c:forEach>
        </td>
        <td>
          <form action="${pageContext.request.contextPath}/admin" method="post">
            <input type="hidden" name="userId" value="${user.id}"/>
            <input type="hidden" name="action" value="delete"/>
            <button type="submit">Delete</button>
          </form>

        </td>

      </tr>
    </c:forEach>
  </table>
  <a href="/">Главная</a>
</div>
</body>
</html>