package co.withyou.care.family.bestLike.service;

import java.util.List;
import java.util.Map;

public interface BestLikeService {
	public void bestLikeInsert(BestLikeVo bestLikeVo) throws Exception;
	public void bestLikeDelete(BestLikeVo bestLikeVo) throws Exception;
	List <Map> getSelectList(BestLikeVo bestLikeVo) throws Exception;
	
}
