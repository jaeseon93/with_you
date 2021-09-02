package co.withyou.care.helper.Login.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.withyou.care.helper.Login.mapper.HelperMapper;
import co.withyou.care.helper.Login.service.HelperService;
import co.withyou.care.helper.Login.service.HelperVO;

@Service("helperservice")
public class HelperServiceImpl implements HelperService {

	@Autowired
	private HelperMapper map;
	
	@Override
	public HelperVO getSelect(HelperVO vo) throws Exception {
		return map.getSelect(vo);
	}

}
