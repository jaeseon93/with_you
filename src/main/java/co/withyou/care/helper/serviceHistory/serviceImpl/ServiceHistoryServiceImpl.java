package co.withyou.care.helper.serviceHistory.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.withyou.care.helper.serviceHistory.mapper.ServiceHistoryMapper;
import co.withyou.care.helper.serviceHistory.service.ServiceHistoryService;
import co.withyou.care.helper.serviceHistory.service.ServiceHistoryVo;

@Service("historyService")
public class ServiceHistoryServiceImpl implements ServiceHistoryService {

	@Autowired
	public ServiceHistoryMapper historyMap;
	
	
	@Override
	public List<Map> getList(ServiceHistoryVo historyVO) throws Exception {
		return historyMap.getList(historyVO);
	}


	@Override
	public Map getSelect(String serviceNo) throws Exception {
		return historyMap.getSelect(serviceNo);
	}
	

}
