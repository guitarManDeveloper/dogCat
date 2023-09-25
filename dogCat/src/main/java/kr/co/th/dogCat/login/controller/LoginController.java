package kr.co.th.dogCat.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.th.dogCat.login.service.LoginService;
import kr.co.th.dogCat.login.vo.LoginVO;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;

	@RequestMapping("/loginView") 
	public String loginView(@ModelAttribute("loginVO") LoginVO loginVO) {
		
		return "dogCat/login/loginView";
	}
	
	@RequestMapping("/login") 
	public String login(@ModelAttribute("loginVO") LoginVO loginVO, HttpServletRequest request) throws Exception{
		
		//검사
		//입력한 아이디랑 비밀번호 
		
		//사용자가 입력한 아이디, 비밀번호
		//String userId = loginVO.getUserId(); //아이디
		//String userPw = loginVO.getUserPw(); //비밀번호
		
		//사용자가 입력한 아이디와 비밀번호를 가지고 정보를 조회하는 서비스
		LoginVO resultVO = loginService.selectLogin(loginVO);
		
		if(resultVO == null) {
			//로그인실패
			return "redirect:/loginView?message=LoginFail";
		}
		
		//로그인정보 세션에 담기
		request.getSession().setAttribute("loginVO", resultVO);
		
		return "redirect:/adoptList";
	}
	
	
	
	
	
	
	
}
