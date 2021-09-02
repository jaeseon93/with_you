$(function(){
	//알람 가져옴
	$.ajax({
	    type: "get",
	    url: "getAlarmCount.do",
	    success : function(data) {
		        $(".alarm-count").text(data);
	    }, 
	    error : function(xhr, textStatus, errorThrown){
	    }
	});
	
});