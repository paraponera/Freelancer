package com.pidev.test;


import Job.delegate.JobServiceDelegate;

import com.pidev.persistence.Job;


public class CreateJob {

public static void main (String[] args){
		
		
		
		Job job = new Job();
		//job.setId(3);
		job.setTitle("Designer");
		job.setDescription("1234");
		job.setRequired_skills("xcop");
		job.setEstimate_duration(15);
		job.setState("On hold");
		job.setCost(100);
		job.setUserid(500);
		JobServiceDelegate.create(job);
		
		Job job1 = new Job();
		//job.setId(3);
		job1.setTitle("Web dev");
		job1.setDescription("1234");
		job1.setRequired_skills("xcop");
		job1.setEstimate_duration(15);
		job1.setState("On hold");
		job1.setCost(350);
		job1.setUserid(450);
		JobServiceDelegate.create(job1);
		
		Job job2 = new Job();
		//job.setId(3);
		job2.setTitle("Javaee");
		job2.setDescription("1234");
		job2.setRequired_skills("xcop");
		job2.setEstimate_duration(15);
		job2.setState("On hold");
		job2.setCost(200);
		job2.setUserid(600);
		JobServiceDelegate.create(job2);
		
		
		Job job3 = new Job();
		//job.setId(3);
		job3.setTitle("Architect");
		job3.setDescription("1234");
		job3.setRequired_skills("xcop");
		job3.setEstimate_duration(15);
		job3.setState("On hold");
		job3.setCost(320);
		job3.setUserid(260);
		JobServiceDelegate.create(job3);
		
	}
	
	
}
