package co.withyou.care.common.signUp.service;

import java.util.Date;

public class CareerVO {
	private int careerNo;
	private String careerOrgan;
	private Date careerStart;
	private Date careerEnd;
	private String careerContents;
	private int helperNo;
	
	public int getCareerNo() {
		return careerNo;
	}
	public void setCareerNo(int careerNo) {
		this.careerNo = careerNo;
	}
	
	public String getCareerOrgan() {
		return careerOrgan;
	}
	public void setCareerOrgan(String careerOrgan) {
		this.careerOrgan = careerOrgan;
	}
	
	public Date getCareerStart() {
		return careerStart;
	}
	public void setCareerStart(Date careerStart) {
		this.careerStart = careerStart;
	}
	
	public Date getCareerEnd() {
		return careerEnd;
	}
	public void setCareerEnd(Date careerEnd) {
		this.careerEnd = careerEnd;
	}
	
	public String getCareerContents() {
		return careerContents;
	}
	public void setCareerContents(String careerContents) {
		this.careerContents = careerContents;
	}
	
	public int getHelperNo() {
		return helperNo;
	}
	public void setHelperNo(int helperNo) {
		this.helperNo = helperNo;
	}
	
	@Override
	public String toString() {
		return "CareerVO [careerNo=" + careerNo + ", careerOrgan=" + careerOrgan + ", careerStart=" + careerStart
				+ ", careerEnd=" + careerEnd + ", careerContents=" + careerContents + ", helperNo=" + helperNo + "]";
	}
	
	

}
