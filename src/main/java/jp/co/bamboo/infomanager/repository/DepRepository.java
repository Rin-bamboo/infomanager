package jp.co.bamboo.infomanager.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.bamboo.infomanager.entity.DepTb;

public interface DepRepository extends JpaRepository<DepTb, Integer> {

}
