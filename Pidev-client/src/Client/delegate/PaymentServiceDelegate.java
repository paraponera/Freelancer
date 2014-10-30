package Client.delegate;

import java.util.List;





import com.pidev.persistence.*;

import com.pidev.services.PaymentServiceRemote;






public class PaymentServiceDelegate {

	private static final String jndiName ="ejb:/Pidev-EJB/PaymentService!com.pidev.services.PaymentServiceRemote";
	
	private static PaymentServiceRemote getProxy(){
		return (PaymentServiceRemote) Client.locator.ServiceLocator.getInstance().getProxy(jndiName);
	}

	public static void addPayment(Payment p){
		getProxy().addPayment(p);
	}
	public static List<Payment> findAll() {

		return getProxy().findAll();
	}
	public static Payment findPayment(int idPayment)
	{
		return getProxy().findPayment(idPayment);
	}

	public static void updatePayment(Payment p) {
		getProxy().updatePayment(p);

	}
	
	
	
	
	
	


}
