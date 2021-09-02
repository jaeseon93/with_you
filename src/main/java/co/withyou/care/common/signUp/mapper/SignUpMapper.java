package co.withyou.care.common.signUp.mapper;

import org.mybatis.spring.annotation.MapperScan;

import co.withyou.care.common.signUp.service.FamilyVO;
import co.withyou.care.common.signUp.service.HelperVO;
import co.withyou.care.common.signUp.service.PatientVO;

@MapperScan
public interface SignUpMapper{

	int checkEmailFamily(FamilyVO vo) throws Exception;
	int checkEmailHelper(HelperVO vo) throws Exception;
	
	int selectFamilyNo(FamilyVO vo) throws Exception;
	int checkPatientVCode(String code) throws Exception;

	void insertPatient(PatientVO vo) throws Exception;
	void insertFamily(FamilyVO vo) throws Exception;
	void insertHelper(HelperVO vo) throws Exception;
	
}
