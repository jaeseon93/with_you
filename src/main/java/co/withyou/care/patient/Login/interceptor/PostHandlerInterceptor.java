package co.withyou.care.patient.Login.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import co.withyou.care.family.Login.service.FamilyVO;
import co.withyou.care.helper.Login.service.HelperVO;
import co.withyou.care.patient.Login.service.PatientVO;


public class PostHandlerInterceptor extends HandlerInterceptorAdapter {

	
	// 자동로그인 controller의 handler가 끝나면 처리됨
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,Object obj, ModelAndView mav) throws Exception {			
		HttpSession session = request.getSession();
		ModelMap modelMap = mav.getModelMap();
		PatientVO vo = new PatientVO();
		vo = (PatientVO) session.getAttribute("loginOk");
		
	  if(modelMap.get("customCheck") != null) {
		  Cookie loginCookie = new Cookie("ploginCookie",session.getId());
		  loginCookie.setPath("/");
		  loginCookie.setMaxAge(60*60*24*7);
		  //담기
		  response.addCookie(loginCookie);

		  // 코드 쿠키에 저장 
		  Cookie CodeCookie = new Cookie("ploginCode", vo.getPatientVcode()); 
		  loginCookie.setPath("/");
		  loginCookie.setMaxAge(60*60*24*7); 
		  
		  //담기 
		  response.addCookie(CodeCookie); 
 
	  }
	}

}
