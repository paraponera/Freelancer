package com.pidev.services;

import java.util.List;

import javax.ejb.Remote;
import com.pidev.persistence.*;

@Remote
public interface PaymentServiceRemote {
	
	public void addPayment(Payment p);
	public void updatePayment(Payment p);
	public Payment findPayment(int idPayment);
	public void deletePayment(Payment p);
	public List<Payment> findAll();
	

}
