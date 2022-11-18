package jp.co.bamboo.infomanager.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jp.co.bamboo.infomanager.service.LoginService;

@Configuration
public class LoginConfiguration {
	//serviceを使うために、beanにする必要がある。

	@Bean
	LoginService loginServices() {
		return new LoginService();
	}
}
