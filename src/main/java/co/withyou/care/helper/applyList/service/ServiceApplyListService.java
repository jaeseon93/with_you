package co.withyou.care.helper.applyList.service;

import java.util.List;
import java.util.Map;

public interface ServiceApplyListService {

	List<Map> getApplyList(ServiceApplyListVo applyListVo) throws Exception;
	
}
