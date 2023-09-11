package com.broadway.springDemo.controller;

import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.broadway.springDemo.model.Student;
import com.broadway.springDemo.repository.StudentRepository;

@Controller

public class SignupController {
	@Autowired

	private StudentRepository sturepo;

	@GetMapping("signupcontroller")
	public String signupIndex() {
		return "signup";
	}

	

	@PostMapping("signup")
	public String signupPost(@ModelAttribute Student stu) {
		stu.setPassword(DigestUtils.md5DigestAsHex(stu.getPassword().getBytes()));
		
		sturepo.save(stu);
		return "index";
	}
}
