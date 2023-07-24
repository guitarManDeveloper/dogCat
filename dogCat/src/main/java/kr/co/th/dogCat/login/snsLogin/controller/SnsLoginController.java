package kr.co.th.dogCat.login.snsLogin.controller;

import kr.co.th.dogCat.login.snsLogin.service.SnsLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SnsLoginController {

    @Autowired
    SnsLoginService snsLoginService;

    @RequestMapping(value = "/kakaoLogin")
    public ModelAndView modifyItemView(@RequestParam String code, HttpServletRequest request)throws Exception{
        //인가코드
        System.out.println("kakaoLogin code = " + code);

        //인가코드를 이용해서 토근값 가져오기
        String token = snsLoginService.getToken(code);

        //토큰을 이용해서 사용자정보가져오기
        snsLoginService.getKakaoUserInfo(token,request);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/");
        return mv;
    }
}
