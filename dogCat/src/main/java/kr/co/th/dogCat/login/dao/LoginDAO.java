package kr.co.th.dogCat.login.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.th.dogCat.login.vo.LoginVO;

@Repository
public class LoginDAO {

	@Autowired
	SqlSessionTemplate sqlsessionTemplate;
	
	public LoginVO selectLogin(LoginVO loginVO) {
		return sqlsessionTemplate.selectOne("login.selectLogin", loginVO);
	}

}
