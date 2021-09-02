package co.withyou.care.family.search.service;

public class SearchFilterVo {
	private String helperWorkArea;
	private String helperStartTime;
	private String helperEndTime;
	private String certifiName;
	private int familyNo;
	
	public int getFamilyNo() {
		return familyNo;
	}
	public void setFamilyNo(int familyNo) {
		this.familyNo = familyNo;
	}
	public String getHelperWorkArea() {
		return helperWorkArea;
	}
	public void setHelperWorkArea(String helperWorkArea) {
		this.helperWorkArea = helperWorkArea;
	}
	
	public String getHelperStartTime() {
		return helperStartTime;
	}
	public void setHelperStartTime(String helperStartTime) {
		this.helperStartTime = helperStartTime;
	}
	public String getHelperEndTime() {
		return helperEndTime;
	}
	public void setHelperEndTime(String helperEndTime) {
		this.helperEndTime = helperEndTime;
	}
	public String getCertifiName() {
		return certifiName;
	}
	public void setCertifiName(String certifiName) {
		this.certifiName = certifiName;
	}

	@Override
	public String toString() {
		return "SearchFilterVo [helperWorkArea=" + helperWorkArea + ", helperStartTime=" + helperStartTime
				+ ", helperEndTime=" + helperEndTime + ", certifiName=" + certifiName + ", familyNo=" + familyNo + "]";
	}
	
}
