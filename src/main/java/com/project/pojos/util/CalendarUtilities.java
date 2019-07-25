package com.project.pojos.util;

<<<<<<< HEAD
=======
import java.time.LocalDate;
>>>>>>> 61551b3cf9f23170f42428d5fcc08efaa563005b
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.coursemgmt.daos.CalendarRepository;
<<<<<<< HEAD
import com.project.coursemgmt.daos.FacultyRepository;
=======
import com.project.coursemgmt.pojos.Calendar;
>>>>>>> 61551b3cf9f23170f42428d5fcc08efaa563005b

@Component
public class CalendarUtilities {
	
	@Autowired
	private CalendarRepository repo;
<<<<<<< HEAD
	@Autowired
	FacultyRepository f_repo;
	
	
	public Boolean setHolidays(List<Integer> ids) {
		
		for (Integer id : ids) {
			repo.getOne(id).setHoliday_flag('t');
		}
			
=======
	
	
	public Boolean setHolidays(List<LocalDate> list) {
		
		int i;
			for (LocalDate localDate : list) {
				i=localDate.getYear()*1000+localDate.getMonthValue()*100+localDate.getDayOfMonth();
				Calendar c=repo.findById(i).get();
				c.setHoliday_flag('t');
			}
>>>>>>> 61551b3cf9f23170f42428d5fcc08efaa563005b
		return true;
		
	}
	
<<<<<<< HEAD
=======

>>>>>>> 61551b3cf9f23170f42428d5fcc08efaa563005b
	
}
