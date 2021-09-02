//package co.withyou.care.admin.dao;
//
//import javax.inject.Inject;
//import javax.servlet.http.HttpSession;
//
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.stereotype.Repository;
//
//import co.withyou.care.admin.vo.AdminVO;
//
//@Repository    //6. 현재 클래스를 스프링에서 관리하는 dao bean으로 등록
//	 public class AdminDAOImpl implements AdminDAO {
//	// SqlSession 객체를 스프핑에서 생성하여 주입
//    // 의존관계 주입(Dependency Injection), 느슨한 결합
//    @Inject
//    SqlSession sqlSession; // mybatis 실행 객체
//    
//    // 01_01. 회원 로그인체크
//	@Override
//	public boolean loginCheck(AdminVO vo) throws Exception {
//		String name = sqlSession.selectOne("admin.loginCheck", vo);
//        return (name == null) ? false : true;
//	}
//
//	@Override
//	public AdminVO viewAdmin(AdminVO vo) {
//		  return sqlSession.selectOne("admin.viewA", vo);
//	}
//
//	@Override
//	public void logout(HttpSession session) {
//		
//	}
//	
//}
//
////    
////    @Inject        //sql쿼리를 사용하기 위해서 의존성을 주입함
////    SqlSession sqlSession;
////    
////    
////    //로그인 체크
////    //id가 null이면 false를 리턴하고 값이 있으면 true를 리턴한다.
////    @Override
////    public boolean loginCheck(AdminDTO dto) throws Exception{
////        
////        String name = sqlSession.selectOne("admin.login_check", dto);
////        
////        //조건식 ? true일때의 값 : false일때의 값
////        return (name==null) ? false : true;
////        
////    }
//// 
////    
////    //회원 강제탈퇴 관련 메소드 구현
////    @Override
////    public void admin_member_forced_evictionCheck(MemberDTO dto) throws Exception{
////        
////            sqlSession.delete("admin.admin_member_forced_evictionCheck", dto);
//// 
////    }
//// 
//// 
////    
////}*/