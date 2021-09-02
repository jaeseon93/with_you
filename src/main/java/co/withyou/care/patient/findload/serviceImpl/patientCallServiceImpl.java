package co.withyou.care.patient.findload.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.withyou.care.patient.findload.mapper.patientCallMapper;
import co.withyou.care.patient.findload.service.FamilyVO;
import co.withyou.care.patient.findload.service.patientCallService;

@Service("patientCallservice")
public class patientCallServiceImpl implements patientCallService {

	@Autowired
	private patientCallMapper Callmap;
	@Override
	public FamilyVO getSelect(FamilyVO vo) throws Exception {
		return Callmap.getSelect(vo);
	}

}
