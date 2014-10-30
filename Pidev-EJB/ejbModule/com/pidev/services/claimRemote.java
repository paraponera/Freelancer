package com.pidev.services;

import java.util.List;

import javax.ejb.Remote;

import com.pidev.persistence.Claim;

@Remote
public interface claimRemote {
	void Create (Claim claim);
	
	List<Claim> findAllClaim();
	Claim findClaimById(int id);
	void deleteclaim(Claim claim);

}
