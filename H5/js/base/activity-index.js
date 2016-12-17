$(function(){
    // 绑定前验证登录
         $("#bind-card").on('click',function(){
            $('#login-pop').show();
             $('.rDialog-mask').show();
         });
         $('body').on('click', '.rDialog-btn', function(){
             $('.rDialog').hide();
             $('.rDialog-mask').hide();
        return $.gotoUrl('login.html');
        });
         // //跳转搜索页面
     $('body').on('click', '#search', function(){
        //return $.gotoUrl('securityCenter.html');
        return $.gotoUrl('new_search');
    });
     $('body').on('click', '.rDialog-mask', function(){
       $(this).hide();
        $('.rDialog').hide();
    });
     $('body').on('click', '.rDialog', function(e){//自己要阻止
       e.stopPropagation();//阻止冒泡到body
    });
    
})


