<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<title>메인 홈</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-colors-flat.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-green.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Lato", sans-serif}
.w3-bar,h1,button {font-family: "Montserrat", sans-serif}
.fa-anchor,.fa-coffee {font-size:200px}
.w3-button {width:200px;}
</style>
<body class="w3-container w3-theme-l4">
<div class="w3-right" style="padding:14px">
<button class="w3-button w3-flat-emerald w3-padding-large w3-hover-white w3-large w3-round-large">관리자</button>
</div>
<!-- Header -->
<header class="w3-center" style="padding:80px 16px">
  <h1 class="w3-margin w3-jumbo">Care WithU</h1>
  <p class="w3-xlarge">사용자 유형을 선택해주세요.</p>

  <button class="w3-button w3-theme-d1 w3-padding-large w3-hover-white w3-xlarge w3-margin-top">환자</button><br>
  <button class="w3-button w3-theme-d1 w3-padding-large w3-hover-white w3-xlarge w3-margin-top">보호자</button><br>
  <button class="w3-button w3-theme-d1 w3-padding-large w3-hover-white w3-xlarge w3-margin-top">간병인</button>
</header>

<a href="patientHome.jsp">환자홈</a>
</body>
</html>