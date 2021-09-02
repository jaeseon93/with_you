package co.withyou.care.patient.findload.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.withyou.care.patient.Login.service.PatientVO;
import co.withyou.care.patient.findload.service.FamilyVO;
import co.withyou.care.patient.findload.service.patientCallService;
import javafx.scene.web.WebView;



@Controller
public class patientFindLoadController {
	
	@Autowired
	patientCallService patientCallservice;
	
	@RequestMapping("/findload.do")
	public ModelAndView getTel(FamilyVO vo, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		PatientVO name =  (PatientVO) session.getAttribute("loginOk");
		
		vo.setFamilyNo(name.getFamilyNo());
		vo = patientCallservice.getSelect(vo);
		
		//환자 주소 가져오기
		String addr = name.getPatientAddr();
		System.out.println("환자주소 : "+addr);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("familyVO", vo);
		mav.addObject("patientVO", name);
		
		mav.setViewName("patient/main/patientTestLoadmap");
		
		return mav;		
	}	

//	public boolean shouldOverrideUrlLoading(WebView view, String url) {
//        if (url.startsWith("tel:")) {
//                Intent intent = new Intent(Intent.ACTION_DIAL,
//                        Uri.parse(url));
//                startActivity(intent);
//        }else if(url.startsWith("http:") || url.startsWith("https:")) {
//            view.loadUrl(url);
//        ﻿﻿}
//​​﻿​​﻿        return true;
//    }
//﻿​​﻿
//}

	
	
	
	
} // end of Class
