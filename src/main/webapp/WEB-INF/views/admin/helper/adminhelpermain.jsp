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

		<h1>회원 정보</h1>

		<div>

			HELPERNO: ${view.helperno }<br />
			COMMISSIONGRADE: ${view.commissiongrade }<br /> <!-- 수수료등급 -->
			HELPERNAME: ${view.helpername }<br />
			HELPERBIRTH: ${view.helperbirth }<br />
			HELPERSEX: ${view.helpersex }<br />
			HELPERADDR: ${view.helperaddr }<br />
			HELPERTEL: ${view.helpertel }<br />
			HELPEREMAIL: ${view.helperemail }<br />
			HELPERPW: ${view.helperpw }<br />
			HELPERWORKAREA: ${view.helperworkarea } <br />  <!-- 작업 영역 -->
			HELPERSTARTTIME: ${view.helperstarttime } <br />  <!-- 간병인 근무시작시간 -->
			HELPERENDTIME: ${view.helperendtime } <br />  <!-- 간병인 퇴근시간 -->
			HELPERUNIQUE: ${view.helperunique } <br />  <!-- 독특한 -->
			HELPERPROFILE: ${view.helperprofile } <br />  <!-- 작업 영역 -->
			HELPERJOINDATE: ${view.helperjoindate } <br />  <!-- 작업 영역 -->

			

		</div>

		<div><br />

			<a href="adminhelperList.do">회원목록</a> &nbsp;&nbsp;

			<a href="#">정보수정</a>	&nbsp;&nbsp;

			<a href="HelperDelete.do">회원삭제</a>

		</div>

	</div>

</body>

</html>