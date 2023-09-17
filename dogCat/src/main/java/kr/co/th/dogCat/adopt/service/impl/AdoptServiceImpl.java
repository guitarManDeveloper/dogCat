package kr.co.th.dogCat.adopt.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.th.dogCat.adopt.dao.AdoptDAO;
import kr.co.th.dogCat.adopt.service.AdoptService;
import kr.co.th.dogCat.adopt.vo.AdoptVO;
import kr.co.th.dogCat.common.util.DateUtil;
import kr.co.th.dogCat.common.util.FileUtil;

@Service
public class AdoptServiceImpl implements AdoptService {

	//테스트용
	static String ITEM_FILE_PATH = "C:\\Users\\xodnq\\git\\dogCat\\dogCat\\src\\main\\webapp\\resources\\userImageData"; //파일저장경로
	
	//실서버용
	//static String ITEM_FILE_PATH = "/home/item/webapp/resources/userImageData"; //파일저장경로	
	static int ITEM_FILE_MAX_SIZE = 1024 * 1024 * 5; //파일최대허용용량
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

	@Override
	public AdoptVO detail(AdoptVO adoptVO) {
		return adoptDAO.detail(adoptVO);
	}

	@Override
	public void delete(Map<String, Object> map) {
		adoptDAO.delete(map);
		
	}

	@Override
	public void insert(AdoptVO adoptVO, HttpServletRequest request) throws Exception {
		/*
		 * //파일저장 MultipartRequest multi = new MultipartRequest(request, ITEM_FILE_PATH,
		 * ITEM_FILE_MAX_SIZE, "utf-8", new DefaultFileRenamePolicy());
		 * 
		 * //파일저장 boolean fileUploadFlag = FileUtil.fileUpload(request,multi);
		 * if(fileUploadFlag) {
		 * adoptVO.setOriginalFileName(multi.getOriginalFileName("image")); }
		 */
		
		adoptVO.setOriginalFileName("test");
		
		//현재시간구하기
		String strNowDate = DateUtil.nowDate("yyyyMMddHHmmss");
		adoptVO.setRdate(strNowDate);
		
		adoptDAO.insert(adoptVO);

	}

	@Override
	public void update(AdoptVO adoptVO) {
		//현재시간구하기
		String strNowDate = DateUtil.nowDate("yyyyMMddHHmmss");
		adoptVO.setMdate(strNowDate);
		adoptDAO.update(adoptVO);
		
	}

	@Override
	public void hitUp(AdoptVO adoptVO) {
		//조회수증가
		adoptDAO.hitUp(adoptVO);
		
	}


}
