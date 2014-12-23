package com.pidev.services;

import java.util.List;

import javax.ejb.Local;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pidev.persistence.Freelancer;
import com.pidev.persistence.Job;
import com.pidev.persistence.User;

@Local
@Path("/rest")
public interface JobServicesLocal {

	@PUT
	@Consumes({ MediaType.APPLICATION_XML })
	@Path("/addjob")
	void create(Job job);

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/jobById/{id}")
	Job findJobById(@PathParam("id") int id);

	@POST
	@Consumes("application/json")
	@Path("/updateJob")
	void update(Job job);

	void remove(Job job);

	@DELETE
	@Path("/deleteById/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	void removeJob(@PathParam("id") int id);

	@GET
	@Path("/listAllJobs")
	@Produces(MediaType.APPLICATION_JSON)
	List<Job> findAllJobs();
	
	@GET
	@Path("/listAllfreelancers")
	@Produces(MediaType.APPLICATION_JSON)
	List<User> findAllfreelancers();
}
