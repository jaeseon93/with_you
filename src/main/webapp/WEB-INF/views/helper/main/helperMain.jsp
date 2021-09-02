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
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@700&display=swap" rel="stylesheet">
<title>간병인 메인홈메뉴</title>
<style>
.menuTitle{
	font-family: 'Do Hyeon', sans-serif;
	font-size:30px;
}
.menu {
	margin:20px;
}
.fam1,.fam2 {
	margin:20px;
	display:inline-block;

}
.fam3, .fam4 {
	margin:25px;
	display:inline-block;
}
</style>
</head>
<body>
	<div class="menu" align="center">
		<div class="fam1">
		   	<a href="scheduleList.do">
		  	<img src="${pageContext.request.contextPath}/resources/img/menu/schedule.png" style="height:85px"  />
		  	</a><br>
		  	<a class="menuTitle">일정관리</a>
		</div>
		  <div class="fam2">
		  	<a href="helperGetSelect.do">
		  		<img src="${pageContext.request.contextPath}/resources/img/menu/settingUser.png" style="height:85px"  />
		  	</a><br>
		  	<a class="menuTitle">회원정보 수정</a>
		  </div>
		<br>
		<div class="fam3">
		  	<a href="serviceapplylist.do">
		  		<img src="${pageContext.request.contextPath}/resources/img/menu/callService.png" style="height:85px"  />
		  	</a><br>
		  	<a class="menuTitle">요청내역</a>
		</div>
		<div class="fam4">
		  	<a href="serviceHistory.do">
		  		<img src="${pageContext.request.contextPath}/resources/img/menu/serviceList.png" style="height:85px"  />
		  	</a><br>
		  	<a class="menuTitle">서비스 이력</a>
		</div>
	</div>

</body>
</html>