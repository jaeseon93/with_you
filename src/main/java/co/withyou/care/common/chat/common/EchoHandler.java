package co.withyou.care.common.chat.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import co.withyou.care.common.chat.service.ChatVo;

public class EchoHandler extends TextWebSocketHandler {
	
	@Autowired
	public ChatVo vo;
	
	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	private Map<String, WebSocketSession> map = new HashMap<String, WebSocketSession>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessionList.add(session);
		System.out.println("클라이언트 접속됨");
		
		Map<String, Object> maps = session.getAttributes();
		String familyNo = (String)maps.get("familyNo");
		
		map.put(familyNo, session);
		System.out.println("map에 담긴값 :" +map);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//		Map<String,Object> map = session.getAttributes();
//		String userLoc = (String)session.getId();
		
		String userLoc = (String)session.getAttributes().get("userLoc");
		System.out.println("httpsession :" +userLoc);
		System.out.println("WSsession : "+session);
		
//		InetAddress local = InetAddress.getLocalHost();
//		String userLoc = local.getHostAddress();
//		System.out.println("userLoc: " + userLoc);

			for(WebSocketSession sess: sessionList) {
				if (sess == session)
				sess.sendMessage(new TextMessage("나   : "+message.getPayload()));
				else {
					sess.sendMessage(new TextMessage(userLoc +" : "+message.getPayload()));
				}
			}
		
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessionList.remove(session);
		System.out.println("접속종료됨");
	}
	
	
}