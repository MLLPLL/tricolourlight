var $parentNode = window.parent.document;

function $childNode(name) {
    return window.frames[name]
}

$('.tooltip-demo').tooltip({
    selector: "[data-toggle=tooltip]",
    container: "body"
});

// 使用animation.css修改Bootstrap Modal
$('.modal').appendTo("body");

$("[data-toggle=popover]").popover();

//折叠ibox
$('.collapse-link').click(function () {
    var 

    ibox = $(this).closest('div.ibox');
    var button = $(this).find('i');
    var content = ibox.find('div.ibox-content');
    

content.slideToggle(200);
    button.toggleClass('fa-chevron-up').toggleClass('fa-chevron-down');
    ibox.toggleClass

('').toggleClass('border-bottom');
    setTimeout(function () {
        ibox.resize();
        ibox.find('[id^=map-]').resize

();
    }, 50);
});

//关闭ibox
$('.close-link').click(function () {
    var content = $(this).closest('div.ibox');
    content.remove();
});

//判断当前页面是否在iframe中
//if (top == this) {
//    var gohome = '<div class="gohome"><a class="animated bounceInUp" href="index.html?v=4.0" title="返回首页"><i class="fa fa-home"></i></a></div>';
//    $('body').append(gohome);
//}

//animation.css
function animationHover(element, animation) {
    element = $(element);
    element.hover(
        function () 

{
            element.addClass('animated ' + animation);
        },
        function () {
            //动画完成之前移除class
   

         window.setTimeout(function () {
                element.removeClass('animated ' + animation);
            }, 2000);
  

      });
}

//拖动面板
function WinMove() {
    var element = "[class*=col]";
    var handle = ".ibox-title";
    var connect = "[class*=col]";
    $(element).sortable({
            handle: handle,
            connectWith: connect,
            tolerance: 'pointer',
            forcePlaceholderSize: true,
            opacity: 0.8,
        })
        .disableSelection();
};

//登陆控制(如果未登录则返回)
//$(function($) {
//	$.ajax({
//		contentType: "application/json;charset=utf-8",
//		url: "/osv" + "/auth/isLogin",
//        type: "POST",
//        cache: false,
//        async: false,
//        dataType : "json",
//        data: null,
//        success: function(data){
//        	if(data.loginStatus == '-2' ){
//        		//alert(data.osvMessage);
//        		location.replace(data.nextUrl);
//        	}
//        },
//        error: function(error){
//       	 	alert("error" + error);
//       	 	return false;
//        }
//    });
//
//
//});

//数据导出
function DownLoad(strUrl) { 
    var form = $("<form>");   //定义一个form表单
    form.attr('style', 'display:none');   //在form表单中添加查询参数
    form.attr('target', '');
    form.attr('method', 'post');
    form.attr('action', "/osv/export/export");

    var input1 = $('<input>');
    input1.attr('type', 'hidden');
    input1.attr('name', 'strUrl');
    input1.attr('value', strUrl);
    $('body').append(form);  //将表单放置在web中 
    form.append(input1);   //将查询参数控件提交到表单上
    form.submit();
}

//function exportXls(){
//	DownLoad('/file/1.xlsx');
//};