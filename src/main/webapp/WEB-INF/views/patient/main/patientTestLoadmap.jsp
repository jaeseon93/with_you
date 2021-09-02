<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 글꼴  -->
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css">
<title>환자 메인 화면</title>

<style type="text/css"> 
.menu {
	margin:38px;
}

.patient1,.patient2 {
	display:inline-block;
	margin-top:20px;
}
.patient3 {
	margin-top:20px;
}
.menuTitle{
	font-family: 'Do Hyeon', sans-serif;
	font-size:30px;
}
</style>
</head>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7d32000692658cb31291420c5c084e6d&libraries=services"></script>

<script>
//전화걸기
function callNumber(num){
    location.href = "tel:" + num;
}

//주소 좌표 얻어내기
// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

//주소로 좌표를 검색합니다
var addr = ("${patientVO.patientAddr}").split(',');
console.log("주소 :" + addr[0]);
geocoder.addressSearch(addr[0], function(result, status) {
	
	// 정상적으로 검색이 완료됐으면 
    if (status === kakao.maps.services.Status.OK) {

       var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
	   console.log("좌표 :" + coords);
	   
	   var lat = result[0].y;
	   var lng = result[0].x;
	   console.log("lat :" + lat);
	   console.log("lng :" + lng);
	   
	   document.getElementById("addr").setAttribute("href","https://map.kakao.com/link/to/"+ addr[0] + "," + lat + "," + lng);
	   window.MyApp.patientStartService(${patientVO.patientNo},${patientVO.familyNo},${patientVO.patientZone}, lat, lng);
    }
	
});

</script>

<body>
	<div class="menu" align="center">
		<div class="patient1">
			<a id="addr" style="color: black"
			   href="https://map.kakao.com/link/to/${patientAddr},126.57049341667,126.57049341667"> 
				<img src="${pageContext.request.contextPath}/resources/img/menu/findLoad.png" style="height: 90px" />
			</a><br>
			<a class="menuTitle">길찾기</a>
		</div>
		<br>
		<!-- 자바스크립트 이용시  -->
		<div class="patient2">
			<a onclick="callNumber('${ familyVO.familyTel }')"> <!--보호자번호  -->
				<img src="${pageContext.request.contextPath}/resources/img/menu/call.png" style="height: 90px" />
			</a><br>
			<a class="menuTitle">가족에게</a>
		</div>
		
		<div class="patient3">
			<a id="urgent" href="tel:112">
				<img src="${pageContext.request.contextPath}/resources/img/menu/cap.png" style="height: 90px" />
			</a><br>
			<a class="menuTitle">112</a>
		</div>
	</div>
</body>
</html>