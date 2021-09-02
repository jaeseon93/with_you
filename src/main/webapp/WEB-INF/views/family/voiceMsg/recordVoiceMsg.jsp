<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css">
<title>보호자 음성녹음 화면</title>
<style>
.filebox label { 
 	display:inline-block;
 	width: 150px;
    height: 30px;
 	padding: .5em .75em; 
 	color: #fdfdfd; 
 	font-size: large; 
 	line-height: normal; 
 	vertical-align: middle; 
 	background-color: #696969; 
 	cursor: pointer; 
 	border: 1px solid #ebebeb; 
 	border-bottom-color: #e2e2e2; 
 	border-radius: .25em; 
 }

.filebox input[type="file"] { /* 파일 필드 숨기기 */ 
	position: absolute; 
	width: 1px; 
	height: 1px; 
	padding: 0; 
	margin: -1px; 
	overflow: hidden; 
	clip:rect(0,0,0,0); 
	border: 0; 
}




</style>
<script>

	var recorder = document.getElementById('recorder');
	var player = document.getElementById('player')
	
	recorder.addEventListener('change', function(e) {
	  var file = e.target.files[0]; 
	  // Do something with the audio file.
	  player.src =  URL.createObjectURL(file);
	});
  
</script>

</head>
<body>	
<div style="margin:50px" align="center">
	<i class="fas fa-microphone fa-5x"></i>
</div>
<div class="filebox" align="center">
 	<label for="ex_file">업로드</label>
    <input type="file"  accept="audio/*" capture="microphone" id="recorder"><br>
</div>

<div style="margin:80px" align="center">
	<audio id="player" controls></audio>
</div>
</body>
</html>