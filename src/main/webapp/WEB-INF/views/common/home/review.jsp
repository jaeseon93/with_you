<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 아름 : 후기 작성 기능입니다. 나중에 신청내역, 서비스 이력에 추가할 예정 -->

<script src="${pageContext.request.contextPath}/resources/common/js/jquery.min.js"></script>
	
<style>
.starR1{
    background: url('http://miuu227.godohosting.com/images/icon/ico_review.png') no-repeat -52px 0;
    background-size: auto 100%;
    width: 15px;
    height: 30px;
    float:left;
    text-indent: -9999px;
    cursor: pointer;
}
.starR2{
    background: url('http://miuu227.godohosting.com/images/icon/ico_review.png') no-repeat right 0;
    background-size: auto 100%;
    width: 15px;
    height: 30px;
    float:left;
    text-indent: -9999px;
    cursor: pointer;
}
.starR1.on{background-position:0 0;}
.starR2.on{background-position:-15px 0;}
</style>

   
<div class="form-group">
	<label for="exampleTextarea">후기:</label>
	<form action="" id="reviewFrm" name="reviewFrm">
		<div>
			<div class="starRev">
				<span class="starR1 on">별1_왼쪽</span>
				<span class="starR2">별1_오른쪽</span>
				<span class="starR1">별2_왼쪽</span>
				<span class="starR2">별2_오른쪽</span>
				<span class="starR1">별3_왼쪽</span>
				<span class="starR2">별3_오른쪽</span>
				<span class="starR1">별4_왼쪽</span>
				<span class="starR2">별4_오른쪽</span>
				<span class="starR1">별5_왼쪽</span>
				<span class="starR2">별5_오른쪽</span>
			</div>
		</div>
		<div>
			<textarea class="form-control" id="reviewContents" name="reviewContents" rows="3" style="height: 52px;"></textarea>
			<input type="file" id="reviewFile" name="reviewFile">
	
		</div>
		<div>
	    	<button class="w3-button w3-light-grey w3-round" type="reset">취소</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="w3-button w3-indigo w3-round" type="button" onclick="sendReview(123456)">저장</button>
		</div>
	</form>
</div>	

<script>
function sendReview(serviceNo){
	var starCount = $(".on").length * 0.5;
	
	if(!$('#reviewContents').val()){
		alert("내용입력해주세요");
		return;
	}
	
	$.ajax({
	    type: "post",
	    url: "insertReview.do",
	    data: {"reviewStar" : starCount, "reviewContents":$('#reviewContents').val(), 
	    		"serviceNo" : serviceNo},
	    success : function(data) {
	    }, 
	    error : function(xhr, textStatus, errorThrown){
	        alert(xhr);
	        alert(textStatus);
	        alert(errorThrown);
	    }
	});
}
$('.starRev span').click(function(){
	  $(this).parent().children('span').removeClass('on');
	  $(this).addClass('on').prevAll('span').addClass('on');
	  return false;
});
</script>