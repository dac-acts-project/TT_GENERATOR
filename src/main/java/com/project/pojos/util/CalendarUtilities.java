package com.project.pojos.util;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.coursemgmt.daos.CalendarRepository;
import com.project.coursemgmt.pojos.Calendar;

@Component
public class CalendarUtilities {
	
	@Autowired
	private CalendarRepository repo;
	
	
	public Boolean setHolidays(List<LocalDate> list) {
		
		int i;
			for (LocalDate localDate : list) {
				i=localDate.getYear()*1000+localDate.getMonthValue()*100+localDate.getDayOfMonth();
				Calendar c=repo.findById(i).get();
				c.setHoliday_flag('t');
			}
		return true;
		
	}
	

	
}
