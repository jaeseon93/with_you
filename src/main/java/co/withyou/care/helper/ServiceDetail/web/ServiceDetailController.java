package co.withyou.care.helper.ServiceDetail.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.withyou.care.helper.Login.service.HelperVO;
import co.withyou.care.helper.ServiceDetail.service.PatientReviewVo;
import co.withyou.care.helper.ServiceDetail.service.ServiceDetailService;
import co.withyou.care.helper.ServiceDetail.service.ServiceDetailVo;

@Controller
public class ServiceDetailController {

	@Autowired
	public ServiceDetailService serviceDetail;
	
	
	@RequestMapping("serviceDetail.do")
	public String ServiceDetail(@RequestParam("serviceNo") int sNo,Model model,PatientReviewVo rVo, HttpServletRequest request,ServiceDetailVo vo,HttpSession session) throws Exception {
		session = request.getSession();
		vo.setServiceNo(sNo);
		
		HelperVO helpervo =(HelperVO)session.getAttribute("loginOk");
		vo.setHelperNo(helpervo.getHelperNo());
		
		Map list = serviceDetail.getServiceDetail(vo);
		model.addAttribute("serviceDetail",list);

		String rFno =  list.get("familyNo").toString();
		rVo.setFamilyNo(rFno);
		List<Map> reviewList = serviceDetail.getPatientReview(rVo);
		System.out.println(reviewList);
		model.addAttribute("reviewList",reviewList);
		return "helper/serviceDetail/serviceDetail";
		
	}


	
}
