package com.pidev.services;

import javax.ejb.Remote;

import com.pidev.persistence.User;
import java.util.List;

@Remote
public interface GestionServiceRemote {
	
	void saveUser(User user);
	
	User authenticate(String login, String password);
	List<User> findAllUsers();
	User findUserById(int id);
	public void UpdateUser(User user);

    void Block(User user);
    void Unblock(User user);
}
