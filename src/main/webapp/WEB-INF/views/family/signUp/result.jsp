<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<h1>회원 가입 완료</h1>
<h1>환자 로그인 코드 ${code }</h1>
<button type="button" onclick="goLogin();">로그인하기</button>

<script>
	function goLogin(){
		location.href="familyLogin.do";
	}
</script>