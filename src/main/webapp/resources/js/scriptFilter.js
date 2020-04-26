$(document).on('click', '.sort', function(e){
    $(this).hasClass('desc') || $(this).hasClass('asc') ?
        $(this).toggleClass('asc desc') : $(this).addClass('desc');


    if($(this).hasClass('desc') || $(this).hasClass('asc')){
        $('.sort').click(function () {
            var par1=$('.sort').val();
            alert(par1)
            $.ajax({
                type:'POST',//тип запроса
                data:{param1:par1},//параметры запроса
                /*url : window.location + "mvcmethod",*/
                /* url : ${pageContext.request.contextPath}+"/mvcmethod",*/
                /*url:"<c:url value='mvcmethod'/> ",*/
                url:'/mvcmethod',
                // url:<c:url value= '/mvcmethod' /> ,//url адрес обработчика
                //success: funcSuccess//возвращаемый результат от сервера
            });
        });
    }
});

function checkedRadio(checkedGenre) {
    if(checkedGenre == 'Все')
        $('#radio-0').attr('checked', 'true');
    if(checkedGenre == 'Детектив')
        $('#radio-1').attr('checked', 'true');
    if(checkedGenre == 'Драма')
        $('#radio-2').attr('checked', 'true');
    if(checkedGenre == 'Комедия')
        $('#radio-3').attr('checked', 'true');
    if(checkedGenre == 'Мультфильм')
        $('#radio-4').attr('checked', 'true');
    if(checkedGenre == 'Семейный')
        $('#radio-5').attr('checked', 'true');
    if(checkedGenre == 'Ужасы')
        $('#radio-6').attr('checked', 'true');
    if(checkedGenre == 'Фэнтези')
        $('#radio-7').attr('checked', 'true');
    if(checkedGenre == 'Боевик')
        $('#radio-8').attr('checked', 'true');
    if(checkedGenre == 'Приключения')
        $('#radio-9').attr('checked', 'true');
}

