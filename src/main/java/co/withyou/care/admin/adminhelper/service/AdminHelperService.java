package co.withyou.care.admin.adminhelper.service;

import java.util.List;
import java.util.Map;

import co.withyou.care.common.signUp.service.HelperVO;

public interface AdminHelperService {

	List<AdminHelperVo> HelperselectAll() throws Exception;

	AdminHelperVo selectHp(AdminHelperVo vo) throws Exception;

	int HelperDelete(AdminHelperVo vo) throws Exception;

	List<Map> getSelectList(AdminHelperVo helperVo);

	void helperResultselect(AdminHelperVo helperVo);

}	
