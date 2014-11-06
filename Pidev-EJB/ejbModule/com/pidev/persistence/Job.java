package com.pidev.persistence;

import java.io.Serializable;

import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Job
 *
 */
@Entity

public class Job implements Serializable {

	   
	
	private int id;
	private String title;
	private String description;
	private String required_skills;
	private int estimate_duration;
	//private String category;
	private String state;
	private float cost;
	private Categories categ;
	private int userid;
	private static final long serialVersionUID = 1L;
	private List<Apply> applies;

	public Job() {
		super();
	} 
	
	
	public Job(String title, String description, String required_skills,
			int estimate_duration, String state, float cost, int userid) {
		super();
		this.title = title;
		this.description = description;
		this.required_skills = required_skills;
		this.estimate_duration = estimate_duration;
		//this.category = category;
		this.state = state;
		this.cost = cost;
		this.userid = userid;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	
	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public String getRequired_skills() {
		return this.required_skills;
	}

	public void setRequired_skills(String required_skills) {
		this.required_skills = required_skills;
	} 
	
	  
	public int getEstimate_duration() {
		return estimate_duration;
	}


	public void setEstimate_duration(int estimate_duration) {
		this.estimate_duration = estimate_duration;
	}


	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}


	public float getCost() {
		return cost;
	}


	public void setCost(float cost) {
		this.cost = cost;
	}
	
	

	@ManyToOne
	@JoinColumn(name = "categ_fk")
	public Categories getCateg() {
		return categ;
	}


	public void setCateg(Categories categ) {
		this.categ = categ;
	}
	


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


	@Override
	public String toString() {
		return "Job [id=" + id + ", title=" + title + ", description="
				+ description + ", required_skills=" + required_skills
				+ ", estimate_duration=" + estimate_duration + ", state="
				+ state + ", cost=" + cost + ", categ=" + categ + ", userid="
				+ userid + "]";
	}

	@OneToMany (mappedBy ="job")
	public List<Apply> getApplies() {
		return applies;
	}


	public void setApplies(List<Apply> applies) {
		this.applies = applies;
	}


	


	


	
	
	
	
   
}
