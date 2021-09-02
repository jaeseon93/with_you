<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스케줄 리스트 가져오는 화면</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@700&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Chewy&family=Jua&display=swap" rel="stylesheet">
<%-- 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
--%>
<!-- 캘린더  -->
<script src="${pageContext.request.contextPath}/resources/schedule/lib/main.js"></script>
<script src="${pageContext.request.contextPath}/resources/schedule/lib/locales/ko.js"></script>
<link href="${pageContext.request.contextPath}/resources/schedule/lib/main.css" rel='stylesheet' />
<style>
html,body,h1,h2,h3,h4,h5,h6 {
  font-family: 'Do Hyeon', sans-serif;
}
.card-body {
  font-family: 'Noto Serif KR', serif;
  font-size:18px;
}
ul.breadcrumb { 
  margin:10px;
  padding: 10px 16px;
  list-style: none;
  background-color: white;
}
ul.breadcrumb li {
  display: inline;
  font-size: 22px;
}
ul.breadcrumb li+li:before {
  padding: 8px;
  color: black;
  content: "/\00a0";
}
ul.breadcrumb li a {
  color: #0275d8 !important;
  text-decoration: none;
  font-family: 'Do Hyeon', sans-serif;
}
#calendar {
	width: 100%;
}
.w3-button{
	font-family: 'Jua', sans-serif;
}
</style>
<script>

 /* 캘린더  */

	document.addEventListener('DOMContentLoaded', function() {

		var calendarEl = document.getElementById('calendar');
		var calendar = new FullCalendar.Calendar(calendarEl, {
			//날짜 클릭시, 카드 나오게 하는구문
			dateClick: function(info) {
				document.getElementById('serviceDate').value=info.dateStr;
				document.caleandarList.submit();
			  },

			initialView : 'dayGridMonth',
			locale : 'ko',
			eventSources : [

			{
				url : 'calendarList.do', // use the `url` property
				color : 'white', // an option!
				textColor : 'red' // an option!
			}

			]


	}); //캘린더 만드는 창 닫힘
	
	calendar.render();
});

	function getServiceNo(key) {
		document.scheduleListForm.serviceNo.value = key;
		console.log(key);
		document.scheduleListForm.submit();
	}
	
	// 간병인이 보호자에게 전화 걸기
	function callToFamily(num) {
		location.href = "tel:" + num;	
}	
	
	
</script>
</head>
<body>
 <div id='calendar'></div>

<header>
	<ul class="breadcrumb">	
	  <li><a>스케줄 리스트</a></li>
	</ul>
</header>
<form id="caleandarList" name="caleandarList" action="scheduleList.do" method="post">
	    <input type="hidden" id="serviceDate" name="serviceDate">
</form>
 
<form id="scheduleListForm" name="scheduleListForm" action="scheduleDetail.do" method="post">
<div class="container">
  <c:forEach var="sceduleList" items="${sceduleList }">
	<div class="card bg-secondary text-white ">
       <div class="card-body">
			<h4>${sceduleList.title }님 </h4>
			<h5>서비스 시간: ${sceduleList.serviceStartTime } - ${sceduleList.serviceEndTime }</h5>
				<button type="button" onclick="getServiceNo('${sceduleList.serviceNo}')"class="w3-button w3-sand w3-round">상세정보</button>&nbsp;&nbsp;&nbsp;&nbsp;
				<a onclick="callToFamily('${sceduleList.familyTel}')"> 
					<img src="${pageContext.request.contextPath}/resources/img/chat/callWhite.png" style="height: 42px" />
				</a> 
				&nbsp;&nbsp;&nbsp;
			    <a href="javascript:void(0);" onclick="chatPage('${sceduleList.familyNo}');">
			   		 <img src="${pageContext.request.contextPath}/resources/img/chat/chat2.png" style="height: 42px" />
			    </a>				
       </div>
    </div>
    <br>
  </c:forEach>
    <input type="hidden" id="serviceNo" name="serviceNo">
    <input type="hidden" id="familyNo" name="familyNo">
<br>
</div>
</form>


<!-- 채팅버튼 클릭시 컨트롤러 이동 함수 boy 찬진 -->
<script type="text/javascript">
	//채팅페이지로 가는 함수
	function chatPage(key) {
		document.scheduleListForm.familyNo.value=key;
		console.log(key);
		document.scheduleListForm.action="chat.do";
		document.scheduleListForm.submit();
	}
</script>


</body>
</html>