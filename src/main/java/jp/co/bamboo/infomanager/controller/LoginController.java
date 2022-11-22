package jp.co.bamboo.infomanager.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.bamboo.infomanager.repository.EmpRepository;
import jp.co.bamboo.infomanager.repository.LoginRepository;
import jp.co.bamboo.infomanager.repository.SurrogetekeyRepository;
import jp.co.bamboo.infomanager.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginRepository loginRepository;

	@Autowired
	SurrogetekeyRepository surrogetekeyRepository;

	@Autowired
	EmpRepository empRepository;

	@Autowired
	LoginService loginService;

	@Autowired
	HttpSession session;

	/*ログインページの表示*/
	@RequestMapping("/login")
	public String loginPage() {
		//暫定処理ログイン画面に飛ぶとログアウトする
		session.invalidate();
		return "login";
	}

	/*ログインボタン押下後の表示*/
	@RequestMapping(path = "/dologin" ,method = RequestMethod.POST)
	public String logIn(String loginId, String inputPassword, HttpSession session) {
		/*loginServiceでログイン処理を実施*/
		if (loginService.login(loginId,inputPassword)){
			return "redirect:/";
		}else {
			return "redirect:/login";
		}
		/**/
	}

	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public String LogOut() {
		//セッション情報の破棄
		session.invalidate();
		return "redirect:/login";
	}

}
