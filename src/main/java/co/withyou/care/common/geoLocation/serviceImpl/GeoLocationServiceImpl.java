package co.withyou.care.common.geoLocation.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.withyou.care.common.geoLocation.mapper.GeoLocationMapper;
import co.withyou.care.common.geoLocation.service.GeoLocationService;
import co.withyou.care.common.geoLocation.service.PatientLocVO;

@Service
public class GeoLocationServiceImpl implements GeoLocationService {

	@Autowired
	GeoLocationMapper map;
	
	@Override
	public int insertPatientLoc(PatientLocVO vo) {
		return map.insertPatientLoc(vo);
	}
	
	@Override
	public PatientLocVO getPatientLoc(PatientLocVO vo) {
		return map.getPatientLoc(vo);
	}

	@Override
	public PatientLocVO getPatientLoc(int serviceNo) {
		return map.getPatientLocInt(serviceNo);
	}
}
