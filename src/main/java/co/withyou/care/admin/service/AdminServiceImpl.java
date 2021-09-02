package co.withyou.care.admin.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.withyou.care.admin.last.mapper.AdminMapper;
import co.withyou.care.admin.vo.AdminVO;

//3. 관리자 관련 서비스 구현
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired // dao를 호출하기때문에 의존성을 주입한다.
	AdminMapper adminMapper;

	@Override
	public boolean loginCheck(AdminVO vo, HttpSession session) throws Exception {
		String result = adminMapper.loginCheck(vo);
		boolean bresult;

		if (!result.equals("")) { // true일 경우 세션에 등록 //!있냐 없냐에서 반전이란 뜻 이퀄즈는 무엇을 담을것인지|
			// 세션에 등록
			bresult = true;

		} else {
			bresult = false;
		}
			return bresult;
	}
	// AdminVO vo2 = viewAdmin(vo);
	// // 세션 변수 등록
	// session.setAttribute("adminId", vo2.getAdminid());
	// }
	// return result;
	// 01_02. 회원 로그인 정보

	@Override
	public AdminVO viewAdmin(AdminVO vo) {
		return adminMapper.viewAdmin(vo);
	}

	// 02. 회원 로그아웃
	@Override
	public void logout(HttpSession session) {
		// 세션 변수 개별 삭제
		// session.removeAttribute("adminId");
		// 세션 정보를 초기화 시킴
		session.invalidate();
	}

}
