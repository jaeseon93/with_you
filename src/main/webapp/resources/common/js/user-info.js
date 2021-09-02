//주소 api 샘플은  views/common/addr/jusoPopup 참고
document.domain = "abc.go.kr";
function jusoPopup(index){
	// 주소검색을 수행할 팝업 페이지를 호출합니다.=
	jusoIndex = index;
	//window.MyApp.setAddress();
	var pop = window.open("jusoPopup.do","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
}
//주소 팝업에서 콜백됨
function jusoCallBack(roadFullAddr){
	$(".add-juso").eq(jusoIndex).val(roadFullAddr);
}

//비밀번호 암호화
function pwSHA256(){
	$('.pw-check:eq(0)').val(CryptoJS.SHA256($('.pw-check:eq(0)').val()).toString()); 
}


//숫자만 입력 받기 numberOnly
$(function(){
	$("input:text[numberOnly]").on("keyup", function() {
	    $(this).val($(this).val().replace(/[^0-9]/g,""));
	});
});
