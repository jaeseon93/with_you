package co.withyou.care.family.search.web;

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
import co.withyou.care.family.search.service.SearchFilterVo;
import co.withyou.care.family.search.service.SearchService;


@Controller
public class SearchController {

	@Autowired
	public SearchService searchService;
	
	//간병신청 메뉴
	@RequestMapping("applyMenu.do")
	public String applyMenu() {
		return "family/applyService/applyHelperService";
	}
	
	//간병인 조회 
	@RequestMapping("helperList.do")
	public String helperList(SearchFilterVo searchFilterVo, Model model, HttpServletRequest request, HttpSession session) throws Exception {
		//세션에서 familyNo 받기
		session = request.getSession();
		FamilyVO familyVo = (FamilyVO) session.getAttribute("loginOk");
		searchFilterVo.setFamilyNo(familyVo.getFamilyNo());	
		
		//서비스 지역 한 문장으로 합치기
		String area1 = request.getParameter("helperWorkArea1");
		String area2 = request.getParameter("helperWorkArea2");
		String area = area1 + " " + area2;
		
		searchFilterVo.setHelperWorkArea(area);
		if(searchFilterVo.getHelperWorkArea() == null) {
			return "family/searchHelper/helperList";
		} else {
			List <Map> list = searchService.getSelectList(searchFilterVo);
			model.addAttribute("searchList", list);
			System.out.println(searchFilterVo);
		}
		
		return "family/searchHelper/helperList";
	}
	
	//조회된 간병인 상세정보
	@RequestMapping("helperInfo.do")
	public String memberInfo(@RequestParam("helperNo") String hNo, Model model, SearchFilterVo searchFilterVo, HttpServletRequest request) throws Exception {
		String helperNo = hNo;
		System.out.println(helperNo);
		
		//간병인 정보 셀렉트
		Map map = searchService.getSelect(helperNo);
		model.addAttribute("helperInfo", map);
		
		//간병인 후기 셀렉트
		List <Map> list = searchService.getSelectList2(helperNo);
		model.addAttribute("reviewList", list);
		
		//서비스 지역 한 문장으로 합치기
		String area1 = request.getParameter("helperWorkArea1");
		String area2 = request.getParameter("helperWorkArea2");
		String area = area1 + " " + area2;
		
		searchFilterVo.setHelperWorkArea(area);
		
		return "family/searchHelper/helperInfo";
	}
}
