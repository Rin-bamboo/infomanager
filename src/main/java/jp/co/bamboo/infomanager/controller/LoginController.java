package jp.co.bamboo.infomanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.bamboo.infomanager.repository.LoginRepository;
import jp.co.bamboo.infomanager.service.LoginService;

@Controller
public class LoginController {

	//serviceControllerとコントローラをAutowired

	@Autowired
	LoginRepository loginRepository;

	@Autowired
	LoginService loginService;

	/*ログインページの表示*/
	@RequestMapping("/login")
	public String loginPage() {
		return "login";
	}

	/*ログインボタン押下後の表示*/
	@RequestMapping(path = "/dologin" ,method = RequestMethod.POST)
	public String logIn(String loginId, String inputPassword) {


		/*loginServiceでログイン処理を実施*/
		if (loginService.login(loginId,inputPassword)){
			return "redirect:/";
		}else {
			return "redirect:/login";
		}
		/**/
	}

}
