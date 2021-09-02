package co.withyou.care.family.voiceMsg;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecordVoiceMsgController {

	@RequestMapping("/recordVoiceMsg.do")
	public String recordVoiceMsg(Model model) throws Exception {
		
		return "family/voiceMsg/recordVoiceMsg";
	}
	
}
