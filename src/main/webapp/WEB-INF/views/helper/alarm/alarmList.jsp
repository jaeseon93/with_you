<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:forEach items="${list }" var="alarm">
	${alarm.alarmNo }  : ${alarm.familyName } ${alarm.codeName } (${alarm.alarmType }) : <br>
	${alarm.alarmTime }<br>
	${alarm.alarmReceiverNo }, ${alarm.alarmSenderNo }, ${alarm.serviceNo }
	<c:choose>
		<c:when test="${alarm.alarmCheck == 'N'}">
			읽지 않음<br>
		</c:when>
		<c:otherwise>
			읽음<br>
		</c:otherwise>
	</c:choose>
	<br><hr>
</c:forEach>
    