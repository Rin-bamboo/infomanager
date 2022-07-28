package jp.co.bamboo.infomanager.entity;

import java.util.Date;

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

	//誕生日
	@Column
	private String barthday;

	//電話番号
	@Column
	private String telNo;

	//緊急電話番号
	@Column
	private String emgTelNo;

	//郵便番号
	@Column
	private String addressNo;

	//住所
	@Column
	private String address;


	//メールアドレス
	@Column
	private String mailAddress;

	//部署ID
	@ManyToOne
	@JoinColumn(name = "depId", referencedColumnName = "depId")
	private DepTb depTb;

	//入社日
	@Column
	private String joinDate;

	//最寄りバス停
	@Column
	private String busStation;

	//最寄り駅
	@Column
	private String station;

	//退職日
	@Column
	private Date retDate;

	//死亡日
	@Column
	private Date dieDate;

	//削除フラグ
	@Column
	private Integer deleteFlg;

	//登録日
	@Column
	private Date insertDate;

	//更新日
	@Column
	private Date updateDate;

	/*バグ発生でコメントアウト　外部参照でうまく使いたい
	@OneToMany
	@JoinTable
	(
	  name="emp_dep_tb",
	  joinColumns = {@JoinColumn(name="emp_id", referencedColumnName="emp_id")},
	  inverseJoinColumns = {@JoinColumn(name="dep_id", referencedColumnName="dep_id", unique=true)}
	 )
	 private List<DepTb> depList;*/

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

	/**
	 * @return barthday
	 */
	public String getBarthday() {
		return barthday;
	}

	/**
	 * @param barthday セットする barthday
	 */
	public void setBarthday(String barthday) {
		this.barthday = barthday;
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
	public String getJoinDate() {
		return joinDate;
	}

	/**
	 * @param joinDate セットする joinDate
	 */
	public void setJoinDate(String joinDate) {
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
	 * @return depTb
	 */
	public DepTb getDepTb() {
		return depTb;
	}

	/**
	 * @param depTb セットする depTb
	 */
	public void setDepTb(DepTb depTb) {
		this.depTb = depTb;
	}





}
