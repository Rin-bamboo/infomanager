package jp.co.bamboo.infomanager.service;

import java.sql.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.bamboo.infomanager.entity.SurrogeteKeyTb;
import jp.co.bamboo.infomanager.repository.EmpRepository;
import jp.co.bamboo.infomanager.repository.SurrogetekeyRepository;

@Service
public class SurrogeteKeyService {

	@Autowired
	EmpRepository empRepository;

	@Autowired
	SurrogetekeyRepository surrogeteKeyRepository;

	public String SurrogeteKeyCreate(Integer empId, SurrogeteKeyTb surrogeteKeyTb) {
		Date now = new Date(System.currentTimeMillis());

		UUID uuid = UUID.randomUUID();
		System.out.println(uuid);

		String surrogeteKeyString = uuid.toString();
		surrogeteKeyString = surrogeteKeyString.replace("-", "");
		System.out.println(surrogeteKeyString);

		surrogeteKeyTb.setEmpId(empId);
		surrogeteKeyTb.setSurrogeteKey(surrogeteKeyString);
		surrogeteKeyTb.setIssueDate(now);
		surrogeteKeyTb.setInsertDate(now);
		surrogeteKeyTb.setUpdateDate(now);

		surrogeteKeyRepository.save(surrogeteKeyTb);

		String surrogeteKey = surrogeteKeyRepository.surrogeteKeyFindempId(empId);

		return surrogeteKey;
	}
}
