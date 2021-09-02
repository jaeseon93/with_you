<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>

<style>

	#listDiv {

		width: 300px;

	}

</style>

<script type="text/javascript">

	function selectOne(key) {

		document.frm.mId.value=key;

		console.log(key);

		document.frm.submit();

	}

</script>

</head>

<body>
	<div align="center">

		<h1>간병인 회원</h1>


<c:forEach items="${ helperlist }" var="list">
	${ list.helperNo }
	${ list.helperName }
	${ list.helperBirth }
	${ list.helperSex }
	${ list.helperTel }	
	${ list.helperEmail }	
	<%-- ${ list.helperPw }	 
	${ list.helperWorkArea }	
	${ list.helperStartTime }	
	${ list.helperEndTime }	
	${ list.helperUnique }	
	${ list.helperAddr }	
	${ list.helperProfile }	
	${ list.commissionGrade }	--%>
	<br>
	<br>
</c:forEach>


		<div>

			<c:forEach var="adminhelperlist" items="${list }">

				<div id="adminhelperlistDiv" onclick="selectOne('${list.id }')" 

				onMouseOver="this.style.backgroundColor='silver';" onMouseOut="this.style.backgroundColor='';">

					ID: ${adminhelperlist.list.id } &nbsp;&nbsp;

					Name: ${adminhelperlist.list.name } <br />

				</div>

			</c:forEach>

		</div>

		<div><br />

			<a href="main.do">환자로 이동...</a>
			<a href="main.do">보호자로 이동...</a>

		</div>

	</div>

	<form id="frm" name="frm" action="adminhelperInfo.do" method="post">

		<input type="hidden" id="mId" name="mId">

	</form>

	

</body>

</html>