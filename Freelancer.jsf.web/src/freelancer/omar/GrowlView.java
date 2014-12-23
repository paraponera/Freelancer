package freelancer.omar;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
@ManagedBean
public class GrowlView {
	 private String message;
	 
	    public String getMessage() {
	        return message;
	    }
	 
	    public void setMessage(String message) {
	        this.message = message;
	    }
	     
	    public void saveMessage() {
	        FacesContext context = FacesContext.getCurrentInstance();
	         
	        context.addMessage(null, new FacesMessage("Successful",  "Your message: " + message) );
	        context.addMessage(null, new FacesMessage("Second Message", "Additional Message Detail"));
	    }
	    public void RefuseMessage() {
	        FacesContext context = FacesContext.getCurrentInstance();
	         
	        context.addMessage(null, new FacesMessage("Successful",  "The job has been deleted " + "") );
	      
	    }
	    public void AcceptMessage() {
	        FacesContext context = FacesContext.getCurrentInstance();
	         
	        context.addMessage(null, new FacesMessage("Successful",  "The job has been verified " + "") );
	      
	    }

}
