package co.withyou.care.family.bestLike.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.withyou.care.family.Login.service.FamilyVO;
import co.withyou.care.family.apply.service.ApplyService;
import co.withyou.care.family.apply.service.ApplyServiceVo;
import co.withyou.care.family.bestLike.service.BestLikeService;
import co.withyou.care.family.bestLike.service.BestLikeVo;
import co.withyou.care.family.search.service.SearchService;

@Controller
public class BestLikeController {

	@Autowired
	public BestLikeService bestLikeService;
	
	@Autowired
	public SearchService searchService;
	
	@Autowired
	public ApplyService applyService;
	
	//즐겨찾기 추가
	@RequestMapping("addLike.do")
	public String addLike (BestLikeVo bestLikeVo, HttpServletRequest request, HttpSession session) throws Exception {
		session = request.getSession();
		FamilyVO familyVo = (FamilyVO) session.getAttribute("loginOk");
		bestLikeVo.setFamilyNo(familyVo.getFamilyNo());
		
		bestLikeService.bestLikeInsert(bestLikeVo);
		
		return "redirect:/applyDetail.do?serviceNo="+bestLikeVo.getServiceNo();
	}
	
	//즐겨찾기 삭제
	@RequestMapping("disLike.do")
	public String disLike (BestLikeVo bestLikeVo, HttpServletRequest request, HttpSession session) throws Exception {
		session = request.getSession();
		FamilyVO familyVo = (FamilyVO) session.getAttribute("loginOk");
		bestLikeVo.setFamilyNo(familyVo.getFamilyNo());
		
		bestLikeService.bestLikeDelete(bestLikeVo);
		
		return "redirect:/applyDetail.do?serviceNo="+bestLikeVo.getServiceNo();
	}
	
	//즐겨찾기 리스트 뷰
	@RequestMapping("bestLikeList.do")
	public String bestLikeList (BestLikeVo bestLikeVo, HttpServletRequest request, HttpSession session, Model model) throws Exception {
		session = request.getSession();
		FamilyVO familyVo = (FamilyVO) session.getAttribute("loginOk");
		bestLikeVo.setFamilyNo(familyVo.getFamilyNo());
		
		List <Map> list = bestLikeService.getSelectList(bestLikeVo);
		model.addAttribute("bestLikeList", list);
		
		return "family/bestLike/bestLikeList";
	}
	
	
	//즐겨찾기 삭제 (리스트에서 삭제)
//	@RequestMapping("disLikeInList.do")
//	public String disLikeInList (BestLikeVo bestLikeVo, HttpServletRequest request, HttpSession session) throws Exception {
//		session = request.getSession();
//		FamilyVO familyVo = (FamilyVO) session.getAttribute("loginOk");
//		bestLikeVo.setFamilyNo(familyVo.getFamilyNo());
//		
//		bestLikeService.bestLikeDelete(bestLikeVo);
//		
//		return "redirect:/bestLikeList.do";
//	}
	
	//즐겨찾기 목록 상세보기
	@RequestMapping("bestLikeDetail.do")
	public String bestLikeDetail (@RequestParam("helperNo") String hNo, Model model, BestLikeVo bestLikeVo, HttpServletRequest request, HttpSession session) throws Exception {
		String helperNo = hNo;
		
		Map map = searchService.getSelect(helperNo);
		model.addAttribute("likeDetail", map);
		
		//간병인 후기 셀렉트
		List <Map> list = searchService.getSelectList2(helperNo);
		model.addAttribute("reviewList", list);
		
		return "family/bestLike/bestLikeDetail";
	}
	
	//즐겨찾기 상세보기에서 서비스 신청
	@RequestMapping("applyInLike.do")
	public String applyInLike(ApplyServiceVo applyServiceVo) throws Exception {
		applyService.applyResultInsert(applyServiceVo);
		
		return "family/main/FamilyMain";
	}
	
}
