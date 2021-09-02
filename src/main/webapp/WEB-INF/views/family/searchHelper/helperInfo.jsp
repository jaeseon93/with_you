<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 글꼴  -->
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Noto+Serif+KR:wght@600&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Chewy&family=Jua&display=swap" rel="stylesheet">
<title>Insert title here</title>

<style type="text/css">
.container-fluid {
	border: solid 1px;
}
.title{
	font-family: 'Do Hyeon', sans-serif;
	font-size: 38px;
}
.content {
	
	font-family: 'Do Hyeon', sans-serif;
	font-size:17px;
}
.btn {
	font-family: 'Jua', sans-serif;
	font-size:18px;
}
</style>

</head>
<body>
<div class="container">
<div align="center" style="margin:30px;">
	<a class="title">간병인 정보</a>
		<img src="${pageContext.request.contextPath}/resources/upload/${helperInfo.helperProfile }" onerror='this.src="resources/img/no_image.png"' id="viewProfile" class="rounded-circle" width="100" height="100"><br/>
		<div class="content">
		${helperInfo.helperName }님 / ${helperInfo.helperSex }<br />		
		희망근무지역: ${helperInfo.helperWorkArea }<br />
		돌봄가능시간: ${helperInfo.helperStartTime }시~${helperInfo.helperEndTime }시<br />
		특이사항: ${helperInfo.helperUnique }<br />
		<%-- 자격증명: ${helperInfo.certifiName }<br /> --%>
		<br />

		<!-- 후기 및 평점 영역 -->
		<img src="${pageContext.request.contextPath}/resources/img/noContents.png" style="height: 30px" />
		후기 및 평점 :<br />
				<c:choose>
					<c:when test="${empty reviewList}">
						<br />
					아직 작성된 후기가 없습니다.
				</c:when>
					<c:otherwise>
						<c:forEach var="list" items="${reviewList }">
							<div class="container-fluid">
								<div>별점 : ${list.reviewStar } / 10</div>
								<div>작성자 : ${list.familyName }</div>
								<div>작성일자: ${list.reviewDate }</div>
								<div>내용 : ${list.reviewContents }</div>
								<div>사진첨부 : ${list.reviewFile }</div>
							</div>
							<br />
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
	</div>
	<div align="center">
		<input type="button" class="btn btn-secondary" name="helperList" value="조회목록" onclick="location.href='helperList.do'">
	</div><br>
	<div align="center">
		<a class="title">서비스 신청하기</a>
	</div>
	<div align="">
		<form id="orderFrm" name="orderFrm" action="applyService.do" method="post">
		 <div class="content">
			서비스 요청시간 : ${searchFilterVo.helperStartTime }시 부터~${searchFilterVo.helperEndTime }시 까지 <br />
			
			<c:choose>
				<c:when test="${param.helperWorkArea2  eq '%'}">
					서비스 지역 : ${param.helperWorkArea1 } 전체 <br/>
				</c:when>
			<c:otherwise>
				서비스 지역 : ${searchFilterVo.helperWorkArea } <br/>
			</c:otherwise>
			</c:choose>
			<%-- 
			자격보유 : 
				<c:choose>
					<c:when test="${searchFilterVo.certifiName eq 'y'}">${helperInfo.certifiName }</c:when>
					<c:otherwise>미보유</c:otherwise>
				</c:choose>
			<br /> 
			--%>
			서비스 날짜: <input type="date" id="serviceDate" name="serviceDate"><br />
			<div class="form-group">
		      <label for="comment">보호자 요청사항:</label>
		      <textarea class="form-control" rows="5" id="serviceDemand" name="serviceDemand"></textarea>
   			</div>
		 </div>
		 <div align="center">		 
			<input type="button" class="btn btn-warning w3-round" id="btnOrder" name="btnOrder" value="신청하기" onclick="orderInfo()">
			<input type="hidden" id="serviceStartTime" name="serviceStartTime" value="${searchFilterVo.helperStartTime }">
			<input type="hidden" id="serviceEndTime" name="serviceEndTime" value="${searchFilterVo.helperEndTime }">
			<input type="hidden" id="serviceArea" name="serviceArea" value="${searchFilterVo.helperWorkArea }">
			<input type="hidden" id="familyNo" name="familyNo" value="${loginOk.familyNo }">
			<input type="hidden" id="helperNo" name="helperNo" value="${helperInfo.helperNo }">
		 </div>
		</form>
	</div>
</div>

<script type="text/javascript">
	function orderInfo(){
		if(document.orderFrm.serviceDate.value == '') {
			alert('돌봄서비스 날짜를 선택해주세요');
			document.orderFrm.serviceDate.focus();
		} 
		else if( confirm(
				'아래의 내용과 같이 돌봄서비스를 신청합니다.' +'\n'+ 
				'"서비스신청내역" 메뉴에서 결제 등 진행상황을 확인 하실 수 있습니다.' +'\n'+
				'\n'+
				'<신청내용>' +'\n'+
				'신청자 성명: ' + '${loginOk.familyName}'+'\n'+
				'간병인 성명: ' + '${helperInfo.helperName}'+'\n'+
				'돌봄시간 : ' + ${searchFilterVo.helperStartTime }+ ' 시부터~'+${searchFilterVo.helperEndTime }+' 시까지 ('+(parseInt('${searchFilterVo.helperEndTime }')-parseInt('${searchFilterVo.helperStartTime }'))+'시간)' +'\n'+
				'돌봄지역 : ' +	 '${helperInfo.helperWorkArea }' +'\n'+
				'돌봄날짜 : ' + document.orderFrm.serviceDate.value +'\n'+
				'요청메모 : ' + document.orderFrm.serviceDemand.value +'\n'+
				'결제예정금액 : ' + (parseInt('${searchFilterVo.helperEndTime }')-parseInt('${searchFilterVo.helperStartTime }'))*10000 +'원'+'\n'+
				'    * (금액 = 시간 X 10,000원)'
				) == true) {
			alert("신청이 완료 되었습니다"+"\n"+"'신청내역'메뉴에서 내용을 확인 하실 수 있습니다.")
			document.orderFrm.submit();
		} else {
			return;
		}
	}
</script>

</body>
</html>