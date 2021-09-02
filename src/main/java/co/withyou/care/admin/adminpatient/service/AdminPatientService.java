package co.withyou.care.admin.adminpatient.service;

import java.util.List;

public interface AdminPatientService {

	List<AdminPatientVo> selectAll() throws Exception;
	AdminPatientVo selectPt(AdminPatientVo vo) throws Exception;
	int PatientDelete(AdminPatientVo vo) throws Exception;
}
