package com.jntuh.cse.dms.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="faculty_table")
public class Faculty {

	@Id
	private String fid;
	@NotNull(message="Please Enter Password")
	@Length(min=6,message="Should Be Minimum 6 Characters")
	private String fpw;
	@NotNull(message="Please Enter Your Designtion")
	private String fdes;
	@NotNull(message="Please Enter Your Name")
	private String fname;
	@NotNull
	private String fgender;
	@NotNull(message="Please Enter Your Branch")
	private String fbranch;
	@Email
	@NotNull(message="Please Enter Your Email")
	private String femail;
	
	@NotNull(message="Please Enter Your Phone")
	private Long fphone;
	@NotNull(message="Please Enter Your Address")
	private String faddress;
	
	@Temporal(TemporalType.DATE)
	private Date fdob;
	
	
	public Faculty(String fid,
			@NotNull(message = "Please Enter Password") @Length(min = 6, message = "Should Be Minimum 6 Characters") String fpw,
			@NotNull(message = "Please Enter Your Designtion") String fdes,
			@NotNull(message = "Please Enter Your Name") String fname, @NotNull String fgender,
			@NotNull(message = "Please Enter Your Branch") String fbranch,
			@Email @NotNull(message = "Please Enter Your Email") String femail,
			@NotNull(message = "Please Enter Your Phone") Long fphone,
			@NotNull(message = "Please Enter Your Address") String faddress, Date fdob) {
		super();
		this.fid = fid;
		this.fpw = fpw;
		this.fdes = fdes;
		this.fname = fname;
		this.fgender = fgender;
		this.fbranch = fbranch;
		this.femail = femail;
		this.fphone = fphone;
		this.faddress = faddress;
		this.fdob = fdob;
	}


	public String getFid() {
		return fid;
	}


	public void setFid(String fid) {
		this.fid = fid;
	}


	public String getFpw() {
		return fpw;
	}


	public void setFpw(String fpw) {
		this.fpw = fpw;
	}


	public String getFdes() {
		return fdes;
	}


	public void setFdes(String fdes) {
		this.fdes = fdes;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getFgender() {
		return fgender;
	}


	public void setFgender(String fgender) {
		this.fgender = fgender;
	}


	public String getFbranch() {
		return fbranch;
	}


	public void setFbranch(String fbranch) {
		this.fbranch = fbranch;
	}


	public String getFemail() {
		return femail;
	}


	public void setFemail(String femail) {
		this.femail = femail;
	}


	public Long getFphone() {
		return fphone;
	}


	public void setFphone(Long fphone) {
		this.fphone = fphone;
	}


	public String getFaddress() {
		return faddress;
	}


	public void setFaddress(String faddress) {
		this.faddress = faddress;
	}


	public Date getFdob() {
		return fdob;
	}


	public void setFdob(Date fdob) {
		this.fdob = fdob;
	}


	public Faculty() {
		// TODO Auto-generated constructor stub
	}
}
