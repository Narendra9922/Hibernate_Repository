package com.ketan.DO;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "STUDENT")
@NamedQuery(name = "ALL_STUDENT", query ="from StudentDO where sname =:name")
@NamedNativeQuery(name = "CALL_PROC", query = "{call GET_STUDENTS}", callable = true , resultClass = StudentDO.class)
public class StudentDO {

	@Id
	@Column(name = "roll_no")
	int rollno;
	@Column(name = "name")
	String sname;
	@Column(name = "city")
	String scity;
	@Column(name = "marks")
	int smarks;
	@Column(name = "grade")
	char sgrade;
	@Column(name = "modfiy_cnt")
	@Type(type = "int")
	@Version
	int vr_cntl;
	@CreationTimestamp
	@Column(name = "insert_tmsp")
	Timestamp isrt_dt;
	@CreationTimestamp
	@Column(name = "update_tmsp")
	Timestamp updt_dt;
	
	public Timestamp getIsrt_dt() {
		return isrt_dt;
	}
	public void setIsrt_dt(Timestamp isrt_dt) {
		this.isrt_dt = isrt_dt;
	}
	public Timestamp getUpdt_dt() {
		return updt_dt;
	}
	public void setUpdt_dt(Timestamp updt_dt) {
		this.updt_dt = updt_dt;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getScity() {
		return scity;
	}
	public void setScity(String scity) {
		this.scity = scity;
	}
	public int getSmarks() {
		return smarks;
	}
	public void setSmarks(int smarks) {
		this.smarks = smarks;
	}
	public char getSgrade() {
		return sgrade;
	}
	public void setSgrade(char sgrade) {
		this.sgrade = sgrade;
	}
	public int getVr_cntl() {
		return vr_cntl;
	}
	public void setVr_cntl(int vr_cntl) {
		this.vr_cntl = vr_cntl;
	}
	
	@Override
	public String toString() {
		return "Student Informaion : Roll_No=" + rollno + 
				"\t Name=" + sname + 
				"\t City=" + scity + 
				"\t Marks=" + smarks + 
				"\t Grade=" + sgrade +
				"\t Insert Date=" + isrt_dt +
				"\t Last Update Date=" + updt_dt +
				"\t Modification_count=" + vr_cntl;
	}

}
