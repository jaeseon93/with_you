<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!-- 글꼴 -->
<link href="https://fonts.googleapis.com/css2?family=Chewy&family=Jua&display=swap" rel="stylesheet">
<style>
.btn,.date {
	font-family: 'Jua', sans-serif;
	font-size:18px;
}
</style>    
<script>
function Dsearch() {
		if (insertDate.Loctime.value == "") {
			alert("날짜를 입력해주세요.")
		} else {
			document.insertDate.submit();
		}
	}
</script>	
</head>
<body>
<div id="map" style="width:100%;height:350px;"></div>    
 <form name="insertDate" action="patientGetLine.do" method="post">
        <input type="date" class="date" id='Loctime' name='Loctime'/>
        <button type="button" class="btn btn-warning w3-round" onclick="Dsearch()">검색</button>
		<button type="button" class="btn btn-warning w3-round" onclick="location.href='sevenLine.do'">1주일 보기</button>
    </form>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=94bea10f3763df2dcedf149bfaa1440e"></script>
<script>
var sevenLine = JSON.parse('${sevenLine}');
console.log("sevenLine:"+sevenLine)

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(sevenLine[0].patientLatitude, sevenLine[0].patientLongitude), // 지도의 중심좌표
        level: 4 // 지도의 확대 레벨
    };  

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 선을 구성하는 좌표 배열입니다. 이 좌표들을 이어서 선을 표시합니다

var linePath = [];
	for(var i=0;i<sevenLine.length;i++){
		linePath.push(new kakao.maps.LatLng(sevenLine[i].patientLatitude, sevenLine[i].patientLongitude))
	}
  


// 지도에 표시할 선을 생성합니다
var polyline = new kakao.maps.Polyline({
    path: linePath, 
    strokeWeight: 2, // 선의 두께 입니다
    strokeColor: '#0000FF', // 선의 색깔입니다
    strokeOpacity: 0.8, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
    strokeStyle: 'solid' // 선의 스타일입니다
});

// 지도에 선을 표시합니다 
//+1함수
polyline.setMap(map);  

</script>
</body>
</html>