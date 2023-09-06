package kr.co.th.dogCat.adopt.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import kr.co.th.dogCat.adopt.service.AdoptService;
import kr.co.th.dogCat.adopt.vo.AdoptVO;

@Controller
public class AdoptController {
	@Autowired
	AdoptService adoptService;
	
	//분양목록화면
	@RequestMapping("/adoptList")
	public String adoptList(@ModelAttribute("adoptVO") AdoptVO adoptVO, ModelMap model) throws Exception {		
		//상품목록조회
		List<AdoptVO> adoptList =  adoptService.adoptList(adoptVO);
		model.addAttribute("adoptList",adoptList);
		
		
		//총 카운터 수
		int totalCnt = adoptService.selectAdoptTotalCnt(adoptVO);
		int totalPage = (int)Math.ceil((double)totalCnt/adoptVO.getPageSize());
		
		
		model.addAttribute("totalCnt",totalCnt);
		model.addAttribute("totalPage",totalPage);
		model.addAttribute("currentPage",adoptVO.getPage());
		
		return "dogCat/adopt/adoptList";
	}

	
	//상세화면
	@RequestMapping("/adoptView")
	public String adoptView(@ModelAttribute("adoptVO") AdoptVO adoptVO, ModelMap model) {
		AdoptVO adopt =  adoptService.detail(adoptVO);
		model.addAttribute("adopt",adopt);
		return "dogCat/adopt/adoptView";
	}
	

	/**
	 * 상품 삭제처리
	 * @param map
	 * @return redirect:/selectItemList
	 * @throws Exception
	 */
	@RequestMapping("/deleteAdopt")
	public String deleteAdopt(@RequestParam Map<String, Object> map) throws Exception {
		try {
			//상품삭제
			adoptService.delete(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/adoptList";
	}
	
	@RequestMapping(value = "/createAdopt" ,method = RequestMethod.GET)
	public ModelAndView createAdopt(@ModelAttribute("adoptVO")AdoptVO adoptVO) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("dogCat/adopt/adoptCreate");
		return mv;
	}

	@RequestMapping(value = "/createAdopt",method = RequestMethod.POST)
	public ModelAndView createAdopt(@ModelAttribute("adoptVO") AdoptVO adoptVO, ModelMap model,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		//상품등록
		try {
			adoptService.insert(adoptVO, request);
			mav.setViewName("redirect:/adoptList");
		} catch (Exception e) {
			e.printStackTrace();
			//등록실패
			mav.setViewName("redirect:/adoptList");
			return mav;
		}
		return mav;
	}
	
	
	
}
