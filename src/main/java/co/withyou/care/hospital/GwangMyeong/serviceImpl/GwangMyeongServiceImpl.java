package co.withyou.care.hospital.GwangMyeong.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import co.withyou.care.hospital.GwangMyeong.service.GwangMyeongService;
import co.withyou.care.hospital.GwangMyeong.service.GwangMyeongVo;
import co.withyou.care.hospital.GwangMyeong.service.HospitalVo;
import co.withyou.care.hospital.GwangMyeong.service.SeoulVo;

public class GwangMyeongServiceImpl implements GwangMyeongService{

	@Autowired
	public GwangMyeongService hospitallist;
	@Override
	public void gwangmyeonginsert(GwangMyeongVo vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SeoulInsert(SeoulVo vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Map> selectList(HospitalVo vo) throws Exception {
		// TODO Auto-generated method stub
		return hospitallist.selectList(vo);
	}
	

}
