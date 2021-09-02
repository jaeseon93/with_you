package co.withyou.care.common.review.service;

import java.util.Date;

public class ReviewVO {
	private int reviewNo;
	private int reviewWriter;
	private Date reviewDate;
	private String reviewStar;
	private String reviewContents;
	private String reviewFile;
	private int serviceNo;
	
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public int getReviewWriter() {
		return reviewWriter;
	}
	public void setReviewWriter(int reviewWriter) {
		this.reviewWriter = reviewWriter;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public String getReviewStar() {
		return reviewStar;
	}
	public void setReviewStar(String reviewStar) {
		this.reviewStar = reviewStar;
	}
	public String getReviewContents() {
		return reviewContents;
	}
	public void setReviewContents(String reviewContents) {
		this.reviewContents = reviewContents;
	}
	public String getReviewFile() {
		return reviewFile;
	}
	public void setReviewFile(String reviewFile) {
		this.reviewFile = reviewFile;
	}
	public int getServiceNo() {
		return serviceNo;
	}
	public void setServiceNo(int serviceNo) {
		this.serviceNo = serviceNo;
	}
	@Override
	public String toString() {
		return "ReviewVO [reviewNo=" + reviewNo + ", reviewWriter=" + reviewWriter + ", reviewDate=" + reviewDate
				+ ", reviewStar=" + reviewStar + ", reviewContents=" + reviewContents + ", reviewFile=" + reviewFile
				+ ", serviceNo=" + serviceNo + "]";
	}
	
	
}
