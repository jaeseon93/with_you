package co.withyou.care.family.careFamily.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class careFamilyController {

	@RequestMapping("/careFamily.do")
	public String careFamilyMain() {
		return "family/careFamily/careFamilyMenu";
	}
}
