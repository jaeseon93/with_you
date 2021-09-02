package co.withyou.care.common.alarm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import co.withyou.care.common.alarm.service.AlarmService;
import co.withyou.care.common.alarm.service.AlarmVO;
import co.withyou.care.family.apply.service.ApplyServiceVo;

public class PostchangeServiceStateS01 extends HandlerInterceptorAdapter {

	@Autowired
	AlarmService alarmService;
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
		ModelMap modelMap = modelAndView.getModelMap();
		ApplyServiceVo vo = (ApplyServiceVo)modelMap.get("applyVo");
		System.out.println(vo);
		
		AlarmVO alarmVO = new AlarmVO();
		alarmVO.setAlarmType("AH01");
		alarmVO.setAlarmReceiverNo(vo.getHelperNo());
		alarmVO.setAlarmSenderNo(vo.getFamilyNo());
		alarmVO.setServiceNo(vo.getServiceNo());
		alarmService.insertAlarm(alarmVO);
		
	}
}
