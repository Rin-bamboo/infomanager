package jp.co.bamboo.infomanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "emp_dep_tb")
public class EmpDepTb {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="link_emp_dep_id_gen")
	@SequenceGenerator(name="link_emp_dep_id_gen", sequenceName = "link_emp_dep_id", allocationSize=1)
	private Integer linkEmpDepId;

	@ManyToOne
	@JoinColumn(name = "emp_id", referencedColumnName = "empId")
	private EmpTb emp;

	@ManyToOne
	@JoinColumn(name = "dep_id", referencedColumnName = "depId")
	private DepTb dep;

	@Column
	private String multFlg;

	/**
	 * @return linkEmpDepId
	 */
	public Integer getLinkEmpDepId() {
		return linkEmpDepId;
	}

	/**
	 * @param linkEmpDepId セットする linkEmpDepId
	 */
	public void setLinkEmpDepId(Integer linkEmpDepId) {
		this.linkEmpDepId = linkEmpDepId;
	}

	/**
	 * @return emp
	 */
	public EmpTb getEmp() {
		return emp;
	}

	/**
	 * @param emp セットする emp
	 */
	public void setEmp(EmpTb emp) {
		this.emp = emp;
	}

	/**
	 * @return dep
	 */
	public DepTb getDep() {
		return dep;
	}

	/**
	 * @param dep セットする dep
	 */
	public void setDep(DepTb dep) {
		this.dep = dep;
	}

	/**
	 * @return multFlg
	 */
	public String getMultFlg() {
		return multFlg;
	}

	/**
	 * @param multFlg セットする multFlg
	 */
	public void setMultFlg(String multFlg) {
		this.multFlg = multFlg;
	}



}
