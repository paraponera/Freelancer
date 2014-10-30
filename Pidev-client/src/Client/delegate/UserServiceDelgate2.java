package Client.delegate;

import java.util.List;

import com.pidev.persistence.Claim;
import com.pidev.services.claim;
import com.pidev.services.claimRemote;

public class UserServiceDelgate2  {
	


	private static final String jndiName ="ejb:/Pidev-EJB/claim!com.pidev.services.claimRemote";
	
	private static claimRemote getProxy(){
		return (claimRemote) Client.locator.ServiceLocator.getInstance().getProxy(jndiName);
	}

	
	public static   void Create(Claim claim) {
		getProxy().Create(claim);
	}

	
	public static  List<Claim> findAllClaim() {
		
		return getProxy().findAllClaim();
		
	}


	
	public static Claim findClaimById(int id) {
		
		return getProxy().findClaimById(id);
	}
	
	
	
	public static void deleteclaim(Claim claim)
	{
		
		getProxy().deleteclaim(claim);
		
		
		
	}

}
