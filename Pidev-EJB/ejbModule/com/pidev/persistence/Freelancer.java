package com.pidev.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Freelancer
 *
 */
@Entity

public class Freelancer extends User implements Serializable {

	
	private String Skills;
	private String cv;
	private String about;
	private String friend_list;
	private static final long serialVersionUID = 1L;
	private List<Apply> applies;

	public Freelancer() {
		super();
	}   
	
	
	public Freelancer(String first_name, String last_name, String e_mail,
			String country, String city, String username, String pwd,
			boolean state, String type, byte[] picture, float fund, String skills,
			String cv, String about, String friend_list) {
		super(first_name, last_name, e_mail, country, city, username, pwd,
				state, type, picture,fund);
		Skills = skills;
		this.cv = cv;
		this.about = about;
		this.friend_list = friend_list;
	}


	public String getSkills() {
		return this.Skills;
	}

	public void setSkills(String Skills) {
		this.Skills = Skills;
	}   
	public String getCv() {
		return this.cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}   
	public String getAbout() {
		return this.about;
	}

	public void setAbout(String about) {
		this.about = about;
	}
	
	


	public String getFriend_list() {
		return friend_list;
	}


	public void setFriend_list(String friend_list) {
		this.friend_list = friend_list;
	}


	@Override
	public String toString() {
		return super.toString()+ "Freelancer [Skills=" + Skills + ", cv=" + cv + ", about="
				+ about + "]";
	}
	
	@OneToMany (mappedBy ="freelancer")
	public List<Apply> getApplies() {
		return applies;
	}


	public void setApplies(List<Apply> applies) {
		this.applies = applies;
	}
	
   
}
