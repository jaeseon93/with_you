package co.withyou.care.helper.serviceHistory.web;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.withyou.care.common.review.service.ReviewService;
import co.withyou.care.common.review.service.ReviewVO;
import co.withyou.care.helper.Login.service.HelperVO;
import co.withyou.care.helper.serviceHistory.service.ServiceHistoryService;
import co.withyou.care.helper.serviceHistory.service.ServiceHistoryVo;

@Controller
public class ServiceHistoryController {
	
	@Autowired
	ServiceHistoryService historyService;
	
	@Autowired
	public ReviewService reviewService;
	
	//서비스 완료된 서비스 가저오기
	@RequestMapping("/serviceHistory.do")
	public ModelAndView serviceListH(ModelAndView mav, ServiceHistoryVo historyVO, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		HelperVO getSession = (HelperVO) session.getAttribute("loginOk");
		historyVO.setHelperNo(getSession.getHelperNo());
				
		List<Map> map = historyService.getList(historyVO);
		
		mav.addObject("serviceHistoryList", map);
		mav.setViewName("helper/serviceHistory/serviceHistory");
		
		return mav;
	}
	
	//상세보기
	@RequestMapping("/historyDetail.do")
	public ModelAndView historyDetail(@RequestParam("serviceNo") String sNo, HttpServletRequest request, 
										ReviewVO reviewVo, ServiceHistoryVo historyVO, 
										ModelAndView mav) throws Exception {
		// 파라미터 가져오기
		String serviceNo = sNo;
		System.out.println("서비스넘버"+sNo);
		
		HttpSession session = request.getSession();
		HelperVO getSession = (HelperVO) session.getAttribute("loginOk");
		historyVO.setHelperNo(getSession.getHelperNo());
		System.out.println("세션에있는 간병인번호:"+getSession.getHelperNo());
		
		Map detailMap = historyService.getSelect(serviceNo);
		mav.addObject("historyDetail", detailMap);
		mav.setViewName("helper/serviceHistory/historyDetail");
		

		//리뷰 정보 가져오기
		reviewVo.setServiceNo(Integer.parseInt(serviceNo));
		reviewVo.setReviewWriter(getSession.getHelperNo());
		reviewVo = reviewService.selectReview(reviewVo);
		mav.addObject("reviewVo", reviewVo);
		
		return mav;

	}
	
	
}
