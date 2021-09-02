package co.withyou.care.helper.schedule.service;

import java.util.List;
import java.util.Map;


public interface ScheduleService {
	List<Map> getSchedule(ApplyVo vo) throws Exception;
	List<Map> getCaleadar(ApplyVo vo) throws Exception;
	Map getSelect (String serviceNo) throws Exception;
	ServiceHistoryVO getStartTime(int no);
	ServiceHistoryVO getEndTime(int no);
	ServiceHistoryVO getRealTimes(int no);
	
	int insertStartTime(ServiceHistoryVO vo);
	int updateEndTime(ServiceHistoryVO vo);
	int updateServiceStatus(int serviceNo);
}
