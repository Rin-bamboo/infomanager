package jp.co.bamboo.infomanager.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.bamboo.infomanager.repository.LoginRepository;

@Service
public class LoginService {
	@Autowired
	LoginRepository loginRepository;

	public boolean login(String loginId, String inputPassword) {

		/* TODO ログインIDから取得したパスワードを getPassword2に代入する*/
		String getPassword2 = loginRepository.passwordFindByLoginId(loginId);

		/* ログインIDでパスワードが取得できても出来なくても入力PWのハッシュ化を行う */
		/* 常にハッシュ化を行うことで、ログイン時のレスポンスの違いでログインIDが存在するのかしないのかを判断させない */
		if (getPassword2 == null) {
			getPassword2 = "";
		}
		MessageDigest sha3_512 = null;
		try {
			sha3_512 = MessageDigest.getInstance("SHA3-512");
		} catch (NoSuchAlgorithmException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		byte[] sha3_512_result = sha3_512.digest(inputPassword.getBytes());

		String hashPassword = String.format("%040x", new BigInteger(1, sha3_512_result));
		// System.out.println(hashPassword);

		if(getPassword2.equals(hashPassword)) {
			return true;
		}else {
			return false;
		}
	}
}
