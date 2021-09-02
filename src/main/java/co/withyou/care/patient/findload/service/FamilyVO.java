package co.withyou.care.patient.findload.service;

public class FamilyVO {
	private int familyNo;
	private String familyTel;
	
	public FamilyVO() {
		// TODO Auto-generated constructor stub
	}

	public int getFamilyNo() {
		return familyNo;
	}

	public void setFamilyNo(int familyNo) {
		this.familyNo = familyNo;
	}

	public String getFamilyTel() {
		return familyTel;
	}

	public void setFamilyTel(String familyTel) {
		this.familyTel = familyTel;
	}

	@Override
	public String toString() {
		return "FamilyVO [familyNo=" + familyNo + ", familyTel=" + familyTel + "]";
	}
	
	
}
