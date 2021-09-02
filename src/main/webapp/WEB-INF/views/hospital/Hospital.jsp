<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html lang="en">
<head>
  
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<br><br><br>
<div class="container">       
  <table class="table table-bordered" >
    <thead>
      <tr>
        <th>�̸�</th>
        <th>�ּ�</th>
        <th>����ó</th>
        <th width="70px">ħ��</th>
        <th width="80px">�Կ���</th>
        <th width="80px">�Ƿ���</th>
        
      </tr>
    </thead>
    <c:forEach var="list" items="${selectList }">
    <tbody>
      <tr>
        <td>${list.HOSPITALNAME }</td>
        <td>${list.HOSPITALADDR }</td>
        <td>${list.HOSPITALTEL }</td>
        <td>${list.HOSPITALSICKBAD }</td>
        <td>${list.HOSPITALLRM }</td>
        <td>${list.HOSPITALMEDSTAF }</td>
      </tr>
    </tbody>
    </c:forEach>
  </table>
</div>

