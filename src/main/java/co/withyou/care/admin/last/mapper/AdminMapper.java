package co.withyou.care.admin.last.mapper;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.annotation.MapperScan;

import co.withyou.care.admin.vo.AdminVO;

//5. 로긴체크 구간
@MapperScan
public interface AdminMapper {
		 
	    String loginCheck(AdminVO vo) throws Exception;    //01_01. 로그인을 체크하는 메소드
	    
	    public AdminVO viewAdmin(AdminVO vo); // 01_02. 관리자 로그인 정보
	    
	    public void logout(HttpSession session);  // 02. 관리자 로그아웃
	    
//	 
//	    void admin_member_forced_evictionCheck(MemberVO vo) throws Exception;    //회원 강제탈퇴 관련 메소드
//	 
	}
	 
