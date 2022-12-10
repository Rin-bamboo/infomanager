package jp.co.bamboo.infomanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jp.co.bamboo.infomanager.entity.SurrogeteKeyTb;

public interface SurrogetekeyRepository extends JpaRepository<SurrogeteKeyTb, Integer> {

	@Query("SELECT i.surrogeteKey FROM SurrogeteKeyTb i WHERE i.empId = :empId")
	String surrogeteKeyFindempId(@Param("empId") Integer empId);

	@Query("SELECT i.empId FROM SurrogeteKeyTb i WHERE i.surrogeteKey = :surrogeteKey")
	Integer empIdFindBySurrogeteKey(@Param("surrogeteKey") String surrogeteKey);

}
