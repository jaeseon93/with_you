package co.withyou.care.common.chat.service;

import org.springframework.stereotype.Component;

@Component
public class ChatVo {
	private int chatNo;
	private int senderNo;
	private int receiverNo;
	private int helperNo;
	private int familyNo;
	private String chatDate;
	private String chatContents;
	private int chatCheck;
	private String userType;
	
	public ChatVo() {
		// TODO Auto-generated constructor stub
	}

	public int getChatNo() {
		return chatNo;
	}

	public void setChatNo(int chatNo) {
		this.chatNo = chatNo;
	}

	public int getSenderNo() {
		return senderNo;
	}

	public void setSenderNo(int senderNo) {
		this.senderNo = senderNo;
	}

	public int getReceiverNo() {
		return receiverNo;
	}

	public void setReceiverNo(int receiverNo) {
		this.receiverNo = receiverNo;
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

	public String getChatDate() {
		return chatDate;
	}

	public void setChatDate(String chatDate) {
		this.chatDate = chatDate;
	}

	public String getChatContents() {
		return chatContents;
	}

	public void setChatContents(String chatContents) {
		this.chatContents = chatContents;
	}

	public int getChatCheck() {
		return chatCheck;
	}

	public void setChatCheck(int chatCheck) {
		this.chatCheck = chatCheck;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "ChatVo [chatNo=" + chatNo + ", senderNo=" + senderNo + ", receiverNo=" + receiverNo + ", helperNo="
				+ helperNo + ", familyNo=" + familyNo + ", chatDate=" + chatDate + ", chatContents=" + chatContents
				+ ", chatCheck=" + chatCheck + ", userType=" + userType + "]";
	}

}
