<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>로그인 길어지면 띄워지는 경고창</title>
</head>
<body>
<div class="w3-panel w3-yellow w3-display-container">
  <span onclick="this.parentElement.style.display='none'"
  class="w3-button w3-large w3-display-topright">&times;</span>
  <h3>경고!</h3>
  <p>로그인 세션이 만료되었습니다. 다시 로그인 해주십시오.</p>
  <button type="button" class="login100-form-btn" onclick="location.href='home.do'">확인</button>
</div>
</body>
</html>