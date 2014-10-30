package Job.delegate;

import java.util.List;

import Job.locator.ServiceLocator;

import com.pidev.persistence.Job;
import com.pidev.persistence.Payment;
import com.pidev.services.JobServicesRemote;
import com.pidev.services.PaymentServiceRemote;

public class JobServiceDelegate {

	private static final String jndiName ="ejb:/Pidev-EJB/JobServices!com.pidev.services.JobServicesRemote";
	
	private static JobServicesRemote getProxy(){
		return (JobServicesRemote) ServiceLocator.getInstance().getProxy(jndiName);
	}

	public static void create(Job job){
		getProxy().create(job);
	}
	public static List<Job> findAllJobs() {

		return getProxy().findAllJobs();
	}
	public static Job findJobById(int id)
	{
		return getProxy().findJobById(id);
	}

	public static void update(Job job) {
		getProxy().update(job);

	}
	public static void removeJob(int id) {
		getProxy().removeJob(id);
		
	}
	
	
	
	
	
	


}

