package co.withyou.care.helper.ServiceDetail.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import co.withyou.care.helper.ServiceDetail.mapper.ServiceDetailMapper;
import co.withyou.care.helper.ServiceDetail.service.PatientReviewVo;
import co.withyou.care.helper.ServiceDetail.service.ServiceDetailService;
import co.withyou.care.helper.ServiceDetail.service.ServiceDetailVo;

public class ServiceDetailServiceImpl implements ServiceDetailService{

	@Autowired
	public ServiceDetailMapper map;
	@Override
	public Map getServiceDetail(ServiceDetailVo vo) throws Exception {
		// TODO Auto-generated method stub
		return map.getServiceDetail(vo);
	}
	@Override
	public List<Map> getPatientReview(PatientReviewVo rVo) throws Exception {
		// TODO Auto-generated method stub
		return map.getPatientReview(rVo);
	}

}
