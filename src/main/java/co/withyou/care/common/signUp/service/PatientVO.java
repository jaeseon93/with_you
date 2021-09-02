package co.withyou.care.common.signUp.service;

import java.util.Date;

public class PatientVO {
	private int patientNo;
	private String patientName;
	private String patientAddr;
	private String patientSex;
	private Date patientBirth;
	private String patientFamilyTel;
	private String patientTel;
	private String patientBlood;
	private String patientVcode;
	private int patientZone;
	private String patientDisease;
	private String patientGrade;
	private String patientMedication;
	private String patientUnique;
	private int familyNo;
	
	
	public PatientVO() {
	}


	public int getPatientNo() {
		return patientNo;
	}


	public void setPatientNo(int patientNo) {
		this.patientNo = patientNo;
	}


	public String getPatientName() {
		return patientName;
	}


	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}


	public String getPatientAddr() {
		return patientAddr;
	}


	public void setPatientAddr(String patientAddr) {
		this.patientAddr = patientAddr;
	}


	public String getPatientSex() {
		return patientSex;
	}


	public void setPatientSex(String patientSex) {
		this.patientSex = patientSex;
	}


	public Date getPatientBirth() {
		return patientBirth;
	}


	public void setPatientBirth(Date patientBirth) {
		this.patientBirth = patientBirth;
	}


	public String getPatientFamilyTel() {
		return patientFamilyTel;
	}


	public void setPatientFamilyTel(String patientFamilyTel) {
		this.patientFamilyTel = patientFamilyTel;
	}


	public String getPatientTel() {
		return patientTel;
	}


	public void setPatientTel(String patientTel) {
		this.patientTel = patientTel;
	}


	public String getPatientBlood() {
		return patientBlood;
	}


	public void setPatientBlood(String patientBlood) {
		this.patientBlood = patientBlood;
	}


	public String getPatientVcode() {
		return patientVcode;
	}


	public void setPatientVcode(String patientVcode) {
		this.patientVcode = patientVcode;
	}


	public int getPatientZone() {
		return patientZone;
	}


	public void setPatientZone(int patientZone) {
		this.patientZone = patientZone;
	}


	public String getPatientDisease() {
		return patientDisease;
	}


	public void setPatientDisease(String patientDisease) {
		this.patientDisease = patientDisease;
	}


	public String getPatientGrade() {
		return patientGrade;
	}


	public void setPatientGrade(String patientGrade) {
		this.patientGrade = patientGrade;
	}


	public String getPatientMedication() {
		return patientMedication;
	}


	public void setPatientMedication(String patientMedication) {
		this.patientMedication = patientMedication;
	}


	public String getPatientUnique() {
		return patientUnique;
	}


	public void setPatientUnique(String patientUnique) {
		this.patientUnique = patientUnique;
	}


	public int getFamilyNo() {
		return familyNo;
	}


	public void setFamilyNo(int familyNo) {
		this.familyNo = familyNo;
	}


	@Override
	public String toString() {
		return "PatientVO [patientNo=" + patientNo + ", patientName=" + patientName + ", patientAddr=" + patientAddr
				+ ", patientSex=" + patientSex + ", patientBirth=" + patientBirth + ", patientFamilyTel="
				+ patientFamilyTel + ", patientTel=" + patientTel + ", patientBlood=" + patientBlood + ", patientVcode="
				+ patientVcode + ", patientZone=" + patientZone + ", patientDisease=" + patientDisease
				+ ", patientGrade=" + patientGrade + ", patientMedication=" + patientMedication + ", patientUnique="
				+ patientUnique + ", familyNo=" + familyNo + "]";
	}
	
	
}
