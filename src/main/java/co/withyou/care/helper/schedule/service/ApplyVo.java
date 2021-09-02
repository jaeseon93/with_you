package co.withyou.care.helper.schedule.service;

public class ApplyVo {
	
	private int serviceNo;
	private int serviceStartTime;
	private int helperPrice;
	private String serviceStatus;
	private int serviceEndTime;
	private int servicePrice;
	private String serviceDate;
	private String serviceDemand;
	private int helperNo;
	private int patientNo;
	private String applyDate;
	private String serviceArea;
	
	public ApplyVo() {
		// TODO Auto-generated constructor stub
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

	public String getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(String serviceDate) {
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

	public void setHelperNo(int helperNo) {
		this.helperNo = helperNo;
	}

	public int getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(int patientNo) {
		this.patientNo = patientNo;
	}

	@Override
	public String toString() {
		return "ApplyVo [serviceNo=" + serviceNo + ", serviceStartTime=" + serviceStartTime + ", serviceEndTime="
				+ serviceEndTime + ", helperPrice=" + helperPrice + ", servicePrice=" + servicePrice
				+ ", serviceStatus=" + serviceStatus + ", serviceDate=" + serviceDate + ", applyDate=" + applyDate
				+ ", serviceDemand=" + serviceDemand + ", helperNo=" + helperNo + ", patientNo=" + patientNo
				+ ", serviceArea=" + serviceArea + "]";
	}
 

	
}
