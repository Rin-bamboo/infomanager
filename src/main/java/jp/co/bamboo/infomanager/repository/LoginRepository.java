package jp.co.bamboo.infomanager.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jp.co.bamboo.infomanager.entity.LoginTb;


public interface LoginRepository extends JpaRepository<LoginTb, Integer> {


	List<LoginTb> findByLoginId(String loginId);

	/* TODO ログインIDからパスワードを取得するクエリの作成*/
	@Query("SELECT i.password FROM LoginTb i WHERE i.loginId = :loginId")
	String passwordFindByLoginId(@Param("loginId") String loginId);

	@Query("SELECT i.empId From LoginTb i WHERE i.loginId = :loginId")
	Integer myIdFindByLoginId(@Param("loginId") String loginId);
}
