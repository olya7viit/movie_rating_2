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
                <li><a href="/">Главная</a></li>
                <li><a href="#">Актеры</a></li>
                <li><a href="${pageContext.request.contextPath}/user/allProducers">Продюсеры</a></li>
                <li><a href="#">Закладки</a></li>
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
                <input name="username" type="text" placeholder="Username" autofocus="true"/><br>
                <input name="password" type="password" placeholder="Password"/>
                <!--<h4><a href="/registration">Зарегистрироваться</a></h4>-->
            </div>
          <!--  <a href="#" class="dakisvan">Login</a>-->
            <button type="submit" class="dakisvan">Log In</button>
        </form>
    </div>
</div>
<!---------------------------------------->
<div class="blog">
    <div class="container">
        <div class="post">
            <c:forEach items="${allFilms}" var="film">
                <img src="${film.photoPath}" alt="">
                <h3>${film.name}</h3>
                <p class="date">${film.releaseYear}</p>
                <p>Продолжительность: ${film.duration}</p>
                <p>Жанр: ${film.genre}</p>
                <p>Режиссёр:: ${film.producer.surname} ${film.producer.name}</p>
                <p>${film.annotation}</p>
            </c:forEach>
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