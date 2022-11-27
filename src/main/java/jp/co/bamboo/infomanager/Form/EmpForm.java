package jp.co.bamboo.infomanager.Form;

import java.sql.Date;

public class EmpForm {
	//
	private Integer empId;

	//社員名
	private String empName;

	//社員名（カナ）
	private String empNameKana;

	//誕生日
	private Date birthday;

	//電話番号
	private String telNo;

	//緊急電話番号
	private String emgTelNo;

	//郵便番号
	private String addressNo;

	//住所
	private String address;

	//メールアドレス
	private String mailAddress;

	//入社日
	private Date joinDate;

	//最寄りバス停
	private String busStation;

	//最寄り駅
	private String station;

	//退職日
	private Date retDate;

	//死亡日
	private Date dieDate;

	//削除フラグ
	private Integer deleteFlg;

	//登録日
	private Date insertDate;

	//更新日
	private Date updateDate;

	//社員コメント
	private String Discription;

	//管理者権限
	private Integer empAdmin;

	//部署ID
	private Integer depId;
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

	/**
	 * @return barthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param barthday セットする barthday
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return telNo
	 */
	public String getTelNo() {
		return telNo;
	}

	/**
	 * @param telNo セットする telNo
	 */
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	/**
	 * @return emgTelNo
	 */
	public String getEmgTelNo() {
		return emgTelNo;
	}

	/**
	 * @param emgTelNo セットする emgTelNo
	 */
	public void setEmgTelNo(String emgTelNo) {
		this.emgTelNo = emgTelNo;
	}

	/**
	 * @return addressNo
	 */
	public String getAddressNo() {
		return addressNo;
	}

	/**
	 * @param addressNo セットする addressNo
	 */
	public void setAddressNo(String addressNo) {
		this.addressNo = addressNo;
	}

	/**
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address セットする address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return mailAddress
	 */
	public String getMailAddress() {
		return mailAddress;
	}

	/**
	 * @param mailAddress セットする mailAddress
	 */
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	/**
	 * @return joinDate
	 */
	public Date getJoinDate() {
		return joinDate;
	}

	/**
	 * @param joinDate セットする joinDate
	 */
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	/**
	 * @return busStation
	 */
	public String getBusStation() {
		return busStation;
	}

	/**
	 * @param busStation セットする busStation
	 */
	public void setBusStation(String busStation) {
		this.busStation = busStation;
	}

	/**
	 * @return station
	 */
	public String getStation() {
		return station;
	}

	/**
	 * @param station セットする station
	 */
	public void setStation(String station) {
		this.station = station;
	}

	/**
	 * @return retDate
	 */
	public Date getRetDate() {
		return retDate;
	}

	/**
	 * @param retDate セットする retDate
	 */
	public void setRetDate(Date retDate) {
		this.retDate = retDate;
	}

	/**
	 * @return dieDate
	 */
	public Date getDieDate() {
		return dieDate;
	}

	/**
	 * @param dieDate セットする dieDate
	 */
	public void setDieDate(Date dieDate) {
		this.dieDate = dieDate;
	}

	/**
	 * @return deleteFlg
	 */
	public Integer getDeleteFlg() {
		return deleteFlg;
	}

	/**
	 * @param deleteFlg セットする deleteFlg
	 */
	public void setDeleteFlg(Integer deleteFlg) {
		this.deleteFlg = deleteFlg;
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

	/**
	 * @return discription
	 */
	public String getDiscription() {
		return Discription;
	}

	/**
	 * @param discription セットする discription
	 */
	public void setDiscription(String discription) {
		Discription = discription;
	}

	/**
	 * @return empAdmin
	 */
	public Integer getEmpAdmin() {
		return empAdmin;
	}

	/**
	 * @param empAdmin セットする empAdmin
	 */
	public void setEmpAdmin(Integer empAdmin) {
		this.empAdmin = empAdmin;
	}

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



}
