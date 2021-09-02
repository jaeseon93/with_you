package co.withyou.care.common;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home.do")
	public String home(Locale locale, Model model, HttpSession session, HttpServletRequest request) {
		logger.info("Welcome home! The client locale is {}.", locale);

		//채팅 기능 테스트용 접속 IP값 세션 저장
//		String ipAddress = request.getRemoteAddr();
//		session.setAttribute("userLoc", ipAddress);
		
		return "common/home/home";
	}
	// 재선 로그인용 home 가는 코드
	@RequestMapping(value = "/goHome.do")
	public String goHome(Locale locale, Model model, HttpSession session, HttpServletRequest request) {
		logger.info("Welcome home! The client locale is {}.", locale);

		//채팅 기능 테스트용 접속 IP값 세션 저장
//		String ipAddress = request.getRemoteAddr();
//		session.setAttribute("userLoc", ipAddress);
		
		return "common/home/home";
	}	
 //환자
	@RequestMapping(value = "/patient.do")
	public String patient(Locale locale, Model model) {

		return "patient/test/patient";
	}
//보호자
	@RequestMapping(value = "/family.do")
	public String family(Locale locale, Model model) {

		return "family/test/family";
	}
//간병
	@RequestMapping(value = "/helper.do")
	public String helper(Locale locale, Model model) {
	
		return "helper/test/helper";
	}	
	@RequestMapping(value = "/hospitalGetData.do")
	public String hospital(Locale locale,Model model) {
		return "hospital/test/hospitalGetdata";
		
	}
	
}
