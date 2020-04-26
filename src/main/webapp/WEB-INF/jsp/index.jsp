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
  <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/styleLike.css">
  <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/styleFilter.css">
  <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/styleMovieFeed.css">
  <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=PT+Sans:400,700" rel="stylesheet">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" />
  <script src="https://use.fontawesome.com/0ca06f29a6.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
  <script src="${contextPath}/resources/js/jquery-3.4.1.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js" integrity="sha256-T0Vest3yCU7pafRw9r+settMBX6JkKN06dqBnpQ8d30=" crossorigin="anonymous"></script>
  <script src="${contextPath}/resources/js/script.js"></script>
  <script src="${contextPath}/resources/js/scriptLike.js"></script>
  <script src="${contextPath}/resources/js/scriptFilter.js"></script>

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
        <li><a href="${pageContext.request.contextPath}/user/allProducers">Режисеры</a></li>
          <sec:authorize access="isAuthenticated()">
        <li><a href="${pageContext.request.contextPath}/user/bookmarkPage/${pageContext.request.userPrincipal.principal.id}">Закладки</a></li>
          </sec:authorize>
        <sec:authorize access="!isAuthenticated()">
          <li><a href="/login" class=" svalokan-big openmodal">   Войти</a></li>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
          <li><a href="/logout" >   Выйти</a></li>
          <li><a href="/">Привет, ${pageContext.request.userPrincipal.principal.username}  </a></li>

        </sec:authorize>
      </ul>
    </nav>
  </div>
</header>




<div class="jumbotronForIndex">
  <div class="container">
      <!------------------Карусель--------------------------------------------------------------------------->
      <div id="carousel" class="carousel">
          <button class="arrow prev">⇦</button>
          <div class="gallery">
              <ul class="images">
                  <c:forEach items="${allNewFilm2020}" var="newFilm">
                  <li>
                      <img src="${newFilm.photoPath}" alt=""/>
                  </li>
                  </c:forEach>
              </ul>
          </div>
          <button class="arrow next">⇨</button>
      </div>

      <script>
          /* этот код помечает картинки, для удобства разработки */
          let i = 1;
          for(let li of carousel.querySelectorAll('li')) {
              li.style.position = 'relative';
              li.insertAdjacentHTML('beforeend', `<span style="position:absolute;left:0;top:0">${i}</span>`);
              i++;
          }

          /* конфигурация */
          let width = 188; // ширина картинки
          let count = 5; // видимое количество изображений

          let list = carousel.querySelector('ul');
          let listElems = carousel.querySelectorAll('li');

          let position = 0; // положение ленты прокрутки

          carousel.querySelector('.prev').onclick = function() {
              position += width * count;// сдвиг влево
              position = Math.min(position, 0)// последнее передвижение влево может быть не на 3, а на 2 или 1 элемент
              list.style.marginLeft = position + 'px';
          };

          carousel.querySelector('.next').onclick = function() {
              position -= width * count;   // сдвиг вправо
              position = Math.max(position, -width * (listElems.length - count)); // последнее передвижение вправо может быть не на 3, а на 2 или 1 элемент
              list.style.marginLeft = position + 'px';
          };
      </script>

<!------------------------------------------------------------------------------------------------------->
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





<div class="section">
  <p class="filterText">Жанр: </p>
  <form action="${pageContext.request.contextPath}/filter" method="post">
          <div class="container">
            <input type="radio" name="genre" value="Все" id="radio-0" class="aaa">
            <label for="radio-0"><span class="radio">Все</span></label>
          </div>
          <div class="container">
            <input type="radio" name="genre" value="Детектив" id="radio-1">
            <label for="radio-1"><span class="radio">Детектив</span></label>
          </div>
          <div class="container">
            <input type="radio" name="genre" value="Драма" id="radio-2">
            <label for="radio-2"><span class="radio">Драма</span></label>
          </div>
          <div class="container">
            <input type="radio" name="genre" value="Комедия" id="radio-3">
            <label for="radio-3"><span class="radio">Комедия </span></label>
          </div>
          <div class="container">
            <input type="radio" name="genre"  value="Мультфильм" id="radio-4">
            <label for="radio-4"><span class="radio">Мультфильм</span></label>
          </div>
          <div class="container">
            <input type="radio" name="genre" value="Семейный" id="radio-5">
            <label for="radio-5"><span class="radio">Семейный</span></label>
          </div>
          <div class="container">
            <input type="radio" name="genre"  value="Ужасы" id="radio-6">
            <label for="radio-6"><span class="radio">Ужасы </span></label>
          </div>
          <div class="container">
            <input type="radio" name="genre" value="Фэнтези" id="radio-7">
            <label for="radio-7"><span class="radio">Фэнтези </span></label>
          </div>
          <div class="container">
            <input type="radio" name="genre" value="Боевик" id="radio-8">
            <label for="radio-8"><span class="radio">Боевик</span></label>
          </div>
          <div class="container">
            <input type="radio" name="genre" value="Приключения" id="radio-9">
            <label for="radio-9"><span class="radio">Приключения</span></label>
          </div>
          <div class="container">
            <button type="submit" class="buttonForFilter">Выбрать</button>
          </div>
      <script>
          checkedRadio("${checkedGenre}");
      </script>
  </form>
</div>





<!------------Кнопки сортировки---------------->
    <div class="sortDiv">
        <button class="sort" id="name" name="sortType" value="sortRating">Рейтинг</button>
        <button class="sort" id="perc" name="sortType" value="sortYear">Год</button>
    </div>
<!---------------------------------------->





<c:set var="count" value="1"/>
<div class="blog">
  <div class="container">
      <div class="d1">
          <form method="POST" action="/search">
              <input name="search" placeholder="Искать здесь..." type="search">
              <button type="submit"></button>

          </form>
      </div>
    <div class="post">
      <c:if test="${sizeSet==0}"><p style="font-size: 30px ">Совпадений не найдено</p></c:if>
      <c:forEach items="${allFilms}" var="film">
          <c:choose>
          <c:when test="${count <= i}">
        <sec:authorize access="isAuthenticated()">
        <div class="divLike">
          <div class='like'>

            <form action="${pageContext.request.contextPath}/add-bookmark" method="post">
              <input type="hidden" name="idFilm" value="${film.id}"/>
              <input type="hidden" name="idUser" value=" ${pageContext.request.userPrincipal.principal.id}"/>

              <c:if test="${film.existBookmark==true}">
                <button class="like-toggle like-active basic">♥</button>
              </c:if>
              <c:if test="${film.existBookmark==false}">
                <button class="like-toggle basic">♥</button>
              </c:if>

              <span class='hidden'>В закладках</span>
            </form>
          </div>
        </div>
        </sec:authorize>


        <div>
          <img src="${film.photoPath}" alt=""/>
          <h3><a href="${pageContext.request.contextPath}/filmPage/${film.getId()}">
              ${film.name} (${film.releaseYear})</a>
            <img class="starR" src="http://biblefav.org/images/tool_favs1.png"
                 hspace="0"  vspace="0" align="right" class="starR" height="20px">
             <p class="starRText"> ${ratingServise.oneFilmRating(film.getId())}</p>
          </h3>


              <p>Продолжительность: ${film.duration}</p>
              <p>Жанр: ${film.genre}</p>
              <p>Режиссёр: ${film.producer.surname} ${film.producer.name}</p>
              <p>${film.annotation}</p>
             </div>
             </br>  </br>

              <c:set var="count" value="${count+1}"/>
          </c:when>
          </c:choose>
      </c:forEach>

    </div>

      <c:if test="${allFilms.size()>i}">
      <div class="load">
          <form method="POST" action="/">
              <button type="submit">Загрузить еще</button>
          </form>
      </div>
      </c:if>

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