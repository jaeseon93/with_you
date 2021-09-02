package co.withyou.care.common.alarm.service;

import java.util.List;
import java.util.Map;

public interface AlarmService {
	int getAlarmCount(int no);
	Map getPatientName(int no);
	List<Map> getAlarmListFamily(int no);
	List<Map> getAlarmListHelper(int no);
	void insertAlarm(AlarmVO vo);
	void updateAlarmCheck(int no);
}
