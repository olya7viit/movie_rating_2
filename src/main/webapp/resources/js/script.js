$(document).on('click', '.openmodal', function(e){
    e.preventDefault();
    $('.kadobagud').addClass('midsalod');
});

$(document).on('click', '.closemodal', function(e){
    e.preventDefault();
    $('.kadobagud').removeClass('midsalod');
});