<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
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
<style>
.m4{
		font-family: 'Nanum Gothic', sans-serif;		
	}
	.title{
		font-size : 35px;	
		margin-bottom : 20px;
		margin-left : 50px;
		
	}
	input{
		margin-bottom : 5px;
		border-radius : 4px;
		width : 1200px;
	}
	.searchAdd{
		margin-bottom : 5px;

		width :200px;
	}
	.m4 {
		left-margin : 50px;
	}
	.confirm{
		margin-left : 60px;
	}
	.add-btn{
	width : 100%;
	margin-top : 5px;
	margin-bottom : 5px;
	height : 35px;
	background-color :#F0F8FF;
	border : 2px solid #464646;
	}
	
	
</style>
<script>

</script>
<body>
<div class="w3-padding-large">
		<div class="m4 container">
				<form id="updateForm" name="updateForm" action="patientUpdate.do">
					<h1 class="m4 title">환자정보 수정</h1>
					
					<div class="">
						<div class="w3-col s4 m4"><p>이름</p></div>
						<div class="w3-col s8 m8">
							<input class="w3-input w3-border form-control" type="text" placeholder="" id="patientName" name="patientName" value="${getSelect.patientName }" readonly>
						</div>
					</div>
					
					<div class="w3-row">
						<div class="w3-col s4 m4"><p>성별</p></div>
						<div class="w3-col s8 m8">
							<input class="w3-input w3-border form-control" type="text" placeholder="" id="patientSex" name="patientSex" value="${getSelect.patientSex }" readonly>
						</div>
					</div>
					<div class="w3-row">
						<div class="w3-col s4 m4"><p>주소</p></div>
						<div class="w3-col s8 m8">
							<input class="w3-input w3-border add-juso form-control" type="text" placeholder="" id="patientAddr" name="patientAddr" value="${getSelect.patientAddr }" >
							<button class="add-btn w3-round"type="button" onclick="jusoPopup(0)">주소찾기</button>
						</div>
					</div>
					<div class="w3-row">
						<div class="w3-col s4 m4"><p>생년월일</p></div>
						<div class="w3-col s8 m8">
							<input class="w3-input w3-border form-control" type="text" placeholder="" id="patientBirth" name="patientBirth" value="<fmt:formatDate value="${getSelect.patientBirth}" pattern="yyyy-MM-dd" />" readonly/>
						</div>
					</div>
					<div class="w3-row">
						<div class="w3-col s4 m4"><p>연락처</p></div>
						<div class="w3-col s8 m8">
							<input class="w3-input w3-border form-control" type="text" placeholder="" id="patientTel" name="patientTel" value="${getSelect.patientTel }">
						</div>
					</div>
					<div class="w3-row">
						<div class="w3-col s4 m4"><p>비상연락처</p></div>
						<div class="w3-col s8 m8">
							<input class="w3-input w3-border form-control" type="text" placeholder="" id="patientFamilyTel" name="patientFamilyTel" value="${getSelect.patientFamilyTel }">
						</div>
					</div>
					<div class="w3-row">
						<div class="w3-col s4 m4"><p>치매등급</p></div>
						<div class="w3-col s8 m8">
							<input class="w3-input w3-border form-control" type="text" placeholder="" id="patientGrade" name="patientGrade" value="${getSelect.patientGrade }" readonly>
						</div>
					</div>
					<div class="w3-row">
						<div class="w3-col s4 m4"><p>질환</p></div>
						<div class="w3-col s8 m8">
							<input class="w3-input w3-border form-control" type="text" placeholder="" id="patientDisease" name="patientDisease" value="${getSelect.patientDisease }">
						</div>
					</div>
					<div class="w3-row">
						<div class="w3-col s4 m4"><p>혈액형</p></div>
						<div class="w3-col s8 m8">
							<input class="w3-input w3-border form-control" type="text" placeholder="" id="patientBlood" name="patientBlood" value="${getSelect.patientBlood }" readonly>
						</div>
					</div>
					<div class="w3-row">
						<div class="w3-col s4 m4"><p>복용중인약</p></div>
						<div class="w3-col s8 m8">
							<input class="w3-input w3-border form-control" type="text" placeholder="" id="patientMedication" name="patientMedication" value="${getSelect.patientMedication }">
						</div>
					</div>
					
					<div class="w3-row">
						<div class="w3-col s4 m4"><p>특이사항</p></div>
						<div class="w3-col s8 m8">
							<input class="w3-input w3-border form-control" type="text" placeholder="" id="patientUnique" name="patientUnique" value="${getSelect.patientUnique }">
						</div>
					</div>
					<div class="w3-row">
					<div class="w3-col s4 m4"><p>프로필 사진</p></div>
						<div class="w3-col s8 m8">
							<input class="w3-input w3-border" type="file" placeholder="" id="helperProfile" name="helperProfile">
						</div>
					</div>
					<button class="w3-button w3-round w3-dark-grey confirm" id="updateButton"type="submit" >&nbsp;&nbsp;수정&nbsp;&nbsp;</button>
						&nbsp;&nbsp;&nbsp;
					<button class="w3-button w3-round w3-dark-grey cancle" type="reset">&nbsp;&nbsp;취소&nbsp;&nbsp;</button>
				
				</form>
			</div>
			<div class="w3-col m4">&nbsp;</div>
		</div>

	</div>
</div>
</body>
</html>