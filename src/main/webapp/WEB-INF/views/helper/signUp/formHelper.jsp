<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@700&display=swap" rel="stylesheet">
<script src="${pageContext.request.contextPath}/resources/common/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/common/js/core.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/common/js/sha256.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/common/js/user-info.js?v=<%=System.currentTimeMillis() %>"></script>
<script src="${pageContext.request.contextPath}/resources/common/js/sign.js?v=<%=System.currentTimeMillis() %>"></script>
<script src="${pageContext.request.contextPath}/resources/common/js/select-area.js?v=<%=System.currentTimeMillis() %>"></script>
<script src="${pageContext.request.contextPath}/resources/common/js/add-form.js?v=<%=System.currentTimeMillis() %>"></script>
</head>
<style>
	.m4, .m3{
		font-family: 'Nanum Gothic', sans-serif;		
		margin : auto;
	}
	.add-btn{
		width : 100%;
	}
	.confrim{
		margin-left : 70px;
	}
	.title{
		margin-bottom : 10px;
	}
	
</style>

<body>
<div class="">
<div class="">

<div class="">&nbsp;</div>
<div class="container">
	<form action="createMemberHelper.do" id="mainFrm" name="mainFrm" method="post" encType="multipart/form-data">
		<h1 align="center" class="m4 title">회원가입</h1>
		<div class="w3-row form-group">
			<div class="w3-col s4 m4 etop"><p>이메일*</p></div>
			<div class="w3-col s8 m8">
				<input class="form-control input email-check" type="email" placeholder="abc@def.com" id="helperEmail" name="helperEmail" required> 
				<span id="email-success" style="display: none;">사용 가능</span>
				<span id="email-danger" style="display: none; color: #d92742; font-weight: bold; ">사용 불가</span>
			</div>
		</div>
		<div class="w3-row">
			<div class="w3-col s4 m4"><p>비밀번호*</p></div>
			<div class="w3-col s8 m8">
				<input class="w3-input w3-border pw-check form-control input" type="password" placeholder="" id="helperPw" name="helperPw" required>
			</div>
		</div>
		<div class="w3-row">
			<div class="w3-col s4 m4"><p>비밀번호확인*</p></div>
			<div class="w3-col s8 m8">
				<input class="w3-input w3-border pw-check form-control input" type="password" placeholder="" id="helperPw2" name="helperPw2" required>
				<span id="pw-success" style="display: none;">비밀번호 일치</span>
				<span id="pw-danger" style="display: none; color: #d92742; font-weight: bold; ">비밀번호 불일치</span>
			</div>
		</div>
		<div class="w3-row">
			<div class="w3-col s4 m4"><p>이름*</p></div>
			<div class="w3-col s8 m8">
				<input class="input w3-input w3-border form-control" type="text" placeholder="" id="helperName" name="helperName" required>
			</div>
		</div>
		<div class="w3-row form-check">
			<div class="w3-col s3 m3 sex"><p>성별*</p></div>
			<div class="w3-col s3 m3 "><p></p></div>
			<div class="w3-col s3 m3 form-check-label">
				<p>
				<input class="form-check-input" type="radio" id="h-male" name="helperSex" value="남" required>
				<label class="form-check-label" for="h-male">남</label>
				</p>
			</div>
			<div class="w3-col s3 m3 form-check-label">
				<p>
				<input class="form-check-input" type="radio" id="h-female" name="helperSex" value="여">
				<label class="form-check-label" for="h-female">여</label>
				</p>
			</div>
		</div>
		
		<div class="w3-row">
			<div class="w3-col s4 m4"><p>생년월일*</p></div>
			<div class="w3-col s4 m4"><input class="w3-input w3-border form-control input" type="text" placeholder="년" id="helperBirthY" name="helperBirthY" numberOnly required></div>
			<div class="w3-col s2 m2"><input class="w3-input w3-border form-control input" type="text" placeholder="월" id="helperBirthM" name="helperBirthM" numberOnly required></div>
			<div class="w3-col s2 m2"><input class="w3-input w3-border form-control input" type="text" placeholder="일" id="helperBirthD" name="helperBirthD" numberOnly required></div>
		</div>
		<div class="w3-row">
			<div class="w3-col s4 m4"><p>연락처*</p></div>
			<div class="w3-col s8 m8">
				<input class="w3-input w3-border form-control input" type="text" placeholder="숫자만" id="helperTel" name="helperTel" numberOnly required>
			</div>
		</div>
		<div class="w3-row">
			<div class="w3-col s4 m4"><p>주소*</p></div>
			<div class="w3-col s8 m8">
				<input class="w3-input w3-border add-juso form-control input " type="text" placeholder="" id="helperAddr" name="helperAddr" required readOnly><button class="add-btn"type="button" onclick="jusoPopup(0)">주소찾기</button>
			</div>
		</div>
		<div class="w3-row">
			<div class="w3-col s4 m4"><p>특이사항</p></div>
			<div class="w3-col s8 m8">
				<input class="w3-input w3-border form-control" type="text" placeholder="" id="helperUnique" name="helperUnique"><br>
			</div>
		</div>
		<div class="w3-row">
			<div class="w3-col s4 m4 hope"><p>희망근무지역*</p></div>
			<div class="w3-col s8 m8">
				<select name="helperWorkArea1" id="helperWorkArea1" onchange="categoryChange(this)">
				<option value="" selected="selected">시도</option>
				<option value="서울">서울</option>
				<option value="부산">부산</option>
				<option value="대구">대구</option>
				<option value="인천">인천</option>
				<option value="광주">광주</option>
				<option value="대전">대전</option>
				<option value="울산">울산</option>
				<option value="세종">세종</option>
				<option value="경기">경기</option>
				<option value="강원">강원</option>
				<option value="충북">충북</option>
				<option value="충남">충남</option>
				<option value="전북">전북</option>
				<option value="전남">전남</option>
				<option value="경북">경북</option>
				<option value="경남">경남</option>
				<option value="제주">제주</option>
			</select> 
			
			<select name="helperWorkArea2" id="helperWorkArea2">
				<option value="" selected="selected">시군구</option>
			</select>	
			</div>
		</div>
		<div class="w3-row">
			<div class="w3-col s4 m4 time"><p>희망근무시간*</p></div>
			<div class="w3-col s8 m8">
				<select name="helperStartTime" required>
				  <option value="">시작</option>
				  <option value="1">1</option>
				  <option value="2">2</option>
				  <option value="3">3</option>
				  <option value="4">4</option>
				  <option value="5">5</option>
				  <option value="6">6</option>
				  <option value="7">7</option>
				  <option value="8">8</option>
				  <option value="9">9</option>
				  <option value="10">10</option>
				  <option value="11">11</option>
				  <option value="12">12</option>
				  <option value="13">13</option>
				  <option value="14">14</option>
				  <option value="15">15</option>
				  <option value="16">16</option>
				  <option value="17">17</option>
				  <option value="18">18</option>
				  <option value="19">19</option>
				  <option value="20">20</option>
				  <option value="21">21</option>
				  <option value="22">22</option>
				  <option value="23">23</option>
				  <option value="24">24</option>
				</select>
				~
				<select name="helperEndTime" required>
				  <option value="">종료</option>
				  <option value="1">1</option>
				  <option value="2">2</option>
				  <option value="3">3</option>
				  <option value="4">4</option>
				  <option value="5">5</option>
				  <option value="6">6</option>
				  <option value="7">7</option>
				  <option value="8">8</option>
				  <option value="9">9</option>
				  <option value="10">10</option>
				  <option value="11">11</option>
				  <option value="12">12</option>
				  <option value="13">13</option>
				  <option value="14">14</option>
				  <option value="15">15</option>
				  <option value="16">16</option>
				  <option value="17">17</option>
				  <option value="18">18</option>
				  <option value="19">19</option>
				  <option value="20">20</option>
				  <option value="21">21</option>
				  <option value="22">22</option>
				  <option value="23">23</option>
				  <option value="24">24</option>
				</select>
			</div>
		</div>
		
		<div class="w3-row">
			<div class="w3-col s4 m4"><p>프로필 사진</p></div>
			<div class="w3-col s8 m8">
				<input class="w3-input w3-border file" type="file" placeholder="" id="uploadFile" name="uploadFile">
			</div>
		</div>
		
		<!-- 자격증과 경력 추가 입력란 -->
		<!-- 경력 추가 위치 -->
		<br>
		<h1 class="m4">경력</h1>
		<div id="career-list"></div>
		<button class="w3-button w3-round w3-grey confrim" type="button" onclick="careerAddForm()"> 경력 등록 </button>
		
		<!-- 자격증 추가 위치 -->
		<br>
		<h1 class="m4">자격증</h1>
		<div id="certification-list"></div>
		<button class="w3-button w3-round w3-grey confrim" type="button" onclick="certificationAddForm()"> 자격증 등록 </button>
		<!--  자격증과 경력 추가 입력란  end -->
		
		<br>
		<br>
		<button class="w3-button w3-round w3-dark-grey confrim" type="button" onclick="formCheckH()" >&nbsp;&nbsp;등록&nbsp;&nbsp;</button>
		&nbsp;&nbsp;&nbsp;
		<button class="w3-button w3-round w3-dark-grey cancle" type="reset">&nbsp;&nbsp;취소&nbsp;&nbsp;</button>
		
	</form>
</div>
<div class="w3-col m4">&nbsp;</div>

</div>
</div>
</body>
</html>





