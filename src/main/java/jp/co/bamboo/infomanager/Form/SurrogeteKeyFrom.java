package jp.co.bamboo.infomanager.form;

import java.sql.Date;

public class SurrogeteKeyFrom {

	private Integer empId;

	private String surrogeteKey;

	private Date issueDate;

	private Date insertDate;

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
