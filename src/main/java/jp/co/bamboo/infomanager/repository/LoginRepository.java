package jp.co.bamboo.infomanager.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.bamboo.infomanager.entity.LoginTb;


public interface LoginRepository extends JpaRepository<LoginTb, Integer> {

	List<LoginTb> findByLoginId(String loginId);
}
