
function fun_like(value){
    if(value == true){

        $('.like-toggle').toggleClass('like-active');
        $('.like-toggle').next().toggleClass('hidden');
    }
}

$(function(){
    $('.like-toggle').click(function(){
        $(this).toggleClass('like-active');
        $(this).next().toggleClass('hidden');
        alert($(this).hasClass())
    });
});


