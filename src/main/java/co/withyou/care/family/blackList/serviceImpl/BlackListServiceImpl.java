package co.withyou.care.family.blackList.serviceImpl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import co.withyou.care.family.bestLike.mapper.BestLikeMapper;
import co.withyou.care.family.bestLike.service.BestLikeService;
import co.withyou.care.family.bestLike.service.BestLikeVo;
import co.withyou.care.family.blackList.mapper.BlackListMapper;
import co.withyou.care.family.blackList.service.BlackListService;
import co.withyou.care.family.blackList.service.BlackListVo;

@Service
@Primary
public class BlackListServiceImpl implements BlackListService{

	@Autowired
	public BlackListMapper blackListMap;

	@Override
	public void blackListInsert(BlackListVo blackListVo) throws Exception {
		// TODO Auto-generated method stub
		blackListMap.blackListInsert(blackListVo);
	}

	@Override
	public void blackListDelete(BlackListVo blackListVo) throws Exception {
		// TODO Auto-generated method stub
		blackListMap.blackListDelete(blackListVo);
	}

	@Override
	public List<Map> getSelectList(BlackListVo blackListVo) throws Exception {
		// TODO Auto-generated method stub
		return blackListMap.getSelectList(blackListVo);
	}

	
}
