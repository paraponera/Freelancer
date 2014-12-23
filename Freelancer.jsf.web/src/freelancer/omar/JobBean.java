package freelancer.omar;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;

import org.primefaces.component.selectcheckboxmenu.SelectCheckboxMenu;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.pidev.persistence.Job;
import com.pidev.services.*;

@ManagedBean
@ViewScoped
public class JobBean {
	private StreamedContent Content;
	private Job job = new Job();
	@EJB
	private JobServicesRemote  JobServicesRemote;
	private List<Job> jobs;
	private boolean formDisplyed = false;
	private List<SelectItem> filterOptions;
	private List<SelectItem> DatefilterOptions;
	 
	 



	@PostConstruct
	public void init(){
		jobs = JobServicesRemote.findAllJobs();
		filterOptions = new ArrayList<SelectItem>();
		filterOptions.add( new SelectItem("  "));
		for(Job job:jobs){
			filterOptions.add(new SelectItem(job.getState()));
		}
		 
		
		 
		DatefilterOptions = new ArrayList<SelectItem>();
		DatefilterOptions.add(new SelectItem("Jan²"));
		DatefilterOptions.add(new SelectItem("Feb"));
		DatefilterOptions.add(new SelectItem("BMN"));
		 
	}
	
	public JobBean() {
		 
		 
	}
	
	 

	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public List<Job> getJobs() {
		return jobs;
	}
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
	public boolean isFormDisplyed() {
		return formDisplyed;
	}


	public void setFormDisplyed(boolean formDisplyed) {
		this.formDisplyed = formDisplyed;
	}
    public void UpdateJob(){
    	
    	 
    	 JobServicesRemote.UpdateStatusJob(job);
    	jobs = JobServicesRemote.findAllJobs();
    	 
    	 
    
    	
      }
    public void DeleteJob(){
    	
    	
    	 JobServicesRemote.remove(job);;
    	jobs = JobServicesRemote.findAllJobs();
    	
    	 
      }

	/*public StreamedContent getContent() {
		InputStream stream = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream(Job.getPath()); 
		Content = new DefaultStreamedContent(stream, "image/jpg", "downloaded_optimus.jpg");
    
		
		return Content;
	}*/

	public void setContent(StreamedContent content) {
		Content = content;
	}

	public List<SelectItem> getFilterOptions() {
		return filterOptions;
	}

	public void setFilterOptions(List<SelectItem> filterOptions) {
		this.filterOptions = filterOptions;
	}

	public List<SelectItem> getDatefilterOptions() {
		return DatefilterOptions;
	}

	public void setDatefilterOptions(List<SelectItem> datefilterOptions) {
		DatefilterOptions = datefilterOptions;
	}
	 
    

}
