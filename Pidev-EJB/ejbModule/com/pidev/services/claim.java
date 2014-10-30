package com.pidev.services;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.pidev.persistence.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class claim implements claimRemote{

	@PersistenceContext
	private EntityManager em;
	
	



public void Create(Claim claim) {
	
	 em.persist(claim);
	
}





public List<Claim> findAllClaim() {
	return em.createQuery("select c from Claim c",Claim.class).getResultList();
}





public Claim findClaimById(int id) {
	Claim found=null;
	String jpql="select a from Claim a where a.id =:x ";
	TypedQuery<Claim> query = em.createQuery(jpql, Claim.class);
	query.setParameter("x", id);
	
	try{
		found=query.getSingleResult();
	}
	catch(Exception e){
		Logger.getLogger(getClass().getName()).log(Level.WARNING, "auth failed with id"+id);
	}
	return found;
}





@Override
public void deleteclaim(Claim claim) {
	// TODO Auto-generated method stub
	
	em.remove(em.merge(claim));
	
	
}









}