package co.withyou.care.common.alarm.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import co.withyou.care.common.alarm.service.AlarmVO;

@MapperScan
public interface AlarmMapper {
	int getAlarmCount(int no);
	Map getPatientName(int no);
	List<Map> getAlarmListFamily(int no);
	List<Map> getAlarmListHelper(int no);
	void insertAlarm(AlarmVO vo);
	void updateAlarmCheck(int no);
}
