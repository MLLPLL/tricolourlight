$(document).ready(function() {
    $('.navbtn').click(function(){$('.nav').slideToggle()});
    $('.nav li li a:last').css('border','none');
    $('.searchbtn').click(
        function(){$('.search').fadeToggle();}
    );
    $('.sub_search').click(
        function(){$('.subsearch').fadeToggle();}
    );
});
	