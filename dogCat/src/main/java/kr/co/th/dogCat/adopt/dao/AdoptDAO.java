package kr.co.th.dogCat.adopt.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.th.dogCat.adopt.vo.AdoptVO;

@Repository
public class AdoptDAO {
	@Autowired
	SqlSessionTemplate sqlsessionTemplate;
	

	public List<AdoptVO> adoptList(AdoptVO adoptVO) {
		return sqlsessionTemplate.selectList("adopt.adoptList", adoptVO);
	}


	public int selectAdoptTotalCnt(AdoptVO adoptVO) {
		return sqlsessionTemplate.selectOne("adopt.selectAdoptTotalCnt", adoptVO);
	}


	public AdoptVO detail(AdoptVO adoptVO) {
		return sqlsessionTemplate.selectOne("adopt.select_detail", adoptVO);
	}


	public void delete(Map<String, Object> map) {
		sqlsessionTemplate.delete("adopt.delete", map);
	}

}
