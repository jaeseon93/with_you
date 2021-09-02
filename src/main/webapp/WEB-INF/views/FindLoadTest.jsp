<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>주소로 장소 표시하기</title>
    
</head>
<body>
<div id="map" style="width:100%;height:350px;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=94bea10f3763df2dcedf149bfaa1440e&libraries=services"></script>
<script>

// 주소-좌표 변환 객체를 생성합니다
 	geocoder = new kakao.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
	
	geocoder.addressSearch('대구광역시 북구 태전동 608-5', function(result) {
   
       coords = new kakao.maps.LatLng(result[0].y, result[0].x);
      
       console.log(coords.Ga); 
       console.log(coords.Ha);        
       coords.Ga;
});
console.log(gps);<%-- 안찍힘 ..왜 why?? 비동기라서?? 콜백함수로 사용으로 해결??--%>
</script>
</body>
</html>