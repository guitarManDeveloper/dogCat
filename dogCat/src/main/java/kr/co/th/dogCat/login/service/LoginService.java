package kr.co.th.dogCat.login.service;

import kr.co.th.dogCat.login.vo.LoginVO;

public interface LoginService {

	public LoginVO selectLogin(LoginVO loginVO) throws Exception;

}
