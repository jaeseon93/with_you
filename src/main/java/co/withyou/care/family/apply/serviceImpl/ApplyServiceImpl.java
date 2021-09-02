package co.withyou.care.family.apply.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import co.withyou.care.family.apply.mapper.ApplyMapper;
import co.withyou.care.family.apply.service.ApplyService;
import co.withyou.care.family.apply.service.ApplyServiceVo;

@Service
@Primary
public class ApplyServiceImpl implements ApplyService{

	@Autowired
	public ApplyMapper applyMap;

	@Override
	public void applyResultInsert(ApplyServiceVo applyVo) throws Exception {
		applyMap.applyResultInsert(applyVo);
	}

	@Override
	public List<Map> getSelectList(ApplyServiceVo applyVo) throws Exception {
		return applyMap.getSelectList(applyVo);
	}

	@Override
	public Map getSelect(String serviceNo) throws Exception {
		return applyMap.getSelect(serviceNo);
	}

	@Override
	public Map getSelect2(String serviceNo) throws Exception {
		return applyMap.getSelect2(serviceNo);
	}

	@Override
	public Map getSelect3(String serviceNo) throws Exception {
		return applyMap.getSelect3(serviceNo);
	}

	@Override
	public Map getSelect4(ApplyServiceVo applylVo) throws Exception {
		return applyMap.getSelect4(applylVo);
	}

	@Override
	public Map getSelect5(ApplyServiceVo applylVo) throws Exception {
		return applyMap.getSelect5(applylVo);
	}

	@Override
	public int getSelectLatest(ApplyServiceVo applyVo) throws Exception {
		return applyMap.getSelectLatest(applyVo);
	}
	
}
