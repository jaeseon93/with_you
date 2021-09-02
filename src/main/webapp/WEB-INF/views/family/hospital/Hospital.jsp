<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- 글꼴  -->
<link href="https://fonts.googleapis.com/css2?family=Chewy&family=Jua&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Noto+Serif+KR:wght@600&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
<title>서비스 신청 페이지</title>
</head>
<style>
.search {
 	margin-top:30px;
}
ul.breadcrumb { 
  margin:0px;
  padding: 6px;
  list-style: none;
  background-color: white;
}
ul.breadcrumb li {
  display: inline;
}
ul.breadcrumb li+li:before {
  padding: 8px;
  color: black;
  content: "/\00a0";
}
ul.breadcrumb li a {
  color: #4f0e0e;
  text-decoration: none;
  font-family: 'Do Hyeon', sans-serif;
  font-size:20px;
  text-align:center;
}
.w3-border{
	font-family: 'Do Hyeon', sans-serif;
	font-size: 18px;
}
.btn{
	font-family: 'Jua', sans-serif;
	font-size:20px;
	color:#432c19;
}
.w3-col{
	font-family: 'Do Hyeon', sans-serif;
	font-size:17px;
}	
.content{
	font-family: 'Do Hyeon', sans-serif;
	font-size:17px;
	margin-right:18px;
	
}
</style>
<body>

<div class="main" align="center">
	<div class="search">
		<form id="frm" action="searchHospital.do" method="post">
			<input type="text" class="w3-border" name="search" size="28px"placeholder="검색어를 입력해주세요.">
			<input type="submit" class="btn" value="검색">	
		</form>
		<br>
	</div>
	<hr style="border: 1px solid white;" width="100%">
	<c:forEach var="list" items="${selectList}">
	<div align="left">
			<a class="content">이름:${list.HOSPITALNAME }</a><br>
			<a class="content">주소:${list.HOSPITALADDR  }</a><br>
			<a class="content">번호:${list.HOSPITALTEL  }</a><br>
	</div>
	<div class="w3-row" align="left">
		<a class="content">병상:${list.HOSPITALSICKBAD  }</a>	
		<a class="content">입원실:${list.HOSPITALLRM }</a>
       	<a class="content">의료진:${list.HOSPITALMEDSTAF }</a>
	</div>
	<hr style="border: 1px solid white;" width="100%">
	</c:forEach>
		<br>
	
</div>
</body>