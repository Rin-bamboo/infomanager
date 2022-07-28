package jp.co.bamboo.infomanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.bamboo.infomanager.entity.EmpDepTb;

public interface LinkEmpDepIdRepository extends JpaRepository<EmpDepTb,Integer> {

	//全データ検索昇順
	//SQL<SELECT * FROM emp_tb ORDER BY emp_id ASC;>
	//List<EmpDepTb> findByempIdAndMultFlg(String empId, String MultFlg);

}
