package co.withyou.care.helper.update.service;

import co.withyou.care.helper.Login.service.HelperVO;

public interface HelperUpdateService {
	
	HelperVO getSelect(HelperVO vo) throws Exception;
	public int HelperUpdate(HelperVo vo) throws Exception;
}
