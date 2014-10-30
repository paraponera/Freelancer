package com.pidev.persistence;

import java.io.Serializable;
import java.lang.Float;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Payment
 *
 */
@Entity

public class Payment implements Serializable {

	
	private int id;
	private Float solde;
	private int idfreelancer;
	private int idjobowner;
	private Double compte;
	public Double getCompte() {
		return compte;
	}
	public void setCompte(Double compte) {
		this.compte = compte;
	}

	private static final long serialVersionUID = 1L;

	public Payment() {
		
	}   
	@Id  
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public Float getSolde() {
		return this.solde;
	}

	public void setSolde(Float solde) {
		this.solde = solde;
	}   
	public int getIdfreelancer() {
		return this.idfreelancer;
	}

	public void setIdfreelancer(int idfreelancer) {
		this.idfreelancer = idfreelancer;
	}   
	public int getIdjobowner() {
		return this.idjobowner;
	}

	public void setIdjobowner(int idjobowner) {
		this.idjobowner = idjobowner;
	}
   
}
