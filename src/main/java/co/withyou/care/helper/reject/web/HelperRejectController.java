package co.withyou.care.helper.reject.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.withyou.care.helper.Login.service.HelperVO;
import co.withyou.care.helper.confirm.service.ConfirmVo;
import co.withyou.care.helper.reject.service.HelperRejectService;
import co.withyou.care.helper.reject.service.RejectVo;

@Controller
public class HelperRejectController {

	@Autowired
	public HelperRejectService rejectservice;
	
	@RequestMapping("/reject.do")
	public String Reject(@RequestParam("serviceNo") int sNo,RejectVo vo, HttpServletRequest request, Model model) throws Exception{

		HttpSession session = request.getSession();
		HelperVO helperVo = (HelperVO) session.getAttribute("loginOk");
		
		System.out.println("거절serviceNo :"+sNo);
		vo.setHelperNo(helperVo.getHelperNo());
		vo.setServiceNo(sNo);
		int result=0;
		rejectservice.RejectUpdate(vo);
		
		//알람을 위해 넘겨주는값
		model.addAttribute("RejectVo", vo);
		return "helper/main/helperMain";
	}
}
