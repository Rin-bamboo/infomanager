package jp.co.bamboo.infomanager.controller;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.bamboo.infomanager.repository.LoginRepository;

//import jp.co.bamboo.infomanager.repository.LoginRepository;

@Controller
public class LoginController {

	@Autowired
	LoginRepository loginRepository;

	/*ログインページの表示*/
	@RequestMapping("/login")
	public String loginPage() {

		return "login";
	}

	/*ログインボタン押下後の表示*/
	@RequestMapping(path = "/dologin" ,method = RequestMethod.POST)
	public String logIn(String loginId, String inputPassword) {

		MessageDigest sha3_512 = null;

		try {
			sha3_512 = MessageDigest.getInstance("SHA3-512");
		} catch (NoSuchAlgorithmException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		byte[] sha3_512_result = sha3_512.digest(inputPassword.getBytes());

		System.out.println(String.format("%040x", new BigInteger(1, sha3_512_result)));
		loginRepository.findByLoginId(loginId);
		if (String.format("%040x", new BigInteger(1, sha3_512_result)).equals("d2d8cc4f369b340130bd2b29b8b54e918b7c260c3279176da9ccaa37c96eb71735fc97568e892dc6220bf4ae0d748edb46bd75622751556393be3f482e6f794e")){
			return "redirect:/";
		}else {
			return "redirect:/login";
		}
	}

}
