package co.withyou.care.family.searchHospital.service;

import java.util.List;
import java.util.Map;

public interface SearchHospitalService {
	List<Map> selectList(SearchHospitalVo vo) throws Exception;
		
}
