package jp.co.bamboo.infomanager;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
/**/
@Component
public class LoginFilter implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String requestURL = httpRequest.getRequestURI();

		if (requestURL.endsWith("/login") || requestURL.indexOf("/css/") != -1) {
			//URLがログイン画面のURLだったら
			chain.doFilter(request, response);

		} else {
			//URLがログイン画面じゃなかったら
			HttpSession session = httpRequest.getSession();

			String surrogetekey = (String) session.getAttribute("surrogeteKey");

			System.out.println("サロゲートキー" + surrogetekey);

			if (surrogetekey == null) {
				//セッションのログインIDがnull（ログインしていない状態）だったら
				HttpServletResponse httpResponse = (HttpServletResponse) response;

				httpResponse.sendRedirect("login");
			} else {
				//セッションのログインIDがNullじゃない（ログインしている状態）なら
				chain.doFilter(request, response);
			}

		}

	}
}
/**/
