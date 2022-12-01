package jp.co.bamboo.infomanager.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jp.co.bamboo.infomanager.entity.DepTb;
import jp.co.bamboo.infomanager.entity.EmpTb;

@Transactional
@Repository
public interface EmpRepository extends JpaRepository<EmpTb, Integer> {

	//全データ検索昇順
	//SQL<SELECT * FROM emp_tb ORDER BY emp_id ASC;>
	List<EmpTb> findAllByOrderByEmpIdAsc();

	//名前のあいまい検索
	//SQL<SELECT * FROM emp_tb WHERE emp_name LIKE '%empName%' ORDER BY emp_id ASC;>
	List<EmpTb> findByEmpNameLikeOrderByEmpIdAsc(String empName);

	//部署名での検索
	//SQL<SELECT * FROM emp_tb WHERE dep_id = '?';>
	List<EmpTb> findByDepTb(DepTb depTb);

	//社員名の取得
	@Query("SELECT i.empName FROM EmpTb i WHERE i.empId = :empId")
	String empNameFindByLoginId(@Param("empId") Integer empId);

	//管理者フラグの取得
	@Query("SELECT i.empAdmin FROM EmpTb i WHERE i.empId = :empId")
	Integer empAdminFindByLoginId(@Param("empId") Integer empId);

	//
	/**
	 *一般ユーザーのデータ更新
	 * @param empName		社員名
	 * @param empNameKana	社員仮名氏名
	 * @param TelNo			電話番号
	 * @param empEmgTelNo	緊急連絡先
	 * @param AddressNo		郵便番号
	 * @param Address		住所
	 * @param busStation	最寄りバス停
	 * @param station		最寄り駅
	 * @param mailAddress	メールアドレス
	 * @param discription	コメント
	 * @param updateDate	更新日
	 * @param empId			社員番号
	 */
	@Modifying
	@Query("UPDATE EmpTb u SET empName = :empName, empNameKana = :empNameKana, "
			+ "telNo = :telNo,emgTelNo = :emgTelNo, addressNo = :addressNo, address = :address, mailAddress = :mailAddress, "
			+ "busStation = :busStation, station = :station, discription = :discription, "
			+ "updateDate = :updateDate WHERE empId = :empId ")
	void SetEmpData(@Param("empName") String empName, @Param("empNameKana") String empNameKana,
			@Param("telNo") String TelNo, @Param("emgTelNo") String emgTelNo,
			@Param("addressNo") String AddressNo,
			@Param("address") String Address, @Param("mailAddress") String mailAddress,
			@Param("busStation") String busStation, @Param("station") String station,
			@Param("discription") String discription,
			@Param("updateDate") Date updateDate, @Param("empId") Integer empId);

	/**
	 * 管理者のテーブル更新
	 * @param empName
	 * @param empNameKana
	 * @param TelNo
	 * @param emgTelNo
	 * @param AddressNo
	 * @param Address
	 * @param mailAddress
	 * @param busStation
	 * @param station
	 * @param discription
	 * @param updateDate
	 * @param empId
	 */
	@Modifying
	@Query("UPDATE EmpTb u SET empName = :empName, empNameKana = :empNameKana, birthday = :birthday, "
			+ "telNo = :telNo, emgTelNo = :emgTelNo, addressNo = :addressNo, address = :address, "
			+ "mailAddress = :mailAddress, depId = :depId, joinDate = :joinDate, busStation = :busStation,"
			+ "station = :station WHERE empId = :empId")
	void SetEmpDataAdmin(
			@Param("empName") String empName, @Param("empNameKana") String empNameKana,
			@Param("birthday") Date birthday,
			@Param("telNo") String TelNo, @Param("emgTelNo") String emgTelNo,
			@Param("addressNo") String AddressNo,
			@Param("address") String Address, @Param("mailAddress") String mailAddress,
			@Param("depId") DepTb depId,
			@Param("busStation") String busStation, @Param("station") String station,
			@Param("discription") String discription,
			@Param("updateDate") Date updateDate, @Param("empId") Integer empId);
}
