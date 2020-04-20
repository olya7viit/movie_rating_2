<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>

<head>
    <title>Landing Page — Practice</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/normalize.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style2.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/styleRating.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/styleRatingAnonim.css">
    <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
    <script src="https://use.fontawesome.com/0ca06f29a6.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/jquery-3.4.1.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js" integrity="sha256-T0Vest3yCU7pafRw9r+settMBX6JkKN06dqBnpQ8d30=" crossorigin="anonymous"></script>
    <script src="${contextPath}/resources/js/script.js"></script>
</head>

<body>

<header role="banner">
    <div class="container">
        <div class="brand">Project Name</div>
        <nav>
            <ul class="menu">
                <sec:authorize access="hasRole('ROLE_ADMIN')"><li><a href="/management">Управление</a></li></li></sec:authorize>
                <li><a href="/">Главная</a></li>
                <li><a href="${pageContext.request.contextPath}/user/allActors">Актеры</a></li>
                <li><a href="${pageContext.request.contextPath}/user/allProducers">Продюсеры</a></li>
                <sec:authorize access="isAuthenticated()">
                    <li><a href="${pageContext.request.contextPath}/user/bookmarkPage/${pageContext.request.userPrincipal.principal.id}">Закладки</a></li>
                </sec:authorize>
                <sec:authorize access="!isAuthenticated()">
                    <li><a href="/login" class=" svalokan-big openmodal">   Войти</a></li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <li><a href="/logout" >   Выйти</a></li>
                    <li><a href="/">Привет, ${pageContext.request.userPrincipal.name}</a></li>
                </sec:authorize>
            </ul>
        </nav>
    </div>
</header>

<div class="jumbotron">
    <div class="container">
        <h1>Films</h1>
    </div>
</div>

<!------------Всплывающее окно---------------->
<div class="kadobagud" aria-hidden="true">
    <div class="angebes-koverla">
        <div class="doveacko-gangeroun">
            <h2>Login Your Account</h2>
            <a href="/" class="valokan-close closemodal" aria-hidden="true">×</a>
        </div>

        <form method="POST" action="/login">
            <div class="davasgu-kevanud">
                <input name="username" type="text" placeholder="Login" autofocus="true"/><br>
                <input name="password" type="password" placeholder="Password"/>
            </div>
            <button type="submit" class="dakisvan">Log In</button>
            <h3><a class = "registration" href="/registration">Зарегистрироваться</a></h3>
        </form>
    </div>
</div>
<!---------------------------------------->

<div class="blog">
    <div class="container">
        <div class="post">

            <!--[if lte IE 7]><style>#reviewStars-input{display:none}</style><![endif]-->

            <div id="reviewStars-input">
                <sec:authorize access="isAuthenticated()">
                    <form action="${pageContext.request.contextPath}/filmPage/${oneFilm.getId()}" method="post">
                        <input type="hidden" name="filmId" value="${oneFilm.getId()}"/>

                        <input id="star-4" type="submit" name="value" value="5"/>
                        <label title="5" for="star-4"></label>
                        <input id="star-3" type="submit" name="value" value="4"/>
                        <label title="4" for="star-3"></label>

                        <input id="star-2" type="submit" name="value" value="3"/>
                        <label title="3" for="star-2"></label>

                        <input id="star-1" type="submit" name="value" value="2"/>
                        <label title="2" for="star-1"></label>

                        <input id="star-0" type="submit" name="value" value="1"/>
                        <label title="1" for="star-0"></label>
                    </form>
                </sec:authorize>
                <sec:authorize access="!isAuthenticated()">
                    <div id="reviewStars-input1">
                        <input id="star-7" type="button" name="value" value="5"/>
                        <label title="5" for="star-4"></label>
                        <div id="rating">${ratingServise.oneFilmRating(oneFilm.getId())}</div>
                    </div>

                </sec:authorize>
            </div>

            <img src="${oneFilm.photoPath}" alt="">
            <h3>${oneFilm.name}</h3>
            <p class="date">${oneFilm.releaseYear}</p>
            <p>Продолжительность: ${oneFilm.duration}</p>
            <p>Жанр: ${oneFilm.genre}</p>
            <p>Режиссёр: ${oneFilm.producer.surname} ${oneFilm.producer.name}</p>
            <p>Актеры: <c:forEach items="${oneFilm.actors}" var="actor">${actor.surname}; </c:forEach></p>
            <p>${oneFilm.annotation}</p>


            <div id="commentBlock">
                <c:forEach items="${comments}" var="comment">

                    <div class='comment'>Автор: <strong>${comment.userName}</strong><br>${comment.comment}

                        <c:if test="${pageContext.request.userPrincipal.name == comment.userName}">
                            <form action="${pageContext.request.contextPath}/filmPage/deleteReview/${oneFilm.getId()}" method="post">
                                <input type="hidden" name="reviewId" value="${comment.id}"/>
                                <input type="hidden" name="action" value="delete"/>
                                <button type="submit" >Удалить</button>
                            </form>
                        </c:if>
                    </div>
                </c:forEach>

            </div>
            <sec:authorize access="isAuthenticated()">
                <%--@elvariable id="reviewForm" type=""--%>
                <form:form method="POST"  modelAttribute="reviewForm" action="/filmPage/addComment/${oneFilm.getId()}">
                    <form:textarea  path="comment" placeholder="Введите ваш комментарий" cols="50" rows="3" autofocus="true"/>
                    <p><form:input path="idFilm" type="hidden" name="idFilm" value="${oneFilm.id}"/>
                        <form:input path="idUser" type="hidden" name="idUser" value="${pageContext.request.userPrincipal.principal.id}"/>
                        <button type="submit">Добавить комментарий</button></p>
                </form:form>
            </sec:authorize>
        </div>
    </div>
</div>


<footer>
    <div class="container">
        <div class="brand">Project Name</div>
        <nav>
            <ul class="menu">
                <li><a href="#">About</a></li>
                <li><a href="#">Team</a></li>
                <li><a href="#">News</a></li>
                <li><a href="#">Contact</a></li>
            </ul>
        </nav>
        <p class="copyright">© 2020 BSUIR</p>
    </div>
</footer>

</body>
</html>