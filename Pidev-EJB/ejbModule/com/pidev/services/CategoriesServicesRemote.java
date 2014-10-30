package com.pidev.services;

import java.util.List;


import javax.ejb.Remote;

import com.pidev.persistence.Categories;

@Remote
public interface CategoriesServicesRemote {
	
	public void insertCategories(Categories categories);
    public void updateCategories(Categories categories);
    public void deleteCategories(Categories categories);
    public Categories getById(int Id_Ca);
    public List<Categories> getAll();
}
