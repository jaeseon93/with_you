package co.withyou.care.common.signUp.web;



import java.io.File;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import co.withyou.care.common.signUp.service.FamilyVO;
import co.withyou.care.common.signUp.service.HelperVO;
import co.withyou.care.common.signUp.service.PatientVO;
import co.withyou.care.common.signUp.service.SignUpService;


@Controller
public class SignUpController {
	
	@Autowired
	public SignUpService signUpService;

	/**
	 * 보호자 회원가입 폼으로 이동
	 */
	@RequestMapping(value = "/signUpFormFamily.do")
	public String goFormFamily() {
		return "family/signUp/formFamily";
	}
	/**
	 * 간병인 회원가입 폼으로 이동
	 */
	@RequestMapping(value = "/signUpFormHelper.do")
	public String goFormHelper() {
		return "helper/signUp/formHelper";
	}

	/**
	 * 주소 조회
	 */
	@RequestMapping(value = "/jusoPopup.do")
	public String jusoPopup() {
		return "common/addr/jusoPopup";
	}

	/**
	 * 보호자 아이디 중복확인
	 */
	@RequestMapping(value = "/checkEmail.do")
	@ResponseBody
	public int checkEmail(FamilyVO fVO, HelperVO hVO) throws Exception {
		int result = 0;
		if(fVO.getFamilyEmail() != null) {
			result = signUpService.checkEmailFamily(fVO);
		}else if(hVO.getHelperEmail() != null) {
			result = signUpService.checkEmailHelper(hVO);
		}
		return result;
	}
	
	/**
	 * 보호자.환자정보 추가
	 */
	@RequestMapping(value = "/createMemberFamily.do")
	public String createMemberFamily(FamilyVO fVO, PatientVO pVO, HttpServletRequest request, Model model) throws Exception {
		String familyBirth = request.getParameter("familyBirthY") + "-" 
							+ request.getParameter("familyBirthM") + "-"
							+ request.getParameter("familyBirthD");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		fVO.setFamilyBirth(df.parse(familyBirth));
		
		String patientBirth = request.getParameter("patientBirthY") + "-" 
							+ request.getParameter("patientBirthM") + "-"
							+ request.getParameter("patientBirthD");
		pVO.setPatientBirth(df.parse(patientBirth));
		
		String code = signUpService.insertFamilyAndPatient(fVO, pVO);
		model.addAttribute("code", code);
		return "family/signUp/result";
	}
	
	/**
	 * 간병인 정보 추가
	 */
	@RequestMapping(value = "/createMemberHelper.do")
	public String createMemberHelper(HelperVO hVO, HttpServletRequest request, Model model) throws Exception {
		String helperBirth = request.getParameter("helperBirthY") + "-" 
							+ request.getParameter("helperBirthM") + "-"
							+ request.getParameter("helperBirthD");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		hVO.setHelperBirth(df.parse(helperBirth));
		
		String area1 = request.getParameter("helperWorkArea1");
		String area2 = request.getParameter("helperWorkArea2");
		String area = area1 + " " + area2;
		hVO.setHelperWorkArea(area);
		
		//첨부파일 업로드 처리
		MultipartFile uploadFile = hVO.getUploadFile();
		String fileName = null;
		if(uploadFile !=null && !uploadFile.isEmpty() && uploadFile.getSize()>0) {
		fileName = uploadFile.getOriginalFilename();
		String path = request.getServletContext().getRealPath("/");
		String attachPath = "resources/upload/";
		uploadFile.transferTo(new File( path + attachPath +  fileName));		
		
		}
		
		hVO.setHelperProfile(fileName);
		
		signUpService.insertHelper(hVO);
		return "helper/signUp/result";
	}		
}
