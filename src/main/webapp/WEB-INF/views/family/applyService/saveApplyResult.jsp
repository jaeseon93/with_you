<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>보호자 서비스 신청 완료 테스트</h1>
		<pre>
	서비스 신청 완료시 '보호자메인' 페이지로 이동 될 것이며,
	동시에 신청 내용은 DB로 저장된다.
	DB 테이블명 : serviceApply
		</pre>
		<div><br/></div>
		<input type="button" name="main" value="메인화면" onclick="location.href='familyMain.do'">
	</div>
</body>
</html>