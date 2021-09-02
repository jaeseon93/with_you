package co.withyou.care.patient.Login.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.withyou.care.patient.Login.service.PatientService;
import co.withyou.care.patient.Login.service.PatientVO;

@Controller
public class PatientLoginController {

	@Autowired
	private PatientService patientService;
	
	// 로그인 폼 가기
	@RequestMapping("/patientLogin.do")
	public String patientLogin() {
		return "patient/login/patientLogin";
	}
	
	// 메인 화면 가기
	@RequestMapping("/patientMain.do")
	public String patientMain() {
		return "redirect:findload.do";
	}
	
	// 로그인 유효성 검사
	@RequestMapping("/patientLoginCheck.do")
	public String loginCheck(PatientVO vo, HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		PatientVO loginCheck = patientService.getSelect(vo);
		model.addAttribute("customCheck", request.getParameter("customCheck"));
		 
		 if(loginCheck == null) {
			 model.addAttribute("noCode", false);
			 return "patient/login/patientLogin";
			 
		 } else if (vo.getPatientVcode().equals(loginCheck.getPatientVcode())) {
			 session.setAttribute("loginOk", loginCheck);
			 session.setAttribute("userType", "p");
			 model.addAttribute("loginOk", loginCheck);
			 return "redirect:patientMain.do";
			 
		 } else {
			 model.addAttribute("noMember", false);
			 return "patient/login/patientLogin";
		 }
				 		 
} 
	
	
}// end of Class

