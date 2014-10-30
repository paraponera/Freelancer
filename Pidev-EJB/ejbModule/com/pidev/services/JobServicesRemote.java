package com.pidev.services;

import java.util.List;

import javax.ejb.Remote;

import com.pidev.persistence.Job;

@Remote
public interface JobServicesRemote {

	void create(Job job);
	Job findJobById(int id);
	void update(Job job);
	void remove(Job job);
	void removeJob(int id);
	List<Job> findAllJobs();
	
}
