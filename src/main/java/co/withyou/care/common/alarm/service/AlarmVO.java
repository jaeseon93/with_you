package co.withyou.care.common.alarm.service;

import java.util.Date;

public class AlarmVO {
	private int alarmNo;
	private String alarmType;
	private int alarmReceiverNo;
	private int alarmSenderNo;
	private Date alarmTime;
	private String alarmCheck;
	private int serviceNo;
	
	public int getAlarmNo() {
		return alarmNo;
	}
	public void setAlarmNo(int alarmNo) {
		this.alarmNo = alarmNo;
	}
	public String getAlarmType() {
		return alarmType;
	}
	public void setAlarmType(String alarmType) {
		this.alarmType = alarmType;
	}
	public int getAlarmReceiverNo() {
		return alarmReceiverNo;
	}
	public void setAlarmReceiverNo(int alarmReceiverNo) {
		this.alarmReceiverNo = alarmReceiverNo;
	}
	public int getAlarmSenderNo() {
		return alarmSenderNo;
	}
	public void setAlarmSenderNo(int alarmSenderNo) {
		this.alarmSenderNo = alarmSenderNo;
	}
	public Date getAlarmTime() {
		return alarmTime;
	}
	public void setAlarmTime(Date alarmTime) {
		this.alarmTime = alarmTime;
	}
	public String getAlarmCheck() {
		return alarmCheck;
	}
	public void setAlarmCheck(String alarmCheck) {
		this.alarmCheck = alarmCheck;
	}
	public int getServiceNo() {
		return serviceNo;
	}
	public void setServiceNo(int serviceNo) {
		this.serviceNo = serviceNo;
	}
	
	@Override
	public String toString() {
		return "AlarmVO [alarmNo=" + alarmNo + ", alarmType=" + alarmType + ", alarmReceiverNo=" + alarmReceiverNo
				+ ", alarmSenderNo=" + alarmSenderNo + ", alarmTime=" + alarmTime + ", alarmCheck=" + alarmCheck
				+ ", serviceNo=" + serviceNo + "]";
	}
	
	
	
}
