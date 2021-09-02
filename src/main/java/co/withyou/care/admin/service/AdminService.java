package co.withyou.care.admin.service;

import javax.servlet.http.HttpSession;

import co.withyou.care.admin.vo.AdminVO;

//
////2. 관리자 관련 서비스 인터페이스
//
public interface AdminService {
	  // 01_01. 회원 로그인 체크
    public boolean loginCheck(AdminVO vo, HttpSession session) throws Exception;//관리자 로그인을 체크하는 메소드
    // 01_02. 회원 로그인 정보
    public AdminVO viewAdmin(AdminVO vo);
    // 02. 회원 로그아웃
    public void logout(HttpSession session);
}
////    void admin_member_forced_evictionCheck(MemberDTO dto) throws Exception; //강제탈퇴 시킬때 해당 회원이 있는지 체크하는 메소드
// 