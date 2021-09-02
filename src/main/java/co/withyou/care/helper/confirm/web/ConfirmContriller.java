package co.withyou.care.helper.confirm.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.withyou.care.helper.Login.service.HelperVO;
import co.withyou.care.helper.confirm.service.ConfirmService;
import co.withyou.care.helper.confirm.service.ConfirmVo;

@Controller
public class ConfirmContriller {
	@Autowired
	public ConfirmService confirmservice;
	
	@RequestMapping("/confirm.do")
	public String Confrim(@RequestParam("serviceNo") int sNo,ConfirmVo vo, HttpServletRequest request, Model model) throws Exception{
		//confirmservice.ConfirmUpdate(vo);
		//알람을 위해 값을 전달함
		System.out.println("여기가 sNo"+sNo);
		HttpSession session = request.getSession();
		HelperVO helperVo = (HelperVO) session.getAttribute("loginOk");

		vo.setHelperNo(helperVo.getHelperNo());
		vo.setServiceNo(sNo);
		int result = 0;
		result = confirmservice.ConfirmUpdate(vo);
		model.addAttribute("confirm",vo);
		
		return "helper/main/helperMain";
		
	}
	
}
