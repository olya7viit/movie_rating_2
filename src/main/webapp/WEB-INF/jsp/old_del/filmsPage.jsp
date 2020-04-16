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
     <h4><a href="${pageContext.request.contextPath}/admin/addFilm">Добавить</a></h4>

  </div>

    <table>
    <thead>
    <th>Name</th>
    <th>Photo_Path</th>
    <th>Year of release</th>
    <th>Genre</th>
    <th>Producer</th>
    <th>Duration</th>
    <th>Annotation</th>
    </thead>
    <c:forEach items="${allFilms}" var="film">
        <tr>
        <td>${film.name}</td>
        <td>${film. photoPath}</td>
        <td>${film.releaseYear}</td>
        <td>${film.genre}</td>
        <td>${film.producer.surname} ${film.producer.name}</td>
        <td>${film.duration}</td>
        <td>${film.annotation}</td>

        <td>
          <form action="${pageContext.request.contextPath}/admin/filmsPage" method="post">
            <input type="hidden" name="filmId" value="${film.idReview}"/>
            <input type="hidden" name="action" value="delete"/>
            <button type="submit">Delete</button>
          </form>

        </td>
            <td>
                <form action="${pageContext.request.contextPath}/admin/updateFilm" method="get">
                    <input type="hidden" name="filmId" value="${film.idReview}"/>
                    <button type="submit">Update</button>
                </form>

            </td>
      </tr>
    </c:forEach>
  </table>


  <a href="/">Главная</a>
</div>
</body>
</html>