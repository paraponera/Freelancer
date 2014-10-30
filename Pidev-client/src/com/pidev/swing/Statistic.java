package com.pidev.swing;

import java.awt.*; 
import java.awt.event.*; 
import java.util.List;

import javax.naming.Context;

import javax.swing.*; 
import org.jfree.chart.*; 
//import org.jfree.chart.plot.*; 
//import org.jfree.data.*; 
import org.jfree.data.general.DefaultPieDataset;

import Job.delegate.JobServiceDelegate;

import com.pidev.persistence.Job;
import com.pidev.services.JobServicesRemote;

public class Statistic extends JFrame { 
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private JPanel pnl; 
JobServicesRemote proxy = null;
Context ctx = null;
  public Statistic() { 
    addWindowListener(new WindowAdapter() { 
      public void windowClosing(WindowEvent e) { 
        dispose(); 
        //System.exit(0); 
      } 
    }); 
   
    
    List<Job> allofThem = JobServiceDelegate.findAllJobs();
    int ver = 0 ;
    int hold = 0 ;
    
	for(Job j : allofThem){
	
	if(j.getState().equalsIgnoreCase("On hold"))
		{
			hold = hold+1;
		}
	else{
			ver = ver+1;
		}
	}
	
    pnl = new JPanel(new BorderLayout()); 
    setContentPane(pnl); 
    setSize(700, 500); 

    DefaultPieDataset pieDataset = new DefaultPieDataset(); 
    pieDataset.setValue("Jobs on hold ("+hold+")", new Integer(hold)); 
    pieDataset.setValue("Jobs verified ("+ver+")", new Integer(ver)); 
   

    JFreeChart pieChart = ChartFactory.createPieChart("Statistic", 
      pieDataset, true, true, true); 
    ChartPanel cPanel = new ChartPanel(pieChart); 
    pnl.add(cPanel); 
    
  } 

  public static void main(String args[]) { 
    Statistic tpc = new Statistic(); 
    tpc.setVisible(true); 
  } 
}
