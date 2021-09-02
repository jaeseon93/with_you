package co.withyou.care.helper.Login.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.withyou.care.helper.Login.service.HelperService;
import co.withyou.care.helper.Login.service.HelperVO;

@Controller
public class HelperLoginController {

	@Autowired
	private HelperService helperservice;
	
	
  // 로그인폼 가기	  
  @RequestMapping("/helperLogin.do") 
  public String familyLogin() { 
	  return "helper/login/helperLogin";
}
	 
 // 메인 화면 가기
  @RequestMapping("/helperMain.do")
  public String helperMain() {
	  return "helper/main/helperMain";
  }
  
  // 로그인 유효성 검사
  @RequestMapping("/helperLoginCheck.do")
  public String loginCheck(HelperVO vo, HttpServletRequest request, Model model) throws Exception {
	  HttpSession session = request.getSession();
	  HelperVO loginCheck = helperservice.getSelect(vo);
	  model.addAttribute("customCheck", request.getParameter("customCheck"));
	
	  if(loginCheck == null) {
		  model.addAttribute("noEmail", false);
		  return "helper/login/helperLogin";
		  
	  } else if(vo.getHelperPw().equals(loginCheck.getHelperPw())) {
		  session.setAttribute("loginOk", loginCheck);	
		  session.setAttribute("userType", "h");	
		  model.addAttribute("loginOk", loginCheck);	
		  return "redirect:helperMain.do";
		  
	  } else {
		  model.addAttribute("noMember", false);			  
		  return "helper/login/helperLogin";
	  }  		  
  }
	
	
	
} // end of Class
