package com.project.coursemgmt.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.coursemgmt.daos.FacultyRepository;
import com.project.coursemgmt.daos.ModulesRepository;
import com.project.coursemgmt.pojos.FacultyPojo;
import com.project.coursemgmt.pojos.ModulePojo;
import com.project.pojos.util.CalendarUtilities;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ModulesRepository modules;
	@Autowired
	private CalendarUtilities service;
	@Autowired
	private FacultyRepository faculties;

	@GetMapping("/modules")
	public List<ModulePojo> populateModules() {

		return modules.findAll();
	}
	

	@PostMapping("/modules")
	public String modulesAdd(ModulePojo p) {

		try {
			modules.save(p);
			return "{ \"status\" : \"success\"}";
		} catch (Exception e) {
			return "{ \"status\" : \"present \"}";
		}

	}

	@PutMapping("/modules")
	public String modulesUpdate(ModulePojo p) {
		/*
		 * ModulePojo update=modules.findById(p.getModule_id()).get(); p=update;
		 */
		try {
			modules.save(p);
			return "{ \"status\" : \"success\"}";
		} catch (Exception e) {
			return "{ \"status\" : \"error in updating\"}";
		}

	}

	@DeleteMapping("/modules/{id}")
	public String moduleDelete(@PathVariable Integer id) {
		try {
			modules.deleteById(id);
			return "{ \"status\" : \"success\"}";
		} catch (Exception e) {
			return "{ \"status\" : \"error in deleting\"}";
		}
	}
	
	
	@GetMapping("/faculty")
	public List<FacultyPojo> populateFaculty() {

		return faculties.findAll();
	}
	
	

	@PostMapping("/faculty")
	public String facultyAdd(FacultyPojo p) {

		try {
			faculties.save(p);
			return "{ \"status\" : \"success\"}";
		} catch (Exception e) {
			return "{ \"status\" : \"present\" }";
		}

	}

	@PutMapping("/faculty/{id}")
	public String facultypdate(FacultyPojo p,@PathVariable String id) {
		/*
		 * ModulePojo update=modules.findById(id).get(); p=update;
		 */
		try {
			faculties.save(p);
			return "{ \"status\" : \"success\"}";
		} catch (Exception e) {
			return "{ \"status\" : \"duplicate entry for this module\"}";
		}

	}

	@DeleteMapping("/faculty/{id}")
	public String facultyDelete(@PathVariable String id) {
		try {
			faculties.deleteById(id);
			return "{ \"status\" : \"success\"}";
		} catch (Exception e) {
			return "{ \"status\" : \"error\"}";
		}
	}
	
	@PostMapping("/calendar")
	public String calendarSet(List<LocalDate> d) {
		
		if(service.setHolidays(d))
			
		 return "{ \"status\" : \"success\"}";
		else 
			return "{ \"status\" : \"error\"}";
		
		
	}


}
