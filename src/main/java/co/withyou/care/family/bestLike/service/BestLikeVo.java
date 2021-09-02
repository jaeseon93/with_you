package co.withyou.care.family.bestLike.service;

public class BestLikeVo {
	private int helperNo;
	private int familyNo;
	private int serviceNo;
	
	public BestLikeVo() {
		// TODO Auto-generated constructor stub
	}

	public int getHelperNo() {
		return helperNo;
	}

	public void setHelperNo(int helperNo) {
		this.helperNo = helperNo;
	}

	public int getFamilyNo() {
		return familyNo;
	}

	public void setFamilyNo(int familyNo) {
		this.familyNo = familyNo;
	}

	public int getServiceNo() {
		return serviceNo;
	}

	public void setServiceNo(int serviceNo) {
		this.serviceNo = serviceNo;
	}

	@Override
	public String toString() {
		return "BestLikeVo [helperNo=" + helperNo + ", familyNo=" + familyNo + ", serviceNo=" + serviceNo + "]";
	}

}
