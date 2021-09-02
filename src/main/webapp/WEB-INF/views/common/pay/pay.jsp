<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<!-- iamport.payment.js -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>

<script type="text/javascript">
	var IMP = window.IMP; // 생략해도 괜찮습니다.
	IMP.init("imp07126152"); 
	
	function requestPay() {
	  // IMP.request_pay(param, callback) 호출
	IMP.request_pay({ // param
	  	pg : 'kakaopay',
	    pay_method : 'card',
	    merchant_uid : 'merchant_' + new Date().getTime(),
	    name : '주문명:결제테스트',	// order 테이블에 들어갈 주문명 혹은 주문 번호
	    amount : 14000,	//결제금액
	    buyer_email : 'iamport@siot.do',	//구매자 정보
	    buyer_name : '123456',
	    buyer_tel : '010-3826-3364',
	    buyer_addr : '서울특별시 강남구 삼성동',
	    buyer_postcode : '123-456',
//    	m_redirect_url : '/savePayResult.do'	// 결제 완료 후 보낼 컨트롤러의 메소드명
	  }, 
	  
		 function(rsp) { // callback
			    if ( rsp.success ) {
			        //[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
	                jQuery.ajax({
	                    url: "savePayResult.do", //cross-domain error가 발생하지 않도록 주의해주세요
	                    type: 'POST',
	                    dataType: 'json',
	                    data: { imp_uid:rsp.imp_uid, merchant_uid:rsp.merchant_uid, 
	                    		apply_num:rsp.apply_num, paid_amount: rsp.paid_amount, buyer_name:rsp.buyer_name 
	                    	}
	                    
	                }).done(function(data) {
	                    //[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
				   	var msg = '결제가 완료되었습니다.\n';
				        msg += '고유ID : ' + rsp.imp_uid + '\n';
				        msg += '상점 거래ID : ' + rsp.merchant_uid + '\n';
				        msg += '결제 금액 : ' + rsp.paid_amount + '\n';
				        msg += '카드 승인번호 : ' + rsp.apply_num + '\n';
				        msg += '===========================\n'
				        msg += '주문자 성명 : ' + rsp.buyer_name + '\n';
				        msg += '주문자 연락처 : ' + rsp.buyer_tel + '\n';
				        msg += '주문자 주소 : ' + rsp.buyer_addr + '\n';
				        //document.console.log(rsp.imp_uid);
				        location.href='<%=request.getContextPath()%>/paySuccess.do';
				        alert(msg);
				    })
			    }else {
				        var msg = '결제에 실패하였습니다.';
				        msg += '에러내용 : ' + rsp.error_msg;
				    	alert(msg);
				    }
				});
	}
</script>
	
</head>
<body>
	<div align="center">
		<h1>결제하기</h1>
		<button onclick="requestPay()">결제하기</button>
	</div>
</body>
</html>