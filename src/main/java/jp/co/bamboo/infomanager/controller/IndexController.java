package jp.co.bamboo.infomanager.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {



	@Autowired
	HttpSession session;
	@RequestMapping(path="/")
	public String index(){

		return "index";
	}

}
