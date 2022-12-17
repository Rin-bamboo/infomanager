package jp.co.bamboo.infomanager.service;

import java.sql.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.bamboo.infomanager.Form.EmpForm;
import jp.co.bamboo.infomanager.entity.DepTb;
import jp.co.bamboo.infomanager.entity.EmpTb;
import jp.co.bamboo.infomanager.entity.SurrogeteKeyTb;
import jp.co.bamboo.infomanager.repository.DepRepository;
import jp.co.bamboo.infomanager.repository.EmpRepository;
import jp.co.bamboo.infomanager.repository.SurrogetekeyRepository;

@Service
public class EmpService {

	@Autowired
	EmpRepository empRepository;

	@Autowired
	DepRepository depRepository;

	@Autowired
	SurrogetekeyRepository surrogeteKeyRepository;

	@Autowired
	SurrogeteKeyService surrogeteKeyService;

	@Autowired
	private HttpSession session;

	public Integer EmpCreate(EmpForm empForm, EmpTb emp) {
		System.out.println(session.getAttribute("editEmp"));
		Date now = new Date(System.currentTimeMillis());
		boolean admIfflg = session.getAttribute("adminFlg").equals("1");
		//管理者の一般社員で実行するアップデート文を変更 アドミンフラグが１じゃなかったら
		if (!(admIfflg) && !(session.getAttribute("editEmp") == null)) {
			//一般社員の情報変更
			System.out.println("社員編集");
			empRepository.SetEmpData(empForm.getEmpName(), empForm.getEmpNameKana(),
					empForm.getTelNo(), empForm.getEmgTelNo(),
					empForm.getAddressNo(), empForm.getAddress(),
					empForm.getMailAddress(), empForm.getBusStation(),
					empForm.getStation(), empForm.getDiscription(),
					now, emp.getEmpId());

		} else if (admIfflg && !(session.getAttribute("editEmp") == null)) {
			System.out.println("管理者編集");
			//管理者用の社員情報変更
			//DepTb depData = depRepository.getReferenceById(empForm.getDepId());
			Integer admflg = empForm.getEmpAdmin();
			empRepository.SetEmpDataAdmin(
					empForm.getEmpName(), empForm.getEmpNameKana(), empForm.getTelNo(),
					empForm.getEmgTelNo(), empForm.getAddressNo(), empForm.getAddress(),
					empForm.getMailAddress(), empForm.getDepId(),
					empForm.getBusStation(), empForm.getStation(),
					admflg, now, emp.getEmpId());

		} else {
			System.out.println("新規登録");
			DepTb depData = depRepository.getReferenceById(empForm.getDepId());
			emp.setEmpName(empForm.getEmpName());
			emp.setEmpNameKana(empForm.getEmpNameKana());
			emp.setBirthday(empForm.getBirthday());
			emp.setTelNo(empForm.getTelNo());
			emp.setEmgTelNo(empForm.getEmgTelNo());
			emp.setAddressNo(empForm.getAddressNo());
			emp.setAddress(empForm.getAddress());
			emp.setMailAddress(empForm.getMailAddress());
			emp.setBusStation(empForm.getBusStation());
			emp.setStation(empForm.getStation());
			emp.setJoinDate(empForm.getJoinDate());
			emp.setDiscription(empForm.getDiscription());
			//emp.setInsertDate(now);
			emp.setUpdateDate(now);
			emp.setDepTb(depData);
			emp.setEmpAdmin(empForm.getEmpAdmin());
			empRepository.save(emp);

			SurrogeteKeyTb surrogeteKeyTb = new SurrogeteKeyTb();
			//surrogeteKeyTb = surrogeteKeyRepository.getReferenceById(empId);
			surrogeteKeyService.SurrogeteKeyCreate(emp.getEmpId(), surrogeteKeyTb);
			
		}

		session.removeAttribute("editEmp");

		return emp.getEmpId();
	}
}
