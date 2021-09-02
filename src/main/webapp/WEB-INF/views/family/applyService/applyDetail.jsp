<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/resources/common/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/common/js/review.js"></script>
<link href="${pageContext.request.contextPath}/resources/common/css/review.css" rel="stylesheet">
<!-- 글꼴  -->
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Chewy&family=Jua&display=swap" rel="stylesheet">
<title>Insert title here</title>
<style>
.img{
	margin-top:10px;
}
.content,.form-group {
	font-family: 'Do Hyeon', sans-serif;
	font-size: 18px;
}
.star, .black{
	margin-top:9px;
	display:inline-block;
}
.btn {
	width:30%;
	font-family: 'Jua', sans-serif;
	font-size: 17px;
}
</style>
</head>
<body>
<div class="container">
 <div align="right">
  <div class="star">
	<!-- 즐겨찾기 버튼 + Form -->
	<form id="likeFrm" name="likeFrm" action="bestLike.do" method="post">
	<c:choose>
		<c:when test="${empty applyDetail4.familyNo}">
			<a href="#" onClick="addlike(); return false;">
		  		<img src="${pageContext.request.contextPath}/resources/img/bestLike/bestLike.png" style="height:39px"  />
		  	</a>
		</c:when>
		<c:when test="${not empty applyDetail4.familyNo}"> 
			<a href="javascript:void(0);" onClick="disLike();">
		  		<img src="${pageContext.request.contextPath}/resources/img/bestLike/bestLike2.png" style="height:39px"  />
		  	</a>
		</c:when>
	</c:choose>
	<input type="hidden" id="serviceNo" name="serviceNo" value="${applyDetail.serviceNo }">
	<input type="hidden" id="helperNo" name="helperNo" value="${applyDetail.helperNo }">
	<input type="hidden" id="familyNo" name="familyNo" value="${applyDetail.familyNo }">
	</form>
 </div>
<!-- 블랙리스트 버튼 + Form -->
 <div class="black">
	<form id="blackFrm" name="blackFrm" action="" method="post">
	<c:choose>
		<c:when test="${empty applyDetail5.familyNo}">
			<a href="#" onClick="addBlack(); return false;">
		  	  <img alt="블랙리스트 등록" src="${pageContext.request.contextPath}/resources/img/chat/nonBlackList.png" style="height: 40px">
		  	</a>
		</c:when>
		<c:when test="${not empty applyDetail5.familyNo}"> 
			<a href="javascript:void(0);" onClick="removeBlack();">
		  		<img alt="블랙리스트 삭제" src="${pageContext.request.contextPath}/resources/img/chat/checkBlackList.png" style="height: 40px">
		  	</a>
		</c:when>
	</c:choose> 
	<input type="hidden" id="serviceNo" name="serviceNo" value="${applyDetail.serviceNo }">
	<input type="hidden" id="helperNo" name="helperNo" value="${applyDetail.helperNo }">
	<input type="hidden" id="familyNo" name="familyNo" value="${applyDetail.familyNo }">
	</form>
 </div>
 </div>
<!-- 블랙리스트 버튼 + Form 끝-->
	<div class="img" align="center">
		<img src="uploadProfile/${applyDetail.helperProfile }" onerror='this.src="resources/img/no_image.png"' id="viewProfile" class="rounded-circle" width="110" height="120"><br/>
	</div>
	<div class="col-xl-6 col-md-12 col-sm-12 content" align="center" >
		<br> 
		간병인 : ${applyDetail.helperName} 님<br/>
		요청서비스날짜 : ${applyDetail.serviceDate }<br/>
		돌봄시작시간 : ${applyDetail.serviceStartTime }시<br/>
		돌봄종료시간 : ${applyDetail.serviceEndTime }시<br/>
		실제출근시간 : ${applyDetail2.realStartTime }<br/>
		실제퇴근시간 : ${applyDetail2.realEndTime }<br/>
		보호자요청사항 : ${applyDetail.serviceDemand }<br/>
		결제예정금액 : ${applyDetail.servicePrice }원<br/>
	</div>
	<br>
	<div align="center">
		<c:choose>
			<c:when test="${applyDetail.serviceStatus eq 'S02' }">
				<button type="button" id="btnServiceReady" class="btn btn-primary" onclick="requestPay()">결제하기</button>
			</c:when>
			<c:when test="${applyDetail.serviceStatus eq 'S03' }">
				<button type="button" id="btnServiceReady" class="btn btn-success" onclick="requestPay()" disabled>결제완료</button>
			</c:when>
		</c:choose>
	</div>
	<br>
<!--  후기 및 평점 작성  -->
<div class="form-group" align="center">
	<label for="exampleTextarea">후기 및 평점:</label>
	<form action="insertFamilyReview.do" id="reviewFrm" name="reviewFrm">
		<div>
			<c:choose>
				<%-- 후기가 없을 경우 --%>
				<c:when test="${empty reviewVo}">
					<div>
						<div class="starRev">
							<span class="starR1 on"></span>
							<span class="starR2"></span>
							<span class="starR1"></span>
							<span class="starR2"></span>
							<span class="starR1"></span>
							<span class="starR2"></span>
							<span class="starR1"></span>
							<span class="starR2"></span>
							<span class="starR1"></span>
							<span class="starR2"></span>
						</div>
					</div>
					<c:choose>
						<%-- 서비스 신청가 종료된 상태일때 : 활성화 --%>
						<c:when test="${applyDetail.serviceStatus == 'S04'}">
							<textarea class="form-control" id="reviewContents" name="reviewContents" rows="5"></textarea>
							<input type="file" id="reviewFile" name="reviewFile" >
							<input type="hidden" id="reviewStar" name="reviewStar" >
							<input type="hidden" id="serviceNo" name="serviceNo" value="${applyDetail.serviceNo }">
					    	<button class="" type="reset" >취소</button>
							<button class="" type="button" onclick="sendReview()" >저장</button>
				    		<button class="" type="button" onclick="location.href='familyMain.do'" >메인</button>
						</c:when>
						<%--그 외 상태일 때 : 비활성화 --%>
						<c:otherwise>
							<textarea class="form-control" id="reviewContents" name="reviewContents" rows="5" placeholder="서비스 종료 후 작성할 수 있습니다." readonly></textarea>
							<input type="file" id="reviewFile" name="reviewFile" disabled>
					    </c:otherwise>
					</c:choose>
				</c:when>
				<%--후기가 있을 경우 --%>
				<c:otherwise>
					<div id="star">
						<c:forEach var="i" begin="1" end="${reviewVo.reviewStar}">
							<span class="review-star on"></span>
						</c:forEach>
					</div>
					<div id="review-content">
						<p>${reviewVo.reviewStar}</p>
						<p>${reviewVo.reviewContents}</p>
						<p>${reviewVo.reviewFile}</p>
						<p>${reviewVo.reviewDate}</p>
						<button class="" type="button" onclick="deleteReview()" >삭제</button>
			    		<button class="" type="button" onclick="updateFrmReview()" >수정</button>	
					</div>
					<%-- 후기 수정 폼 --%>
					<div id="updateFrm" style="display: none;">
						<textarea class="form-control" id="reviewContents" name="reviewContents" rows="5">${reviewVo.reviewContents}</textarea>
						<input type="file" id="reviewFile" name="reviewFile" value="${reviewVo.reviewFile}">
						<input type="hidden" id="reviewNo" name="reviewNo" value="${reviewVo.reviewNo }">
						<input type="hidden" id="reviewStar" name="reviewStar" >
						<input type="hidden" id="writerType" name="writerType" value="f">
						<input type="hidden" id="serviceNo" name="serviceNo" value="${reviewVo.serviceNo }">
						<br><br>
				    	<button class="" type="reset" onclick="updateReviewReset()" >수정취소</button>
						<button class="" type="button" onclick="updateReview()" >수정저장</button>
			    		<button class="" type="button" onclick="location.href='familyMain.do'" >메인</button>
		    		</div>		
			    </c:otherwise>
			</c:choose>
			<br><br>
		</div> 

	</form>
</div>	
<!--  후기 및 평점 작성 끝  -->
</div>



				<!-- 즐겨찾기 자바스크립트 -->
<script type="text/javascript">
	function addlike() {
//		document.likeFrm.helperNo.value=key;
		document.likeFrm.action="addLike.do";
		document.likeFrm.submit();
	}
	function disLike() {
		document.likeFrm.action="disLike.do";
		document.likeFrm.submit();
	}
</script>
				<!-- 즐겨찾기 자바스크립트 끝-->
				
				<!-- 블랙리스트 자바스크립트 -->
<script type="text/javascript">
	function addBlack() {
		if(confirm('블랙리스트로 등록 하시겠습니까?' +'\n'+
				 '*블랙리스트에 등록된 간병인은 검색목록에서 제외됩니다.'
			)== true ) {
		document.likeFrm.action="addBlack.do";
		document.likeFrm.submit();
		} else {
			return;
		}
	}
	
	function removeBlack() {
		document.likeFrm.action="removeBlack.do";
		document.likeFrm.submit();
	}
</script>
				<!-- 블랙리스트 자바스크립트 끝-->




									<!-- 결제 스크립트 -->
									
<!-- jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<!-- iamport.payment.js -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>

<script type="text/javascript">
	var IMP = window.IMP; // 생략해도 괜찮습니다.
	IMP.init("imp07126152"); 
	
	function requestPay() {
	  // IMP.request_pay(param, callback) 호출
	IMP.request_pay({ // param
	  	pg : 'kakaopay',
	    pay_method : 'card',
	    merchant_uid : 'merchant_' + new Date().getTime(),
	    name : '부탁Care: 돌봄서비스',	// order 테이블에 들어갈 주문명 혹은 주문 번호
	    amount : ${applyDetail3.servicePrice},	//결제금액
	    buyer_email : '${applyDetail3.familyEmail}',	//구매자 정보
	    buyer_name : '${applyDetail3.familyNo}',	//구매자 등록번호 (보호자등록번호 familyNo)
	    buyer_tel : '${applyDetail3.familyTel}',
	    buyer_addr : '${applyDetail.serviceNo}',		//서비스 등록번호 (serviceNo)
	    buyer_postcode : '${applyDetail3.familyName}',	//구매자 성명 (보호자 성명 familyName)
//    	m_redirect_url : '/savePayResult.do'	// 결제 완료 후 보낼 컨트롤러의 메소드명
	  }, 
	  
		 function(rsp) { // callback
			    if ( rsp.success ) {
			        //[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
	                jQuery.ajax({
	                    url: "savePayResult.do", //cross-domain error가 발생하지 않도록 주의해주세요
	                    type: 'POST',
	                    dataType: 'json',
	                    data: { imp_uid:rsp.imp_uid, 
	                    		merchant_uid:rsp.merchant_uid, 
	                    		apply_num:rsp.apply_num, 
	                    		paid_amount: rsp.paid_amount, 
	                    		buyer_name:rsp.buyer_name,
	                    		buyer_addr:rsp.buyer_addr,
	                    		helper_no:'${applyDetail.helperNo}'
	                    	}
	                    
	                }).done(function(data) {
	                    //[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
				   	var msg = '결제가 완료되었습니다.\n';
				        msg += '고유ID : ' + rsp.imp_uid + '\n';
				        msg += '상점 거래ID : ' + rsp.merchant_uid + '\n';
				        msg += '결제 금액 : ' + rsp.paid_amount + '\n';
				        msg += '카드 승인번호 : ' + rsp.apply_num + '\n';
				        msg += '===========================\n'
				        msg += '주문명 : ' + rsp.name + '\n';
				        msg += '주문자 성명 : ' + rsp.buyer_postcode + '\n';
				        msg += '주문자 연락처 : ' + rsp.buyer_tel + '\n';
				        msg += '서비스신청번호: ' + rsp.buyer_addr + '\n';
				        msg += '간병인 정보 : ' + ${applyDetail.helperNo} + '\n';
				        //document.console.log(rsp.imp_uid);
				        alert(msg);
				        likeFrm.action = "payResult.do";
				        likeFrm.submit();
				    })
			    }else {
				        var msg = '결제에 실패하였습니다.';
				        msg += '에러내용 : ' + rsp.error_msg;
				    	alert(msg);
				    }
				});
	}
</script>

</body>
</html>