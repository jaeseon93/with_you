package co.withyou.care.helper.applyList.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.withyou.care.family.Login.service.FamilyVO;
import co.withyou.care.family.apply.service.ApplyServiceVo;
import co.withyou.care.helper.Login.service.HelperVO;
import co.withyou.care.helper.applyList.service.ServiceApplyListService;
import co.withyou.care.helper.applyList.service.ServiceApplyListVo;

@Controller
public class ServiceApplyListController {

	@Autowired
	public ServiceApplyListService serviceapplylist;
	
	@RequestMapping("serviceapplylist.do")
	public String ServiceApplyList(ServiceApplyListVo applyListVo, Model model, HttpServletRequest request,HttpSession session) throws Exception {
		
		session = request.getSession();
		HelperVO helperVo = (HelperVO) session.getAttribute("loginOk");
		applyListVo.setHelperNo(helperVo.getHelperNo());
		
		List<Map> list = serviceapplylist.getApplyList(applyListVo);
		model.addAttribute("serviceList",list);
		return "helper/ServiceApplyList/applyList";
		
	}
}
