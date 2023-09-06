package kr.co.th.dogCat.adopt.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;

import kr.co.th.dogCat.adopt.vo.AdoptVO;


public interface AdoptService {
	
	//목록화면
	List<AdoptVO> adoptList(AdoptVO adoptVO) throws Exception;
	
	
	//상품목록의 카운트 수
	int selectAdoptTotalCnt(AdoptVO adoptVO);
	
	//상세보기정보 조회
	AdoptVO detail(AdoptVO adoptVO);


	void delete(Map<String, Object> map);


	void insert(AdoptVO adoptVO, HttpServletRequest request) throws Exception;
}
