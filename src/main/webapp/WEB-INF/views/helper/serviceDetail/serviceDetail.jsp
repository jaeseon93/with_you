<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script> -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<!-- 글꼴 스타일  -->
<link href="https://fonts.googleapis.com/css2?family=Chewy&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Chewy&family=Jua&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@700&display=swap" rel="stylesheet">
</head>

<style>	
.title{
  font-family: 'Do Hyeon', sans-serif;
  margin:35px;
  font-size: 30px;
  color: black;
  text-decoration: none;
}
.text,.text2 {
  font-family: 'Do Hyeon', sans-serif;
  font-size: 16px;
}
.w3-button{
  font-family: 'Jua', sans-serif;
  font-size: 19px;
}
</style>


<body>
	<div class="container">
<div align="center">
	<div class="content">
		<a class="title">환자정보</a><br>
	</div>
	<div class="text">
		이름 : ${serviceDetail.patientName }님<br>
	<fmt:formatDate value="${serviceDetail.patientBirth}" pattern="yyyy-MM-dd" /><br>
		성별 : ${serviceDetail.patientSex }<br>
	         보호자 연락처 :${serviceDetail.patientFamilyTel }<br>
	         주소 :<br>${serviceDetail.patientAddr }<br>
	         질환 : ${serviceDetail.patientDisease }<br>
		치매등급 : ${serviceDetail.patientGrade }<br>
		혈액형 :${serviceDetail.patientBlood }형<br>
		복용중인약 :${serviceDetail.patientMedication }<br>
		특이사항 :${serviceDetail.patientUnique }
	</div>
	<br>
	<div class="content">
		<a class="title">서비스정보</a><br>
	</div>
	<div class="text2">
	근무시간:${serviceDetail.serviceStartTime }시 ~ ${serviceDetail.serviceEndTime }시 <br>
	결제금액:${serviceDetail.servicePrice }원<br>
	수수료 :${serviceDetail.commission }원<br>
        수령금액:${serviceDetail.helperPrice }원<br>
         요구사항:${serviceDetail.serviceDemand } <br><br>
     <환자 후기><br>
	 <c:forEach var="rList" items="${reviewList}"> 
	작성일 : 
	<fmt:formatDate value="${rList.reviewDate}" pattern="yy.MM.dd HH:MM" /><br>
	별점 : ${rList.reviewStar }<br>
	내용 :${rList.reviewContents }<br>
	<hr style="border: 1px solid #313b45" width="100%">
     </c:forEach>
	</div>
		</div>
	</div>
	<!-- 컨트롤러에 값을 전달하기 위해 태그 추가-->
<div align="center">
<form action="confirm.do" id="serviceFrm" name="serviceFrm">
	<input type="hidden" id="familyNo" name="familyNo" value="${serviceDetail.familyNo }">
	<input type="hidden" id="serviceNo" name="serviceNo" value="${serviceDetail.serviceNo }">
	<button type="button" id="confirm" class="confirm w3-button w3-light-grey" onclick="getServiceNo('${serviceDetail.serviceNo }')">수락</button>
	<button type="button" class="w3-button w3-dark-grey" id="reject" onclick="getRejectNo('${serviceDetail.serviceNo}')">거절</button>
	<input type="hidden" id="serviceNo" name="serviceNo">
</form>
</div>

<script type="text/javascript">
function getServiceNo(key){
	alert("요청을 수락했습니다.");
	document.serviceFrm.action="confirm.do";
	document.serviceFrm.submit();
}
function getRejectNo(key){
	alert("요청을 거절했습니다.")
	document.serviceFrm.action="reject.do";
	document.serviceFrm.submit();
}

</script>
</body>
</html>