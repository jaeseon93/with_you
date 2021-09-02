package co.withyou.care.family.Update.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.withyou.care.family.Login.service.FamilyVO;
import co.withyou.care.family.Update.service.FamilyUpdateService;
import co.withyou.care.family.Update.service.FamilyUpdateVo;

@Controller
public class FamilyUpdateController {

		@Autowired
		private FamilyUpdateService updateservice;
		
		@RequestMapping("/familygetSelect.do")
		public String familygetSelect(FamilyVO vo, HttpServletRequest request, Model model) throws Exception{
			HttpSession session = request.getSession();
			vo=(FamilyVO)session.getAttribute("loginOk");
			vo = updateservice.getSelect(vo);
			model.addAttribute("getSelect",vo);
			return "family/update/familygetSelect";
			
		}
		
		@RequestMapping("/familyUpdate.do")
		public String familyUpdate(FamilyUpdateVo vo, HttpServletRequest request) throws Exception {
		//	System.out.println(vo.getFamily);
		//	String birth = request.getParameter("familyBirth");
//			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
//			Date to = transFormat.parse(birth);

//			vo.setFamilyBirth(to);
			HttpSession session = request.getSession();
			FamilyVO familyVo = (FamilyVO)session.getAttribute("loginOk");
			vo.setFamilyNo(familyVo.getFamilyNo());
			int result = 0;
			result = updateservice.Update(vo);
		
//			System.out.println("FamilyBirth :" + vo.getFamilyBirth());	
//			System.out.println("RESULT :"+result);
//			if(result!=0) {
//			}else {
//				return "family/main/FamilyMain";
//			}
			if(result != 0) {
			return "family/main/FamilyMain";
			}else {
				return "familygetSelect.do";
			}
		}
		
		@RequestMapping("/familyLogout")
	    public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
			session.invalidate();
			return "common/home/home";
		}

}
