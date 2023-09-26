package kr.co.th.dogCat.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.co.th.dogCat.login.dao.LoginDAO;
import kr.co.th.dogCat.login.service.LoginService;
import kr.co.th.dogCat.login.vo.LoginVO;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDAO loginDAO;
	
	@Override
	public LoginVO selectLogin(LoginVO loginVO) throws Exception {
		//DAO
		return loginDAO.selectLogin(loginVO);
	}
}
