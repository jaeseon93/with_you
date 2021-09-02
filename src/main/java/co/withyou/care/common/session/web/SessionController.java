package co.withyou.care.common.session.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SessionController {
	
	@RequestMapping("/sessionAlert.do")
	public String sessionAlert() {
		return "common/session/sessionAlert";
	}
}
