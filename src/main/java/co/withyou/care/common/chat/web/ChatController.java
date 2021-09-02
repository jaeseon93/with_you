package co.withyou.care.common.chat.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.withyou.care.common.chat.service.ChatService;
import co.withyou.care.common.chat.service.ChatVo;
import co.withyou.care.family.Login.service.FamilyVO;
import co.withyou.care.helper.Login.service.HelperVO;

@Controller
public class ChatController {

	@Autowired
	public ChatService chatService;
	
	@RequestMapping("chat.do")
	public String chat(ChatVo chatVo, HttpServletRequest request, HttpSession session, Model model) throws Exception {
		
		//get userType from session
		session = request.getSession();
		String userType = (String) session.getAttribute("userType");
		chatVo.setUserType(userType);
		if (chatVo.getUserType().equals("f")) {
			//get familyNo from session
			FamilyVO familyVo = (FamilyVO) session.getAttribute("loginOk");
			chatVo.setFamilyNo(familyVo.getFamilyNo());
			
			//chatVo에 helperNo 항상 갖고 있게 하기 (페이지 새로고침시 필요 값)
			if(chatVo.getHelperNo() == 0) {
				chatVo.setHelperNo((Integer)session.getAttribute("chatHelperNo"));
			} else {
				session.setAttribute("chatHelperNo", chatVo.getHelperNo());
			}
		} else {
			//get helperNo from session
			HelperVO helperVo = (HelperVO) session.getAttribute("loginOk");
			chatVo.setHelperNo(helperVo.getHelperNo());
			
			//chatVo에 familyNo 항상 갖고 있게 하기 (페이지 새로고침시 필요 값)
			if(chatVo.getFamilyNo() == 0) {
				chatVo.setFamilyNo((Integer)session.getAttribute("chatFamilyNo"));
			} else {
				session.setAttribute("chatFamilyNo", chatVo.getFamilyNo());
			}
		}
		
		//체팅방 읽음 메시지 업데이트
		chatService.chatUpdate(chatVo);
		
		//채팅메시지 리스트 뿌려주는 셀렉트
		List <Map> list = chatService.chatSelectList(chatVo);
		model.addAttribute("chatList", list);
		System.out.println(list);
		
		//접속자 유형에 따라 리턴페이지 경로 구분
		if (chatVo.getUserType().equals("f")) {
			return "family/chat/chatTest";
		} else {
			return "helper/chat/chatTest";
		} 
	}
	
	@RequestMapping("chatInsert.do")
	public String chatInsert (ChatVo chatVo, HttpServletRequest request, HttpSession session, Model model) throws Exception {
		//get userType from session
			session = request.getSession();
			String userType = (String) session.getAttribute("userType");
			chatVo.setUserType(userType);
			if (chatVo.getUserType().equals("f")) {
				//get familyNo from session
				FamilyVO familyVo = (FamilyVO) session.getAttribute("loginOk");
				chatVo.setFamilyNo(familyVo.getFamilyNo());
			} else {
				//get helperNo from session
				HelperVO helperVo = (HelperVO) session.getAttribute("loginOk");
				chatVo.setHelperNo(helperVo.getHelperNo());
			}
		
		//msg insert into DB table name 'CHAT'
		System.out.println("insert chat vo:" + chatVo);
		chatService.chatInsert(chatVo);

		//알람을 위해 값을 전달함
		model.addAttribute("chatVo", chatVo);
		
		//유저타입에 따라 필요한 값 물려서 페이지 리다이렉트
//		if (chatVo.getUserType().equals("f")) {
//			return "redirect:/chat.do?helperNo="+chatVo.getHelperNo();
//		} else {
//			return "redirect:/chat.do";
//		} 
				
		return "redirect:/chat.do";
	}
	
}
