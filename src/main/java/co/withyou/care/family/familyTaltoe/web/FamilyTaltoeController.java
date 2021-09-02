package co.withyou.care.family.familyTaltoe.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.withyou.care.family.Login.service.FamilyVO;
import co.withyou.care.family.familyTaltoe.service.FamilyTaltoeService;
import co.withyou.care.family.familyTaltoe.service.FamilyTaltoeVo;

@Controller
public class FamilyTaltoeController {

	@Autowired 
	public FamilyTaltoeService familytaltoeservice;
	
	@RequestMapping("/gofamilyTaltoe.do")
	public String GoFamilyTaltoe(HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		FamilyVO loginFno = (FamilyVO)session.getAttribute("loginOk");
		String sessionPw = loginFno.getFamilyPw();
		model.addAttribute("sessionPw",sessionPw);
		return "family/taltoe/FamilyTaltoe";
	}
	
	@RequestMapping("/familyTaltoe.do")
	public String FamilyTaltoe(FamilyTaltoeVo vo,HttpServletRequest request,Model model) throws Exception {
		HttpSession session = request.getSession();
		FamilyVO loginFno = (FamilyVO) session.getAttribute("loginOk");
		
		System.out.println(loginFno.getFamilyNo());
		
		vo.setFamilyNo(loginFno.getFamilyNo());
		String sessionPw = loginFno.getFamilyPw();
		System.out.println("familyPw :"+sessionPw);
		model.addAttribute("sessionPw",sessionPw);
		familytaltoeservice.PatientTaltoe(vo);
		familytaltoeservice.FamilyTaltoe(vo);
		session.invalidate();
		return "common/home/home";
		
		
	}
}
