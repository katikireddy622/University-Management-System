package com.jntuh.cse.dms.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="attendance_table")
public class Attendance {

	@EmbeddedId
	private CompositeKey compositeKey;
	@NotNull
	private int ayear;
	@NotNull
	private int attended;
	@NotNull
	private int atotal;
	public CompositeKey getCompositeKey() {
		return compositeKey;
	}
	public void setCompositeKey(CompositeKey compositeKey) {
		this.compositeKey = compositeKey;
	}
	public int getAyear() {
		return ayear;
	}
	public void setAyear(int ayear) {
		this.ayear = ayear;
	}
	public int getAttended() {
		return attended;
	}
	public void setAttended(int attended) {
		this.attended = attended;
	}
	public int getAtotal() {
		return atotal;
	}
	public void setAtotal(int atotal) {
		this.atotal = atotal;
	}
	public Attendance(CompositeKey compositeKey, @NotNull int ayear, @NotNull int attended, @NotNull int atotal) {
		super();
		this.compositeKey = compositeKey;
		this.ayear = ayear;
		this.attended = attended;
		this.atotal = atotal;
	}
	
	public Attendance() {
		// TODO Auto-generated constructor stub
	}
	
}
