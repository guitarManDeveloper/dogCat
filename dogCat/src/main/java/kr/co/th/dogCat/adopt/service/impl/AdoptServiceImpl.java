package kr.co.th.dogCat.adopt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.th.dogCat.adopt.dao.AdoptDAO;
import kr.co.th.dogCat.adopt.service.AdoptService;
import kr.co.th.dogCat.adopt.vo.AdoptVO;

@Service
public class AdoptServiceImpl implements AdoptService {

	@Autowired
	AdoptDAO adoptDAO;
	
	@Override
	public List<AdoptVO> adoptList(AdoptVO adoptVO) {
		return adoptDAO.adoptList(adoptVO);
	}

	@Override
	public int selectAdoptTotalCnt(AdoptVO adoptVO) {
		return adoptDAO.selectAdoptTotalCnt(adoptVO);
	}

}
