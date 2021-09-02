package co.withyou.care.common.alarm.web;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.withyou.care.common.alarm.service.AlarmService;
import co.withyou.care.family.Login.service.FamilyVO;
import co.withyou.care.helper.Login.service.HelperVO;

@Controller
public class AlarmController {

	@Autowired
	AlarmService alarmService;
	
	@RequestMapping(value = "/getAlarmCount.do")
	@ResponseBody
	public int getAlarmCount(Model model, HttpSession session, HttpServletRequest request) {
		session = request.getSession();
		String type = (String)session.getAttribute("userType");
		int result=0;
		if(type != null) {
			if(type.equals("f")) {
				FamilyVO vo = (FamilyVO)session.getAttribute("loginOk");
				result  = alarmService.getAlarmCount(vo.getFamilyNo());
			} else if (type.equals("h")) {
				HelperVO vo = (HelperVO)session.getAttribute("loginOk");
				result  = alarmService.getAlarmCount(vo.getHelperNo());
			}
		}
		return result;
	}
	
	
	@RequestMapping(value = "/getAlarmList.do")
	public String getAlarmList(Model model, HttpSession session, HttpServletRequest request) {
		session = request.getSession();
		String type = (String)session.getAttribute("userType");
		
		if(type.equals("f")) {
			FamilyVO vo = (FamilyVO)session.getAttribute("loginOk");
			List<Map> list = alarmService.getAlarmListFamily(vo.getFamilyNo());
			Map map = alarmService.getPatientName(vo.getFamilyNo());
			alarmService.updateAlarmCheck(vo.getFamilyNo());
			model.addAttribute("list", list);
			model.addAttribute("map", map);
			return "family/alarm/alarmList";
		} else if (type.equals("h")) {
			HelperVO vo = (HelperVO)session.getAttribute("loginOk");
			List<Map> list = alarmService.getAlarmListHelper(vo.getHelperNo());
			alarmService.updateAlarmCheck(vo.getHelperNo());
			model.addAttribute("list", list);
			return "helper/alarm/alarmList";
		}
		
		return "";
	}
}
