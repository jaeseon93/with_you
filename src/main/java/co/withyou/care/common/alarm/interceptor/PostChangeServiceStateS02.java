package co.withyou.care.common.alarm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import co.withyou.care.common.alarm.service.AlarmService;
import co.withyou.care.common.alarm.service.AlarmVO;
import co.withyou.care.helper.confirm.service.ConfirmVo;

public class PostChangeServiceStateS02 extends HandlerInterceptorAdapter {
	
	@Autowired
	AlarmService alarmService;
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
		ModelMap modelMap = modelAndView.getModelMap();
		ConfirmVo vo = (ConfirmVo)modelMap.get("confirm");
		
		AlarmVO alarmVO = new AlarmVO();
		alarmVO.setAlarmType("AF02");
		alarmVO.setAlarmReceiverNo(vo.getFamilyNo());
		alarmVO.setAlarmSenderNo(vo.getHelperNo());
		alarmVO.setServiceNo(vo.getServiceNo());
		alarmService.insertAlarm(alarmVO);
		
	}
	
}
