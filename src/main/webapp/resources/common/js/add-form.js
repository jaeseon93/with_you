var careerIndex=0;
var certificationIndex=0;

//삭제버튼에 들어갈 function들
function careerDeleteForm(index){
	$(".career-form"+index).remove();
}

function certificationDeleteForm(index){
	$(".certification-form"+index).remove();
}


//동적폼생성 경력
function careerAddForm(){
	var formStr = $(
			"<div class='career-form" + careerIndex + "'>" + 
			"<div class='w3-row'>" + 
				"<div class='w3-col s4 m4'><p>기관명*</p></div>" + 
				"<div class='w3-col s8 m8'>" + 
					"<input class='form-control input careerOrgan' type='text'>" +  
				"</div>" + 
			"</div>" + 
			"<div class='w3-row'>" + 
				"<div class='w3-col s4 m4'><p>근무기간*</p></div>" + 
				"<div class='w3-col s4 m4'>" +
					"<input class='form-control input careerStart' type='text' placeholder='년-월' checkDate>" +
				"</div>" + 
				"<div class='w3-col s4 m4'>" +
					"<input class='form-control input careerEnd' type='text' placeholder='년-월' checkDate>" +
				"</div>" + 
			"</div>" + 
			"<div class='w3-row'>" + 
				"<div class='w3-col s4 m4'><p>업무내용*</p></div>" + 
				"<div class='w3-col s8 m8'>" + 
					"<input class='form-control input careerContents' type='text'> " + 
				"</div>" + 
			"</div>" + 
			"<button class='w3-grey'type='button' onclick='careerDeleteForm(" + careerIndex + ")'>경력삭제</button>" + 
			"<hr>");
	
	$("#career-list").append(formStr);
	careerIndex += 1;
	$("input:text[checkDate]").on("keyup", function() {
	    $(this).val($(this).val().replace(/[^0-9]/g,""));
	    var number = $(this).val();
	    if(number.length > 4){
		    $(this).val(number.substr(0,4)+ "-" + number.substr(4,2));
	    }
	});
}

//동적폼생성 경력
function certificationAddForm(){
	var formStr = $(
			"<div class='certification-form" + certificationIndex + "'>" + 
			"<div class='w3-row'>" + 
				"<div class='w3-col s4 m4'><p>자격증명*</p></div>" + 
				"<div class='w3-col s8 m8'>" + 
					"<input class='form-control input certifiName' type='text'>" +  
				"</div>" + 
			"</div>" + 
			"<div class='w3-row'>" + 
				"<div class='w3-col s4 m4'><p>발급처*</p></div>" + 
				"<div class='w3-col s8 m8'>" + 
					"<input class='form-control input certifiOrgan' type='text'>" +  
				"</div>" + 
			"</div>" + 
			"<div class='w3-row'>" + 
				"<div class='w3-col s4 m4'><p>취득일자*</p></div>" + 
				"<div class='w3-col s4 m4'>" +
					"<input class='w3-input w3-border form-control input certifiGetDate' type='text' placeholder='년' numberOnly>" +
				"</div>" + 
				"<div class='w3-col s2 m2'>" +
					"<input class='w3-input w3-border form-control input certifiGetDate' type='text' placeholder='월' numberOnly>" +
				"</div>" + 
				"<div class='w3-col s2 m2'>" +
					"<input class='w3-input w3-border form-control input certifiGetDate' type='text' placeholder='일' numberOnly>" +
				"</div>" +
			"</div>" + 
			"<div class='w3-row'>" + 
				"<div class='w3-col s4 m4'><p>사진*</p></div>" + 
				"<div class='w3-col s8 m8'>" + 
					"<input class='w3-input w3-border file' type='file'>" +  
				"</div>" + 
			"</div>" + 
			"<button class='w3-grey'type='button' onclick='certificationDeleteForm(" + certificationIndex + ")'>자격증삭제</button>" + 
			"<hr>");
	
	$("#certification-list").append(formStr);
	certificationIndex += 1;
	$("input:text[numberOnly]").on("keyup", function() {
	    $(this).val($(this).val().replace(/[^0-9]/g,""));
	});
}