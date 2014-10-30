package com.pidev.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.pidev.persistence.Categories;

/**
 * Session Bean implementation class CategoriesServices
 */
@Stateless
@LocalBean
public class CategoriesServices implements CategoriesServicesRemote, CategoriesServicesLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager entityManager;
    public CategoriesServices() {
        
    }

	@Override
	public void insertCategories(Categories categories) {
		entityManager.persist(categories);
		
		
	}

	@Override
	public void updateCategories(Categories categories) {
		entityManager.merge(categories);
		
	}

	@Override
	public void deleteCategories(Categories categories) {
		entityManager.remove(categories);
		
	}

	@Override
	public Categories getById(int Id_Ca) {
		
		return entityManager.find(Categories.class, Id_Ca);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categories> getAll() {
		Query query = entityManager.createQuery("selecet c from Categories c");
		return query.getResultList();
	}

}
