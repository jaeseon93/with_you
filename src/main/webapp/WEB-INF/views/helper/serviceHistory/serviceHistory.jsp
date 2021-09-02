<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>간병인 서비스이력 화면</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<!-- 글꼴  -->
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@700&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Chewy&family=Jua&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500&display=swap" rel="stylesheet">
<style>
.list{
  margin-top:30px;
}
.w3-tag{
  font-family: 'Do Hyeon', sans-serif;
  font-size: 18px;
}
.text{
  margin-top:10px;
  margin-left:22px;
  font-family: 'Do Hyeon', sans-serif;
  font-size: 20px;
  text-align:left;
}
.w3-blue{
  font-family: 'Jua', sans-serif;
  font-size: 17px;
  margin-right: 30px;
}
</style>
<script>
function getServiceNo(key) {
	document.historyForm.serviceNo.value=key;
	console.log(key);
	document.historyForm.submit();
}
</script>

</head>
<body>
<div>
 <div class="list">
	<form id="historyForm" name="historyForm" action="historyDetail.do" method="post">
	<c:forEach var ="list" items="${serviceHistoryList }">
		    <div class="w3-tag w3-round w3-green" style="margin-left:30px;padding:3px">
	  			 <div class="w3-tag w3-round w3-green w3-border w3-border-white">
	 				   서비스날짜: ${list.serviceDate }
			     </div>
	        </div>
	   <div class="w3-row">
		    <div class="w3-col w3-container m9 s9 text">
					${list.patientName } 님<br>
					${list.patientBirth }세 / ${list.patientSex } <br>
					${list.patientAddr }
		    </div>
		 </div> 
		    <div align="right">
		    	<button type="button" onclick="getServiceNo('${list.serviceNo}')" class="w3-button w3-blue w3-round-large">상세보기</button>
		    </div>
		<hr style="border:1px solid black;" width="100%">
	</c:forEach>
	<input type="hidden" id="serviceNo" name="serviceNo">
	</form>
 </div>
</div>




</body>
</html>