package co.withyou.care.common.alarm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import co.withyou.care.common.alarm.service.AlarmService;
import co.withyou.care.common.alarm.service.AlarmVO;
import co.withyou.care.common.geoLocation.service.GeoLocationService;
import co.withyou.care.common.geoLocation.service.PatientLocVO;

public class PreHelperLeave extends HandlerInterceptorAdapter {
	
	@Autowired
	AlarmService alarmService;
	
	int RANGE = 100;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		int familyNo = Integer.parseInt(request.getParameter("familyNo"));
		int serviceNo = Integer.parseInt(request.getParameter("serviceNo"));
		int helperNo = Integer.parseInt(request.getParameter("helperNo"));
		
		
		
		
		
		
		AlarmVO alarmVO = new AlarmVO();
		alarmVO.setAlarmType("AF06");
		alarmVO.setAlarmReceiverNo(familyNo);
		alarmVO.setAlarmSenderNo(helperNo);
		alarmVO.setServiceNo(serviceNo);
		alarmService.insertAlarm(alarmVO);
		return true;
	}
}
