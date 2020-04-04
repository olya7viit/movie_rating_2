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
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/styleManagement.css">
    <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
    <script src="https://use.fontawesome.com/0ca06f29a6.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/jquery-3.4.1.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js" integrity="sha256-T0Vest3yCU7pafRw9r+settMBX6JkKN06dqBnpQ8d30=" crossorigin="anonymous"></script>
    <script src="${contextPath}/resources/js/script.js"></script>
    <script src="${contextPath}/resources/js/scriptTab.js"></script>
</head>

<body>

<header role="banner">
    <div class="container">
        <div class="brand">Project Name</div>
        <nav>
            <ul class="menu">
                <sec:authorize access="hasRole('ROLE_ADMIN')"><li><a href="/">Управление</a></li></li></sec:authorize>
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

<!------------------------ Вкладки ---------------------------------------------->
<div class="naccs">
    <div class="grid">
        <div class="gc gc--1-of-3">
            <div class="menu">
                <div class="active"><span class="light"></span><span>Информация</span></div>
                <div><span class="light"></span><span>Фильмы</span></div>
                <div><span class="light"></span><span>Актеры</span></div>
                <div><span class="light"></span><span>Режисеры</span></div>
                <div><span class="light"></span><span>Комментарии</span></div>
            </div>
        </div>
        <div class="gc gc--2-of-3">
            <ul class="nacc">
                <li class="active">
                    <div>
                        <p>Добавить ссылку НАЗАД</p>
                    </div>
                </li>
<!---------------------------------------Фильмы-------------------------------------------------->
                <li>
                    <div>
                        <div>
                            <h4><a class = "linkToAdd" href="${pageContext.request.contextPath}/admin/addFilm">Добавить новый фильм</a></h4>
                        </div>

                        <table>
                            <thead>
                            <th colspan="2">Фильм</th>
                            <th>Год</th>
                            <th>Жанр</th>
                            <th>Режисер</th>
                            <th>Время</th>
                            </thead>

                            <c:forEach items="${allFilms}" var="film">
                                <tr>
                                    <td><img src="${film.photoPath}"></td>
                                    <td>${film.name}</td>
                                    <td>${film.releaseYear}</td>
                                    <td>${film.genre}</td>
                                    <td>${film.producer.surname} ${film.producer.name}</td>
                                    <td>${film.duration}</td>
                                    <td>
                                        <form action="${pageContext.request.contextPath}/admin/filmsPage" method="post">
                                            <input type="hidden" name="filmId" value="${film.id}"/>
                                            <input type="hidden" name="action" value="delete"/>
                                            <button type="submit" class="dakisvan">Удалить</button>
                                        </form>

                                    </td>
                                    <td>
                                        <form action="${pageContext.request.contextPath}/admin/updateFilm" method="get">
                                            <input type="hidden" name="filmId" value="${film.id}"/>
                                            <button type="submit" class="dakisvan">Редактировать</button>
                                        </form>

                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </li>
 <!------------------------------------------------------------------------------------------>
                <li>
                    <div>
                        <p>A vine (Latin vīnea "grapevine", "vineyard", from vīnum "wine") in the narrowest sense is the grapevine (Vitis), but more generally it can refer to any plant with a growth habit of trailing or scandent (that is, climbing) stems, lianas or runners.
                            The word also can refer to such stems or runners themselves, for instance when used in wicker work.[1][2] In the United Kingdom, the term "vine" applies almost exclusively to the grapevine. The term "climber" is used for all climbing plants.[3]</p>
                    </div>
                </li>
                <li>
                    <div>
                        <p>Lemonade is any of various sweetened beverages found around the world, all characterized by lemon flavor. Most lemonade varieties can be separated into two distinct types: cloudy and clear; each is known simply as "lemonade" (or a cognate) in countries
                            where dominant.[1] Cloudy lemonade, generally found in North America and India, is a traditionally homemade drink made with lemon juice, water, and sweetener such as cane sugar or honey.[2] Found in the United Kingdom, Ireland, South Africa, Australia,
                            and New Zealand, clear lemonade is a lemon flavoured carbonated soft drink. Not to be confused with Sprite a lemon-lime flavored, soft drink.</p>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>
<!------------------------------------------------------------------------>


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