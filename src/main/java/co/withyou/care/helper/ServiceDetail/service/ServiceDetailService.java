package co.withyou.care.helper.ServiceDetail.service;

import java.util.List;
import java.util.Map;

public interface ServiceDetailService {

	Map getServiceDetail(ServiceDetailVo vo) throws Exception;
	List<Map> getPatientReview(PatientReviewVo rVo) throws Exception;
}
