<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html> 
<head> 
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-colors-flat.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-green.css">
<link href="https://fonts.googleapis.com/css2?family=Bitter:wght@700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- 글꼴 스타일  -->
<link href="https://fonts.googleapis.com/css2?family=Chewy&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Chewy&family=Jua&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Noto+Serif+KR:wght@700&display=swap" rel="stylesheet">
</head> 
<title>메인화면</title> 
<script type="text/javascript">
	window.MyApp.homeStopService();
</script>
<style type = "text/css">
html, body {
  height: 100%;
}

.button {
  width: 250px;
  height: 55px;
  font-family: 'Jua', sans-serif;
  font-size: 25px;
  text-transform: uppercase;
  letter-spacing: 2.5px;
  font-weight: 500;
  color: #000;
  background-color: #fff;
  border: none;
  border-radius: 45px;
  box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);
  transition: all 0.3s ease 0s;
  cursor: pointer;
  outline: none;
  }

.button:hover {
  background-color: #2EE59D;
  box-shadow: 0px 15px 20px rgba(46, 229, 157, 0.4);
  color: #fff;
  transform: translateY(-7px);
}
	
body,h1,h2,h3,h4,h5,h6 {font-family: "Lato", sans-serif}
.w3-bar,h1,button {font-family: "Montserrat", sans-serif}
.fa-anchor,.fa-coffee {font-size:200px}
.title{
	font-family: 'Chewy', cursive;
	font-size: 48px;
	
}
.subtitle {
	font-family: 'Chewy', cursive;
	font-family: 'Jua', sans-serif;
	font-size: 25px;
}
button{
	font-family: 'Jua', sans-serif;
}
</style>
</head>

<body>
<div class="w3-right" style="padding:4px; margin:4px">
<button class="w3-button w3-flat-white w3-padding-large w3-hover-white w3-large w3-round-large" 
	 class="adminlogin" onclick="location.href='adminlogin.do'">★</button>
</div>
<!-- Header -->
<header class="w3-center" style="padding:50px 16px">
<div align="center" style="margin:65px;">
  <a class="title">Care WithU</a>
</div>
  <p class="subtitle">사용자 유형을 선택해주세요.</p><br>


  <button class="button" style="background:white;" onclick="location.href='patientLogin.do'">환자</button><br><br>
  <button class="button" style="background:white;" onclick="location.href='familyLogin.do'">보호자</button><br><br>
  <button class="button" style="background:white;" onclick="location.href='helperLogin.do'">간병인</button><br><br>

</header>

</body> 

</html>

