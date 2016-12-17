$(function(){
	/*出现删除×*/	
		// $('body').on('focus', '.c-input input', function() {
		// 	if($(this).val().length > 0) {
		// 		$(this).siblings('.c-close-btn').show().css("display", "inline-block");
		// 	}
		// 	else {
		// 		$(this).siblings('.c-close-btn').hide();
		// 	}
		// });
		// $('body').on('keyup', '.c-input input',	 function() {
		// 	if($(this).val().length > 0) {
		// 		$(this).siblings('.c-close-btn').show().css("display", "inline-block");
		// 	}
		// 	else {
		// 		$(this).siblings('.c-close-btn').hide();
		// 	}
		// });
$(".c-input input").keyup(function(){
		if ($(this).val().length > 0) {
			$(this).siblings(".search-icon").hide();
			$(this).siblings(".delete_x").show();
		}
		else{
			$(this).siblings(".search-icon").show();
			$(this).siblings(".delete_x").hide();
		}
	})
	$(".c-input input").focus(function(){
		if ($(this).val().length > 0) {
			$(this).siblings(".search-icon").hide();
			$(this).siblings(".delete_x").show();
		}
		else{
			$(this).siblings(".search-icon").show();
			$(this).siblings(".delete_x").hide();
		}
	})
		
	
	/*演示清除input（新的）*/
		$('body').on('click', '.delete_x', function() {	
			$(this).parent('.c-input').find('input').val("");
			$(this).parent('.c-input').find('input').focus();
		});


})

