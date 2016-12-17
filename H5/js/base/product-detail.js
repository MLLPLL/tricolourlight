
    
$(function(){

   // 滚动改变头部
    $(window).scroll(function() {
        var scrollY = $(window).scrollTop();// 获取垂直滚动的距离，即滚动了多少        
        var slideHeight = $(".slideBox").height();
        var tabHeight = $(".section_one").height();
        if (scrollY > slideHeight/5){  
            // 向下滚动
          $(".share_back").css({background:"rgba(255,255,255,1)","border-bottom":"1px solid #eef3f5",transitionDuration: ".8s",transitionProperty: "all",transitionTimingFunction: "ease-in-out"});
          $(".share_back").addClass("boxShadow");  
          $(".show_font").css("opacity",1);
        } 
        else {
            // 向上滚动
           $(".share_back").css({background:"rgba(255,255,255,0)","border-bottom":"none",transitionDuration: ".8s",transitionProperty: "all",transitionTimingFunction: "ease-in-out"});
          $(".share_back").removeClass("boxShadow"); 
          $(".show_font").css("opacity",0)
        }
        if(scrollY >= tabHeight){
          $(".pros_tab").addClass("tabfixed");
        }
        else{
          $(".pros_tab").removeClass("tabfixed");
        }
    })
    // 查看更多详情

   
    var showHeight = $(".show_pro_detail").height();
    if(showHeight<550){
      $(".updown_more").hide();
    }
    $(".updown_more").click(function(){
      $(".show_pro_detail").toggleClass("show");      
      $(this).toggleClass("up");
      $(this).find(".updowns_arrow").toggleClass("on");
      if($("#moreall").html()=="点击查看更多"){
        $("#moreall").html("点击收起更多");      
      }
      else{
        $("#moreall").html("点击查看更多");     
      }
    })
          

    // 点击爱心图 喜欢 、取消喜欢
    var flag=1;
    $(".lovein").click(function(){
      
      if(flag==1){
         $(this).addClass("loveinred");
         $(this).siblings(".fly_texts").css("display","block").html("已喜欢");
         setTimeout(function(){
            $(".lovein").siblings(".fly_texts").css("display","none");
         },1500)
         
         flag = 0;
      }
      else{
        $(this).removeClass("loveinred");
        $(this).siblings(".fly_texts").css("display","block").addClass("grayflex").html("已取消");
         setTimeout(function(){
            $(".lovein").siblings(".fly_texts").css("display","none").removeClass("grayflex");
         },1500)        

        flag=1;
      }
      
    })

     //tab切换
     window.onload = function(){
      var $li = $('.pros_tab li');
      var $tabs = $('.pro_tab_con');             
      $li.click(function(){
        var $this = $(this);
        var $t = $this.index();
        $li.removeClass();
        $this.addClass('on');
        $tabs.css({"display":"none"});
        $tabs.eq($t).css({"display":"block"});
        return false;         
      })        
    }

    // 购物车背景变化
    // $(".increase").click(function(){
    //   $(".cart_sales_nums").addClass("scalebig");
    //   setTimeout(function(){
    //         $(".cart_sales_nums").removeClass("scalebig");
    //      },600) 
    // })
    // $(".decrease").click(function(){
    //   $(".cart_sales_nums").addClass("scalebig");
    //   setTimeout(function(){
    //         $(".cart_sales_nums").removeClass("scalebig");
    //      },600) 
    // })
    $(".add_shopcart").click(function(){
      $(".cart_sales_nums").addClass("scalebig");
      setTimeout(function(){
            $(".cart_sales_nums").removeClass("scalebig");
         },600) 
    })

    // 全部 晒图切换
    var $tabc = $('.allcomments'); 
    $(".all_parts li").click(function(){      
      var $tg = $(this).index();
      $(".all_parts li").removeClass("on");
      $(this).addClass("on");
      if($(this).hasClass("alls")){
        $(".all_onbg").css("left","0")
      }
      if($(this).hasClass("show_pic")){
        $(".all_onbg").css("left","50%")
      }
      $tabc.css({"display":"none"});
      $tabc.eq($tg).css({"display":"block"});
      return false;  
    })

    // 回复下拉
  
    $(".replay").click(function(){
      $(this).toggleClass("canclereply");
      $(this).parent().siblings(".reply_box").slideToggle();
      if($(this).html()=="回复"){
        $(this).html("取消");      
      }
      else{
        $(this).html("回复");
     
      }
    })

    //分享提示    
    $("#share-icon").click(function(){
        // alert(1);
        $("#success-pop").show();
        $(".rDialog-mask").show();
        setTimeout(function(){
          $("#success-pop").hide();
          $(".rDialog-mask").hide()
        },2000);
      })
      
      

})

    