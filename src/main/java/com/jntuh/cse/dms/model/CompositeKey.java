package com.jntuh.cse.dms.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Embeddable
public class CompositeKey implements Serializable {

	@NotNull
	private String sid;
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date adate;
	@NotNull
	private String cid;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public Date getAdate() {
		return adate;
	}
	public void setAdate(Date adate) {
		this.adate = adate;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public CompositeKey(@NotNull String sid, @NotNull Date adate, @NotNull String cid) {
		super();
		this.sid = sid;
		this.adate = adate;
		this.cid = cid;
	}
	
	public CompositeKey() {
		// TODO Auto-generated constructor stub
	}
	
}
