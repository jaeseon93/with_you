package co.withyou.care.family.patientLine.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.withyou.care.common.geoLocation.service.PatientLocVO;
import co.withyou.care.family.patientLine.service.PatientLineService;

@Controller
public class PatientLineController {
	@Autowired
	public PatientLineService pservice;

	@RequestMapping("/patientGetLine.do")
	public String GpsList(HttpServletRequest request,PatientLocVO vo,  Model model) throws Exception {
		// int a = request.getParameter("아이디");
		
		// jsp의 name 태그가 vo의 파라미터이름과같으면 자동으로 입력"2020-12-123"
		String LocDate = request.getParameter("Loctime");
		System.out.println("LocDate : "+LocDate);
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date to = transFormat.parse(LocDate);
		vo.setPatientLoctime(to);
		System.out.println("to :"+to);
		System.out.println("patientLocTime : "+vo.getPatientLoctime());
		// 값을 받고 -> 변환->vo 입력
		// vo.set
		List<Map> list = pservice.getGpsList(vo);
		model.addAttribute("GpsLine",new ObjectMapper().writeValueAsString(list));
		return "family/PatientLine/PatientLine";
	}

	@RequestMapping("/todayLine.do")
	public String TodateLine(PatientLocVO vo,Model model) throws Exception {
		List<Map>list = pservice.getTodayLine(vo);
		model.addAttribute("todayLine",new ObjectMapper().writeValueAsString(list));
		
		return "family/PatientLine/PatientLineSearch";

	}
	
	@RequestMapping("/sevenLine.do")
	public String SevenLine(PatientLocVO vo,Model model) throws Exception{
		List<Map>list = pservice.getSevenLine(vo);
		model.addAttribute("sevenLine",new ObjectMapper().writeValueAsString(list));
		return "family/PatientLine/PatientSevenLine";
		
	}
}
