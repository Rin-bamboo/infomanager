package jp.co.bamboo.infomanager.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.bamboo.infomanager.Form.EmpForm;
import jp.co.bamboo.infomanager.entity.DepTb;
import jp.co.bamboo.infomanager.entity.EmpTb;
import jp.co.bamboo.infomanager.repository.DepRepository;
import jp.co.bamboo.infomanager.repository.EmpRepository;
import jp.co.bamboo.infomanager.repository.SurrogetekeyRepository;

@Controller
public class EmpController {

	//社員情報リポジトリとつなげる
	@Autowired
	EmpRepository empRepository;

	@Autowired
	DepRepository depRepository;

	@Autowired
	SurrogetekeyRepository surrogeteKeyRepository;

	@Autowired
	private HttpSession session;

	//社員情報全件検索
	@RequestMapping("/emps/findAll")
	public String showEmpList(Model model) {
		model.addAttribute("emps", empRepository.findAllByOrderByEmpIdAsc());
		return "emps/emp_list";
	}

	//社員名あいまい検索
	@RequestMapping(path = "/emps/empnamefind", method = RequestMethod.GET)
	public String findEmpName(String empName, Model empModel) {
		if (empName == null || "".equals(empName)) {
			return "redirect:/emps/findAll";
		}
		empModel.addAttribute("emps", empRepository.findByEmpNameLikeOrderByEmpIdAsc("%" + empName + "%"));
		return "emps/emp_list";
	}

	//社員部署検索
	@RequestMapping(path = "/emps/empdepfind", method = RequestMethod.GET)
	public String findDepId(int depId, Model depModel) {
		DepTb depTb = new DepTb();
		depTb.setDepId(depId);
		List<EmpTb> emps = empRepository.findByDepTb(depTb);
		depModel.addAttribute("emps", emps);
		return "emps/emp_list";
	}
	//サロゲートキー社員検索
	@RequestMapping("/emp/{surrogeteKey}")
	public String showEmp(@PathVariable String surrogeteKey,Model empModel) {
		Integer empId = surrogeteKeyRepository.empIdFindBySurrogeteKey(surrogeteKey);
		empModel.addAttribute("emp", empRepository.getReferenceById(empId));
		return "emps/emp_show";
	}

	//社員情報詳細表示
	@RequestMapping("/emps/empshow/{empId}")
	public String shoEmp(@PathVariable int empId, Model empModel) {
		empModel.addAttribute("emp", empRepository.getReferenceById(empId));
		return "emps/emp_show";
	}

	//社員新規登録画面表示
	@RequestMapping("/emps/create/emp")
	public String createEmp() {
		return "emps/emp_create";
	}

	//社員新規登録
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
		emp.setDiscription(empForm.getDiscription());
		emp.setInsertDate(now);
		emp.setUpdateDate(now);
		emp.setDepTb(depRepository.getReferenceById(empForm.getDepId()));
		emp.setEmpAdmin(empForm.getEmpAdmin());
		empRepository.save(emp);
		return "redirect:/emps/empshow/" + emp.getEmpId();
	}

	//社員情報編集
	@RequestMapping("/empedit/{surrogeteKey}")
	public String editEmp(@PathVariable String surrogeteKey, Model empModel) {
		Integer empId = surrogeteKeyRepository.empIdFindBySurrogeteKey(surrogeteKey);

		/*サロゲートキーの検索結果がnull または セッション情報のサロゲートキーと一致しなかったらトップエージへ遷移
		 * （将来的にエラー画面へ遷移するようにします。）*/
		if((empId == null || !(surrogeteKey.equals(session.getAttribute("surrogeteKey"))) && session.getAttribute("adminFlg") == "0")) {
			/*暫定処理存在しないサロゲートキーを指定したらトップページへ遷移*/
			return "redirect:/";
		}
		empModel.addAttribute("emp", empRepository.getReferenceById(empId));
		return "emps/emp_edit";
	}

}
