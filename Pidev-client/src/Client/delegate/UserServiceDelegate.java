package Client.delegate;

import java.util.List;


import java.util.logging.Level;
import java.util.logging.Logger;

import com.pidev.services.*;

import com.pidev.persistence.*;




public class UserServiceDelegate     {

	private static final String jndiName ="ejb:/Pidev-EJB/GestionService!com.pidev.services.GestionServiceRemote";
	
	
	
	private static GestionServiceRemote getProxy(){
		return (GestionServiceRemote) Client.locator.ServiceLocator.getInstance().getProxy(jndiName);
	}


	public static User authenticate(String login, String password) {
		
		return getProxy().authenticate(login, password);
	}


	public static List<User> findAllUsers() {
		
		return getProxy().findAllUsers();
	}



	
	public static void UpdateUser(User user) {
		getProxy().UpdateUser(user);
		
	}


	public static void Block(User user) {
		getProxy().Block(user);
		
	}


	public static void Unblock(User user) {
		getProxy().Unblock(user);
		
	}


	
	public static void saveEmployee(User user) {
		getProxy().saveUser(user);
		
	}


	
	public static User findUserById(int id) {
		
		return getProxy().findUserById(id);
	}


	
	
	
	
	
	
	
	
	
}



	
		