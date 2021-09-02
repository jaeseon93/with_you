<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
 <head>
 <meta charset="utf-8" />
 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
 <title>Creative - Start Bootstrap Theme</title>
 <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
 <!-- Font Awesome icons (free version)-->
 <script src="https://use.fontawesome.com/releases/v5.13.0/js/all.js" crossorigin="anonymous"></script>
 <script src="${pageContext.request.contextPath}/resources/common/js/jquery.min.js"></script>
 <script src="${pageContext.request.contextPath}/resources/common/js/alarm.js"></script>
 <!-- Google fonts-->
 <link href="https://fonts.googleapis.com/css2?family=Chewy&display=swap" rel="stylesheet">
 <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
 <!-- Third party plugin CSS-->
 <link href="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/magnific-popup.min.css" rel="stylesheet" />
 <!-- Core theme CSS (includes Bootstrap)-->
 <link href="${pageContext.request.contextPath}/resources/userLayout/css/styles.css" rel="stylesheet" />
 <style>
 html,body,h1,h2,h3,h4,h5,h6 {
  font-family: Arial, Helvetica, sans-serif;
}
.w3-container{
	font-family: 'Chewy', cursive;
	font-size: 34px;
	padding-left:0px;
}
.w3-container2,.dropdown-item{
	font-family: 'Do Hyeon', sans-serif;
	font-size: 18px;
}
.sidePatient {
	background:#89c1a5;	
	height:80px;
	width:32px;
}
.sideHelper {
	background:#c6e2ff;	
	height:80px;
	width:32px;
}
.sideFamily {
	background:#f8ca90;
	height:80px;
	width:32px;
}

 </style>
 </head>
    <body id="page-top">
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg" id="mainNav" style="padding:.0rem 0rem;">
            <div class="container">
            	<c:choose>
            		<c:when test="${userType == 'h' || hloginCookie != null}">
            		<div class="sideHelper">
        				<a style="color:#c6e2ff;">.</a>
        			</div>	
	                <a class="w3-container" href="helperMain.do" style="color:black; padding:0px 80px 0px 0px;">Care WithU</a>           	
            		</c:when>
            		<c:when test="${userType == 'f' || floginCookie != null}">
            		<div class="sideFamily">
        				<a style="color:#f8ca90;">.</a>
        			</div>	
	                <a class="w3-container" href="familyMain.do" style="color:black; padding:0px 80px 0px 0px;">Care WithU</a>           	
            		</c:when>            		
            		<c:when test="${userType == 'p' || ploginCookie != null }">
            		<div class="sidePatient">
        				<a style="color:#89c1a5;">.</a>
        			</div>	
	                <a class="w3-container" href="patientMain.do" style="color:black; padding:0px 80px 0px 0px;">Care WithU</a>           	
            		</c:when>            		         		            		
            		<c:when test="${userType == null }">
	                <a class="w3-container" href="home.do" style="color:black; padding:10px 20px;">Care WithU</a>           	
            		</c:when>
            	</c:choose>

            	<!-- 창 줄어들 때 흰색배경에 나오는 아이들 -->
                <a class="navbar-toggler navbar-toggler-right" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true" id="dropdownMenu2" >              		
              		
              		<c:if test="${userType == 'h' || userType == 'f' || userType == 'p'}">
              		<img src="${pageContext.request.contextPath}/resources/img/user.png" style="height:50px" /><span class="alarm-count"></span>
              		</c:if>
              	</a>
              <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenu2">
               	<c:if test="${userType =='h' }">
               	 <button class="dropdown-item" type="button" onclick="location.href='helperGetSelect.do'">회원정보수정</button>
				 <button class="dropdown-item" type="button" onclick="location.href='getAlarmList.do'">알림<span class="alarm-count"></span></button>
               	 <button class="dropdown-item" type="button" onclick="location.href='goTaltowi.do'">회원탈퇴</button>
				 <button class="dropdown-item" type="button" onclick="location.href='logout.do'">로그아웃</button>
               	</c:if><c:if test="${userType =='f' }">
               	 <button class="dropdown-item" type="button" onclick="location.href='familygetSelect.do'">회원정보수정</button>
               	 <button class="dropdown-item" type="button" onclick="location.href='patientgetSelect.do'">환자정보수정</button>
               	 <button class="dropdown-item" type="button" onclick="location.href='gofamilyTaltoe.do'">회원탈퇴</button>
				 <button class="dropdown-item" type="button" onclick="location.href='getAlarmList.do'">알림<span class="alarm-count"></span></button>
				 <button class="dropdown-item" type="button" onclick="location.href='logout.do'">로그아웃</button>
               	</c:if>	<c:if test="${userType =='p' }">       
				 <button class="dropdown-item" type="button" onclick="location.href='logout.do'">로그아웃</button>
               	</c:if>
               </div>
             
               
             
                
                
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto my-2 my-lg-0">
                        <li class="w3-container w3-myfont w3-large">
                            <c:if test="${userType == 'h' || hloginCookie != null}">
								<a class="w3-container2" style="color:black;">${loginOk.helperName }님 어서오세요.</a>
							</c:if>
							<c:if test="${userType == 'f' || floginCookie != null }">
								<a class="w3-container2" style="color:black;">${loginOk.familyName }님 어서오세요.</a>
							</c:if>
						    <c:if test="${userType == 'p' || ploginCookie != null  }">
								<a class="w3-container2" style="color:black;">${loginOk.patientName }님 어서오세요.</a>
							</c:if>
                        </li>
                        <li class="dropdown">
                        	<c:if test="${userType == 'f' }">
	                        	<a class="dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
	                        		<img src="${pageContext.request.contextPath}/resources/img/user.png" style="height:50px" /><span class="alarm-count"></span>
	                        	</a>
		                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenu2">
		                        	 <button class="dropdown-item" type="button" onclick="location.href='familygetSelect.do'">회원정보수정</button>
		                        	 <button class="dropdown-item" type="button" onclick="location.href='patientgetSelect.do'">환자정보수정</button>
		                        	 <button class="dropdown-item" type="button">공지사항</button>
		    						 <button class="dropdown-item" type="button">문의하기</button>
		    						 <button class="dropdown-item" type="button" onclick="location.href='getAlarmList.do'">알림<span class="alarm-count"></span></button>
		    						 <button class="dropdown-item" type="button" onclick="location.href='gofamilyTaltoe.do'">회원탈퇴</button>
		    						 <button class="dropdown-item" type="button" onclick="location.href='logout.do'">로그아웃</button>
		                        </div>
                        	</c:if>
                        </li>
						<li class="dropdown">
                        	<c:if test="${userType == 'p' }">
	                        	<a class="dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="ty">
	                        		<img src="${pageContext.request.contextPath}/resources/img/user.png" style="height:50px" /><span class="alarm-count"></span>
	                        	</a>
		                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenu2">
		                        	 <button class="dropdown-item" type="button" >공지사항</button>
		    						 <button class="dropdown-item" type="button" >문의하기</button>
		    						 <button class="dropdown-item" type="button" onclick="location.href='logout.do'">로그아웃</button>
		                        </div>
                        	</c:if>
                        </li>                        
                        <li class="dropdown">
                        	<c:if test="${userType == 'h' }">
	                        	<a class="dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	                        		<img src="${pageContext.request.contextPath}/resources/img/user.png" style="height:50px" /><span class="alarm-count"></span>
	                        	</a>
		                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenu2">
		                        	 <button class="dropdown-item" type="button" onclick="location.href='helperGetSelect.do'">회원정보수정</button>		                        	 		                        	 
		    						 <button class="dropdown-item" type="button" onclick="location.href='getAlarmList.do'">알림<span class="alarm-count"></span></button>
		    						 <button class="dropdown-item" type="button" onclick="location.href='goTaltowi.do'">회원탈퇴</button>
		    						 <button class="dropdown-item" type="button" onclick="location.href='logout.do'">로그아웃</button>
		                        </div>
                        	</c:if>
                        </li>
                    </ul>
                    <br><br>	
                </div>
            </div>
        </nav>

    </body>
</html>
