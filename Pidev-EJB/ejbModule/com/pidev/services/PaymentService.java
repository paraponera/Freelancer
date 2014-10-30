package com.pidev.services;

import java.util.List;

import javax.ejb.LocalBean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.pidev.persistence.*;

/**
 * Session Bean implementation class PaymentService
 */
@Stateless
@LocalBean
public class PaymentService implements PaymentServiceRemote {


	
	@PersistenceContext
	EntityManager em;
	


	
	 /**
     * Default constructor. 
     */
	
	
	public PaymentService() {
		
		// TODO Auto-generated constructor stub
	}




	@Override
	public void addPayment(Payment p) {
		em.persist(p);
		
	}




	@Override
	public void updatePayment(Payment p) {
		em.merge(p);
		
	}




	
	public Payment findPayment(int idPayment) {
		
		return em.find(Payment.class, idPayment);
	}




	@Override
	public void deletePayment(Payment p) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public List<Payment> findAll() {
		return em.createQuery("select p from Payment p", Payment.class).getResultList();
	}


}
