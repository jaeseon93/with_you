package co.withyou.care.common.geoLocation.service;

public interface GeoLocationService {
	int insertPatientLoc(PatientLocVO vo);
	PatientLocVO getPatientLoc(PatientLocVO vo);
	PatientLocVO getPatientLoc(int serviceNo);
}
