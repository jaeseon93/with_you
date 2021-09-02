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
<title>보호자 메인홈메뉴</title>
<style>
.menu {
	margin:38px;
}
.fam1,.fam2 {
	margin:30px;
	display:inline-block;

}
.fam3 {
	display:inline-block;
	margin:30px;
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
		   	<a href="applyMenu.do">
		  	<img src="${pageContext.request.contextPath}/resources/img/menu/addHelper.png" style="height:68px"  />
		  	</a><br>
		  	<a class="menuTitle">간병인 신청</a>
		</div>
		  <div class="fam2">
		  	<a href="careFamily.do">
		  		<img src="${pageContext.request.contextPath}/resources/img/menu/familyCare.png" style="height:78px"  />
		  	</a><br>
		  	<a class="menuTitle">가족 케어</a>
		  </div>
		<br>
		<div class="fam3">
		  	<a href="hospital.do">
		  		<img src="${pageContext.request.contextPath}/resources/img/menu/hospital.png" style="height:70px"  />
		  	</a><br>
		  	<a class="menuTitle">시설 조회</a>
		</div>
		
  	
	</div>

</body>
</html>