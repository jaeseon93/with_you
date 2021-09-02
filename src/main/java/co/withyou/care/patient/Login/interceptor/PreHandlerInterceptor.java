package co.withyou.care.patient.Login.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import co.withyou.care.family.Login.service.FamilyService;
import co.withyou.care.family.Login.service.FamilyVO;
import co.withyou.care.helper.Login.service.HelperService;
import co.withyou.care.helper.Login.service.HelperVO;
import co.withyou.care.patient.Login.service.PatientService;
import co.withyou.care.patient.Login.service.PatientVO;

public class PreHandlerInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	PatientService patientService;
	
	@Override
	public boolean preHandle(
			HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
		
		Cookie loginCookie = WebUtils.getCookie(request, "ploginCookie");
		if(loginCookie != null) {		
			PatientVO vo = new PatientVO();
			Cookie loginCodeCookie = WebUtils.getCookie(request, "ploginCode");
			vo.setPatientVcode(loginCodeCookie.getValue());		
			request.getSession().setAttribute("loginOk", patientService.getSelect(vo));	
			response.sendRedirect("patientMain.do");	
			
		} else {
			return true;

		}
		
		return false;
	}

} //end of Class
