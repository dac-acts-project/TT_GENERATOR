package com.project.coursemgmt.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.coursemgmt.daos.CommonLoginDao;
import com.project.coursemgmt.daos.FacultyRepository;
import com.project.coursemgmt.pojos.CommonLoginPojo;
import com.project.coursemgmt.pojos.FacultyPojo;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

	@Autowired
	FacultyRepository faculties;
	@Autowired
	CommonLoginDao dao;
	
	@GetMapping("/registration")
	public String registerFaculty() {
		
		
		
		return "{ \"status\" : \"not present \"}";
		
	}
	
	@PostMapping("/registration")
	public String registeringData(FacultyPojo f, HttpServletResponse res)
	{
		CommonLoginPojo user=new CommonLoginPojo();
		
		FacultyPojo p= faculties.save(f);
		
		user.setUsername(p.getFaculty_username());
		user.setPassword(p.getFaculty_password());
		user.setRole("faculty");
		dao.save(user);
		try {
			res.sendRedirect(res.encodeRedirectURL("faculty/mainpage"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return "{ \"status\" : \"error \"}";
		}
		
		return "{ \"status\" : \"done redirection \"}";
		
	}
	
	@GetMapping("/mainpage")
	public String check() {
		
		return "hello bhai";
	}



}
