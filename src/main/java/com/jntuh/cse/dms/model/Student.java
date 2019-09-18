package com.jntuh.cse.dms.model;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;



@Entity
@Table(name="student_table")
public class Student {

	
	@Id
	private String sid;
	
	@Size(min=6,message="PassWord should Be Minimum 6 Characters")
	@NotNull
	private String spw;
	
	@NotNull
	private String sname;
	
	@NotNull
	private String sgender;
	
	@NotNull
	private Long sphone;
	
	@Email
	@NotNull
	private String semail;
	
	@Size(max=500,message="Address should not Exceed 500 Charaters")
	@NotNull
	private String saddress;
	
	@Temporal(TemporalType.DATE)
	private Date sdob;
	
	@NotNull(message="Please Enter The Branch")
	private String sbranch;
	
	@NotNull
	@Min(value=2012,message="Please Enter The Joining Year")
	private int sjyear;
	
	@Min(value=1,message="Please Enter The Year")
	@NotNull
	private int spyear;
	
	@Min(value=1,message="Please Enter The Semester")
	@NotNull
	private int spsem;
	
	@NotNull
	private String spsec;
	 
	
	@NotNull
	private String sfname; 
	
	@NotNull
	private Long sfphone;
	
	@Email
	@NotNull
	private String sfemail;
	
	@NotNull
	private String smname; 
	
	@NotNull
	private Long smphone;
	
	
	@Email
	@NotNull
	private String smemail;


	
	
public String getSid() {
		return sid;
	}




	public void setSid(String sid) {
		this.sid = sid;
	}




	public String getSpw() {
		return spw;
	}




	public void setSpw(String spw) {
		this.spw = spw;
	}




	public String getSname() {
		return sname;
	}




	public void setSname(String sname) {
		this.sname = sname;
	}




	public String getSgender() {
		return sgender;
	}




	public void setSgender(String sgender) {
		this.sgender = sgender;
	}




	public Long getSphone() {
		return sphone;
	}




	public void setSphone(Long sphone) {
		this.sphone = sphone;
	}




	public String getSemail() {
		return semail;
	}




	public void setSemail(String semail) {
		this.semail = semail;
	}




	public String getSaddress() {
		return saddress;
	}




	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}




	public Date getSdob() {
		return sdob;
	}




	public void setSdob(Date sdob) {
		this.sdob = sdob;
	}




	public String getSbranch() {
		return sbranch;
	}




	public void setSbranch(String sbranch) {
		this.sbranch = sbranch;
	}




	public int getSjyear() {
		return sjyear;
	}




	public void setSjyear(int sjyear) {
		this.sjyear = sjyear;
	}




	public int getSpyear() {
		return spyear;
	}




	public void setSpyear(int spyear) {
		this.spyear = spyear;
	}




	public int getSpsem() {
		return spsem;
	}




	public void setSpsem(int spsem) {
		this.spsem = spsem;
	}




	public String getSpsec() {
		return spsec;
	}




	public void setSpsec(String spsec) {
		this.spsec = spsec;
	}




	public String getSfname() {
		return sfname;
	}




	public void setSfname(String sfname) {
		this.sfname = sfname;
	}




	public Long getSfphone() {
		return sfphone;
	}




	public void setSfphone(Long sfphone) {
		this.sfphone = sfphone;
	}




	public String getSfemail() {
		return sfemail;
	}




	public void setSfemail(String sfemail) {
		this.sfemail = sfemail;
	}




	public String getSmname() {
		return smname;
	}




	public void setSmname(String smname) {
		this.smname = smname;
	}




	public Long getSmphone() {
		return smphone;
	}




	public void setSmphone(Long smphone) {
		this.smphone = smphone;
	}




	public String getSmemail() {
		return smemail;
	}




	public void setSmemail(String smemail) {
		this.smemail = smemail;
	}




public Student(String sid, @Size(min = 6, message = "PassWord should Be Minimum 6 Characters") @NotNull String spw,
			@NotNull String sname, @NotNull String sgender, @NotNull Long sphone, @Email @NotNull String semail,
			@Size(max = 500, message = "Address should not Exceed 500 Charaters") @NotNull String saddress,
			@Past Date sdob, @Size(max = 5, message = "Maximum of 5 Charaters") String sbranch,
			@NotNull @Min(value = 2010, message = "Joining Year Should Be Greater Than 2010") int sjyear,
			@NotNull @Min(value = 1, message = "Year Should Written Like 1,2,3,4 or 5") @Max(value = 5, message = "Year Should Written Like 1,2,3,4 or 5") int spyear,
			@Min(value = 1, message = "Sem Should be 1 or 2") @Max(value = 2, message = "Sem Should be 1 or 2") int spsem,
			@Size(min = 1, max = 2, message = "enter sem and section i.e.. A,B,C2") String spsec,
			@NotNull String sfname, @NotNull Long sfphone, @Email @NotNull String sfemail, @NotNull String smname,
			@NotNull Long smphone, @Email @NotNull String smemail) {
		super();
		this.sid = sid;
		this.spw = spw;
		this.sname = sname;
		this.sgender = sgender;
		this.sphone = sphone;
		this.semail = semail;
		this.saddress = saddress;
		this.sdob = sdob;
		this.sbranch = sbranch;
		this.sjyear = sjyear;
		this.spyear = spyear;
		this.spsem = spsem;
		this.spsec = spsec;
		this.sfname = sfname;
		this.sfphone = sfphone;
		this.sfemail = sfemail;
		this.smname = smname;
		this.smphone = smphone;
		this.smemail = smemail;
	}




public Student() {
	// TODO Auto-generated constructor stub
}




@Override
public String toString() {
	return "Student [sid=" + sid + ", spw=" + spw + ", sname=" + sname + ", sgender=" + sgender + ", sphone=" + sphone
			+ ", semail=" + semail + ", saddress=" + saddress + ", sdob=" + sdob + ", sbranch=" + sbranch + ", sjyear="
			+ sjyear + ", spyear=" + spyear + ", spsem=" + spsem + ", spsec=" + spsec + ", sfname=" + sfname
			+ ", sfphone=" + sfphone + ", sfemail=" + sfemail + ", smname=" + smname + ", smphone=" + smphone
			+ ", smemail=" + smemail + "]";
}




}
