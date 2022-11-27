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
			+ "TelNo = :TelNo,empEmgTelNo = :empEmgTelNo, AddressNo = :AddressNo, Address = :Address, mailAddress = :Address, "
			+ "busStation = :busStation, station = :station, discription = :discription, "
			+ "updateDate = :updateDate WHERE empId = :empId ")
	void SetEmpData(@Param("empName") String empName, @Param("empNameKana") String empNameKana,
			@Param("TelNo") String TelNo,@Param("empEmgTelNo") String empEmgTelNo, @Param("AddressNo") String AddressNo,
			@Param("Address") String Address,@Param("busStation") String busStation, @Param("station") String station,
			@Param("mailAddress") String mailAddress,@Param("discription") String discription,
			@Param("updateDate") Date updateDate, @Param("empId") Integer empId);

}
