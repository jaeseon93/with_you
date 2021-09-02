package co.withyou.care.common.alarm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import co.withyou.care.common.alarm.service.AlarmService;
import co.withyou.care.common.alarm.service.AlarmVO;

public class PreOutOfTheArea extends HandlerInterceptorAdapter {
	
	@Autowired
	AlarmService alarmService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		AlarmVO alarmVO = new AlarmVO();
		alarmVO.setAlarmType("AF01");
		alarmVO.setAlarmReceiverNo(Integer.parseInt(request.getParameter("familyNo")));
		alarmVO.setAlarmSenderNo(Integer.parseInt(request.getParameter("patientNo")));
		alarmService.insertAlarm(alarmVO);
		return true;
	}
}
