package co.withyou.care.helper.serviceHistory.service;

import java.sql.Date;

public class ServiceHistoryVo {
	// ServiceApply 테이블
	private int serviceNo;
	private int serviceStartTime;
	private int helperPrice;
	private String serviceStatus;
	private int serviceEndTime;
	private int servicePrice;
	private Date serviceDate;
	private String serviceDemand;
	private int helperNo;
	private int familyNo;
	private int patientNo;
	private String applyDate;
	private String serviceArea;

	
	public ServiceHistoryVo() {
		// TODO Auto-generated constructor stub
	}
	
	public int getFamilyNo() {
		return familyNo;
	}

	public void setFamilyNo(int familyNo) {
		this.familyNo = familyNo;
	}

	public String getServiceArea() {
		return serviceArea;
	}

	public void setServiceArea(String serviceArea) {
		this.serviceArea = serviceArea;
	}

	public int getServiceNo() {
		return serviceNo;
	}

	public void setServiceNo(int serviceNo) {
		this.serviceNo = serviceNo;
	}

	public int getServiceStartTime() {
		return serviceStartTime;
	}

	public void setServiceStartTime(int serviceStartTime) {
		this.serviceStartTime = serviceStartTime;
	}

	public int getServiceEndTime() {
		return serviceEndTime;
	}

	public void setServiceEndTime(int serviceEndTime) {
		this.serviceEndTime = serviceEndTime;
	}

	public int getHelperPrice() {
		return helperPrice;
	}

	public void setHelperPrice(int helperPrice) {
		this.helperPrice = helperPrice;
	}

	public int getServicePrice() {
		return servicePrice;
	}

	public void setServicePrice(int servicePrice) {
		this.servicePrice = servicePrice;
	}

	public String getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

	public Date getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(Date serviceDate) {
		this.serviceDate = serviceDate;
	}

	public String getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	public String getServiceDemand() {
		return serviceDemand;
	}

	public void setServiceDemand(String serviceDemand) {
		this.serviceDemand = serviceDemand;
	}

	public int getHelperNo() {
		return helperNo;
	}

	public void setHelperNo(int i) {
		this.helperNo = i;
	}

	public int getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(int patientNo) {
		this.patientNo = patientNo;
	}

	@Override
	public String toString() {
		return "ApplyVo [serviceNo=" + serviceNo + ", serviceStartTime=" + serviceStartTime + ", helperPrice="
				+ helperPrice + ", serviceStatus=" + serviceStatus + ", serviceEndTime=" + serviceEndTime
				+ ", servicePrice=" + servicePrice + ", serviceDate=" + serviceDate + ", serviceDemand=" + serviceDemand
				+ ", helperNo=" + helperNo + ", familyNo=" + familyNo + ", patientNo=" + patientNo + ", applyDate="
				+ applyDate + ", serviceArea=" + serviceArea + "]";
	}

}
