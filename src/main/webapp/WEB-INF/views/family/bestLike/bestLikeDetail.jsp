<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css">
<!-- 글꼴 -->
<link href="https://fonts.googleapis.com/css2?family=Chewy&family=Jua&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Noto+Serif+KR:wght@600&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">

<title>Insert title here</title>

<style type="text/css">
/* 후기 테두리 */ 
	.container-fluid {
		border: solid 1px;
	}
	
select { 
	/* 네이티브 외형 감추기 */ 
	-webkit-appearance: none; 
	-moz-appearance: none; 
	appearance: none; 
	background-color: white;
	/* 화살표 모양의 이미지 */ 
	background: url(https://farm1.staticflickr.com/379/19928272501_4ef877c265_t.jpg) no-repeat 95% 50%; 
}

select::-ms-expand { 
/* IE 10, 11의 네이티브 화살표 숨기기 */ 
	display: none; 
}

select { 
	width: 90px; /* 원하는 너비설정 */ 
	padding: .4em .5em; /* 여백으로 높이 설정 */ 
	font-family: inherit; /* 폰트 상속 */ 
	background-color: #f5f4f4;
	background: url(https://farm1.staticflickr.com/379/19928272501_4ef877c265_t.jpg) no-repeat 100% 40%; /* 네이티브 화살표 대체 */
    border: 2px solid white; 
    border-radius: 10px; 
    -webkit-appearance: none; /* 네이티브 외형 감추기 */ 
    -moz-appearance: none; appearance: none; 
}
.title{
	font-family: 'Do Hyeon', sans-serif;
	font-size: 38px;
	
}
.btn{
	font-family: 'Jua', sans-serif;
	font-size:20px;
}
.content{
	font-family: 'Do Hyeon', sans-serif;
	font-size: 18px;
}
</style>

</head>
<body>

<!-- 간병인 상세정보 섹션 -->
<div class="container">
  <div align="center" style="margin-top:30px;">
	<a class="title">간병인 정보</a>
  </div>
  <div class="content" align="center">
		<img src="uploadProfile/${likeDetail.helperProfile }" onerror='this.src="resources/img/no_image.png"' id="viewProfile" class="rounded-circle" width="100" height="100">
		<br/><br/>
		${likeDetail.helperName }님 / ${likeDetail.helperSex }<br />
		<br/>
		희망근무지역: ${likeDetail.helperWorkArea }<br/>
		희망근무시간: ${likeDetail.helperStartTime } 시 ~ ${likeDetail.helperEndTime }시<br/>
		특이사항: ${likeDetail.helperUnique }<br/>
		<%-- 자격면허: ${likeDetail.certifiName }<br/> --%>
		경력사항: ${likeDetail.careerOrgan } / ${likeDetail.careerStart } 부터 ~ ${likeDetail.careerEnd } 까지<br/>
		<br/>

		<!-- 후기 및 평점 영역 -->
		<img src="${pageContext.request.contextPath}/resources/img/noContents.png" style="height:30px"  />
		후기 및 평점 :<br />
			<c:choose>
				<c:when test="${empty reviewList}">
					아직 작성된 후기가 없습니다.
				</c:when>
				<c:otherwise>
					<c:forEach var="list" items="${reviewList }">
						<div class="container-fluid">
							<div>
							별점 : ${list.reviewStar } / 10
							</div>
							<div>
							작성자 : ${list.familyName }
							</div>
							<div>
							작성일자: ${list.reviewDate }
							</div>
							<div>
							내용 : ${list.reviewContents }		
							</div>
							<div>
							사진첨부 : ${list.reviewFile }		
							</div>
						</div><br/>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		
	</div>
  </div>
<!-- 간병인 상세정보 섹션 끗 -->


<!-- 즐겨찾기 안에서 서비스 신청하기 섹션 -->
<div class="container">
  <div align="center" style="margin-top:30px;">
	<a class="title">서비스신청</a>
  </div>
  <div class="content" align="center">
		<form id="applyFrm" name="applyFrm" action="applyInLike.do" method="post">
			<label for="serviceStartTime">시작시간</label>
				<select name="serviceStartTime" id="serviceStartTime">
					<option value="" selected="selected">선택</option>
						<c:forEach begin="${likeDetail.helperStartTime}" end="${likeDetail.helperEndTime }" var="startTime">
					 		<option value="${startTime }">${startTime }</option>
						</c:forEach>
				</select>
			<label for="serviceEndTime">종료시간</label>
				<select name="serviceEndTime" id="serviceEndTime">
					<option value="" selected="selected">선택</option>
						<c:forEach begin="${likeDetail.helperStartTime}" end="${likeDetail.helperEndTime }" var="endTime">
							<option value="${endTime }">${endTime }</option>
						</c:forEach>
				</select>
			<br/>희망 요청 날짜 <input type="date" id="serviceDate" name="serviceDate"><br/>
			<div class="form-group">
			      <label for="comment">보호자 요청사항:</label>
			      <textarea class="form-control" rows="5" id="serviceDemand" name="serviceDemand"></textarea>
	   			</div>
			<div align="center">
				<button type="button" id="btnApply" class="btn btn-primary" onclick="serviceApply()">신청하기</button>
			</div>	
			
			<input type="hidden" id="serviceArea" name="serviceArea" value="${likeDetail.helperWorkArea }">
			<input type="hidden" id="familyNo" name="familyNo" value="${loginOk.familyNo }">
			<input type="hidden" id="helperNo" name="helperNo" value="${likeDetail.helperNo }">
		</form>
	</div>
  </div>


<script type="text/javascript">
	function serviceApply(){
		var doc = document.applyFrm;
		
		if(doc.serviceStartTime.value == '') {
			alert('돌봄서비스 시작시간을 선택해주세요');
			doc.serviceStartTime.focus();
		} 
		else if(doc.serviceEndTime.value == '') {
			alert('돌봄서비스 종료시간을 선택해주세요');
			doc.serviceEndTime.focus();
		}
		else if(doc.serviceEndTime.value <= doc.serviceStartTime.value) {
			alert('돌봄종료시간은 시작시간보다 커야합니다');
			doc.serviceEndTime.focus();
		}		
		else if(doc.serviceDate.value == '') {
			alert('돌봄서비스 날짜를 선택해주세요');
			doc.serviceDate.focus();
		} 
		else if( confirm(
				'아래의 내용과 같이 돌봄서비스를 신청합니다.' +'\n'+ 
				'"서비스신청내역" 메뉴에서 결제 등 진행상황을 확인 하실 수 있습니다.' +'\n'+
				'\n'+
				'<신청내용>' +'\n'+
				'신청자 성명: ' + '${loginOk.familyName}'+'\n'+
				'간병인 성명: ' + '${likeDetail.helperName}'+'\n'+
				'돌봄시간 : ' + doc.serviceStartTime.value + ' 시부터 ~ '+ doc.serviceEndTime.value +' 시까지 ('+ (doc.serviceEndTime.value - doc.serviceStartTime.value) +'시간)' +'\n'+
				'돌봄지역 : ' +	 '${likeDetail.helperWorkArea }' +'\n'+
				'돌봄날짜 : ' + doc.serviceDate.value +'\n'+
				'요청메모 : ' + doc.serviceDemand.value +'\n'+
				'결제예정금액 : ' + (doc.serviceEndTime.value - doc.serviceStartTime.value)*10000 +'원'+'\n'+
				'    * (금액 = 시간 X 10,000원)'
				) == true) {
			alert("신청이 완료 되었습니다"+"\n"+"'신청내역'메뉴에서 내용을 확인 하실 수 있습니다.")
			doc.submit();
		} else {
			return;
		}
	}
</script>
<!-- 즐겨찾기 안에서 서비스 신청하기 섹션 끝-->

</body>
</html>