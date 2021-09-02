<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 글꼴 -->
<link href="https://fonts.googleapis.com/css2?family=Chewy&family=Jua&display=swap" rel="stylesheet">
<title>간병인신청 메뉴 페이지</title>
<style>
.myButton {
	background-color:#ffffff;
	border-radius:28px;
	border:1px solid #ffffff;
	display:inline-block;
	cursor:pointer;
	color:#000000;
	font-family: 'Jua', sans-serif;
	width:350px;
	font-size:28px;
	padding:5px 67px;
	text-decoration:none;
	text-shadow:0px 1px 0px #2f6627;
}
.myButton:hover {
	background-color:#f0f0f0;
}
.myButton:active {
	position:relative;
	top:1px;
}


.w3-center {
	margin-top:180px;
	
}

</style>
</head>

<body>
<div class="w3-center">
	<div class="d1">
		<a href="helperList.do" class="myButton">신청하기</a><br><br>
	</div>
	<div class="d2">
		<a href="applyList.do" class="myButton">신청내역</a><br><br>
	</div>
	<div class="d3">
		<a href="bestLikeList.do" class="myButton">즐겨찾기 리스트</a><br><br>
	</div>
</div>


</body>
</html>