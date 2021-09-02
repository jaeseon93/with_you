package co.withyou.care.common.alarm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import co.withyou.care.common.alarm.service.AlarmService;
import co.withyou.care.common.alarm.service.AlarmVO;
import co.withyou.care.common.pay.service.PayVo;

public class PostChangeServiceStateS03 extends HandlerInterceptorAdapter {
	
	@Autowired
	AlarmService alarmService;
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);

		ModelMap modelMap = modelAndView.getModelMap();
		
		AlarmVO alarmVO = new AlarmVO();
		alarmVO.setAlarmType("AH02");
		alarmVO.setAlarmReceiverNo(Integer.parseInt((String)modelMap.get("helperNo")));
		alarmVO.setAlarmSenderNo(Integer.parseInt((String)modelMap.get("familyNo")));
		alarmVO.setServiceNo(Integer.parseInt((String)modelMap.get("serviceNo")));
		alarmService.insertAlarm(alarmVO);
		
	}

}
