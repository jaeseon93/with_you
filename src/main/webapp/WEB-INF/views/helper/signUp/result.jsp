<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<h1>회원 가입 완료</h1>
<button type="button" onclick="goLogin();">로그인하기</button>

<script>
	function goLogin(){
		location.href="helperLogin.do";
	}
</script>