$(function(){
    $('.like-toggle').click(function(){
        $(this).toggleClass('like-active');
        $(this).next().toggleClass('hidden');
    });
});
var btnLogin = document.querySelector('idButton');

btnLogin.addEventListener('click', function (e) {
    e.preventDefault();
    alert("1111111111111");
    event.preventDefault(); // Убираем событие отправки формы
alert("1111111111111");
        // Вызываете обработчик формы
        document.getElementById('fform').submit();

});