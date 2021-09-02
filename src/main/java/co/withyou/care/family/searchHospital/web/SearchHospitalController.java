package co.withyou.care.family.searchHospital.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.withyou.care.family.searchHospital.service.SearchHospitalService;
import co.withyou.care.family.searchHospital.service.SearchHospitalVo;
import co.withyou.care.hospital.GwangMyeong.service.HospitalVo;

@Controller
public class SearchHospitalController {
	
	@Autowired
	private SearchHospitalService search;
	
	@RequestMapping("/searchHospital.do")
	public String SearchHospital(HttpServletRequest request,SearchHospitalVo vo,Model model) throws Exception {
		String Search = request.getParameter("search");
		vo.setSearchKey(Search);
		System.out.println("SearchKey :"+vo.getSearchKey());
		List<Map> list = search.selectList(vo);
		model.addAttribute("selectList",list);
		return "family/hospital/Hospital";
				
	}
}
