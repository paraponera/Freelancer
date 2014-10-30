package com.pidev.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.Arrays;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class User implements Serializable {

	   
	
	private int id;
	private String first_name;
	private String last_name;
	private String e_mail;
	private String country;
	private String city;
	private String username;
	private String pwd;
	private boolean state;
	private String type;
	private byte[] picture;
	private float fund;
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	} 
	
	
	public User(String first_name, String last_name, String e_mail,
			String country, String city, String username, String pwd,
			boolean state, String type, byte[] picture, float fund) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.e_mail = e_mail;
		this.country = country;
		this.city = city;
		this.username = username;
		this.pwd = pwd;
		this.state = state;
		this.type = type;
		this.picture = picture;
		this.fund = fund;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getFirst_name() {
		return this.first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}   
	public String getLast_name() {
		return this.last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}   
	public String getE_mail() {
		return this.e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}   
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}   
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}   
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}   
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}   
	
	public boolean getState() {
		return this.state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}   


	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}


	public float getFund() {
		return fund;
	}


	public void setFund(float fund) {
		this.fund = fund;
	}


	@Override
	public String toString() {
		return "User [first_name=" + first_name + ", last_name=" + last_name
				+ ", e_mail=" + e_mail + ", country=" + country + ", city="
				+ city + ", username=" + username + ", pwd=" + pwd + ", state="
				+ state + ", type=" + type +", fund=" + fund+ ", picture="
				+ Arrays.toString(picture) + "]";
	}   
	
	
	
   
}
