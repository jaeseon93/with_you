package co.withyou.care.hospital.GwangMyeong.service;

public class SeoulVo {
	private String NM;//사업자명
	private String ADDR; //도로명주소
	private String BED_NUM; //병상수
	private String MEDICAL_STAFF_NUM; //의료인수
	private String HOSPITAL_ROOM_NUM;//입원실수
	private String TEL; //전화번호
	private String XCODE; //위도
	private String YCODE; //경도
	private String TOTAL_PEOPLE;
	
	
	public String getTOTAL_PEOPLE() {
		return TOTAL_PEOPLE;
	}
	public void setTOTAL_PEOPLE(String tOTAL_PEOPLE) {
		TOTAL_PEOPLE = tOTAL_PEOPLE;
	}
	public String getNM() {
		return NM;
	}
	public void setNM(String nM) {
		NM = nM;
	}
	public String getADDR() {
		return ADDR;
	}
	public void setADDR(String aDDR) {
		ADDR = aDDR;
	}
	public String getBED_NUM() {
		return BED_NUM;
	}
	public void setBED_NUM(String bED_NUM) {
		BED_NUM = bED_NUM;
	}
	public String getMEDICAL_STAFF_NUM() {
		return MEDICAL_STAFF_NUM;
	}
	public void setMEDICAL_STAFF_NUM(String mEDICAL_STAFF_NUM) {
		MEDICAL_STAFF_NUM = mEDICAL_STAFF_NUM;
	}
	public String getHOSPITAL_ROOM_NUM() {
		return HOSPITAL_ROOM_NUM;
	}
	public void setHOSPITAL_ROOM_NUM(String hOSPITAL_ROOM_NUM) {
		HOSPITAL_ROOM_NUM = hOSPITAL_ROOM_NUM;
	}
	public String getTEL() {
		return TEL;
	}
	public void setTEL(String tEL) {
		TEL = tEL;
	}
	public String getXCODE() {
		return XCODE;
	}
	public void setXCODE(String xCODE) {
		XCODE = xCODE;
	}
	public String getYCODE() {
		return YCODE;
	}
	public void setYCODE(String yCODE) {
		YCODE = yCODE;
	}
	
	
	
}
