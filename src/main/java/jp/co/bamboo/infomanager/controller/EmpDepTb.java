package jp.co.bamboo.infomanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import jp.co.bamboo.infomanager.repository.LinkEmpDepIdRepository;

@Controller
public class EmpDepTb {
	@Autowired
	LinkEmpDepIdRepository ledRepository;


}
