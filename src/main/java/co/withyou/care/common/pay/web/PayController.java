package co.withyou.care.common.pay.web;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.withyou.care.common.pay.service.PayService;
import co.withyou.care.common.pay.service.PayVo;


@Controller
public class PayController {

	@Autowired
	public PayService payService;
	public PayVo payVo;
	
	
	@RequestMapping("pay.do")
	public String pay(HttpSession session, HttpServletRequest request) {
		
		
		return "common/pay/pay";
	}
	
	@RequestMapping(value="savePayResult.do" , method=RequestMethod.POST)
	@ResponseBody
	public PayVo savePayResult (PayVo payVo, Model model, HttpServletRequest request) throws Exception {
		System.out.println(payVo);
		payService.payResultInsert(payVo);
		
		if(payVo.getBuyer_addr() != null) {
			payService.paySuccessUpdate(payVo);
		}
		model.addAttribute("helperNo", request.getParameter("helper_no"));
		model.addAttribute("payVo", payVo);
		return payVo;
	}
	
	//알람을 위해 값을 전달함
	@RequestMapping(value="payResult.do")
	public String payResult (Model model, HttpServletRequest request) throws Exception {
		model.addAttribute("serviceNo", request.getParameter("serviceNo"));
		model.addAttribute("helperNo", request.getParameter("helperNo"));
		model.addAttribute("familyNo", request.getParameter("familyNo"));
		return "redirect:applyList.do";
	}
	
	@RequestMapping("paySuccess.do")
	public String paySuccess () {
		
		
		return "common/pay/paySuccess";
	}
}
