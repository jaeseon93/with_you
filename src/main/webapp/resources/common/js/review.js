//후기 전송버튼
function sendReview(){
	var starCount = $(".on").length;
	$('#reviewStar').val(starCount);
	
	console.log($('#reviewStar').val());
	
	if(!$('#reviewContents').val()){
		alert("내용입력해주세요");
		return;
	}
	reviewFrm.submit();
}

function deleteReview(){
	reviewFrm.action = "deleteReview.do"
	reviewFrm.submit();
}

function updateReview(){
	reviewFrm.action = "updateReview.do"

	var starCount = $(".on").length;
	$('#reviewStar').val(starCount);
	
	console.log($('#reviewStar').val());
	
	if(!$('#reviewContents').val()){
		alert("내용입력해주세요");
		return;
	}
	reviewFrm.submit();
}

function updateReviewReset(){
    if($('#writerType').val() == 'f') {
    	reviewFrm.action = "applyDetail.do"
    }else if($('#writerType').val() == 'h'){
    	reviewFrm.action = "historyDetail.do"
    }
	reviewFrm.submit();
}

function updateFrmReview(){
	$("#review-content").css("display", "none");
	$("#updateFrm").css("display", "block");
	$("#star").addClass("starRev");
	starEvent();
}

function starEvent(){
	//별점 버튼 이벤트 
	$('.starRev span').click(function(){
		  $(this).parent().children('span').removeClass('on');
		  $(this).addClass('on').prevAll('span').addClass('on');
		  return false;
	});
}

$(function(){
	starEvent();

	//후기 있을 때 별점 표시하는 부분
	var starLen = $(".review-star").length;
	for(var i=0 ; i<(10-starLen) ; i++){
		$("#star").append("<span class='review-star'></span>");
	}
	
	for(var i=0 ; i<$(".review-star").length ; i=i+2){
		$(".review-star").eq(i).addClass("starR1");
		$(".review-star").eq(i+1).addClass("starR2");
	}
});