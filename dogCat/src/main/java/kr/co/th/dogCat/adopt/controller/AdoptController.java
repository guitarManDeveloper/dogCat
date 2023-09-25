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
import kr.co.th.dogCat.login.vo.LoginVO;

@Controller
public class AdoptController {
	@Autowired
	AdoptService adoptService;
	
	
	
	//분양목록화면
	@RequestMapping("/adoptList")
	public String adoptList(@ModelAttribute("adoptVO") AdoptVO adoptVO, ModelMap model, HttpServletRequest request) throws Exception {	
		
		if(adoptVO.getViewType().equals("photo")){
			adoptVO.setPageSize(8);
		}
		
		//상품목록조회
		List<AdoptVO> adoptList =  adoptService.adoptList(adoptVO);
		model.addAttribute("adoptList",adoptList);
		

		
		//총 카운터 수
		int totalCnt = adoptService.selectAdoptTotalCnt(adoptVO);
		int totalPage = (int)Math.ceil((double)totalCnt/adoptVO.getPageSize());
		
		
		model.addAttribute("totalCnt",totalCnt);
		model.addAttribute("totalPage",totalPage);
		model.addAttribute("currentPage",adoptVO.getPage());
		
		//로그인정보가져오기
		LoginVO loginVO = (LoginVO)request.getSession().getAttribute("loginVO");
		model.addAttribute("loginVO", loginVO);
		
	    if(adoptVO.getViewType().equals("list")){
	    	return "dogCat/adopt/adoptList";
        }else if(adoptVO.getViewType().equals("photo")){
        	return "dogCat/adopt/adoptPhotoList";
        }else{
        	return "dogCat/adopt/adoptList";
        }
		
		
		
	}

	
	//상세화면
	@RequestMapping("/adoptView")
	public String adoptView(@ModelAttribute("adoptVO") AdoptVO adoptVO, ModelMap model) {
		//조회수증가
		adoptService.hitUp(adoptVO);
		
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
	public String createAdopt(@ModelAttribute("adoptVO")AdoptVO adoptVO, ModelMap model) {
		return "dogCat/adopt/adoptCreate";
	}

	@RequestMapping(value = "/createAdopt",method = RequestMethod.POST)
	//public ModelAndView createAdopt(@ModelAttribute("adoptVO") AdoptVO adoptVO, ModelMap model,HttpServletRequest request,final MultipartHttpServletRequest multiRequest) {
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
	
	 @RequestMapping(value = "/modifyAdopt" ,method = RequestMethod.GET)
	    public String modifyAdopt(@ModelAttribute("adoptVO")AdoptVO adoptVO, ModelMap model)throws Exception{
			//상품 상세정보조회
		 	AdoptVO adopt =  adoptService.detail(adoptVO);
		 	model.addAttribute("adopt",adopt);
		 	
		 	return "dogCat/adopt/adoptModify";
	    }

		/**
		 * 상품수정 처리
		 * @param map
		 * @return "success"
		 * @throws Exception
		 */
	 	@RequestMapping(value = "/modifyAdopt" ,method = RequestMethod.POST)
		public String modifyAdopt(@ModelAttribute("adoptVO")AdoptVO adoptVO, ModelMap model, HttpServletRequest request) throws Exception {
			try {
				//상품수정
				adoptService.update(adoptVO);
			} catch (Exception e) {
				e.printStackTrace();
			}

			//return "dogCat/adopt/adoptList";
			return "redirect:/adoptList";
		}
	
	
}
