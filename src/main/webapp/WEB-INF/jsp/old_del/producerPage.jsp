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

<h4><a href="${pageContext.request.contextPath}/admin/addProducer">Добавить</a></h4>

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
                            <input type="hidden" name="producerId" value="${producer.idReview}"/>
                            <input type="hidden" name="action" value="delete"/>
                            <button type="submit">Delete</button>
                        </form>

                    </td>
                    <td>
                        <form action="${pageContext.request.contextPath}/admin/updateProducer" method="get">
                            <input type="hidden" name="producerId" value="${producer.idReview}"/>
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