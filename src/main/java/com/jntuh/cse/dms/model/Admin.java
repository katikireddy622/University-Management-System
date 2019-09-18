package com.jntuh.cse.dms.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;

@Entity
@Table(name="admin_table")
public class Admin {

  @Id
  private String adid;
  private String adpw;
  @Min(value=5)
  private String adname;
  @Min(value=10)
  private Long adphone;
  
  @Email
  private String ademail;
  
  @Temporal(TemporalType.DATE)
  @Past
  private Date addob;
  
 public String getAdid() {
	return adid;
}

public void setAdid(String adid) {
	this.adid = adid;
}

public String getAdpw() {
	return adpw;
}

public void setAdpw(String adpw) {
	this.adpw = adpw;
}

public String getAdname() {
	return adname;
}

public void setAdname(String adname) {
	this.adname = adname;
}

public Long getAdphone() {
	return adphone;
}

public void setAdphone(Long adphone) {
	this.adphone = adphone;
}

public String getAdemail() {
	return ademail;
}

public void setAdemail(String ademail) {
	this.ademail = ademail;
}

public Date getAddob() {
	return addob;
}

public void setAddob(Date addob) {
	this.addob = addob;
}

public Admin(String adid, String adpw, @Min(5) String adname, @Min(10) Long adphone, @Email String ademail,
		@Past Date addob) {
	super();
	this.adid = adid;
	this.adpw = adpw;
	this.adname = adname;
	this.adphone = adphone;
	this.ademail = ademail;
	this.addob = addob;
}

public Admin() {
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "Admin [adid=" + adid + ", adpw=" + adpw + ", adname=" + adname + ", adphone=" + adphone + ", ademail="
			+ ademail + ", addob=" + addob + "]";
} 
 
 
  
}
