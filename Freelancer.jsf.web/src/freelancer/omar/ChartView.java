package freelancer.omar;
 
import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.PieChartModel;

import com.pidev.persistence.Job;
import com.pidev.services.*;
 
@ManagedBean
public class ChartView implements Serializable {
	
	private Job job = new Job();
	@EJB
	private JobServicesRemote  JobServicesRemote;
	private List<Job> jobs;
    private PieChartModel pieModel1;
    private PieChartModel pieModel2;
    int ver = 0 ;
    int hold = 0 ;

 
    @PostConstruct
    public void init() {
    	jobs = JobServicesRemote.findAllJobs();
    	
    	for(Job j : jobs){
    		
    		if(j.getState().equalsIgnoreCase("On hold"))
    			{
    				hold = hold+1;
    			}
    		else{
    				ver = ver+1;
    			}
    		}
        

        createPieModels();
    }
 
    public PieChartModel getPieModel1() {
        return pieModel1;
    }
     
    public PieChartModel getPieModel2() {
        return pieModel2;
    }
     
    private void createPieModels() {
        createPieModel1();
        createPieModel2();
    }
 
    private void createPieModel1() {
        pieModel1 = new PieChartModel();
         
        pieModel1.set("Verified", ver);
        pieModel1.set("On hold", hold);
        
         
        pieModel1.setTitle("Statistic");
        pieModel1.setLegendPosition("w");
    }
     
    private void createPieModel2() {
        pieModel2 = new PieChartModel();
         
        
        pieModel2.set("Verified", ver);
        pieModel2.set("On hold", hold);
       
         
        pieModel2.setTitle("Percent");
        pieModel2.setLegendPosition("e");
        pieModel2.setFill(false);
        pieModel2.setShowDataLabels(true);
        pieModel2.setDiameter(150);
    }
     
}