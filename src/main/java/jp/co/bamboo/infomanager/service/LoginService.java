package jp.co.bamboo.infomanager.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.bamboo.infomanager.repository.DepRepository;
import jp.co.bamboo.infomanager.repository.EmpRepository;
import jp.co.bamboo.infomanager.repository.LoginRepository;
import jp.co.bamboo.infomanager.repository.SurrogetekeyRepository;

@Service
public class LoginService {
	@Autowired
	LoginRepository loginRepository;

	@Autowired
	SurrogetekeyRepository surrogetekeyRepository;

	@Autowired
	EmpRepository empRepository;
	//部署リポジトリとつなげる
	@Autowired
	DepRepository depRepository;

	@Autowired
	private HttpSession session;

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
			//ログインに成功したら各データをセッションに登録
			Integer getEmpId = loginRepository.myIdFindByLoginId(loginId);
			String surrogetekey = surrogetekeyRepository.surrogeteKeyFindempId(getEmpId);
			String userName = empRepository.empNameFindByLoginId(getEmpId);
			Integer adminFlg = empRepository.empAdminFindByLoginId(getEmpId);
			//サロゲートキーの登録
			session.setAttribute("surrogeteKey", surrogetekey);
			//ユーザーネームの登録
			session.setAttribute("userName", userName);
			//部署名の登録
			session.setAttribute("dep", depRepository.findAll());
			//管理者フラグの登録
			session.setAttribute("adminFlg", adminFlg);


			return true;
		}else {
			return false;
		}
	}
}
