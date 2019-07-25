package com.project.pojos.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.coursemgmt.daos.CalendarRepository;
import com.project.coursemgmt.daos.FacultyRepository;

@Component
public class CalendarUtilities {
	
	@Autowired
	private CalendarRepository repo;
	@Autowired
	FacultyRepository f_repo;
	
	
	public Boolean setHolidays(List<Integer> ids) {
		
		for (Integer id : ids) {
			repo.getOne(id).setHoliday_flag('t');
		}
			
		return true;
		
	}
	
	
}
