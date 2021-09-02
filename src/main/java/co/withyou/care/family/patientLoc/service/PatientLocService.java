package co.withyou.care.family.patientLoc.service;

import co.withyou.care.common.geoLocation.service.PatientLocVO;

public interface PatientLocService {
	PatientLocVO getLoc(PatientLocVO vo) throws Exception;
}
