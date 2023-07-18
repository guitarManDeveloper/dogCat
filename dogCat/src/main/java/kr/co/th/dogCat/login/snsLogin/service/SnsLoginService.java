package kr.co.th.dogCat.login.snsLogin.service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface SnsLoginService {

	void getKakaoUserInfo(String token, HttpServletRequest request)throws Exception;

	String getToken(String code)throws Exception;
}
