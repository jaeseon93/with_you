package co.withyou.care.family.Login.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.withyou.care.family.Login.mapper.FamilyMapper;
import co.withyou.care.family.Login.service.FamilyService;
import co.withyou.care.family.Login.service.FamilyVO;

@Service("service")
public class FamilyServiceImpl implements FamilyService {

	@Autowired
	private FamilyMapper map;
	
	@Override
	public FamilyVO getSelect(FamilyVO vo) throws Exception {
		return map.getSelect(vo);
	}



}
