package jp.co.bamboo.infomanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.bamboo.infomanager.entity.EmpTb;


public interface EmpRepository extends JpaRepository<EmpTb, Integer> {

	List<EmpTb> findAllByOrderByEmpIdAsc();

	List<EmpTb> findByEmpNameLikeOrderByEmpIdAsc(String empName);

}
