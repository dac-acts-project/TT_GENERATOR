package com.project.coursemgmt.controller;

<<<<<<< HEAD
import java.util.List;
=======
import java.io.IOException;
>>>>>>> 61551b3cf9f23170f42428d5fcc08efaa563005b

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.coursemgmt.daos.CalendarRepository;
import com.project.coursemgmt.daos.CommonLoginDao;
import com.project.coursemgmt.daos.FacultyRepository;
import com.project.coursemgmt.daos.ModulesRepository;
import com.project.coursemgmt.pojos.Calendar;
import com.project.coursemgmt.pojos.CommonLoginPojo;
import com.project.coursemgmt.pojos.FacultyPojo;
import com.project.coursemgmt.pojos.ModulePojo;
=======
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.coursemgmt.daos.CommonLoginDao;
import com.project.coursemgmt.daos.FacultyRepository;
import com.project.coursemgmt.pojos.CommonLoginPojo;
import com.project.coursemgmt.pojos.FacultyPojo;
>>>>>>> 61551b3cf9f23170f42428d5fcc08efaa563005b

@RestController
@RequestMapping("/faculty")
public class FacultyController {

	@Autowired
	FacultyRepository faculties;
	@Autowired
	CommonLoginDao dao;
<<<<<<< HEAD
	@Autowired
	CalendarRepository calrepo;
	@Autowired
	ModulesRepository module_repo;

	@GetMapping("/dashboard")
	public List<Calendar> registerFaculty() {

		return calrepo.findAll();

	}

	@PostMapping("/registration")
	public String registeringData(@RequestBody FacultyPojo f, HttpServletResponse res) {
		CommonLoginPojo user = new CommonLoginPojo(f.getFaculty_username());

		System.out.println(f);
		try {
			FacultyPojo p = faculties.save(f);

			/* user.setUsername(p.getFaculty_username()); */
			user.setPassword(p.getFaculty_password());
			user.setRole("faculty");
			dao.save(user);

		} catch (Exception e) {

			return "{ \"status\" : \"error\"}";
		}

		return "{ \"status\" : \"success\"}";

	}

	@PostMapping("/availability/{id}") // [20190101,20190201 ,20190301]
	public String availabilityAdd(@RequestBody List<Integer> dates, @PathVariable Integer id) {

		FacultyPojo fp = faculties.findById(id).get();
		for (Integer dateid : dates) {
			fp.addAvailability(calrepo.findById(dateid).get());
		}

		return "success";
	}

	@PostMapping("/moduleadd/{id}") // [20190101,20190201 ,20190301]
	public String modulesAdd(@RequestBody List<Integer> modules, @PathVariable Integer id) {

		System.out.println(modules);
		System.out.println(id);
		FacultyPojo fp = faculties.findById(id).get();
		ModulePojo mp;
		System.out.println(module_repo.findAll());
		System.out.println(fp);
		for (int moduleid : modules) {
			System.out.println(moduleid);
			
			mp=module_repo.findById(moduleid).orElse(null);
			System.out.println(mp);
			fp.addModules(mp);
		}

		return "success";
	}
	
	
=======
	
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


>>>>>>> 61551b3cf9f23170f42428d5fcc08efaa563005b

}
