package com.broadway.springDemo.controller;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.broadway.springDemo.model.Student;
import com.broadway.springDemo.repository.StudentRepository;

@Controller
public class IndexController {
	@Autowired
	StudentRepository sturepo;
	@PostMapping("/homepage")
public String postIndex(@ModelAttribute Student stu, Model mod) {
		
		Student stud = sturepo.FindByNameAndPassword(stu.getName(), stu.getPassword());
		if(stud != null) {
			mod.addAttribute("name", stu.getName());
			return "home";
		}
		mod.addAttribute("message", "not found");
	return "index";
}
}
