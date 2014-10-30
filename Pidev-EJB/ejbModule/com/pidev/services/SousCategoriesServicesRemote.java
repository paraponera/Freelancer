package com.pidev.services;

import java.util.List;

import javax.ejb.Remote;



import com.pidev.persistence.Categories;
import com.pidev.persistence.Sous_Categories;

@Remote
public interface SousCategoriesServicesRemote {

	public void insertSousCategories(Sous_Categories sous_Categories);
	public List<Sous_Categories> getAll();
	public void delete(int id);
	public Sous_Categories findbyid(int id);
	
}
