package jp.co.bamboo.infomanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "emp_tb")
public class DepTb {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_dep_id_gen")
	@SequenceGenerator(name="seq_dep_id_gen", sequenceName = "seq_dep_id", allocationSize=1)
	private Integer depId;

	@Column
	private String depName;

	@Column
	private String insertDate;

	@Column
	private String updateDate;

	/**
	 * @return depId
	 */
	public Integer getDepId() {
		return depId;
	}

	/**
	 * @param depId セットする depId
	 */
	public void setDepId(Integer depId) {
		this.depId = depId;
	}

	/**
	 * @return depName
	 */
	public String getDepName() {
		return depName;
	}

	/**
	 * @param depName セットする depName
	 */
	public void setDepName(String depName) {
		this.depName = depName;
	}

	/**
	 * @return insertDate
	 */
	public String getInsertDate() {
		return insertDate;
	}

	/**
	 * @param insertDate セットする insertDate
	 */
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}

	/**
	 * @return updateDate
	 */
	public String getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate セットする updateDate
	 */
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}



}
