package com.pidev.persistence;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Apply
 *
 */
@Entity

public class Apply implements Serializable {

	
	
	private static final long serialVersionUID = 1L;
	
	
	private ApplyPK applyPK;
	private Freelancer freelancer;
	private Job job;

	public Apply() {
		super();
	}
@EmbeddedId
	public ApplyPK getApplyPK() {
		return applyPK;
	}

	public void setApplyPK(ApplyPK applyPK) {
		this.applyPK = applyPK;
	}
	@ManyToOne
	@JoinColumn(name="freelancer_fk", updatable =false,insertable = false)
	public Freelancer getFreelancer() {
		return freelancer;
	}

	public void setFreelancer(Freelancer freelancer) {
		this.freelancer = freelancer;
	}
	@ManyToOne
	@JoinColumn(name="job_fk", updatable =false,insertable = false)
	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}   
	
   
}
