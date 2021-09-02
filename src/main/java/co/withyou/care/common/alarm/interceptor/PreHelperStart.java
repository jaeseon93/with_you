package co.withyou.care.common.alarm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import co.withyou.care.common.alarm.service.AlarmService;
import co.withyou.care.common.alarm.service.AlarmVO;
import co.withyou.care.helper.Login.service.HelperVO;

public class PreHelperStart extends HandlerInterceptorAdapter {
	
	@Autowired
	AlarmService alarmService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		HelperVO helperVo = (HelperVO) session.getAttribute("loginOk");
		
		AlarmVO alarmVO = new AlarmVO();
		alarmVO.setAlarmType("AF04");
		alarmVO.setAlarmReceiverNo(Integer.parseInt(request.getParameter("familyNo")));
		alarmVO.setAlarmSenderNo(helperVo.getHelperNo());
		alarmVO.setServiceNo(Integer.parseInt(request.getParameter("serviceNo")));
		alarmService.insertAlarm(alarmVO);
		return true;
	}
}
