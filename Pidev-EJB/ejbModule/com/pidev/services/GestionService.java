package com.pidev.services;

import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.pidev.persistence.User;

/**
 * Session Bean implementation class GestionService
 */
@Stateless
public class GestionService implements GestionServiceRemote, GestionServiceLocal {
	
	@PersistenceContext
	private EntityManager em;
	
	
	

    
    public GestionService() {
        // TODO Auto-generated constructor stub
    }

	
	public User authenticate(String login, String password) {
		User found = null;
		String jpql = "select u from User u where u.e_mail =:x and u.pwd=:y ";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("x", login);
		query.setParameter("y", password);
		
		
		
		try{
			found = query.getSingleResult();
		}catch(Exception e){
			Logger.getLogger(getClass().getName()).log(Level.WARNING, "auth attempt failed with login="+login+" and password="+password);
		}
		return found;
	}

	
	public List<User> findAllUsers() {
		return em.createQuery("select u from User u", User.class).getResultList();
	}

	
	public void UpdateUser(User user) {
		em.merge(user); 
		
	}


	public void Block(User user) {
		user.setState(false);
		em.merge(user);
		
	}


	
	public void Unblock(User user) {
		
		em.merge(user);
		
	}


	
	public void saveUser(User user) {
		em.merge(user);
		
	}


	@Override
	public User findUserById(int id) {

User found=null;
String jpql="select a from User a where a.id =:x ";
TypedQuery<User> query = em.createQuery(jpql, User.class);
query.setParameter("x", id);

try{
found=query.getSingleResult();
}
catch(Exception e){
Logger.getLogger(getClass().getName()).log(Level.WARNING, "auth failed with id"+id);
}
return found;

	}


	

}
