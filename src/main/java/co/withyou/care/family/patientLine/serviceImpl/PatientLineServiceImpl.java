package co.withyou.care.family.patientLine.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import co.withyou.care.common.geoLocation.service.PatientLocVO;
import co.withyou.care.family.patientLine.service.PatientLineService;

public class PatientLineServiceImpl implements PatientLineService{
	@Autowired
	public PatientLineService map;
	@Override
	public List<Map> getGpsList(PatientLocVO vo) throws Exception {
		// TODO Auto-generated method stub
		return map.getGpsList(vo);
	}
	@Override
	public List<Map> getTodayLine(PatientLocVO vo) throws Exception {
		// TODO Auto-generated method stub
		return map.getTodayLine(vo);
	}
	@Override
	public List<Map> getSevenLine(PatientLocVO vo) throws Exception {
		// TODO Auto-generated method stub
		return map.getSevenLine(vo);
	}

}
