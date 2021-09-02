<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="${pageContext.request.contextPath}/resources/common/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/common/js/core.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/common/js/sha256.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/common/js/user-info.js"></script>
<script src="${pageContext.request.contextPath}/resources/common/js/sign.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@700&display=swap" rel="stylesheet">
<style>
	.m4, .m3, .title{
		font-family: 'Nanum Gothic', sans-serif;		
		margin : auto;
	}
	
	.title{
		text-align:center;
		margin-bottom : 10px;
	}
	.title2{
		margin-top : 10px;
	}
	.add-btn{
			width : 100%;
	margin-top : 2px;
	margin-bottom : 2px;
	height : 35px;
	background-color :#F0F8FF;
	border : 2px solid #464646;
	font-family: 'Nanum Gothic', sans-serif;	
	}
	.confirm{
		margin-left : 100px;
		margin-top : 10px;
	}
	.cancle{
		margin-top : 10px;
	
	}
	
	
</style>

<div class="">
<div class="">

<div class="">&nbsp;</div>
<div class="">
	<form action="createMemberFamily.do" id="mainFrm" name="mainFrm" method="post">
		<h1 class="title">보호자 회원가입</h1>
		<div class="w3-row">
			<div class="w3-col s4 m4"><p>이메일*</p></div>
			<div class="w3-col s8 m8">
				<input class="w3-input w3-border email-check form-control" type="email" placeholder="abc@def.com" id="familyEmail" name="familyEmail" required> 
				<span id="email-success" style="display: none;">사용 가능</span>
				<span id="email-danger" style="display: none; color: #d92742; font-weight: bold; ">사용 불가</span>
			</div>
		</div>
		<div class="w3-row">
			<div class="w3-col s4 m4"><p>비밀번호*</p></div>
			<div class="w3-col s8 m8">
				<input class="w3-input w3-border pw-check form-control" type="password" placeholder="" id="familyPw" name="familyPw" required>
			</div>
		</div>
		<div class="w3-row">
			<div class="w3-col s4 m4"><p>비밀번호확인*</p></div>
			<div class="w3-col s8 m8">
				<input class="w3-input w3-border pw-check form-control" type="password" placeholder="" id="familyPw2" name="familyPw2" required>
				<span id="pw-success" style="display: none;">비밀번호 일치</span>
				<span id="pw-danger" style="display: none; color: #d92742; font-weight: bold; ">비밀번호 불일치</span>
			</div>
		</div>
		<div class="w3-row">
			<div class="w3-col s4 m4"><p>이름*</p></div>
			<div class="w3-col s8 m8">
				<input class="w3-input w3-border form-control" type="text" placeholder="" id="familyName" name="familyName" required>
			</div>
		</div>
		<div class="w3-row">
			<div class="w3-col s4 m4"><p>성별*</p></div>
			<div class="w3-col s4 m4">
				<p>
				<input type="radio" id="f-male" name="familySex" value="남" required>
				<label for="f-male">남</label>
				</p>
			</div>
			<div class="w3-col s4 m4">
				<p>
				<input type="radio" id="f-female" name="familySex" value="여">
				<label for="f-female">여</label>
				</p>
			</div>
		</div>
		<div class="w3-row">
			<div class="w3-col s4 m4"><p>생년월일*</p></div>
			<div class="w3-col s4 m4"><input class="w3-input w3-border form-control" type="text" placeholder="년" id="familyBirthY" name="familyBirthY" numberOnly required></div>
			<div class="w3-col s2 m2"><input class="w3-input w3-border form-control" type="text" placeholder="월" id="familyBirthM" name="familyBirthM" numberOnly required></div>
			<div class="w3-col s2 m2"><input class="w3-input w3-border form-control" type="text" placeholder="일" id="familyBirthD" name="familyBirthD" numberOnly required></div>
			<!-- 
			<div class="w3-col s8 m8">
				<input class="w3-input w3-border" type="date" placeholder="" id="familyBirth" name="familyBirth">
			</div>
			 -->
		</div>
		<div class="w3-row">
			<div class="w3-col s4 m4"><p>주소*</p></div>
			<div class="w3-col s8 m8">
				<input class="w3-input w3-border add-juso form-control" type="text" placeholder="" id="familyAddr" name="familyAddr" required readOnly><button class="add-btn" type="button" onclick="jusoPopup(0)">주소찾기</button>
			</div>
		</div>
		<div class="w3-row">
			<div class="w3-col s4 m4"><p>연락처*</p></div>
			<div class="w3-col s8 m8">
				<input class="w3-input w3-border form-control" type="text" placeholder="숫자만" id="familyTel" name="familyTel" numberOnly required>
			</div>
		</div>


		<h1 class="title title2">환자정보</h1>
		<div class="w3-row">
			<div class="w3-col s4 m4"><p>이름*</p></div>
			<div class="w3-col s8 m8">
				<input class="w3-input w3-border form-control" type="text" placeholder="" id="patientName" name="patientName" required>
			</div>
		</div>
		<div class="w3-row">
			<div class="w3-col s4 m4"><p>성별*</p></div>
			<div class="w3-col s4 m4">
				<p>
				<input type="radio" id="p-male" name="patientSex" value="남" required>
				<label for="p-male">남</label>
				</p>
			</div>
			<div class="w3-col s4 m4">
				<p>
				<input type="radio" id="p-female" name="patientSex" value="여">
				<label for="p-female">여</label>
				</p>
			</div>
		</div>
		<div class="w3-row">
			<div class="w3-col s4 m4"><p>생년월일*</p></div>
			<div class="w3-col s4 m4"><input class="w3-input w3-border form-control" type="text" placeholder="년" id="patientBirthY" name="patientBirthY" numberOnly required></div>
			<div class="w3-col s2 m2"><input class="w3-input w3-border form-control" type="text" placeholder="월" id="patientBirthM" name="patientBirthM" numberOnly required></div>
			<div class="w3-col s2 m2"><input class="w3-input w3-border form-control" type="text" placeholder="일" id="patientBirthD" name="patientBirthD" numberOnly required></div>
			<!-- 						
			<div class="w3-col s8 m8">
				<input class="w3-input w3-border" type="text" placeholder="" id="patientBirth" name="patientBirth">
			</div>
			 -->
		</div>
		<div class="w3-row">
			<div class="w3-col s4 m4"><p>주소*</p></div>
			<div class="w3-col s8 m8">
				<input class="w3-input w3-border add-juso form-control" type="text" placeholder="" id="patientAddr" name="patientAddr" required readOnly><button class="add-btn w3-round" type="button" onclick="jusoPopup(1)">주소찾기</button>
			</div>
		</div>
		<div class="w3-row">
			<div class="w3-col s4 m4"><p>연락처*</p></div>
			<div class="w3-col s8 m8">
				<input class="w3-input w3-border form-control" type="text" placeholder="숫자만" id="patientTel" name="patientTel" numberOnly required>
			</div>
		</div>
		<div class="w3-row">
			<div class="w3-col s4 m4"><p>비상연락처*</p></div>
			<div class="w3-col s8 m8">
				<input class="w3-input w3-border form-control" type="text" placeholder="숫자만" id="patientFamilyTel" name="patientFamilyTel" numberOnly required>
			</div>
		</div>
		<div class="w3-row">
			<div class="w3-col s4 m4"><p>치매등급</p></div>
			<div class="w3-col s8 m8">
			  <p>
				<select name="patientGrade">
				  <option value="">선택</option>
				  <option value="G01">1등급</option>
				  <option value="G02">2등급</option>
				  <option value="G03">3등급</option>
				  <option value="G04">4등급</option>
				  <option value="G05">5등급</option>
				  <option value="G06">인지지원등급</option>
				</select>
			  </p>
			</div>
		</div>
		<div class="w3-row">
			<div class="w3-col s4 m4"><p>질환</p></div>
			<div class="w3-col s8 m8">
				<input class="w3-input w3-border form-control" type="text" placeholder="" id="patientDisease" name="patientDisease">
			</div>
		</div>
		<div class="w3-row">
			<div class="w3-col s4 m4"><p>혈액형*</p></div>
			<div class="w3-col s8 m8">
			  <p>
				<select name="patientBlood" required>
				  <option value="">선택</option>
				  <option value="A">A</option>
				  <option value="B">B</option>
				  <option value="AB">AB</option>
				  <option value="O">O</option>
				</select>
			  </p>
				<!-- <input class="w3-input w3-border" type="text" placeholder="예) ABO RH ..." id="patientBlood" name="patientBlood" required> -->
			</div>
		</div>
		<div class="w3-row">
			<div class="w3-col s4 m4"><p>복용중인약</p></div>
			<div class="w3-col s8 m8">
				<input class="w3-input w3-border form-control" type="text" placeholder="예) 당뇨, 고혈압 .. " id="patientMedication" name="patientMedication">
			</div>
		</div>
		<div class="w3-row">
			<div class="w3-col s4 m4"><p>안심구역*</p></div>
			<div class="w3-col s8 m8">
				<input class="w3-input w3-border form-control" type="text" placeholder="예)5000m(숫자만 입력)" id="patientZone" name="patientZone" numberOnly>
			</div>
		</div>
		<div class="w3-row">
			<div class="w3-col s4 m4"><p>특이사항</p></div>
			<div class="w3-col s8 m8">
				<input class="w3-input w3-border form-control" type="text" placeholder="" id="patientUnique" name="patientUnique">
			</div>
		</div>
		<button class="w3-button w3-round w3-dark-grey confirm" type="button" onclick="fnSubmit(true)" >&nbsp;&nbsp;등록&nbsp;&nbsp;</button>
			&nbsp;&nbsp;&nbsp;
		<button class="w3-button w3-round w3-dark-grey cancle" type="reset">&nbsp;&nbsp;취소&nbsp;&nbsp;</button>

	</form>
</div>
<div class="w3-col m4">&nbsp;</div>

</div>
</div>






