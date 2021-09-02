package co.withyou.care.admin;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import co.withyou.care.admin.service.AdminService;
import co.withyou.care.admin.vo.AdminVO;

//1.
@Controller // 현재 클래스를 스프링에서 관리하는 컨트롤러 bean으로 생성
// 모든맵핑은 /admin/를 상속
public class AdminController {
    // 로깅을 위한 변수
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    
    @Autowired
    AdminService adminService;
    
    // 01. 로그인 화면 
    @RequestMapping("adminlogin.do")
    public String login(HttpServletRequest request, ModelMap model){
    	
        return "admin/adminlogin";    // views/admin /login.jsp로 포워드
    }
    
    // 02. 로그인 처리
    @RequestMapping(value = "adminloginCheck.do") //, method=RequestMethod.POST)
    public ModelAndView loginCheck(@ModelAttribute AdminVO vo, HttpSession session) throws Exception{
        
    	System.out.println();
    	boolean result = adminService.loginCheck(vo, session);
        
    	
        ModelAndView mav = new ModelAndView();
        if (result == true) { // 로그인 성공
            // main.로 이동
            mav.setViewName("redirect:ad_home.do");
            mav.addObject("msg", "success");
        } else {    // 로그인 실패
            // login.jsp로 이동
            mav.setViewName("admin/adminlogin");
            mav.addObject("msg", "failure");
        }
        return mav;
    }
    
    // 03. 로그아웃 처리
    @RequestMapping("adminlogout.do")
    public ModelAndView logout(HttpSession session){
        adminService.logout(session);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/adminlogin");
        mav.addObject("msg", "logout");
        return mav;
    }
    
    //관리자 페이지홈으로가기
    @RequestMapping("ad_home.do")
	public String ad_home(Locale locale,Model model) {
		
    	return "admin/admin-layout/ad_home";
}
    //헬퍼조회컨트롤
    /*@RequestMapping("/adminhelperList.do")
      public String adminhelperlist(Locale locale, Model model){
         
      	return "admin/helper/adminhelperList";
      }	 */  
}

