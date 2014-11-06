package com.pidev.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.pidev.persistence.Categories;
import com.pidev.persistence.Sous_Categories;

/**
 * Session Bean implementation class SousCategoriesServices
 */
@Stateless
@LocalBean
public class SousCategoriesServices implements SousCategoriesServicesRemote, SousCategoriesServicesLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager entityManager;
    public SousCategoriesServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insertSousCategories(Sous_Categories sous_Categories) {
		entityManager.persist(sous_Categories);
		
	}

	@Override
	public List<Sous_Categories> getAll() {
		Query query = entityManager.createQuery("select s from Sous_Categories s");
		return query.getResultList();
	}

	@Override
	public void delete(int id) {
		entityManager.remove(findbyid(id));
		
	}

	@Override
	public Sous_Categories findbyid(int id) {
		return entityManager.find(Sous_Categories.class, id);
	}

	

	/*@Override
	public void deleteSousCategories(int id) {
		entityManager.remove(id);
		
	}*/

}
