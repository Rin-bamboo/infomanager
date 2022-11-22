package jp.co.bamboo.infomanager.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "surrogeteKeyTb")
public class SurrogeteKeyTb {
	@Id
	private Integer empId;

	@Column
	private String surrogeteKey;

	@Column
	private Date issueDate;

	@Column
	private Date insertDate;

	@Column
	private Date updateDate;

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
	 * @return surrogeteKey
	 */
	public String getSurrogeteKey() {
		return surrogeteKey;
	}

	/**
	 * @param surrogeteKey セットする surrogeteKey
	 */
	public void setSurrogeteKey(String surrogeteKey) {
		this.surrogeteKey = surrogeteKey;
	}

	/**
	 * @return issueDate
	 */
	public Date getIssueDate() {
		return issueDate;
	}

	/**
	 * @param issueDate セットする issueDate
	 */
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	/**
	 * @return insertDate
	 */
	public Date getInsertDate() {
		return insertDate;
	}

	/**
	 * @param insertDate セットする insertDate
	 */
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	/**
	 * @return updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate セットする updateDate
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}




}
