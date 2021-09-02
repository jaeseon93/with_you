package co.withyou.care.patient.Login.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.withyou.care.patient.Login.mapper.PatientMapper;
import co.withyou.care.patient.Login.service.PatientService;
import co.withyou.care.patient.Login.service.PatientVO;

@Service("patientService")
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientMapper map;
	
	@Override
	public PatientVO getSelect(PatientVO vo) throws Exception {
		return map.getSelect(vo);
	}

}
