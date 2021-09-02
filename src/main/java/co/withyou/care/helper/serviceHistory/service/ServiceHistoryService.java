package co.withyou.care.helper.serviceHistory.service;

import java.util.List;
import java.util.Map;

public interface ServiceHistoryService {
	List<Map> getList(ServiceHistoryVo historyVO) throws Exception;
	Map getSelect (String serviceNo) throws Exception;
}
