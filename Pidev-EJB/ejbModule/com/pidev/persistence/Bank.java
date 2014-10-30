package com.pidev.persistence;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Bank
 *
 */
@Entity

public class Bank implements Serializable {

	   
	
	private int id;
	private float fund;
	private float gain;
	private static final long serialVersionUID = 1L;

	public Bank() {
		super();
	}  
	
	
	
	public Bank(float fund, float gain) {
		super();
		this.fund = fund;
		this.gain = gain;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public float getFund() {
		return this.fund;
	}

	public void setFund(float fund) {
		this.fund = fund;
	}
	
	



	public float getGain() {
		return gain;
	}



	public void setGain(float gain) {
		this.gain = gain;
	}



	@Override
	public String toString() {
		return "Bank [fund=" + fund + ", gain=" + gain + "]";
	}



	
	
	
   
}
