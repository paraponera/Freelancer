package com.pidev.persistence;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Job_owner
 *
 */
@Entity

public class Job_owner extends User implements Serializable {

	
	private String company_name;
	//private String fund;
	private static final long serialVersionUID = 1L;

	public Job_owner() {
		super();
	}  
	
	
	public Job_owner(String first_name, String last_name, String e_mail,
			String country, String city, String username, String pwd,
			boolean state, String type, byte[] picture, String company_name,
			float fund) {
		super(first_name, last_name, e_mail, country, city, username, pwd,
				state, type, picture, fund);
		this.company_name = company_name;
		//this.fund = fund;
	}


	public String getCompany_name() {
		return this.company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}   
	


	@Override
	public String toString() {
		return super.toString() + "Job_owner [company_name=" + company_name + "]";
	}
	
	
   
}
