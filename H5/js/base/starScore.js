$(document).ready(function(){

	//详情页评价总评价分数展示
	var averageScore = 3.5  //平均值
	var mainScore = 5;   //总分值
	// 评价平均分数显示
	var perc = Math.round(averageScore/mainScore * 10000) / 100.00 ;	
	$(".avstar").css("width",perc + "%");
	perc = perc / 100;
	$("#score0").html(averageScore);
	if(perc > 0.63 ){
		$(".avstar").removeClass("bluestar").addClass("redstar");
	}
	if( perc <= 0.63 && perc > 0 ){
		$(".avstar").removeClass("redstar").addClass("bluestar");
	}
	if(perc = 0 ){
		$(".avstar").removeClass("redstar").removeClass("bluestar");
	}

	//单个客户评价星星展示
	var Score = 3;   //值
	var totleScore = 5;   //总分值
	// 评价分数显示
	var perWidth = Math.round(Score/totleScore * 10000) / 100.00 ;	
	$(".stars").css("width",perWidth + "%");
	perWidth = perWidth / 100;
	if(perWidth > 0.63 ){
		$(".stars").removeClass("bluestar").addClass("redstar");
	}
	if( perWidth <= 0.63 && perWidth > 0 ){
		$(".stars").removeClass("redstar").addClass("bluestar");
	}
	if(perWidth = 0 ){
		$(".stars").removeClass("redstar").removeClass("bluestar");
	}


	// 手动去评价打星星					

	$(".evaluate_star").click(function(){
		var fatherWidth = $(".evaluate_star").width();
		var childWidth = $(".dostar").width();
		var leftX = $(this).offset().left;
		var x = event.clientX;
		childWidth = x - leftX;
		var percentScore = Math.round(childWidth/fatherWidth * 10000) / 100.00 ;						
		$(".dostar").css("width",percentScore + "%");
		percentScore = percentScore / 100;							
		if(percentScore > 0.63 ){
			$(".dostar").removeClass("bluestar").addClass("redstar");
			$(".opinion").html("好评");
		}
		if( percentScore <= 0.63 && percentScore > 0 ){
			$(".dostar").removeClass("redstar").addClass("bluestar");
			$(".opinion").html("中评");
			if(percentScore < 0.42){
				$(".opinion").html("差评");
				$(".badpost").show();
				setTimeout(function(){
					$(".badpost").hide();
				},1200)
			}
		}
		if(percentScore = 0 ){
			$(".dostar").removeClass("redstar").removeClass("bluestar");
			$(".opinion").html("差评");
			$(".badpost").show();
				setTimeout(function(){
					$(".badpost").hide();
				},1200)
		}
	})
})