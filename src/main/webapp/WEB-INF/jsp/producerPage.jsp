<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Producers</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>

<body>
<div>
    <%--@elvariable id="producerForm" type=""--%>
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


        </br></br>

        <table>
            <thead>
            <th>Name</th>
            <th>Surname</th>
            <th>Country</th>
            <th>Biography</th>
            <th>Films</th>
            </thead>
            <c:forEach items="${allProducers}" var="producer">
                <tr>
                    <td>${producer.name}</td>
                    <td>${producer.surname}</td>
                    <td>${producer.country}</td>
                    <td>${producer.biography}</td>
                    <td>
                        <c:forEach items="${producer.films}" var="film">${film.name}; </c:forEach>
                    </td>

                    <td>
                        <form action="${pageContext.request.contextPath}/admin/producerPage" method="post">
                            <input type="hidden" name="filmId" value="${producer.id}"/>
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