package jp.co.bamboo.infomanager.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;


/*
 * パスワードのハッシュ化
 * 参考URL
 * https://qiita.com/NagaokaKenichi/items/2742749a93df15b55d24
 */
public class AuthUtil {
	@Autowired
	PasswordEncoder passwordEncoder;

	public void run(String... args) {

		String password = "#fe?3d31";

		String digest = passwordEncoder.encode(password);

		if (passwordEncoder.matches(password, digest)) {
			System.out.println("一致したよ");
			return;
		}
		System.out.println("一致しませんでした");

	}

}
