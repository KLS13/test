package kr.co.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kr.co.test.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService service;

}
