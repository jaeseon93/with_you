package co.withyou.care.family.blackList.service;

import java.util.List;
import java.util.Map;

public interface BlackListService {
	public void blackListInsert(BlackListVo blackListVo) throws Exception;
	public void blackListDelete(BlackListVo blackListVo) throws Exception;
	List <Map> getSelectList(BlackListVo blackListVo) throws Exception;
	
}
