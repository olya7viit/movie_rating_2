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
        <form:form method="POST" modelAttribute="filmForm" action="/admin/updateFilm">
            <h2>Добавить фильм</h2>
            <div>
                <form:input type="text" path="name" value="${oneFilm.name}"

                            autofocus="true"/>
                <form:errors path="name"/>
                    ${nameError}
            </div>
            <div>
                <form:input type="text" path="releaseYear" value="${oneFilm.releaseYear}"
                            autofocus="true"/>
                <form:errors path="releaseYear"/>
                    ${releaseYearError}
            </div>
            <div>
                <form:input type="text" path="genre" value="${oneFilm.genre}"
                            autofocus="true"/>
                <form:errors path="genre"/>
                    ${genreError}
            </div>
            <div>
                <form:input type="text" path="duration" value="${oneFilm.duration}"
                            autofocus="true"/>
                <form:errors path="duration"/>
                    ${durationError}
            </div
            <div>
                <form:input type="text" path="photoPath" value="${oneFilm.photoPath}"
                            autofocus="true"/>
                <form:errors path="photoPath"/>
                    ${photoPathError}
            </div>
            <div>
                <form:input type="text" path="annotation" value="${oneFilm.annotation}"
                            autofocus="true"/>
                <form:errors path="annotation"/>
                    ${annotationError}
            </div>
            <label for="producerId"/>
            <form:select id="producerId" path="producerId" >
                <form:options items="${allProducers}"
                              itemLabel="surname"
                              itemValue="id"/>
            </form:select>
            <form:errors path="producerId"/>



            <input type="hidden" name="filmId" value="${oneFilm.id}"/>
            <button type="submit">Изменить</button>
        </form:form>
    </div>
    <h4><a href="/admin/filmsPage">Назад</a></h4>
</div>
</body>
</html>