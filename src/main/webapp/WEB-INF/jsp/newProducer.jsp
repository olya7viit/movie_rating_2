<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Добавление продюсера</title>
</head>

<body>
<div>
    <form:form method="POST" modelAttribute="producerForm">
        <h2>Добавление продюсера</h2>
        <div>
            <form:input type="text" path="name" placeholder="Name"
                        autofocus="true"></form:input>
            <form:errors path="name"></form:errors>
                ${nameError}
        </div>

        <div>
            <form:input type="text" path="surname" placeholder="Surname"
                        autofocus="true"></form:input>
            <form:errors path="surname"></form:errors>
                ${surnameError}
        </div>

        <div>
            <form:input type="text" path="country" placeholder="Country"
                        autofocus="true"></form:input>
            <form:errors path="country"></form:errors>
                ${countryError}
        </div>

        <div>
            <form:input type="text" path="biography" placeholder="Biography"
                        autofocus="true"></form:input>
            <form:errors path="biography"></form:errors>
                ${biographyError}
        </div>

        <button type="submit">Добавить</button>
    </form:form>
    <a href="/">Главная</a>
</div>
</body>
</html>