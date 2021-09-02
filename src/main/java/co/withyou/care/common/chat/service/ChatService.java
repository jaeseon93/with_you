package co.withyou.care.common.chat.service;

import java.util.List;
import java.util.Map;


public interface ChatService {

	public void chatInsert(ChatVo chatVo) throws Exception;
	List <Map> chatSelectList(ChatVo chatVo) throws Exception;
	public void chatUpdate(ChatVo chatVo) throws Exception;
}
