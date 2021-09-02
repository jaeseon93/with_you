package co.withyou.care.family.patientLine.service;

import java.util.List;
import java.util.Map;

import co.withyou.care.common.geoLocation.service.PatientLocVO;

public interface PatientLineService {

	public List<Map> getGpsList(PatientLocVO vo) throws Exception;
		// TODO Auto-generated method stub
	public List<Map> getTodayLine(PatientLocVO vo) throws Exception;
	public List<Map> getSevenLine(PatientLocVO vo) throws Exception;

}
