package co.withyou.care.family.patientLoc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.withyou.care.common.geoLocation.service.PatientLocVO;
import co.withyou.care.family.patientLoc.service.PatientLocService;

@Controller
public class PatientLocController {
	@Autowired
	private PatientLocService locService;
		
	@RequestMapping("/patientLoc.do")
	public String LocGetSelect(PatientLocVO vo,Model model) throws Exception {
		vo = locService.getLoc(vo);
		model.addAttribute("getLoc",vo);
		return "family/patientLoc/PatientLoc";
	}
}
