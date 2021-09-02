package co.withyou.care.common.geoLocation.service;

import java.util.Date;

public class PatientLocVO {
	private int patientLocno;
	private double patientLongitude;
	private double patientLatitude;
	private Date patientLoctime;
	private int patientNo;
	
	public PatientLocVO() {
	}

	public int getPatientLocno() {
		return patientLocno;
	}

	public void setPatientLocno(int patientLocno) {
		this.patientLocno = patientLocno;
	}

	public double getPatientLongitude() {
		return patientLongitude;
	}

	public void setPatientLongitude(double patientLongitude) {
		this.patientLongitude = patientLongitude;
	}

	public double getPatientLatitude() {
		return patientLatitude;
	}

	public void setPatientLatitude(double patientLatitude) {
		this.patientLatitude = patientLatitude;
	}

	public Date getPatientLoctime() {
		return patientLoctime;
	}

	public void setPatientLoctime(Date patientLoctime) {
		this.patientLoctime = patientLoctime;
	}

	public int getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(int patientNo) {
		this.patientNo = patientNo;
	}

	
	
}
