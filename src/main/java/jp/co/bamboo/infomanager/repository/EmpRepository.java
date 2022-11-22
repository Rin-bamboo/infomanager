package jp.co.bamboo.infomanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jp.co.bamboo.infomanager.entity.DepTb;
import jp.co.bamboo.infomanager.entity.EmpTb;

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


}
