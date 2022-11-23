package jp.co.bamboo.infomanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {


	//エラー番号01への遷移
	@RequestMapping("/error01")
	public String showEmpList(Model model) {

		return "error/ERROR01";
	}


}
