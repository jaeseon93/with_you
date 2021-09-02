<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="${pageContext.request.contextPath}/resources/common/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/common/js/core.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/common/js/sha256.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/common/js/user-info.js"></script>
<script src="${pageContext.request.contextPath}/resources/common/js/sign.js"></script>


<script>
	var loginPw = "${sessionPw}";
	console.log(loginPw);
	function validate(){
		if(helperUpdate.helperPw.value != helperUpdate.helperPw2.value) {
   	 	alert("비밀번호가 일치하지 않습니다.");
    	
	}else if (loginPw != helperUpdate.helperPw.value){
		alert("비밀번호가 일치하지 않습니다.");
	}else{
		alert("회원탈퇴 되었습니다.")
		document.helperUpdate.submit();
	}
}
</script>   
<!DOCTYPE html>
<div class="w3-container w3-center">
	<div class="w3-padding-large">
		<div class="w3-row">
			<div class="w3-col m4">&nbsp;</div>
			<div class="w3-col m4">
				<form action="taltowi.do" id="helperUpdate" name="helperUpdate">
					<h1>간병인 탈퇴</h1>		
					<div class="w3-row">
						<div class="w3-col s4 m4"><p>비밀번호</p></div>
						<div class="w3-col s8 m8">
							<input class="w3-input w3-border pw-check" type="password" placeholder="" id="helperPw" name="helperPw" value="" required>
						</div>
					</div>
					<div class="w3-row">
						<div class="w3-col s4 m4"><p>비밀번호확인</p></div>
						<div class="w3-col s8 m8">
							<input class="w3-input w3-border pw-check" type="password" placeholder="" id="helperPw2" name="helperPw2" value=""required>
<!-- 비밀번호 일치여부 표시		<span id="pw-success" style="display: none; font-weight:bold;">비밀번호 일치</span>
							<span id="pw-danger" style="display: none; color: #d92742; font-weight: bold; ">비밀번호 불일치</span> -->	
						</div>
					</div>
					<br>
					<button class="w3-button w3-round w3-dark-grey"  type="button" id="btn" name="btn" onclick="validate()">&nbsp;&nbsp;회원탈퇴&nbsp;&nbsp;</button>
					&nbsp;&nbsp;&nbsp;
					<button class="w3-button w3-round w3-dark-grey" type="reset" onclick="loaction.href='helperMain.do'">&nbsp;&nbsp;취소&nbsp;&nbsp;</button>
				</form>
				
			</div>
		</div>


	</div>
</div>