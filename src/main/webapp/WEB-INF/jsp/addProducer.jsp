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
        <%--@elvariable id="producerForm" type=""--%>
        <form:form method="POST" modelAttribute="producerForm" action="/admin/addOneProducer/add-Producer">
            <h2>Добавление продюсера</h2>
            <div>
                <form:input type="text" path="name" placeholder="Name"
                            autofocus="true"/>
                <form:errors path="name"/>
                    ${nameError}
            </div>

            <div>
                <form:input type="text" path="surname" placeholder="Surname"
                            autofocus="true"/>
                <form:errors path="surname"/>
                    ${surnameError}
            </div>

            <div>
                <form:input type="text" path="country" placeholder="Country"
                            autofocus="true"/>
                <form:errors path="country"/>
                    ${countryError}
            </div>

            <div>
                <form:input type="text" path="biography" placeholder="Biography"
                            autofocus="true"/>
                <form:errors path="biography"/>
                    ${biographyError}
            </div>
            <div>
                <form:input type="text" path="photoPath" placeholder="Photo Path"
                            autofocus="true"/>
                <form:errors path="photoPath"/>
                    ${photoPathError}
            </div>

            <button type="submit">Добавить</button>
        </form:form>
    </div>
    <h4><a href="/admin/producerPage">Назад</a></h4>
</div>
</body>
</html>
