package co.withyou.care.helper.schedule.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import co.withyou.care.helper.Login.service.HelperVO;
import co.withyou.care.helper.schedule.service.ApplyVo;
import co.withyou.care.helper.schedule.service.ScheduleService;
import co.withyou.care.helper.schedule.service.ServiceHistoryVO;

@Controller
public class ScheduleController {
	@Autowired
	private ScheduleService scheduleService;
	

	@RequestMapping("/scheduleList.do")
	public ModelAndView scheduleList(ModelAndView mav, ApplyVo vo, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		HelperVO getSession = (HelperVO) session.getAttribute("loginOk");
		vo.setHelperNo(getSession.getHelperNo());
		
		if(vo.getServiceDate() ==null) {
			SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy-MM-dd");
			Date currentTime = new Date ();
			String mTime = mSimpleDateFormat.format ( currentTime );
			vo.setServiceDate(mTime);

		}
		List<Map> map = scheduleService.getSchedule(vo);
		
		mav.addObject("sceduleList", map);
		mav.setViewName("helper/Schedule/scheduleList");
		return mav;
	
	}

	@RequestMapping("/calendarList.do")
	@ResponseBody
	public List<Map> calendarList(ApplyVo vo, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		HelperVO getSession = (HelperVO) session.getAttribute("loginOk");
		vo.setHelperNo(getSession.getHelperNo());
		
		List<Map> list = scheduleService.getCaleadar(vo);	


		return list;

	}

	//상세보기
	@RequestMapping("/scheduleDetail.do")
	public ModelAndView scheduleDetail(@RequestParam("serviceNo") String sNo, ModelAndView mav, ApplyVo vo, HttpServletRequest request ) throws Exception {
		//파라미터 가져오기
		String serviceNo = sNo;
		System.out.println("서비스넘버"+sNo);
		HttpSession session = request.getSession();
		HelperVO getSession = (HelperVO) session.getAttribute("loginOk");
		vo.setHelperNo(getSession.getHelperNo());
		System.out.println("세션에있는 간병인번호:"+getSession.getHelperNo());
		
		Map detailMap = scheduleService.getSelect(serviceNo);
		mav.addObject("scheduleDetail", detailMap);
		mav.setViewName("helper/Schedule/scheduleDetail");
		
		
		return mav;
	
	}
	
	/**
	 * ServiceHistory에 데이터를 insert하고  내용을 다시 조회하여 가져옴. 
	 * insert 항목 serviceNo, realStartTime
	 * 
	 * @param vo
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping("/setStartTime.do")
	@ResponseBody
	public ServiceHistoryVO setStartTime(ServiceHistoryVO vo) throws Exception {
		scheduleService.insertStartTime(vo);
		vo = scheduleService.getStartTime(vo.getServiceNo());
		return vo;
	}	
	
	/**
	 * ServiceHistory에 데이터를 update하고 내용을 다시 조회해서 가져옴. 
	 * update 항목 realEndTime
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/setEndTime.do")
	@ResponseBody
	public ServiceHistoryVO setEndTime(ServiceHistoryVO vo) throws Exception {
		scheduleService.updateEndTime(vo);
		scheduleService.updateServiceStatus(vo.getServiceNo());
		vo = scheduleService.getEndTime(vo.getServiceNo());
		return vo;
	}	
	

	@RequestMapping("/getRealTimes.do")
	@ResponseBody
	public ServiceHistoryVO getRealTimes(ServiceHistoryVO vo) throws Exception {
		vo = scheduleService.getRealTimes(vo.getServiceNo());
		return vo;
	}	

	
} // end of Class
