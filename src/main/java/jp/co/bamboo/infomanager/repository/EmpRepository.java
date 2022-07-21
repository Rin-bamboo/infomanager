package jp.co.bamboo.infomanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.bamboo.infomanager.entity.EmpTb;


public interface EmpRepository extends JpaRepository<EmpTb, Integer> {



}
