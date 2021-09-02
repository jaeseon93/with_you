package co.withyou.care.common.alarm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import co.withyou.care.common.alarm.service.AlarmService;
import co.withyou.care.common.alarm.service.AlarmVO;
import co.withyou.care.common.chat.service.ChatVo;

public class PostInsertMsg extends HandlerInterceptorAdapter {

	@Autowired
	AlarmService alarmService;
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		super.postHandle(request, response, handler, modelAndView);
		
		ModelMap modelMap = modelAndView.getModelMap();
		ChatVo vo = (ChatVo)modelMap.get("chatVo");
		
		HttpSession session = request.getSession();
		String userType = (String) session.getAttribute("userType");
		
		AlarmVO alarmVO = new AlarmVO();
		
		if (userType.equals("f")) {
			alarmVO.setAlarmType("AH03");
			alarmVO.setAlarmReceiverNo(vo.getHelperNo());
			alarmVO.setAlarmSenderNo(vo.getFamilyNo());
		} else {
			alarmVO.setAlarmType("AF03");
			alarmVO.setAlarmReceiverNo(vo.getFamilyNo());
			alarmVO.setAlarmSenderNo(vo.getHelperNo());
		}
		
		alarmService.insertAlarm(alarmVO);
	}
}
