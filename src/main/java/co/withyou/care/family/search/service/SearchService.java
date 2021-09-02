package co.withyou.care.family.search.service;

import java.util.List;
import java.util.Map;

public interface SearchService {

	List <Map> getSelectList(SearchFilterVo searchFilterVo) throws Exception;
	Map getSelect (String helperNo) throws Exception;
	List <Map> getSelectList2(String helperNo) throws Exception;
}
