package co.withyou.care.helper.update.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.withyou.care.helper.Login.service.HelperVO;
import co.withyou.care.helper.update.mapper.HelperUpdateMapper;
import co.withyou.care.helper.update.service.HelperUpdateService;
import co.withyou.care.helper.update.service.HelperVo;


public class HelperUpdateServiceImpl implements HelperUpdateService{

	@Autowired
	public HelperUpdateMapper map;
	
	@Override
	public HelperVO getSelect(HelperVO vo) throws Exception {
		// TODO Auto-generated method stub
		return map.getSelect(vo);
	}

	@Override
	public int HelperUpdate(HelperVo vo) throws Exception {
		
		
		return map.HelperUpdate(vo);
	}
	
	
	
}
