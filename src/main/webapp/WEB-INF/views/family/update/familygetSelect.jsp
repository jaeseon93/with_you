<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@700&display=swap" rel="stylesheet">
<script src="${pageContext.request.contextPath}/resources/common/js/core.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/common/js/sha256.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/common/js/user-info.js"></script>
<script src="${pageContext.request.contextPath}/resources/common/js/sign.js"></script>
<script src="${pageContext.request.contextPath}/resources/common/js/jquery.min.js"></script>
<script type="text/javascript">

   function validPw(){
	   if(updateForm.familyPw.value == ""){
	 	alert("비밀번호를 입력하세요.")
	  }else if(updateForm.familyPwValie.value=="" ) {
		  alert("비밀번호를 확인하세요")
	  }else if (updateForm.familyPw.value != updateForm.familyPwValie.value){
		  alert("비밀번호가 일치하지 않습니다.");
	  }else if (updateForm.familyAddr.value == ""){
		 	alert("주소를 입력하세요");
	  }else if(updateForm.familyTel.value==""){
		  alert("연락처를 입력하세요")
	  }
	  else{
		  document.updateForm.submit();
		  
	  }
   }
</script>
<style>
	.m4{
		font-family: 'Nanum Gothic', sans-serif;			
	}
	.title{
	font-family:'Nanum Gothic', sans-serif;	
		font-size : 35px;
		text-align : center;
		margin-bottom : 15px;
	}
	.m4{
	font-family: 'Nanum Gothic', sans-serif;
	font-size : 15px;		
	text-align : left;
	}
	.add-btn{
	width : 100%;
	margin-top : 5px;
	margin-bottom : 5px;
	height : 35px;
	background-color :#F0F8FF;
	border : 2px solid #464646;
	}
	.confirm{
	margin-left : 65px;
	}
	.tell{
		margin-bottom : 15px;
	}
</style>
<div class="w3-pading-large w3-center">
	<div class="w3-padding-large container">

		<div class="w3-row">
			<div class="w3-col m4">&nbsp;</div>
			<div class="w3-col m4">
				<form id="updateForm" name="updateForm" class="updateForm" action="familyUpdate.do">
					<h1 class=" title">보호자 정보수정</h1>
					<div class="w3-row">
						<div class="w3-col s4 m4"><p>이메일</p></div>
						<div class="w3-col s8 m8">
							<input class="w3-input w3-border form-control" type="text" placeholder="" id="familyEmail" name="familyEmail" value="${getSelect.familyEmail }" readonly> 
						</div>
					</div>
					<div class="w3-row">
						<div class="w3-col s4 m4"><p>비밀번호</p></div>
						<div class="w3-col s8 m8">
							<input class="w3-input w3-border form-control" type="password" placeholder="" id="familyPw" name="familyPw" value="" > 
						</div>
					</div>
					<div class="w3-row">
						<div class="w3-col s4 m4"><p>비밀번호 확인</p></div>
						<div class="w3-col s8 m8">
							<input class="w3-input w3-border form-control" type="password" placeholder="" id="familyPwValie" name="familyPwValid" value="" > 
						</div>
					</div>
					
					<div class="w3-row">
						<div class="w3-col s4 m4"><p>이름</p></div>
						<div class="w3-col s8 m8">
							<input class="w3-input w3-border form-control" type="text" placeholder="" id="familyName" name="familyName" value="${getSelect.familyName }" readonly>
						</div>
					</div>
					
					<div class="w3-row">
						<div class="w3-col s4 m4"><p>생년월일</p></div>
						<div class="w3-col s8 m8">
							<input class="w3-input w3-border form-control" type="text" placeholder="" id="familyBirth" name="familyBirth" value="<fmt:formatDate value="${getSelect.familyBirth}" pattern="yyyy-MM-dd" />" readonly/>

						</div>
					</div>
					<div class="w3-row">
						<div class="w3-col s4 m4"><p>주소</p></div>
						<div class="w3-col s8 m8">
							<input class="w3-input w3-border add-juso form-control" type="text" placeholder="" id="familyAddr" name="familyAddr" value="${getSelect.familyAddr }"><button class="add-btn  w3-round"type="button" onclick="jusoPopup(0)">주소찾기</button>
						</div>
					</div>
					<div class="w3-row">
						<div class="w3-col s4 m4"><p>연락처</p></div>
						<div class="w3-col s8 m8">
							<input class="w3-input w3-border form-control tell" type="text" placeholder="" id="familyTel" name="familyTel" value="${getSelect.familyTel }">
						</div>
					</div>
					<button class="w3-button w3-round w3-dark-grey confirm" id="updateButton" type="button" onclick="validPw()">&nbsp;&nbsp;수정&nbsp;&nbsp;</button>
										&nbsp;&nbsp;&nbsp;
					<button class="w3-button w3-round w3-dark-grey" type="reset">&nbsp;&nbsp;취소&nbsp;&nbsp;</button>
				</form>
			</div>
			<div class="w3-col m4">&nbsp;</div>
		</div>

	</div>
</div>