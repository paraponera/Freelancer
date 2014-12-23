package com.pidev.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.pidev.persistence.Freelancer;
import com.pidev.persistence.Job;
import com.pidev.persistence.User;

/**
 * Session Bean implementation class JobServices
 */
@Stateless
public class JobServices implements JobServicesRemote, JobServicesLocal {

    @PersistenceContext
    private EntityManager em;
    
    
    public JobServices() {
        // TODO Auto-generated constructor stub
    }

	
	public void create(Job job) {
		em.persist(job);
		
	}

	@Override
	public Job findJobById(int id) {
		return em.find(Job.class, id);
		
	}

	@Override
	public void update(Job job) {
		em.merge(job);
		
	}

	@Override
	public void remove(Job job) {
		em.remove(em.merge(job));
		
	}

	
	public void removeJob(int id) {
		em.remove(em.find(Job.class, id));
		
	}

	
	public List<Job> findAllJobs() {
		return em.createQuery("select j from Job j", Job.class).getResultList();
	}


	
	public List<User> findAllfreelancers() {
		
		List<User> users=new ArrayList<User>();
	    users =  em.createQuery("select u from User u", User.class).getResultList();
		//List<Freelancer> freelancers = new ArrayList<Freelancer>();
		List<User> frealancers = new ArrayList<User>();
		for (User u : users) {
			if(u instanceof Freelancer){
				frealancers.add(u); 
			}
			
		}
		return frealancers;
	}
	@Override
	public void UpdateStatusJob(Job j) {
		// TODO Auto-generated method stub
		 
		Job job = em.find(Job.class, j.getId());
		job.setState("verified");
		em.merge(job);
		
	}
	
	public List<Object[]> StatisticJob() {
		
		Query q = em.createQuery("select j.date , count(*) from Job j group by state");
		return q.getResultList();
	 }

}
