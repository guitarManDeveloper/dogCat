package kr.co.th.dogCat.adopt.service;

import java.util.List;

import kr.co.th.dogCat.adopt.vo.AdoptVO;


public interface AdoptService {
	
	//목록화면
	List<AdoptVO> adoptList(AdoptVO adoptVO);
	
	
	//상품목록의 카운트 수
	int selectAdoptTotalCnt(AdoptVO adoptVO);
}
