package co.withyou.care.common.chat.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import co.withyou.care.common.chat.mapper.ChatMapper;
import co.withyou.care.common.chat.service.ChatService;
import co.withyou.care.common.chat.service.ChatVo;

@Service
@Primary
public class ChatServiceImpl implements ChatService{

	@Autowired
	public ChatMapper chatMap;

	@Override
	public void chatInsert(ChatVo chatVo) throws Exception {
		// TODO Auto-generated method stub
		chatMap.chatInsert(chatVo);
	}

	@Override
	public List <Map> chatSelectList(ChatVo chatVo) throws Exception {
		// TODO Auto-generated method stub
		return chatMap.chatSelectList(chatVo);
	}

	@Override
	public void chatUpdate(ChatVo chatVo) throws Exception {
		// TODO Auto-generated method stub
		chatMap.chatUpdate(chatVo);
	}
}
