package co.withyou.care.common.signUp.service;

import java.util.Date;

public class FamilyVO {
	private int familyNo;
	private String familyName;
	private Date familyBirth;
	private String familyAddr;
	private String familyTel;
	private String familyEmail;
	private String familyPw;
	private Date familyJoinDate;
	private String familySex;
	
	public FamilyVO() {
	}

	public int getFamilyNo() {
		return familyNo;
	}

	public void setFamilyNo(int familyNo) {
		this.familyNo = familyNo;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public Date getFamilyBirth() {
		return familyBirth;
	}

	public void setFamilyBirth(Date familyBirth) {
		this.familyBirth = familyBirth;
	}

	public String getFamilyAddr() {
		return familyAddr;
	}

	public void setFamilyAddr(String familyAddr) {
		this.familyAddr = familyAddr;
	}

	public String getFamilyTel() {
		return familyTel;
	}

	public void setFamilyTel(String familyTel) {
		this.familyTel = familyTel;
	}

	public String getFamilyEmail() {
		return familyEmail;
	}

	public void setFamilyEmail(String familyEmail) {
		this.familyEmail = familyEmail;
	}

	public String getFamilyPw() {
		return familyPw;
	}

	public void setFamilyPw(String familyPw) {
		this.familyPw = familyPw;
	}

	public Date getFamilyJoinDate() {
		return familyJoinDate;
	}

	public void setFamilyJoinDate(Date familyJoinDate) {
		this.familyJoinDate = familyJoinDate;
	}

	public String getFamilySex() {
		return familySex;
	}

	public void setFamilySex(String familySex) {
		this.familySex = familySex;
	}

	@Override
	public String toString() {
		return "FamilyVO [familyNo=" + familyNo + ", familyName=" + familyName + ", familyBirth=" + familyBirth
				+ ", familyAddr=" + familyAddr + ", familyTel=" + familyTel + ", familyEmail=" + familyEmail
				+ ", familyPw=" + familyPw + ", familyJoinDate=" + familyJoinDate + ", familySex=" + familySex + "]";
	}
	
	
}
