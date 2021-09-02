<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!--8. login.jsp(로그인페이지 : 로그인 성공, 실패, 로그아웃 메시지 알림) -->

<%-- <%@ include file="../admin/ad_home.jsp"%> --%>


<script>

function fnBtnLogin(){
	// 태크.val() : 태그에 입력된 값
	// 태크.val("값") : 태그의 값을 변경 
	var adminId = document.getElementById("adminId").value;
	var adminPw = document.getElementById("adminPw").value;
	if (adminId == "") {
		alert("아이디를 입력하세요.");
		document.getElementById("adminId").focus();
		return; // 함수 종료
	}

	if (adminPw == "") {
		alert("비밀번호를 입력하세요.");
		document.getElementById("adminPw").focus();
		return;
	}
	// 폼 내부의 데이터를 전송할 주소
	document.form1.action = "adminloginCheck.do"
// 	// 제출
	document.form1.submit();
}

</script>


	<%@ include file="/WEB-INF/views/admin/menu.jsp"%>
	<h2>로그인</h2>
	<form name="form1" method="post">
		<table border="1" width="400px">
			<tr>
				<td>아이디</td>
				<td><input name="adminId" id="adminId"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="adminPw" id="adminPw"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="button" id="btnLogin" onclick="fnBtnLogin();">로그인</button> 
				
					
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
