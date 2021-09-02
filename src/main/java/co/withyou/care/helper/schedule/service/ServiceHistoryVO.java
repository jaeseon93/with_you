package co.withyou.care.helper.schedule.service;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ServiceHistoryVO {
	private int serviceNo;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date realStartTime;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date realEndTime;
	
	public int getServiceNo() {
		return serviceNo;
	}
	public void setServiceNo(int serviceNo) {
		this.serviceNo = serviceNo;
	}
	public Date getRealStartTime() {
		return realStartTime;
	}
	public void setRealStartTime(Date realStartTime) {
		this.realStartTime = realStartTime;
	}
	public Date getRealEndTime() {
		return realEndTime;
	}
	public void setRealEndTime(Date realEndTime) {
		this.realEndTime = realEndTime;
	}
}
