package co.withyou.care.common.session.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionPreHandler extends HandlerInterceptorAdapter {
	
//세션을 확인한다 2개 중 하나라도 널이면, home으로 가게 한다. 세션을 다 초기화한다
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			                 Object obj) throws Exception {
		
		HttpSession session = request.getSession();
		String loginSes = (String) session.getAttribute("loginOk");
		String userSes = (String) session.getAttribute("userType");
		
		if(loginSes == null || userSes == null) {
			System.out.println("세션확인:" +loginSes +userSes);	
			response.sendRedirect("sessionAlert.do");
		} else {
			return true;
		}
		
		return false;
	}

} //end of Class
