<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<!-- 글꼴  -->
 <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
<title>가족 케어메뉴</title>
<style>
.menu {
	margin:38px;
}
.fam1,.fam2 {
	display:inline-block;
}
.fam1 {
	margin-top:34px;
}
.fam2{
	margin-top:34px;
	margin-right: 10px;
}
.fam3 {
	margin-top:34px;
	display:inline-block;
}
.menuTitle{
	font-family: 'Do Hyeon', sans-serif;
	font-size:30px;
}
</style>
</head>
<body>
	<div class="menu" align="center">
		<div class="fam1">
		   	<a href="patientLoc.do">
		  	<img src="${pageContext.request.contextPath}/resources/img/menu/findPatient.png" style="height:73px"  />
		  	</a><br>
		  	<a class="menuTitle">가족 실시간 위치</a>
		</div>
		<br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<div class="fam2">
		  	<a href="todayLine.do">
		  		<img src="${pageContext.request.contextPath}/resources/img/menu/analysePatient.png" style="height:78px"  />
		  	</a><br>
		  	<a class="menuTitle">가족 활동체크</a>
		</div>&nbsp;&nbsp;&nbsp;&nbsp;
		<div class="fam3">
		  	<a href="patientgetSelect.do">
		  		<img src="${pageContext.request.contextPath}/resources/img/menu/alterPatient.png" style="height:78px"  />
		  	</a><br>
		  	<a class="menuTitle">가족 정보 수정</a>
		</div>
  	
	</div>

</body>
</html>