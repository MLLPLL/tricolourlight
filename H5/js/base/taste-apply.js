$(function(){
    $('.select-item p').on('click',function(){
        $(this).addClass('on').siblings().removeClass('on')
    })
})