package jp.co.bamboo.infomanager.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.bamboo.infomanager.entity.DepTb;
import jp.co.bamboo.infomanager.entity.EmpTb;
import jp.co.bamboo.infomanager.entity.SurrogeteKeyTb;
import jp.co.bamboo.infomanager.form.EmpForm;
import jp.co.bamboo.infomanager.repository.DepRepository;
import jp.co.bamboo.infomanager.repository.EmpRepository;
import jp.co.bamboo.infomanager.repository.SurrogetekeyRepository;
import jp.co.bamboo.infomanager.service.EmpService;
import jp.co.bamboo.infomanager.service.SurrogeteKeyService;

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
	EmpService empService;

	@Autowired
	SurrogeteKeyService surrogeteKeyService;

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
	public String showEmp(@PathVariable String surrogeteKey, Model empModel) {
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
	public String createEmp(@ModelAttribute EmpForm empForm) {
		return "emps/emp_create";
	}

	//社員新規登録
	@RequestMapping(path = "/emps/create/complete", method = RequestMethod.POST)
	public String cmpleteCreateEmp(@Valid @ModelAttribute EmpForm empForm,BindingResult result) {
		if (result.hasErrors()) {
			return "emps/emp_create";
		}
		EmpTb emp = new EmpTb();
		Integer empId = empService.EmpCreate(empForm, emp);
		return "redirect:/emps/empshow/" + empId;
	}

	//社員情報編集
	@RequestMapping("/empedit/{empData}")
	public String editEmp(@PathVariable String empData, Model empModel, @ModelAttribute EmpForm empForm) {
		Integer empId;
		boolean admflg = false;

		if (session.getAttribute("adminFlg") != null) {
			admflg = session.getAttribute("adminFlg").equals(1);
		}

		if (admflg && !(empData.equals(session.getAttribute("surrogeteKey")))) {
			/*管理者且つ編集先が自分じゃないときはは社員番号で検索し、サロゲートキーを取得する*/
			try {
				empId = empRepository.empIdFindByEmpId(Integer.parseInt(empData));
			} catch (Exception e) {
				return "redirect:/error01";
			}
			empData = surrogeteKeyRepository.surrogeteKeyFindempId(empId);
		} else {
			/*一般社員はempDataサロゲートキーからデータ取得*/
			empId = surrogeteKeyRepository.empIdFindBySurrogeteKey(empData);
		}
		if (empData == null) {
			SurrogeteKeyTb surrogeteKeyTb = new SurrogeteKeyTb();
			empData = surrogeteKeyService.SurrogeteKeyCreate(empId, surrogeteKeyTb);
		}

		//編集IDの編集
		session.setAttribute("editEmp", empData);

		/*セッション情報のサロゲートキーと一致しなかったらエラー画面へ遷移 管理者画面はバイパス*/
		if ((empId == null || !(empData.equals(session.getAttribute("surrogeteKey")))
				&& !(admflg))) {
			/*暫定処理存在しないサロゲートキーを指定したらエラー画面へ遷移*/
			return "redirect:/error01";
		} /* else if (admflg) {

			empModel.addAttribute("emp", empRepository.findById(empId));
			}*/ else {
			empModel.addAttribute("empForm", empRepository.getReferenceById(empId));
		}
		return "emps/emp_create";
	}

	//更新確認画面
	@RequestMapping(path = "empedit/conf")
	public String confUpdateEmp(Model empModel, @Valid @ModelAttribute EmpForm empForm, BindingResult result) {
		if (result.hasErrors()) {
			return "emps/emp_create";
		}

		String surrogeteKey = (String) session.getAttribute("editEmp");
		Integer empId = surrogeteKeyRepository.empIdFindBySurrogeteKey(surrogeteKey);

		empModel.addAttribute("newemp", empForm);
		empModel.addAttribute("oldemp", empRepository.getReferenceById(empId));

		return "emps/emp_edit_confirmation";
	}

	//社員情報編集完了
	@RequestMapping(path = "empedit/complete/{surrogeteKey}", method = RequestMethod.POST)
	public String cmpleteUpdateEmp(@PathVariable String surrogeteKey, EmpForm empForm) {

		Integer empId = surrogeteKeyRepository.empIdFindBySurrogeteKey(surrogeteKey);
		EmpTb emp = empRepository.getReferenceById(empId);

		Integer updateEmpId = empService.EmpCreate(empForm, emp);

		return "redirect:/emps/empshow/" + updateEmpId;
	}
}
