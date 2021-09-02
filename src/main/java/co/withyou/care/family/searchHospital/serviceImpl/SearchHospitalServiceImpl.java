package co.withyou.care.family.searchHospital.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.withyou.care.family.searchHospital.service.SearchHospitalService;
import co.withyou.care.family.searchHospital.service.SearchHospitalVo;

public class SearchHospitalServiceImpl implements SearchHospitalService{

		@Autowired
		public SearchHospitalService searchlist;

		@Override
		public List<Map> selectList(SearchHospitalVo vo) throws Exception {
			// TODO Auto-generated method stub
			return searchlist.selectList(vo);
		}
		
		
}
