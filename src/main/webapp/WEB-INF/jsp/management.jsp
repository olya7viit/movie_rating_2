<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>

<head>
    <title>КиноTOP</title>
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
        <div class="brand">КиноTOP &#8657</div>
        <nav>
            <ul class="menu">
                <sec:authorize access="hasRole('ROLE_ADMIN')"><li><a href="/management">Управление</a></li></li></sec:authorize>
                <li><a href="/">Главная</a></li>
                <li><a href="${pageContext.request.contextPath}/user/allActors">Актеры</a></li>
                <li><a href="${pageContext.request.contextPath}/user/allProducers">Продюсеры</a></li>
                <li><a href="#">Закладки</a></li>
                <sec:authorize access="!isAuthenticated()">
                    <li><a href="/login" class=" svalokan-big openmodal">   Войти</a></li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <li><a href="/logout" >   Выйти</a></li>
                    <li><a href="/">Привет, ${pageContext.request.userPrincipal.principal.username} </a></li>
                </sec:authorize>
            </ul>
        </nav>
    </div>
</header>

<div class="jumbotron">
    <div class="container">
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
                <div><span class="light"></span><span>Пользователи</span></div>
            </div>
        </div>
        <div class="gc gc--2-of-3">
            <ul class="nacc">
                <li class="active">
                    <div>


                        <div class="services">
                            <div class="container">
                                <div class="service">
                                    <i class="fa fa-film fa-3x" aria-hidden="true"></i>
                                    <p> Количетво фильмов: ${countFilms}</p>
                                </div>
                                <div class="service">
                                    <i class="fa fa-user fa-3x" aria-hidden="true"></i>
                                    <p> Количество пользователей:  ${countUsers}</p>
                                </div>
                                <div class="service">
                                    <i class="fa fa-comments fa-3x" aria-hidden="true"></i>
                                    <p> Количество комментариев:  ${countComments}</p>
                                </div>
                            </div>
                        </div>


                    </div>
                </li>
                <!---------------------------------------Фильмы-------------------------------------------------->
                <li>
                    <div>
                        <div>
                            <h4><a class = "linkToAdd" href="${pageContext.request.contextPath}/management/addFilm">Добавить новый фильм</a></h4>
                        </div>

                        <table>
                            <thead>
                            <th colspan="2">Фильм</th>
                            <th>Год</th>
                            <th>Жанр</th>
                            <th>Режисер</th>
                            <th>Актеры</th>
                            <th>Время</th>
                            </thead>

                            <c:forEach items="${allFilms}" var="film">
                                <tr>
                                    <td><img src="${film.photoPath}"></td>
                                    <td>${film.name}</td>
                                    <td>${film.releaseYear}</td>
                                    <td>${film.genre}</td>
                                    <td>${film.producer.surname} ${film.producer.name}</td>
                                    <td> <c:forEach items="${film.actors}" var="actor">${actor.surname}; </c:forEach></td>
                                    <td>${film.duration}</td>
                                    <td>
                                        <form action="${pageContext.request.contextPath}/management/filmsPage" method="post">
                                            <input type="hidden" name="filmId" value="${film.id}"/>
                                            <input type="hidden" name="action" value="delete"/>
                                            <button type="submit" class="dakisvan">Удалить</button>
                                        </form>

                                    </td>
                                    <td>
                                        <form action="${pageContext.request.contextPath}/management/updateFilm" method="get">
                                            <input type="hidden" name="filmId" value="${film.id}"/>
                                            <button type="submit" class="dakisvan">Редактировать</button>
                                        </form>

                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </li>
                <!--------------------------------------------------Actors---------------------------------------------->
                <li>
                    <div>
                        <div>
                            <h4><a class = "linkToAdd" href="${pageContext.request.contextPath}/management/addActor">Добавить нового актера</a></h4>
                        </div>

                        <table>
                            <thead>
                            <th colspan="2">Актер</th>
                            <th>Возраст</th>
                            <th>Страна</th>
                            </thead>

                            <c:forEach items="${allActors}" var="actor">
                                <tr>
                                    <td><img src="${actor.photoPath}"></td>
                                    <td>${actor.surname} ${actor.name}</td>
                                    <td>${actor.age}</td>
                                    <td>${actor.country}</td>

                                    <td>
                                        <form action="${pageContext.request.contextPath}/management/actorsPage" method="post">
                                            <input type="hidden" name="actorId" value="${actor.id}"/>
                                            <input type="hidden" name="action" value="delete"/>
                                            <button type="submit" class="dakisvan">Удалить</button>
                                        </form>

                                    </td>
                                    <td>
                                        <form action="${pageContext.request.contextPath}/management/updateActor" method="get">
                                            <input type="hidden" name="actorId" value="${actor.id}"/>
                                            <button type="submit" class="dakisvan">Редактировать</button>
                                        </form>

                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </li>
                <!---------------------------------------Режисеры-------------------------------------------------->
                <li>
                    <div>
                        <div>
                            <h4><a class = "linkToAdd" href="${pageContext.request.contextPath}/management/addProducer">Добавить нового режисера</a></h4>
                        </div>
                        <table>
                            <thead>
                            <th colspan="2">Режисер</th>
                            <th>Страна</th>
                            <th>Фильмы</th>
                            </thead>

                            <c:forEach items="${allProducers}" var="producer">
                                <tr>
                                    <td><img src="${producer.photoPath}"></td>
                                    <td>${producer.surname} ${producer.name}</td>
                                    <td>${producer.country}</td>
                                    <td>
                                        <c:forEach items="${producer.films}" var="film">${film.name}; </c:forEach>
                                    </td>
                                    <!-- <td>${producer.biography}</td>-->
                                    <td>
                                        <form action="${pageContext.request.contextPath}/management/producerPage" method="post">
                                            <input type="hidden" name="producerId" value="${producer.id}"/>
                                            <input type="hidden" name="action" value="delete"/>
                                            <button type="submit" class="dakisvan">Удалить</button>
                                        </form>
                                    </td>
                                    <td>
                                        <form action="${pageContext.request.contextPath}/management/updateProducer" method="get">
                                            <input type="hidden" name="producerId" value="${producer.id}"/>
                                            <button type="submit" class="dakisvan">Редактировать</button>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </li>
                <!----------------------------------------------Users------------------------------------------------->
                <li>
                    <div>


                        <table>
                            <thead>

                            <th>Логин</th>
                            <th>Пароль</th>

                            </thead>

                            <c:forEach items="${allUser}" var="user">
                                <tr>
                                    <td>${user.username} </td>
                                    <td>${user.password}</td>

                                    <td>
                                        <form action="${pageContext.request.contextPath}/management/usersPage" method="post">
                                            <input type="hidden" name="userId" value="${user.id}"/>
                                            <input type="hidden" name="action" value="delete"/>
                                            <button type="submit" class="dakisvan">Удалить</button>
                                        </form>

                                    </td>

                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </li>
                <!----------------------------------------------------------------------------------------------->
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