package com.project.coursemgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@ComponentScan({"com.project.pojos","com.project.pojos.util"})
@EnableAutoConfiguration
@SpringBootApplication

public class DacCourseMgmtFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(DacCourseMgmtFinalApplication.class, args);
	}

}
