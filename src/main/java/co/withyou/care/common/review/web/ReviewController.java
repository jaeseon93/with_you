package co.withyou.care.common.review.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.withyou.care.common.review.service.ReviewService;
import co.withyou.care.common.review.service.ReviewVO;
import co.withyou.care.family.Login.service.FamilyVO;
import co.withyou.care.helper.Login.service.HelperVO;

@Controller
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;

	@RequestMapping(value = "/goReview.do")
	public String goReview() {
		return "common/home/review";
	}
	
	@RequestMapping(value = "/insertFamilyReview.do")
	public String insertFamilyReview(ReviewVO vo, RedirectAttributes ra, HttpServletRequest request) {
		HttpSession session = request.getSession();
		FamilyVO familyVo = (FamilyVO) session.getAttribute("loginOk");
		vo.setReviewWriter(familyVo.getFamilyNo());
		
		reviewService.insertReview(vo);
	    ra.addAttribute("serviceNo", vo.getServiceNo());
	    
	    return "redirect:applyDetail.do";
	}

	@RequestMapping(value = "/insertHelperReview.do")
	public String insertHelperReview(ReviewVO vo, RedirectAttributes ra, HttpServletRequest request) {
		HttpSession session = request.getSession();
		HelperVO helperVO = (HelperVO) session.getAttribute("loginOk");
		vo.setReviewWriter(helperVO.getHelperNo());
		
		reviewService.insertReview(vo);
	    ra.addAttribute("serviceNo", vo.getServiceNo());
	    
	    return "redirect:historyDetail.do";
	}

	@RequestMapping(value = "/deleteReview.do")
	public String deleteReview(ReviewVO vo, RedirectAttributes ra, HttpServletRequest request) {
		
		reviewService.deleteReview(vo.getReviewNo());
	    ra.addAttribute("serviceNo", vo.getServiceNo());
	    
	    String type= request.getParameter("writerType");
	    if(type.equals("f")) {
		    return "redirect:applyDetail.do";
	    }else {
		    return "redirect:historyDetail.do";
	    }
	}
	
	@RequestMapping(value = "/updateReview.do")
	public String updateReview(ReviewVO vo, RedirectAttributes ra, HttpServletRequest request) {

		reviewService.updateReview(vo);
	    ra.addAttribute("serviceNo", vo.getServiceNo());

	    String type= request.getParameter("writerType");
	    if(type.equals("f")) {
		    return "redirect:applyDetail.do";
	    }else {
		    return "redirect:historyDetail.do";
	    }
	}
}
