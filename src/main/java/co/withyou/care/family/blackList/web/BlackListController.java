package co.withyou.care.family.blackList.web;

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
import co.withyou.care.family.blackList.service.BlackListService;
import co.withyou.care.family.blackList.service.BlackListVo;
import co.withyou.care.family.search.service.SearchService;

@Controller
public class BlackListController {

	@Autowired
	public BlackListService blackListService;
	
	@Autowired
	public SearchService searchService;
	
	@Autowired
	public ApplyService applyService;
	
	//즐겨찾기 추가
	@RequestMapping("addBlack.do")
	public String addLike (BlackListVo blackListVo, HttpServletRequest request, HttpSession session) throws Exception {
		session = request.getSession();
		FamilyVO familyVo = (FamilyVO) session.getAttribute("loginOk");
		blackListVo.setFamilyNo(familyVo.getFamilyNo());
		
		blackListService.blackListInsert(blackListVo);
		
		return "redirect:/applyDetail.do?serviceNo="+blackListVo.getServiceNo();
	}
	
	//즐겨찾기 삭제
	@RequestMapping("removeBlack.do")
	public String disLike (BlackListVo blackListVo, HttpServletRequest request, HttpSession session) throws Exception {
		session = request.getSession();
		FamilyVO familyVo = (FamilyVO) session.getAttribute("loginOk");
		blackListVo.setFamilyNo(familyVo.getFamilyNo());
		
		blackListService.blackListDelete(blackListVo);
		
		return "redirect:/applyDetail.do?serviceNo="+blackListVo.getServiceNo();
	}
	
	//즐겨찾기 리스트 뷰
//	@RequestMapping("bestLikeList.do")
//	public String bestLikeList (BestLikeVo bestLikeVo, HttpServletRequest request, HttpSession session, Model model) throws Exception {
//		session = request.getSession();
//		FamilyVO familyVo = (FamilyVO) session.getAttribute("loginOk");
//		bestLikeVo.setFamilyNo(familyVo.getFamilyNo());
//		
//		List <Map> list = bestLikeService.getSelectList(bestLikeVo);
//		model.addAttribute("bestLikeList", list);
//		
//		return "family/bestLike/bestLikeList";
//	}
	
	
	//즐겨찾기 목록 상세보기
//	@RequestMapping("bestLikeDetail.do")
//	public String bestLikeDetail (@RequestParam("helperNo") String hNo, Model model, BestLikeVo bestLikeVo, HttpServletRequest request, HttpSession session) throws Exception {
//		String helperNo = hNo;
//		
//		Map map = searchService.getSelect(helperNo);
//		model.addAttribute("likeDetail", map);
//		
//		
//		return "family/bestLike/bestLikeDetail";
//	}
	
}
