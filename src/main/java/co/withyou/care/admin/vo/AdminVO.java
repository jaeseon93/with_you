package co.withyou.care.admin.vo;

import java.util.Date;


//4. 먼저 db결정

public class AdminVO {
	    
	    
	    private String adminId;    //아이디
	    private String adminPw;    //비밀번호
	    private String email;    //이메일
		
	

		public String getAdminId() {
			return adminId;
		}



		public void setAdminId(String adminid) {
			this.adminId = adminid;
		}



		public String getAdminPw() {
			return adminPw;
		}



		public void setAdminPw(String adminpw) {
			this.adminPw = adminpw;
		}



		public String getEmail() {
			return email;
		}



		public void setEmail(String email) {
			this.email = email;
		}



		@Override
		    public String toString() {
		        return "AdminDTO [adminid=" + adminId + ", adminpw=" + adminPw + ", Email=" + email + "]";
	}
		
}