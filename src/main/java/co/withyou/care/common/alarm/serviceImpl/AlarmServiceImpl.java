package co.withyou.care.common.alarm.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.withyou.care.common.alarm.mapper.AlarmMapper;
import co.withyou.care.common.alarm.service.AlarmService;
import co.withyou.care.common.alarm.service.AlarmVO;

@Service("alarmService")
public class AlarmServiceImpl implements AlarmService {

	@Autowired
	AlarmMapper map;
	
	
	
	@Override
	public List<Map> getAlarmListHelper(int no) {
		return map.getAlarmListHelper(no);
	}



	@Override
	public void updateAlarmCheck(int no) {
		map.updateAlarmCheck(no);
	}



	@Override
	public Map getPatientName(int no) {
		return map.getPatientName(no);
	}



	@Override
	public List<Map> getAlarmListFamily(int no) {
		return map.getAlarmListFamily(no);
	}



	@Override
	public int getAlarmCount(int no) {
		return map.getAlarmCount(no);
	}



	@Override
	public void insertAlarm(AlarmVO vo) {
		map.insertAlarm(vo);
	}

}
