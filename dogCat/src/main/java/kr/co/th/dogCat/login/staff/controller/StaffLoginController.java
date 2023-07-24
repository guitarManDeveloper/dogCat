package kr.co.th.dogCat.login.staff.controller;

import kr.co.th.dogCat.login.staff.service.StaffLoginService;
import kr.co.th.dogCat.login.staff.vo.StaffLoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StaffLoginController {

    @Autowired
    StaffLoginService staffLoginService;

    @RequestMapping(value = "/staffLoginView")
    public String staffLoginView(@ModelAttribute("staffLoginVO") StaffLoginVO staffLoginVO, HttpServletRequest request)throws Exception{
        //접근가능 아이피체크

        return "dogCat/login/staff/staffLoginView";
    }
}
