package co.withyou.care.family.apply.service;

import java.util.List;
import java.util.Map;

import co.withyou.care.family.search.service.SearchFilterVo;

public interface ApplyService {

	public void applyResultInsert(ApplyServiceVo applyVo) throws Exception;
	List <Map> getSelectList(ApplyServiceVo applyVo) throws Exception;
	Map getSelect (String serviceNo) throws Exception;
	Map getSelect2 (String serviceNo) throws Exception;
	Map getSelect3 (String serviceNo) throws Exception;
	Map getSelect4 (ApplyServiceVo applylVo) throws Exception;
	Map getSelect5 (ApplyServiceVo applylVo) throws Exception;
	int getSelectLatest (ApplyServiceVo applyVo) throws Exception;
	
}
