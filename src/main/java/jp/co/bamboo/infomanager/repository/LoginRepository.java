package jp.co.bamboo.infomanager.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jp.co.bamboo.infomanager.entity.LoginTb;


public interface LoginRepository extends JpaRepository<LoginTb, Integer> {


	List<LoginTb> findByLoginId(String loginId);


	/* TODO ログインIDからパスワードを取得するクエリの作成*/
	@Query("SELECT i.password FROM UserMasterTb i WHERE empId = ?1")
	List<LoginTb> findByLoginId(int loginId);

}
