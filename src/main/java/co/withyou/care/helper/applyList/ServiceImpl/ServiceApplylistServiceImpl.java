package co.withyou.care.helper.applyList.ServiceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import co.withyou.care.helper.applyList.mapper.ServiceApplyListMapper;
import co.withyou.care.helper.applyList.service.ServiceApplyListService;
import co.withyou.care.helper.applyList.service.ServiceApplyListVo;

public class ServiceApplylistServiceImpl implements ServiceApplyListService {
	
	@Autowired
	public ServiceApplyListMapper listMap;

	@Override
	public List<Map> getApplyList(ServiceApplyListVo applyListVo) throws Exception {
		// TODO Auto-generated method stub
		return listMap.getApplyList(applyListVo);
	}
	


}
