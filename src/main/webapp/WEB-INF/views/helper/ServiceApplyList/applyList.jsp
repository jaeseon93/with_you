<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 글꼴  -->
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@700&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Chewy&family=Jua&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500&display=swap" rel="stylesheet">
<title>Insert title here</title>
<style>
.title{
  margin-top:30px;
}
#title{
  font-family: 'Do Hyeon', sans-serif;
  margin:35px;
  font-size: 30px;
  color: black;
  text-decoration: none;
}
.btn {
  width:50%;
  font-family:'Jua',sans-serif;
  font-size:17px;
}
.text {
  margin-top:30px;
  font-family: 'Do Hyeon', sans-serif;
  font-size: 17px;
  text-align:left;
}
.w3-blue{
  font-family: 'Jua', sans-serif;
  font-size: 17px;
  margin-right: 30px;
}
</style>
</head>
<body>
 <div class="title" align="center">
	<a id="title">서비스 요청 리스트</a><br>
 </div>
<form id="sNoFrm" name="sNoFrm" action="serviceDetail.do" method="post">
		<c:forEach var="list" items="${serviceList }">
			<div class="w3-row">
				<div class="w3-col w3-container m12 s12 text">
					요청인:${list.familyName} 님<br /> 요청서비스날짜 : ${list.serviceDate }<br />
					요청서비스시간 : ${list.serviceStartTime }시부터 ~ ${list.serviceEndTime }시까지<br />
				</div>
				
					<br>
					<div align="right">
					<button type="button" id="btnLikeList" class="w3-button w3-blue w3-round-large"
						onclick="getServiceNo('${list.serviceNo}')">상세내역</button>
					</div>
			</div>

			<div align="right" class="" id="centerDiv"></div>
			<hr style="border:1px solid black;" width="100%">
		</c:forEach>

		<input type="hidden" id="serviceNo" name="serviceNo">
</form>

<script type="text/javascript">
	function getServiceNo(key) {
		document.sNoFrm.serviceNo.value=key;
		console.log(key);
		document.sNoFrm.submit();
	}
</script>

</body>
</html>