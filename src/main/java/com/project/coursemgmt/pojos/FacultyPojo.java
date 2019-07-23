package com.project.coursemgmt.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "faculty_info")
public class FacultyPojo {
	
	private String faculty_username;
	private String faculty_name;
	private Integer rating;
	private Double experience;
	private Boolean lab;
	private List<ModulePojo> modules=new ArrayList<>(); 
	
	public FacultyPojo() {
		System.out.println("faculty pojo in");
	}
	
	@Id
	@Column(name="username",length = 50)
	public String getFaculty_username() {
		return faculty_username;
	}
	
	public void setFaculty_username(String faculty_username) {
		this.faculty_username = faculty_username;
	}
	
	
	@Column(name = "faculty_name",length = 50)
	public String getFaculty_name() {
		return faculty_name;
	}
	public void setFaculty_name(String faculty_name) {
		this.faculty_name = faculty_name;
	}
	
	@Column(name = "rating",length = 5)
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
	@Column(name = "experience")
	public double getExperience() {
		return experience;
	}
	public void setExperience(Double experience) {
		this.experience = experience;
	}

	
	@Column(name="lab_flag")
	public Boolean getLab() {
		return lab;
	}
	public void setLab(Boolean lab) {
		this.lab = lab;
	}

	
	@ManyToMany(mappedBy = "faculties")
	public List<ModulePojo> getModules() {
		return modules;
	}

	public void setModules(List<ModulePojo> modules) {
		this.modules = modules;
	}

	
	
	
	

}
