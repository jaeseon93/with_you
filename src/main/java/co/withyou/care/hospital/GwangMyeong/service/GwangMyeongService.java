package co.withyou.care.hospital.GwangMyeong.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface GwangMyeongService {
	
	void gwangmyeonginsert(GwangMyeongVo vo) throws Exception;
	void SeoulInsert(SeoulVo vo)throws Exception;
	List<Map> selectList(HospitalVo vo) throws Exception;
}
