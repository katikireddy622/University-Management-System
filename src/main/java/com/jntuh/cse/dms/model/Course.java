package com.jntuh.cse.dms.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="course_table")
public class Course {
    
	@Id
	@Length(max=5,min=5,message="Should Be 5 Characters")
	private String cid;
	@NotNull
	private String cname;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Course(@Length(max = 5, min = 5, message = "Should Be 5 Characters") String cid, @NotNull String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}
	
	public Course() {
		
	}
	
}
