package com.pidev.persistence;
import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class ApplyPK implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private int id_freelancer;
	
	private int id_job;
	private Date startdate;
	
	
	
	
	@Column(name="freelancer_fk")
	public int getId_freelancer() {
		return id_freelancer;
	}
	public void setId_freelancer(int id_freelancer) {
		this.id_freelancer = id_freelancer;
	}
	@Column(name="job_fk")
	public int getId_job() {
		return id_job;
	}
	public void setId_job(int id_job) {
		this.id_job = id_job;
	}
	@Column(name="start_date")
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	
	public String toString() {
		return "ApplyPK [id_freelancer=" + id_freelancer + ", id_job=" + id_job
				+ ", startdate=" + startdate + "]";
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_freelancer;
		result = prime * result + id_job;
		result = prime * result
				+ ((startdate == null) ? 0 : startdate.hashCode());
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApplyPK other = (ApplyPK) obj;
		if (id_freelancer != other.id_freelancer)
			return false;
		if (id_job != other.id_job)
			return false;
		if (startdate == null) {
			if (other.startdate != null)
				return false;
		} else if (!startdate.equals(other.startdate))
			return false;
		return true;
	}
	
}
