package jp.co.bamboo.infomanager.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.bamboo.infomanager.repository.DepRepository;


@Controller
public class IndexController {

	//部署リポジトリとつなげる
	@Autowired
	DepRepository depRepository;

	@Autowired
	HttpSession session;
	@RequestMapping(path="/")
	public String index(){
		session.setAttribute("dep", depRepository.findAll());
		return "index";
	}

}
