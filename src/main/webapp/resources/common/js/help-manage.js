var sNo;
var pNo;
var fNo;
var hNo;
var type=0; //0:디폴트, 1:출근, 2:퇴근
var yyyy;
var mm;
var dd;
var applyStartDate;
var applyEndDate;
var today;


function initialize(date, startTime, endTime){
	//초기 변수값 세팅
	sNo = parseInt($('#serviceNo').val());
	pNo = parseInt($('#patientNo').val());
	fNo = parseInt($('#fmailyNo').val());
    yyyy = date.substr(0,4);
    mm = date.substr(5,2);
    dd = date.substr(8,2);
    applyStartDate = new Date(yyyy, mm-1, dd, startTime-1); //정해진 1시간전
    applyEndDate = new Date(yyyy, mm-1, dd, endTime);
	today = new Date();
	
	//버튼 초기화
	//시작 버튼이 비활성화 되어야하는 조건 : 너무 일찍 왔다. 퇴근 시간 넘어서 왔다. (아작스후)이미 출근한 상태이다.
	//종료 버튼이 비활성화 되어야하는 조건 : 							(아작스후)출근도 안한 상태이다. 이미 퇴근했다.
	if(applyStartDate > today){ //정해진 시간보다 1시간 일찍 왔다.
		$("#btnStart").attr('disabled', true);
	} else if(applyEndDate < today){
		$("#btnStart").attr('disabled', true);
	}
}


function clickStart(helperNo){
	type = 1;
	var text = $('#realStartTime').text();
	hNo = helperNo;
	console.log(hNo);
	if(text==""){ //출근 안 했음. 해야됨
	    
	    if(applyStartDate > today){
	    	console.log("입실 가능");
	    	helperLcoCheck();
	    }else if(applyStartDate < today){
	    	console.log("님 지각");
	    	helperLcoCheck();
	    }else if(applyEndDate < today){
	    	console.log("님 결석");
	    	helperLcoCheck();
	    }
	}else{
    	console.log("이미 출근함");
	}
}

function clickEnd(date, endTime){
	type = 2;
	
	text = $('#realEndTime').text();
	if(text==""){ //퇴근처리
		
	    if(applyEndDate > today){
	    	console.log("조퇴");
	    	helperLcoCheck();
	    }else if(applyEndDate < today){
	    	console.log("정상퇴근");
	    	helperLcoCheck();
	    }
	}else{
    	console.log("이미 퇴근 했음");
	}
}

//안드로이드로 환자 위치 전달
function helperLcoCheck(){
	$.ajax({
	    type: "post",
	    url: "getPatientLoc.do",
	    data: { "patientNo": pNo },
	    success : function(result) {
	    	//가져온 위치를 앱으로 보낸다.
	    	window.MyApp.helperLocCheck(result.patientLongitude, result.patientLatitude);
	    	if(type==1){
		    	window.MyApp.helperStartService(hNo, fNo, sNo, 1, 1);
		    	alert(sNo + ", " + pNo + ", " + fNo);
	    	}else if(type==2){
		    	window.MyApp.helperStopService();
	    	}
	    }, 
	    error : function(xhr, textStatus, errorThrown){
	    	console.log(xhr, textStatus, errorThrown);
	    }
	});
}

//안드로이드에서 결과값 받아옴
function setResult(isOK){
	var url;
	if(type == 1){
		var url = "setStartTime.do";
	}else if(type == 2){
		var url = "setEndTime.do";
	}
	
	if(isOK){
		//출근처리
		$.ajax({
		    type: "post",
		    url: url,
		    data: { "serviceNo": sNo, "familyNo": fNo},
		    success : function(result) {
		    	if(type == 1){
			    	//출근 시간을 표시
					$('#realStartTime').text(result.realStartTime);
					$("#btnStart").attr('disabled', true);
					$("#btnEnd").attr('disabled', false);
		    	}else if(type == 2){
			    	//퇴근 시간을 표시
					$('#realEndTime').text(result.realEndTime);
					$("#btnEnd").attr('disabled', true);
		    	}
		    }, 
		    error : function(xhr, textStatus, errorThrown){
		    	console.log(xhr, textStatus, errorThrown);
		    }
		});
	}else{
		document.getElementById('testBtn').innerHTML="유효하지 않은 요청입니다";
	}
}

//출퇴근시간 표시
function getStartTime(){
	$.ajax({
	    type: "post",
	    url: "getRealTimes.do",
	    data: { "serviceNo": sNo },
	    success : function(result) {
	    	console.log(result);
	    	//출퇴근 시간을 표시
	    	//시작 버튼이 비활성화 되어야하는 조건 : 너무 일찍 왔다. 퇴근 시간 넘어서 왔다. (아작스후)이미 출근한 상태이다.
	    	//종료 버튼이 비활성화 되어야하는 조건 : 							(아작스후)출근도 안한 상태이다. 이미 퇴근했다.
			if(result.realStartTime != null){
				$('#realStartTime').text(result.realStartTime);
				$("#btnStart").attr('disabled', true); //이미 출근해서 비활성화 
		    	console.log("이미 출근 했음" + result.realStartTime);
		    	
				if(result.realEndTime != null){
					$('#realEndTime').text(result.realEndTime);
					$("#btnEnd").attr('disabled', true); //이미 퇴근해서 비활성화
			    	console.log("이미 퇴근 했음" + result.realEndTime);
				}
			}else{
				$("#btnEnd").attr('disabled', true); //출근 먼저해야해서 비활성화
			}
	    }, 
	    error : function(xhr, textStatus, errorThrown){
	    	console.log(xhr, textStatus, errorThrown);
	    }
	});
}

//타임 형변환
function changeTime(time){
	var cTime = time.getHours()+':'+time.getMinutes();
	return cTime;
}

	