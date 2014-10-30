package com.pidev.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Categories
 *
 */
@Entity

public class Categories implements Serializable {

	   
	
	private int Id_Ca;
	private String Name;
	private List<Sous_Categories> scs;
	private List<Job> jobs;
	
	
	private static final long serialVersionUID = 1L;

	public Categories() {
		super();
	}  
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId_Ca() {
		return this.Id_Ca;
	}

	public void setId_Ca(int Id_Ca) {
		this.Id_Ca = Id_Ca;
	}   
	public String getName() {
		return this.Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}
	@OneToMany(mappedBy="categories", cascade=CascadeType.ALL)
	public List<Sous_Categories> getScs() {
		return scs;
	}
	public void setScs(List<Sous_Categories> scs) {
		this.scs = scs;
	}
	@OneToMany (mappedBy = "categ" )
	public List<Job> getJobs() {
		return jobs;
	}
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
	
	public void assignSousCategoriesToThisClass(List<Sous_Categories> scs) {
		
		this.setScs(scs);
		for(Sous_Categories s: scs)
		{
			s.setCategories(this);
		}
		}
		
	}
   

