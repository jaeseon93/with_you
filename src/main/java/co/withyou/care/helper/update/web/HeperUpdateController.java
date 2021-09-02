package co.withyou.care.helper.update.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.withyou.care.helper.Login.service.HelperVO;
import co.withyou.care.helper.update.service.HelperUpdateService;
import co.withyou.care.helper.update.service.HelperVo;

@Controller
public class HeperUpdateController {
	
	@Autowired
	private HelperUpdateService Hupdateservice;
	
	@RequestMapping("/helperGetSelect.do")
	public String helperGetSelect(HelperVO vo, HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		vo=(HelperVO) session.getAttribute("loginOk");
		vo = Hupdateservice.getSelect(vo);
		model.addAttribute("getSelect",vo);
		return "helper/update/helperUpdate";
		
	}
	
	@RequestMapping("/helperUpdate.do")
	public String helperUpdat(HelperVo vo, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		HelperVO Hvo = (HelperVO)session.getAttribute("loginOk");
		vo.setHelperNo(Hvo.getHelperNo());
		int result = 0;
		result = Hupdateservice.HelperUpdate(vo);
		
		if(result != 0) {
			return "helper/main/helperMain";
			}else {
				return "helperGetSelect.do";
			}
	}
		
	
}
