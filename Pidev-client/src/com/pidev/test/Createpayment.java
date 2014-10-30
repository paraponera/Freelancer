package com.pidev.test;

import Client.delegate.PaymentServiceDelegate;
import Client.delegate.UserServiceDelgate2;

import com.pidev.persistence.Claim;
import com.pidev.persistence.Payment;

public class Createpayment {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Payment pay=new Payment();
		pay.setIdfreelancer(1);
		pay.setIdjobowner(1);
		pay.setSolde((float) 550);
		
		PaymentServiceDelegate.addPayment(pay);

	}

}
