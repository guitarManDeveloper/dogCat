package kr.co.th.dogCat.adopt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import kr.co.th.dogCat.adopt.service.AdoptService;
import kr.co.th.dogCat.adopt.vo.AdoptVO;

@Controller
public class AdoptController {
	@Autowired
	AdoptService adoptService;
	
	//분양목록화면
	@RequestMapping("/adoptList")
	public String adoptList(@ModelAttribute("adoptVO") AdoptVO adoptVO, ModelMap model) {		
		//상품목록조회
		List<AdoptVO> adoptList =  adoptService.adoptList(adoptVO);
		model.addAttribute("adoptList",adoptList);
		    
		return "dogCat/adopt/adoptList";
	}
	
	
	
	
	
	
	
	//상세화면
	@RequestMapping("/adoptView")
	public String adoptView(ModelMap model) {		
		return "dogCat/adopt/adoptView";
	}
	
}
