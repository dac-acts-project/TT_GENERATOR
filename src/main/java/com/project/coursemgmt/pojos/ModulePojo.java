package com.project.coursemgmt.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "modules_info")
public class ModulePojo {

	private Integer module_id;
	private String module_name;
	private String module_desc;
	private Integer module_total_hrs;
	private List<FacultyPojo> faculties = new ArrayList<>();

	public ModulePojo() {
		System.out.println("module pojo in");
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	public Integer getModule_id() {
		return module_id;
	}

	public void setModule_id(Integer module_id) {
		this.module_id = module_id;
	}

	@Column(name = "module_name", length = 50)
	public String getModule_name() {
		return module_name;
	}

	public void setModule_name(String module_name) {
		this.module_name = module_name;
	}

	@Column(name = "module_desc")
	public String getModule_desc() {
		return module_desc;
	}

	public void setModule_desc(String module_desc) {
		this.module_desc = module_desc;
	}

	@Column(name = "total_hours")
	public Integer getModule_total_hrs() {
		return module_total_hrs;
	}

	public void setModule_total_hrs(Integer module_total_hrs) {
		this.module_total_hrs = module_total_hrs;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "faculty_module", joinColumns = @JoinColumn(name = "f_uname"), inverseJoinColumns = @JoinColumn(name = "module_id"))
	public List<FacultyPojo> getFaculties() {
		return faculties;
	}

	public void setFaculties(List<FacultyPojo> faculties) {
		this.faculties = faculties;
	}

}
