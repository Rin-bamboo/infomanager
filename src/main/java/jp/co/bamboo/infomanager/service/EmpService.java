package jp.co.bamboo.infomanager.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.bamboo.infomanager.Form.EmpForm;
import jp.co.bamboo.infomanager.entity.EmpTb;
import jp.co.bamboo.infomanager.repository.DepRepository;
import jp.co.bamboo.infomanager.repository.EmpRepository;

@Service
public class EmpService {

	@Autowired
	EmpRepository empRepository;

	@Autowired
	DepRepository depRepository;


	public Integer EmpCreate(EmpForm empForm,EmpTb emp){

		Date now = new Date(System.currentTimeMillis());

		//EmpTb emp = new EmpTb();

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

		return emp.getEmpId();
	}
}
