package jp.co.bamboo.infomanager.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.bamboo.infomanager.entity.Login;


public interface LoginRepository extends JpaRepository<Login, Integer> {

	List<Login> findByLoginId(String loginId);
}
