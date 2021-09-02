package co.withyou.care.admin.adminhelper.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.withyou.care.admin.adminhelper.mapper.AdminHelperMapper;
import co.withyou.care.admin.adminhelper.service.AdminHelperService;
import co.withyou.care.admin.adminhelper.service.AdminHelperVo;

@Service("adminhelperService")
public class AdminHelperServiceImpl implements AdminHelperService {
	@Autowired
	AdminHelperMapper map;

	@Override
	public List<AdminHelperVo> HelperselectAll() throws Exception {
		// TODO Auto-generated method stub
		return map.HelperselectAll();
	}

	@Override
	public AdminHelperVo selectHp(AdminHelperVo vo) throws Exception {
		// TODO Auto-generated method stub
		return map.selectHp(vo);
	}

	@Override
	public int HelperDelete(AdminHelperVo vo) throws Exception {
		// TODO Auto-generated method stub
		return map.HelperDelete(vo);
	
	}

	@Override
	public List<Map> getSelectList(AdminHelperVo helperVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void helperResultselect(AdminHelperVo helperVo) {
		// TODO Auto-generated method stub
		
	}

}
