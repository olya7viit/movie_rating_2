<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <%--@elvariable id="filmForm" type=""--%>
    <form:form method="POST" modelAttribute="filmForm" action="/admin/filmsPage/add-film">
      <h2>Добавить фильм</h2>
      <div>
        <form:input type="text" path="name" placeholder="Name"
                    autofocus="true"></form:input>
        <form:errors path="name"></form:errors>
          ${nameError}
      </div>
      <div>
        <form:input type="text" path="releaseYear" placeholder="Year of release"
                    autofocus="true"></form:input>
        <form:errors path="releaseYear"></form:errors>
          ${releaseYearError}
      </div>
      <div>
        <form:input type="text" path="genre" placeholder="Genre"
                    autofocus="true"></form:input>
        <form:errors path="genre"></form:errors>
          ${genreError}
      </div>
      <div>
        <form:input type="text" path="annotation" placeholder="Annotation"
                    autofocus="true"></form:input>
        <form:errors path="annotation"></form:errors>
          ${annotationError}
      </div>
        <div>
            <form:select path="producer" >
                <form:option value="NONE" label="--- Producer ---" />
                <form:options items="${producerList}" />
            </form:select>

        </div>
      <button type="submit">Добавить</button>
    </form:form>
  </div>


  </br></br>

    <table>
    <thead>
    <th>Name</th>
    <th>Year of release</th>
    <th>Genre</th>
    <th>Producer</th>
    <th>Annotation</th>
    </thead>
    <c:forEach items="${allFilms}" var="film">
        <tr>
        <td>${film.name}</td>
        <td>${film.releaseYear}</td>
        <td>${film.genre}</td>
        <td>${film.producer.surname} ${film.producer.name}</td>
        <td>${film.annotation}</td>

        <td>
          <form action="${pageContext.request.contextPath}/admin/filmsPage" method="post">
            <input type="hidden" name="filmId" value="${film.id}"/>
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