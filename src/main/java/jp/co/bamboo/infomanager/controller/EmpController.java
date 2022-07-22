package jp.co.bamboo.infomanager.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.bamboo.infomanager.empForm.EmpForm;
import jp.co.bamboo.infomanager.entity.EmpTb;
import jp.co.bamboo.infomanager.repository.EmpRepository;

@Controller
public class EmpController {

	@Autowired
	EmpRepository empRepository;

	@RequestMapping("/emps/findAll")
	public String showEmpList(Model model) {
		model.addAttribute("emps", empRepository.findAll());
		return "emps/emp_list";
	}

	@RequestMapping("/emps/empshow/{empId}")
	public String shoEmp(@PathVariable int empId,Model empModel) {
		empModel.addAttribute("emp",empRepository.getReferenceById(empId));

		return "emps/emp_show";
	}

	@RequestMapping("/emps/create/emp")
	public String createEmp() {
		return "emps/emp_create";
	}

	@RequestMapping(path = "/emps/create/complete", method = RequestMethod.POST)
	public String cmpleteCreateEmp(EmpForm empForm) {
		Date now = new Date();
		EmpTb emp = new EmpTb();
		emp.setEmpName(empForm.getEmpName());
		emp.setEmpNameKana(empForm.getEmpNameKana());
		emp.setBarthday(empForm.getBirthday());
		emp.setTelNo(empForm.getTelNo());
		emp.setEmgTelNo(empForm.getEmgTelNo());
		emp.setAddressNo(empForm.getAddressNo());
		emp.setAddress(empForm.getAddress());
		emp.setMailAddress(empForm.getMailAddress());
		emp.setBusStation(empForm.getBusStation());
		emp.setStation(empForm.getStation());
		emp.setJoinDate(empForm.getJoinDate());
		emp.setInsertDate(now);
		emp.setUpdateDate(now);
		empRepository.save(emp);

		return "redirect:/emps/empshow/" + emp.getEmpId();
		//"redirect:/emps/empshow/" + emp.getEmpId();


	}


	@RequestMapping("/emps/empedit/{empId}")
	public String editEmp(@PathVariable int empId,Model empModel) {
		empModel.addAttribute("emp",empRepository.getReferenceById(empId));

		return "emps/emp_edit";
	}

//編集フォームの作成
//	@RequestMapping("/emp/edit/{empId}")
//	public String editEmp(@PathVariable int empId, EmpForm empform) {

//		Emp
//	}


}
