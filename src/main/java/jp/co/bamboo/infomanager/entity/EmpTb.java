package jp.co.bamboo.infomanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "empTb")


public class EmpTb {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_emps_gen")
	@SequenceGenerator(name = "seq_emps_gen", sequenceName = "seq_emp_id",allocationSize = 1)
	private Integer empId;

	//社員名
	@Column
	private String empName;

	//社員名（カナ）
	@Column
	private String empNameKana;

	/**
	 * @return empId
	 */
	public Integer getEmpId() {
		return empId;
	}

	/**
	 * @param empId セットする empId
	 */
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	/**
	 * @return empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName セットする empName
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return empNameKana
	 */
	public String getEmpNameKana() {
		return empNameKana;
	}

	/**
	 * @param empNameKana セットする empNameKana
	 */
	public void setEmpNameKana(String empNameKana) {
		this.empNameKana = empNameKana;
	}



}
