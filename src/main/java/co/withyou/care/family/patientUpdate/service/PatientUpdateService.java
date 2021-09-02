package co.withyou.care.family.patientUpdate.service;

import co.withyou.care.family.Login.service.FamilyVO;
import co.withyou.care.patient.Login.service.PatientVO;

public interface PatientUpdateService {
	PatientVO getSelect(FamilyVO vo) throws Exception;
	public int Update(PatientUpdateVO vo) throws Exception;
}
