(function($){
     // 绑定通用事件 跳转到首页
    $('body').on('click', '.logo', function(){
        //return $.gotoUrl('securityCenter.html');
         return $.gotoUrl('/show_home');
    });
	
	//点击加入购物车icon动画效果
	$('body').on('click', '.turn',function(){
            if($(this).hasClass('turn-around-a')){
               
                $(this).removeClass('turn-around-a').removeClass('turn-around');
           
            }else{
                $(this).addClass('turn-around-a').addClass('turn-around');
            }
        
    });
	//分类点击tab切换样式
	$('.togglon .swiper-slide').on('click',function(){
		$(this).addClass('on').siblings().removeClass('on');
	});
// 加入购物车
    $('#addcart').on('tap', function() {

                    $(this).securityTap({
                        isIllegal: function(){
                            return !$.isLogin();
                        },
                        ajax: {
                            url: '/user/cart/add',
                            type: 'POST',
                            data: {
                                productId: productId,
                                merchantId: merchantId,
                                num: $('#num').val()
                            }
                        },
                        isNotJump: true,
                        success: function() {
                            $.alert('加入购物车成功');
                        },
                        error: function(error) {
                            $.alert(error.message);
                        }
                    });
                });
  //版本切换
  $('.tap-vs p').on('click',function(){
    $(this).addClass('on').siblings().removeClass('on');
  })
//点击搜索跳转
// $('body').on('click', '#search', function(){
//      return $.gotoUrl('securityCenter.html');
//         return $.gotoUrl('new_search');
//     });
//跳转
  $.gotoUrl = function(url, backUrl) {       
        if (!url) {
            return false;
        }
      
        var backUrl = backUrl || window.location.href;

        window.location.href = url;
        return true;
    };

})(window.jQuery || window.Zepto, window);


