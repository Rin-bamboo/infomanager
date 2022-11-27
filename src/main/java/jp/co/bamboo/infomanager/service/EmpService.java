package jp.co.bamboo.infomanager.service;

import java.sql.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.bamboo.infomanager.Form.EmpForm;
import jp.co.bamboo.infomanager.entity.DepTb;
import jp.co.bamboo.infomanager.entity.EmpTb;
import jp.co.bamboo.infomanager.repository.DepRepository;
import jp.co.bamboo.infomanager.repository.EmpRepository;

@Service
public class EmpService {

	@Autowired
	EmpRepository empRepository;

	@Autowired
	DepRepository depRepository;

	@Autowired
	private HttpSession session;

	public Integer EmpCreate(EmpForm empForm,EmpTb emp){

		Date now = new Date(System.currentTimeMillis());

		Integer admflg = empForm.getEmpAdmin();;
		Date joinDate = empForm.getJoinDate();
		DepTb depData = depRepository.getReferenceById(empForm.getDepId());
		EmpTb empData = empRepository.getReferenceById(empForm.getEmpId());

		if(session.getAttribute("adminFlg") == null) {
			admflg = null;
			joinDate = empData.getJoinDate();
			depData = depRepository.getReferenceById(empData.getEmpId());

		}else if(session.getAttribute("adminFlg") == "1") {
		}

		//管理者の一般社員で実行するアップデート文を変更
		if(session.getAttribute("adminFlg") == null) {
			empRepository.SetEmpData
			(empForm.getEmpName(), empForm.getEmpNameKana(), empForm.getTelNo(),
					empForm.getEmgTelNo(), empForm.getAddressNo(),
					empForm.getAddress(), empForm.getBusStation(),
					empForm.getStation(), empForm.getMailAddress(),
					empForm.getDiscription(),now, empData.getEmpId());

		}else if(session.getAttribute("adminFlg") == "1") {
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
			emp.setJoinDate(joinDate);
			emp.setDiscription(empForm.getDiscription());
			//emp.setInsertDate(now);
			emp.setUpdateDate(now);
			emp.setDepTb(depData);
			emp.setEmpAdmin(admflg);
			empRepository.save(emp);
		}





		return emp.getEmpId();
	}
}
