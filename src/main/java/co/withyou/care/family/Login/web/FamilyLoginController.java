

package co.withyou.care.family.Login.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.WebUtils;

import co.withyou.care.family.Login.service.FamilyService;
import co.withyou.care.family.Login.service.FamilyVO;


@Controller
public class FamilyLoginController {

	 @Autowired
	 private FamilyService service;
	 
	  // 로그인폼 가기	  
	  @RequestMapping("/familyLogin.do") 
	  public String familyLogin() { 
		  return "family/login/FamilyLogin";
		}
	 
	  @RequestMapping("/familyMain.do")
	  public String familyMain() {
		  return "family/main/FamilyMain";
	  }
	  
	 // 이메일 하나 조회 for 자동로그인기능
	  @RequestMapping("/familyGetSelect")
	  public String familyGetSelect(Model model, FamilyVO vo) throws Exception {
		  model.addAttribute("getSelect", service.getSelect(vo));
		  return "family/login/FamilyLogin";
	  }
	
	  // 로그인 유효성검사
	  @RequestMapping("/loginCheck.do")
	  public String loginCheck(FamilyVO vo, HttpServletRequest request, Model model) throws Exception {
		  HttpSession session = request.getSession();
		  FamilyVO loginCheck = service.getSelect(vo);
		  model.addAttribute("customCheck", request.getParameter("customCheck"));
		
		  if(loginCheck == null) {
			  model.addAttribute("noEmail", false);
			  return "family/login/FamilyLogin";
			  
		  } else if(vo.getFamilyPw().equals(loginCheck.getFamilyPw())) {
			  session.setAttribute("loginOk", loginCheck);	
			  session.setAttribute("userType", "f");	// 로그인시 나타나는 이름 설정
			  model.addAttribute("loginOk", loginCheck);	// 로그인시 나타나는 이름 설정
			  return "redirect:familyMain.do";
			  
		  } else {
			  model.addAttribute("noMember", false);			  
			  return "family/login/FamilyLogin";
		  }  		  
	  }
	  
	 //로그아웃
	  @RequestMapping("/logout.do")
	    public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		  
		  session.invalidate();
		  
		  Cookie[] cookies = request.getCookies(); // 모든 쿠키의 정보를 cookies에 저장
		  System.out.println(cookies+"========쿡희덜======================");
		  if(cookies != null){ // 쿠키가 한개라도 있으면 실행

			for (int i = 0; i < cookies.length; i++) {
				System.out.println(cookies[i].getName());
				if ("floginCookie".equals(cookies[i].getName()) || "floginEmail".equals(cookies[i].getName())) {
					cookies[i].setPath("/");
					cookies[i].setMaxAge(0); // 유효시간을 0으로 설정
					response.addCookie(cookies[i]); // 응답 헤더에 추가
				} else if ("hloginCookie".equals(cookies[i].getName()) || "hloginEmail".equals(cookies[i].getName())) {
					cookies[i].setPath("/");
					cookies[i].setMaxAge(0); // 유효시간을 0으로 설정
					response.addCookie(cookies[i]); // 응답 헤더에 추가
				} else if ("ploginCookie".equals(cookies[i].getName()) || "ploginCode".equals(cookies[i].getName())) {
					cookies[i].setPath("/");
					cookies[i].setMaxAge(0); // 유효시간을 0으로 설정
					response.addCookie(cookies[i]); // 응답 헤더에 추가
				}
			}

		}
		return "common/home/home";
	}

} // end of Class
