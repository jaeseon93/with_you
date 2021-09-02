package co.withyou.care.common.pay.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.withyou.care.common.pay.mapper.PayMapper;
import co.withyou.care.common.pay.service.PayService;
import co.withyou.care.common.pay.service.PayVo;


@Service("payService")
public class PayServiceImpl implements PayService{

	@Autowired
	public PayMapper payMap;
	
	@Override
	public void payResultInsert(PayVo payVo) throws Exception {
		// TODO Auto-generated method stub
		payMap.payResultInsert(payVo);
	}

	@Override
	public void paySuccessUpdate(PayVo payVo) throws Exception {
		// TODO Auto-generated method stub
		payMap.paySuccessUpdate(payVo);
		
	}

}
