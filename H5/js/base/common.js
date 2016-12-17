$(document).ready(function(){
	
	//  向上滚动顶部导航添加阴影
		$(window).scroll(function() {
		    var scrollY = $(window).scrollTop();// 获取垂直滚动的距离，即滚动了多少
		    if(scrollY>20){
		    	$("header").addClass("boxShadow")
		    }
		    else{
		    	$("header").removeClass("boxShadow")
		    }
		})
		
		


//提交订单页优惠券显示隐藏
		$("#goshow").click(function(){
			$(".godown").toggleClass("rotate180");
			$("#quan").slideToggle();
		})

	// 确认订单页显示日期
	
	$("#send_date ul li").click(function(){
		$("#send_date ul li").removeClass("on"),
		$(this).addClass("on");
	})

	$("#send_time ul li").click(function(){
		$("#send_time ul li").removeClass("on"),
		$(this).addClass("on");
	})

	$(".open_time").click(function(){
		$(this).parents().find(".open_pop").show();
	})
	$(".open_pop").find(".pop_bg").click(function(){
		$(this).parent(".open_pop").hide();
	})
	$(".sure_btn").click(function(){
		$(this).parents(".open_pop").hide();
	})

	//显示发票信息
	
 	$(".invoice ul li").click(function(){
 		$(".invoice ul li").removeClass("on"),
 		$(this).addClass("on");
 		$(this).find("input[type='radio']").attr("checked","checked");

 	})

	$(".none_cupon").click(function(){
		$(".invoice_show02").hide();
		$(".invoice_show03").hide();
		$(".invoice ul li").removeClass("h25");
		$(".person_cupon").css("borderRight","1px solid #eef3f5")
		$(".none_cupon").css("borderRight","1px solid #eef3f5")
	})
	$(".person_cupon").click(function(){
		$(".invoice_show01").hide();
		$(".invoice_show03").hide();
		$(".invoice ul li").removeClass("h25");
		$(".person_cupon").css("borderRight-color","#ee9b84");
		$(".none_cupon").css("borderRight-color","#ee9b84");
		$(".person_cupon").addClass("h25");
		$(".none_cupon").addClass("h25");
		$(".invoice_show02").slideDown();
	})
	$(".company_cupon").click(function(){
		$(".invoice_show01").hide();
		$(".invoice_show02").hide();
		$(".invoice ul li").removeClass("h25");
		$(".person_cupon").css("borderRight-color","#ee9b84");
		$(".none_cupon").css("borderRight-color","#eef3f5");
		$(".person_cupon").addClass("h25");
		$(".company_cupon").addClass("h25");
		$(".invoice_show03").slideDown();
	})

// 显示金额明细
$(".sum_detail").click(function(){
	
	$(this).parents().find(".show_detail").find(".pop_bg").slideToggle();
	$(".fund_info").slideToggle();
//	$("body").css("overflow-y","hidden");

})
// 查看活动规则
	$(".check_rule").click(function(){			
		$(this).parents().find(".show_detail").find(".pop_bg").show();
		$(".fund_info").slideToggle();
		$("body").css("overflow-y","hidden");		
	})
$(".show_detail").find(".pop_bg").click(function(){
	$(".show_detail").find(".pop_bg").hide();
	$(".fund_info").hide();
	$("body").css("overflow-y","auto");
})
$(".close").click(function(){
	$(".show_detail").find(".pop_bg").hide();
	$(".fund_info").hide();
	$("body").css("overflow-y","auto");
})
$("#btnpointok").click(function(){
	$(this).addClass("sureOn");
	$(this).parents(".od_coupon").find(".deductions").show();
})
$("#btnbalanceok").click(function(){
	$(this).addClass("sureOn");
	$(this).parents(".od_coupon").find(".deductions").show();
})

//验证优惠券 
	$(".yz").click(function(){
		$(this).find('.code_s').show();
		setTimeout( "$('.yz').find('.code_s').hide()",1500)
	}) 	

//close关闭
	$(".paypop").find(".pop_bg").click(function(){
		$(this).parent(".paypop").hide();
	})
	$(".paypop").find(".close").click(function(){
		$(this).parents(".paypop").hide();
	})

// 订单提交页支付方式切换
$(".pay_way label").click(function(){
	$(".pay_way label").removeClass("on"),
	$(this).addClass("on");
	$(this).find("input[type='radio']").attr("checked","checked");
})
$(".invoice_show03 label").click(function(){
	$(".invoice_show03 label").removeClass("on"),
	$(this).addClass("on");
	$(this).find("input[type='radio']").attr("checked","checked");
})

















})