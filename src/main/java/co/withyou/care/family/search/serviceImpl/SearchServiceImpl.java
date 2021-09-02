package co.withyou.care.family.search.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import co.withyou.care.family.search.mapper.SearchMapper;
import co.withyou.care.family.search.service.SearchFilterVo;
import co.withyou.care.family.search.service.SearchService;


@Service
@Primary
public class SearchServiceImpl implements SearchService{
	
	@Autowired
	public SearchMapper map;
	
	@Override
	public List<Map> getSelectList(SearchFilterVo searchFilterVo) throws Exception {
		// TODO Auto-generated method stub
		return map.getSelectList(searchFilterVo);
	}

	@Override
	public Map getSelect(String helperNo) throws Exception {
		// TODO Auto-generated method stub
		return map.getSelect(helperNo);
	}

	@Override
	public List<Map> getSelectList2(String helperNo) throws Exception {
		// TODO Auto-generated method stub
		return map.getSelectList2(helperNo);
	}


}
