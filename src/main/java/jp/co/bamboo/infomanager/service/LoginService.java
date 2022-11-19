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

		System.out.println("ログインID：" + loginId + " パスワード" + inputPassword);

		/* TODO ログインIDから取得したパスワードを getPassword2に代入する*/
		loginRepository.findByLoginId(loginId);

		String getPassword2= "8d40d13a5677252fa51868387c572952629d703770cf17c42e8620f454a54b0cc8420eeaf296510712937ee084e6c02ff58b9b26e095201fbb7650a2f9e99b1b";

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
