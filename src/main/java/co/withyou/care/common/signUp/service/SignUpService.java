package co.withyou.care.common.signUp.service;

public interface SignUpService {
	int checkEmailFamily(FamilyVO vo) throws Exception;
	int checkEmailHelper(HelperVO vo) throws Exception;
	
	String insertFamilyAndPatient(FamilyVO fVO, PatientVO pVO) throws Exception;
	void insertHelper(HelperVO vo) throws Exception;
	
	String createPatientVCode() throws Exception;
}
