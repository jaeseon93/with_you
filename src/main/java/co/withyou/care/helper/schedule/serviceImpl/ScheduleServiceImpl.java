package co.withyou.care.helper.schedule.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.withyou.care.helper.schedule.mapper.ScheduleMapper;
import co.withyou.care.helper.schedule.service.ApplyVo;
import co.withyou.care.helper.schedule.service.ScheduleService;
import co.withyou.care.helper.schedule.service.ServiceHistoryVO;

@Service("scheduleService")
public class ScheduleServiceImpl implements ScheduleService{
	
	@Autowired
	public ScheduleMapper map;
	
	@Override
	public List<Map> getSchedule(ApplyVo vo) throws Exception {
		
		return map.getSchedule(vo);
	}

	@Override
	public Map getSelect(String serviceNo) throws Exception {
		return map.getSelect(serviceNo);
	}

	@Override
	public List<Map> getCaleadar(ApplyVo vo) throws Exception {
		// TODO Auto-generated method stub
		return map.getCaleadar(vo);
	}
	
	@Override
	public int insertStartTime(ServiceHistoryVO vo) {
		return map.insertStartTime(vo);
	}

	@Override
	public int updateEndTime(ServiceHistoryVO vo) {
		return map.updateEndTime(vo);
	}

	@Override
	public ServiceHistoryVO getStartTime(int no) {
		return map.getStartTime(no);
	}

	@Override
	public ServiceHistoryVO getEndTime(int no) {
		return map.getEndTime(no);
	}

	@Override
	public ServiceHistoryVO getRealTimes(int no) {
		return map.getRealTimes(no);
	}

	@Override
	public int updateServiceStatus(int serviceNo) {
		return map.updateServiceStatus(serviceNo);
	}
}
