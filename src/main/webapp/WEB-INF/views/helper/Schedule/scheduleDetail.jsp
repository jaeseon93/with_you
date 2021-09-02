<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<!-- 글꼴 스타일  -->
<link href="https://fonts.googleapis.com/css2?family=Chewy&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Chewy&family=Jua&display=swap" rel="stylesheet">
<script src="${pageContext.request.contextPath}/resources/common/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/common/js/help-manage.js"></script>
<title>서비스이력 상세조회</title>
<script type="text/javascript">
function getCheckResult(isOK){
	setResult(isOK);
}

$(function(){
	//페이지 로딩하면서 출퇴근시간 표시
	initialize('${scheduleDetail.serviceDate}', ${scheduleDetail.serviceStartTime}, ${scheduleDetail.serviceEndTime});
	getStartTime();
	
});

</script>
<style>
.content{
	margin-top:25px;
}
.title{
  font-family: 'Do Hyeon', sans-serif;
  margin:35px;
  font-size: 30px;
  color: black;
  text-decoration: none;
}
a {
  font-size: 26px;
  font-weight:bold;
}
.text,.text2 {
  font-family: 'Do Hyeon', sans-serif;
  font-size: 18px;
}
#btnStart,#btnEnd{
  font-family: 'Jua', sans-serif;
  font-size: 20px;
  color: white !important;
}
</style>
</head>
<body>
<div align="center">
	 <div class="content">
		<a class="title">보호자 정보</a><br>
	 </div>
	 <div align="center">
	 <div class="text">
		서비스날짜:${scheduleDetail.serviceDate } <br> 
		신청날짜:${scheduleDetail.applyDate } <br> 
		이름:${scheduleDetail.familyName }님 <br>
		연락처:${scheduleDetail.familyTel } <br>
		이메일:${scheduleDetail.familyEmail } <br>
		요청한 서비스시간:${scheduleDetail.serviceStartTime }시 - ${scheduleDetail.serviceEndTime }시 <br>
		요구사항:${scheduleDetail.serviceDemand } 
	 </div>
		<br>
		<a class="title">환자 정보</a><br>
	<div class="text2">
		이름:${scheduleDetail.patientName }님 <br>
		${scheduleDetail.patientBirth }세/${scheduleDetail.patientSex }/${scheduleDetail.patientBlood }형<br>
		주소: <br>${scheduleDetail.patientAddr } <br>
		연락처:${scheduleDetail.patientTel } <br>
		보호자비상연락처:${scheduleDetail.patientFamilyTel } <br>
		질환:${scheduleDetail.patientDisease } <br>
		치매등급:${scheduleDetail.patientGrade } <br>
		복용중인 약:${scheduleDetail.patientMedication } <br>
		특이사항:${scheduleDetail.patientUnique } <br>
		<hr style="border: 1px solid #c5bee1" width="100%">
	</div>
	 </div>
	<div align="left">
		<p class="text">출근시간 : <span id="realStartTime"></span></p>
		<p class="text">퇴근시간 : <span id="realEndTime"></span></p>
	</div>
	<div>
		<input type="hidden" id="patientNo" name="patientNo" value="${scheduleDetail.patientNo}">
		<input type="hidden" id="serviceNo" name="serviceNo" value="${scheduleDetail.serviceNo}">
		<input type="hidden" id="fmailyNo" name="fmailyNo" value="${scheduleDetail.familyNo}">
		<button type="button" class="w3-button w3-red" id="btnStart" onclick="clickStart(${loginOk.helperNo})">출근</button>
		<button type="button" class="w3-button w3-cyan" id="btnEnd" onclick="clickEnd()"> 퇴근</button>
	</div>
</div>




</body>
</html>