package jp.co.bamboo.infomanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.bamboo.infomanager.repository.EmpRepository;


@Controller
public class EmpController {

	@Autowired
	EmpRepository repository;

	@RequestMapping("/emps/findAll")
	public String showEmpList(Model model) {
		model.addAttribute("emps", repository.findAll());
		return "emps/emp_list";
		}

}
