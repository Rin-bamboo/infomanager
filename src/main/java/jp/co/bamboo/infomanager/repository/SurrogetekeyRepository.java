package jp.co.bamboo.infomanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.bamboo.infomanager.entity.SurrogeteTb;

public interface SurrogetekeyRepository extends JpaRepository<SurrogeteTb, Integer> {


	//@Query("SELECT i.surrogeteKey FROM SurrogeteKeyTb i WHERE i.empId = :empId")
	//String surrogeteKeyFindempId(@Param("empId") Integer empId);
}
