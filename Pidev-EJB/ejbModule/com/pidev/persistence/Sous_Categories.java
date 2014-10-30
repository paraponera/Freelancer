package com.pidev.persistence;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Sous_Categories
 *
 */
@Entity

public class Sous_Categories implements Serializable {

	   
	
	private int Id_Sc;
	private String Name;
	private Categories categories ;
	private static final long serialVersionUID = 1L;

	public Sous_Categories() {
		super();
	} 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId_Sc() {
		return this.Id_Sc;
	}

	public void setId_Sc(int Id_Sc) {
		this.Id_Sc = Id_Sc;
	}   
	public String getName() {
		return this.Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(insertable=true , name="Id_Ca" , referencedColumnName="Id_Ca")
	public Categories getCategories() {
		return categories;
	}
	public void setCategories(Categories categories) {
		this.categories = categories;
	}
   
}
