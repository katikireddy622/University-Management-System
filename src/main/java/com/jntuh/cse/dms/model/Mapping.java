package com.jntuh.cse.dms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="mapping_table")
public class Mapping {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int mid;
	@NotNull
	private String mfid;
	@NotNull
	private String mcid;
	
	@NotNull
	private int myear;
	@NotNull
	private int msem;
	@NotNull
	private String msec;
	@NotNull
	private int mayear;
	
	


	public Mapping(int mid, @NotNull String mfid, @NotNull String mcid, @NotNull int myear, @NotNull int msem,
			@NotNull String msec, @NotNull int mayear) {
		super();
		this.mid = mid;
		this.mfid = mfid;
		this.mcid = mcid;
		this.myear = myear;
		this.msem = msem;
		this.msec = msec;
		this.mayear = mayear;
	}




	public int getMid() {
		return mid;
	}




	public void setMid(int mid) {
		this.mid = mid;
	}




	public String getMfid() {
		return mfid;
	}




	public void setMfid(String mfid) {
		this.mfid = mfid;
	}




	public String getMcid() {
		return mcid;
	}




	public void setMcid(String mcid) {
		this.mcid = mcid;
	}




	public int getMyear() {
		return myear;
	}




	public void setMyear(int myear) {
		this.myear = myear;
	}




	public int getMsem() {
		return msem;
	}




	public void setMsem(int msem) {
		this.msem = msem;
	}




	public String getMsec() {
		return msec;
	}




	public void setMsec(String msec) {
		this.msec = msec;
	}




	public int getMayear() {
		return mayear;
	}




	public void setMayear(int mayear) {
		this.mayear = mayear;
	}




	public Mapping() {
		// TODO Auto-generated constructor stub
	}
}
