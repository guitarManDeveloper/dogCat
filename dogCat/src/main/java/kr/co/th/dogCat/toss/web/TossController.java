package kr.co.th.dogCat.toss.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.th.dogCat.adopt.vo.AdoptVO;
import kr.co.th.dogCat.toss.service.Toss;

@Controller
public class TossController {
	
	@RequestMapping("/tossIndex")
	public String tossIndex(@ModelAttribute("toss") Toss toss,HttpServletRequest request, ModelMap model) throws Exception {	
		
		System.out.println("price =============>>" +toss.getPrice());
        return "toss/tossIndex";
	}
	
	@RequestMapping("/migSave")
	public String migSave(@ModelAttribute("toss") Toss toss,HttpServletRequest request, ModelMap model) throws Exception {	
		
		
        return "toss/testInput";
	}
	
	
}	
