$(function(){
    //点击筛选icon 展示筛选页
        $('body').on('click', '#choose', function() {  
            var wh = $(window).height();
            $('aside.pop-content').css("height",wh).css('overflow-y','auto').addClass('moved');
            myPopScroll.refresh();
            $('.cd-overlay').addClass('is-visible');
            
            
            // window.unbind(function (e) {e.preventDefault()});
            // $(window).attr("cancelable","false");
            // window.addEventListener('touchmove',function(e){ console.log(e.cancelable);});
            // console.log(e.isDefaultPrevented());
            //   $('aside').on('click', function(e) {  
           
            //     console.log(e.isDefaultPrevented());
            // });
        });
       
        
        $('body').on('click', '.item-list li', function() {  
           $(this).toggleClass('on');
        });

         $('body').on('click', '.clear-btn', function() {  
          // alert(1);
            $(".item-list li").removeClass('on');
            $('.range-slider').jRange('setValue', '0,699');
        });
        $('body').on('click', '.clearon', function() {  
            $(this).parents(".item-list").find('.cat-list li').removeClass('on');
        });

	   $('body').on('click', 'aside#yimi-rz li', function() {  
            var litext=$(this).text(),
            newspan='<span title='+litext+'>'+litext+'、'+'</span>';
            rmspan= $(".authentication p span[title='"+litext+"']");
        if($(this).hasClass('on')){
            $(this).removeClass('on');
            $('.authentication p').addClass('choosed');
            $('.authentication p').removeClass('lightBlue');
           //('.authentication p').find('span[title='+litext+']').remove();
            rmspan.remove();
        }else{
            $(this).addClass('on');
            $('.authentication p i').text('已选择');
            $('.authentication p').removeClass('lightBlue');
            $('.authentication p').append(newspan);
        }; 
        });
       //点击认证选择 展示一米认证列表页
        $('body').on('click', '#slide-menu', function() {  
           var wh = $(window).height();
            $('aside#yimi-rz').css("height",wh).css('overflow-y','auto').addClass('moved');
            myPopScroll2.refresh();
            $('.cd-overlay').addClass('is-visible');
           $('aside.slide-wrapper .wrapper').hide();
           
        });
        //点击差号 一米认证列表页关闭
        $('body').on('click', '#yimi-rz .close', function() {  
            $('#yimi-rz li').removeClass('on'); 
            $('.authentication p span').remove('span');
            $('.authentication p').removeClass('choosed');
            $('.authentication p i').text('未选择');
            $('.authentication p').addClass('lightBlue');
            $('.authentication p em').hide();
        });
        //点击帅选页面的总确定按钮 筛选页面关闭
        $('body').on('click', 'aside.slide-wrapper #all-btn', function() {  
            $('aside.slide-wrapper').removeClass('moved');
            $('.cd-overlay').removeClass('is-visible');
        });

        $('body').on('click', '#yimi-rz header .arrow,#yimi-rz .btn', function() {  
            $('#yimi-rz').removeClass('moved');
            $('.cd-overlay').removeClass('is-visible');
            $('aside.slide-wrapper .wrapper').show();
            $('.authentication p span:gt(2)').hide();
            if($('.authentication p span').length<3){
                $('.authentication p em').hide();
            }
        });

        $('body').on('click', '.pop-content #pop-header .arrow', function() {  
            $('.pop-content').removeClass('moved');
            $('.cd-overlay').removeClass('is-visible');
            
        });
    
});