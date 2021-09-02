package co.withyou.care.admin.adminhelper.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.withyou.care.admin.adminfamily.service.AdminFamilyService;
import co.withyou.care.admin.adminhelper.service.AdminHelperService;
import co.withyou.care.admin.adminhelper.service.AdminHelperVo;
import co.withyou.care.common.signUp.service.HelperVO;
import co.withyou.care.family.Login.service.FamilyVO;
import co.withyou.care.family.apply.service.ApplyService;
import co.withyou.care.family.apply.service.ApplyServiceVo;

@Controller
public class AdminHelperController {

	@Autowired
	AdminHelperService adminhelperService;
	
	@RequestMapping("/adminhelperService.do")
	public String adminhelperService (AdminHelperVo adminhelperVo,Model model) throws Exception {
		
		
		return "admin/helper/adminhelperMain";
	}
	
	
	@RequestMapping("/adminhelperList.do")
	public String adminhelperList (AdminHelperVo adminhelperVo, Model model, HttpServletRequest request, HttpSession session) throws Exception {
		List<AdminHelperVo> checkVo = adminhelperService.HelperselectAll();
		model.addAttribute("helperlist", checkVo);
		
		List <Map> list = adminhelperService.getSelectList(adminhelperVo);
		model.addAttribute("adminhelperList", list);
		
		return "admin/helper/adminhelperList";
	}
	

	}
