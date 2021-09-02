package co.withyou.care.common.signUp.service;

import java.util.Date;

public class CertificationVO {
	private int certifiNo;
	private String certifiName;
	private String certifiFile;
	private String certifiOrgan;
	private Date certifiGetDate;
	private int helperNo;
	
	public int getCertifiNo() {
		return certifiNo;
	}
	public void setCertifiNo(int certifiNo) {
		this.certifiNo = certifiNo;
	}
	
	public String getCertifiName() {
		return certifiName;
	}
	public void setCertifiName(String certifiName) {
		this.certifiName = certifiName;
	}
	
	public String getCertifiFile() {
		return certifiFile;
	}
	public void setCertifiFile(String certifiFile) {
		this.certifiFile = certifiFile;
	}
	
	public String getCertifiOrgan() {
		return certifiOrgan;
	}
	public void setCertifiOrgan(String certifiOrgan) {
		this.certifiOrgan = certifiOrgan;
	}
	
	public Date getCertifiGetDate() {
		return certifiGetDate;
	}
	public void setCertifiGetDate(Date certifiGetDate) {
		this.certifiGetDate = certifiGetDate;
	}
	
	public int getHelperNo() {
		return helperNo;
	}
	public void setHelperNo(int helperNo) {
		this.helperNo = helperNo;
	}
	
	@Override
	public String toString() {
		return "CertificationVO [certifiNo=" + certifiNo + ", certifiName=" + certifiName + ", certifiFile="
				+ certifiFile + ", certifiOrgan=" + certifiOrgan + ", certifiGetDate=" + certifiGetDate + ", helperNo="
				+ helperNo + "]";
	}
	
	
	
}
