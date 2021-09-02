package co.withyou.care.common.pay.service;

public interface PayService {

	public void payResultInsert(PayVo payVo) throws Exception;
	public void paySuccessUpdate(PayVo payVo) throws Exception;
}
