package co.withyou.care.family.Update.service;

import co.withyou.care.family.Login.service.FamilyVO;

public interface FamilyUpdateService {

	FamilyVO getSelect(FamilyVO vo) throws Exception;
	public int Update(FamilyUpdateVo vo)throws Exception;
}
