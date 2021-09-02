package co.withyou.care.family.apply.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.withyou.care.common.review.service.ReviewService;
import co.withyou.care.common.review.service.ReviewVO;
import co.withyou.care.family.Login.service.FamilyVO;
import co.withyou.care.family.apply.service.ApplyService;
import co.withyou.care.family.apply.service.ApplyServiceVo;

@Controller
public class ApplyController {

	@Autowired
	public ApplyService applyService;
	
	@Autowired
	public ReviewService reviewService;
	
	//서비스 신청하기 메뉴
	@RequestMapping("applyService.do")
	public String applyService (ApplyServiceVo applyVo, Model model) throws Exception {
		applyService.applyResultInsert(applyVo);

		//알람을 위해 값을 전달함
		applyVo.setServiceNo(applyService.getSelectLatest(applyVo));
		model.addAttribute("applyVo", applyVo);
		
		return "family/main/FamilyMain";
	}
	
	//서비스 신청내역 메뉴
	@RequestMapping("applyList.do")
	public String applyList (ApplyServiceVo applyVo, Model model, HttpServletRequest request, HttpSession session) throws Exception {
		//세션에서 값 받기
		session = request.getSession();
		FamilyVO familyVo = (FamilyVO) session.getAttribute("loginOk");
		applyVo.setFamilyNo(familyVo.getFamilyNo());
		
		//세션에서 받은 값으로 쿼리 실행, 리스트에 담기
		List <Map> list = applyService.getSelectList(applyVo);
		model.addAttribute("applyList", list);
		
		return "family/applyService/applyList";
	}
	
	//서비스 신청내역 -> 상세내역 메뉴
	@RequestMapping("applyDetail.do")
	public String applyDetail (@RequestParam("serviceNo") String sNo, Model model, 
								ApplyServiceVo applyVo, ReviewVO reviewVo, 
								HttpServletRequest request, HttpSession session) throws Exception {
		//앞에서 가져온 파라미터 serviceNo를 꺼냄
		String serviceNo = sNo;
		System.out.println(serviceNo);
		
		//세션에서 familyNo 받기
		session = request.getSession();
		FamilyVO familyVo = (FamilyVO) session.getAttribute("loginOk");
		applyVo.setFamilyNo(familyVo.getFamilyNo());		
		//상세내역 뷰 출력을 위한 셀렉트
		Map map = applyService.getSelect(serviceNo);
		model.addAttribute("applyDetail", map);
		
		//진행 상태에따라 실제 출퇴근시간 뷰 출력을 위한 셀렉트
		if(map.get("serviceStatus").equals("S02") || map.get("serviceStatus").equals("S03") || map.get("serviceStatus").equals("S04")) {
			Map map2 = applyService.getSelect2(serviceNo);
			model.addAttribute("applyDetail2", map2);
		}
		
		//결제진행시 필요한 정보 수집을 위한 셀렉트
		Map map3 = applyService.getSelect3(serviceNo);
		model.addAttribute("applyDetail3", map3);
		
		//즐겨찾기 데이터에따라 아이콘 활성화 유무를 위한 셀렉트
		Map map4 = applyService.getSelect4(applyVo);
		model.addAttribute("applyDetail4", map4);
		
		//블랙리스트 데이터에따라 아이콘 활성화 유무를 위한 셀렉트
		Map map5 = applyService.getSelect5(applyVo);
		model.addAttribute("applyDetail5", map5);
		
		//리뷰 정보 가져오기
		reviewVo.setServiceNo(applyVo.getServiceNo());
		reviewVo.setReviewWriter(familyVo.getFamilyNo());
		reviewVo = reviewService.selectReview(reviewVo);
		model.addAttribute("reviewVo", reviewVo);
		
		return "family/applyService/applyDetail";
	}
}
