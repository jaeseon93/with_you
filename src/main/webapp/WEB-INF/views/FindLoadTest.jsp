<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>�ּҷ� ��� ǥ���ϱ�</title>
    
</head>
<body>
<div id="map" style="width:100%;height:350px;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=94bea10f3763df2dcedf149bfaa1440e&libraries=services"></script>
<script>

// �ּ�-��ǥ ��ȯ ��ü�� �����մϴ�
 	geocoder = new kakao.maps.services.Geocoder();

// �ּҷ� ��ǥ�� �˻��մϴ�
	
	geocoder.addressSearch('�뱸������ �ϱ� ������ 608-5', function(result) {
   
       coords = new kakao.maps.LatLng(result[0].y, result[0].x);
      
       console.log(coords.Ga); 
       console.log(coords.Ha);        
       coords.Ga;
});
console.log(gps);<%-- ������ ..�� why?? �񵿱��?? �ݹ��Լ��� ������� �ذ�??--%>
</script>
</body>
</html>