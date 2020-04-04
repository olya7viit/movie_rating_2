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
        <form:form method="POST" modelAttribute="filmForm" action="/management/addOneFilm">
            <h2>Добавить фильм</h2>
            <div>
                <form:input type="text" path="name" placeholder="Name"
                            autofocus="true"/>
                <form:errors path="name"/>
                    ${nameError}
            </div>
            <div>
                <form:input type="text" path="releaseYear" placeholder="Year of release"
                            autofocus="true"/>
                <form:errors path="releaseYear"/>
                    ${releaseYearError}
            </div>
            <div>
                <form:input type="text" path="genre" placeholder="Genre"
                            autofocus="true"/>
                <form:errors path="genre"/>
                    ${genreError}
            </div>
            <div>
                <form:input type="text" path="duration" placeholder="Duration"
                            autofocus="true"/>
                <form:errors path="duration"/>
                    ${durationError}
            </div>
            <div>
                <form:input type="text" path="annotation" placeholder="Annotation"
                            autofocus="true"/>
                <form:errors path="annotation"/>
                    ${annotationError}
            </div>

            <div>
                <form:input type="text" path="photoPath" placeholder="Photo Path"
                            autofocus="true"/>
                <form:errors path="photoPath"/>
                    ${photoPathError}
            </div>
            <div>
                <label for="producerId"/>
                <form:select id="producerId" path="producerId" >
                    <form:options items="${allProducers}"
                                  itemLabel="surname"
                                  itemValue="id"/>
                </form:select>
                <form:errors path="producerId"/>
            </div>
            <button type="submit">Добавить</button>
        </form:form>
    </div>
    <h4><a  href="/management">Назад</a></h4>
</div>
</body>
</html>
