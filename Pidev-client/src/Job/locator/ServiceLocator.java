package Job.locator;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import Client.locator.ServiceLocatorException;

public class ServiceLocator {
	
	private static ServiceLocator instance;
	
	private Map<String, Object> cache;
	private Context context;
	
	
	public static ServiceLocator getInstance() {
		if(instance == null)
		{
			instance = new ServiceLocator();
		}
		return instance;
	}



	private Map<String, Object> getCache() {
		return cache;
	}



	private ServiceLocator(){
		cache = new HashMap<>();
		try {
			context = new InitialContext();
		} catch (NamingException e) {
			throw new ServiceLocatorException(e);
		}
	}
	
	public synchronized Object getProxy(String jndiName){
		Object proxy = cache.get(jndiName);
		if(proxy == null)
		{
			try {
				proxy = context.lookup(jndiName);
			} catch (NamingException e) {
				throw new ServiceLocatorException(e);			}
		}
		cache.put(jndiName, proxy);
		return proxy;
	}

}
