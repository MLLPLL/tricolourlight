$(function(){
window.z = 0;


//密码验证

$('input').name('pass').bind('focus',function(){
	//$('.pass_put').css('display','block').css('z-index',''+ window.z++);
	$('.pass_error').css('display','none');
	$('.pass_ok').css('display','none');
}).bind('blur' , function(){
	if( $(this).val() == '' ){
		$('.pass_put').css('display','none');
	}else if( ! (new RegExp(/^[a-zA-Z0-9_]{6,18}$/)).test( $(this).val() ) ){
		$('.pass_put').css('display','none');
		$('.pass_error').css('display','block');
		$('.pass_ok').css('display','none');
	}else{		
		$('.pass_put').css('display','none');
		$('.pass_error').css('display','none');
		$('.m_tips2').css('display','none');
		$('.pass_ok').css('display','block');

	}
		
}).bind('keyup',function(){
	if( (new RegExp(/^[a-zA-Z0-9_]{6,18}$/)).test( $(this).val() )){
		$('.pass_put').css('display','none');
		$('.m_tips2').css('display','block');
		switch( safeTest($(this).val()) ){
			case 1:
				
				$('.t_word').text('低');
				break;
			case 2:
				
				$('.t_word').text('中');
				break;
			case 3:
				
				$('.t_word').text('高');
				break;
		}
	}else{
		$('.m_tips2').css('display','none');
		$('.pass_put').css('display','block');
	}
});


function safeTest(str){
	var strlen = str.length;
	var codeCont = 0;
	if( /\d/.test(str) ) codeCont++;
	if( /[a-zA-Z]/g.test(str) ) codeCont++;
	if( /_/g.test(str) ) codeCont++;
	if( strlen < 10 && codeCont == 1) return 1;
	else if( strlen < 10 && codeCont == 2 ) return 2;
	else return 3;

}

//确认密码验证



$('input').name('confirm_pass').bind('focus',function(){
	//$('.confirm_put').css('display','block');
	$('.confirm_error').css('display','none');
	$('.confirm_ok').css('display','none');
}).bind('blur',function(){
	$('.confirm_put').css('display','none');
	if( $(this).val() == '' )
		$('.confirm_error').css('display','none');
	else{
		if( $(this).val() != $('input').name('pass').val() ){
		$('.confirm_error').css('display','block');
		}else{
		$('.confirm_error').css('display','none');
		$('.confirm_ok').css('display','block');
		}
	}
	
});


});