package com.pidev.persistence;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Claim
 *
 */
@Entity

public class Claim implements Serializable {

	   
	
	private int id;
	private String contenu;
	private String title;
	private String state;
	private String email;
	private static final long serialVersionUID = 1L;

	public Claim() {
		super();
	}  
	
	
	public Claim(String contenu, String title, String state, String email) {
		super();
		this.contenu = contenu;
		this.title = title;
		this.state = state;
		this.email = email;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getContenu() {
		return this.contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}   
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}   
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Claim [contenu=" + contenu + ", title=" + title + ", state="
				+ state + ", email=" + email + "]";
	}
	
	
   
}
