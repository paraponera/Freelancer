package com.pidev.swing;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;

import javax.swing.JTable;

import Job.delegate.JobServiceDelegate;

import com.pidev.persistence.Job;
//import com.pidev.services.JobServicesRemote;
import com.pidev.test.Home;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ListJ extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private javax.swing.JTable table;
	//JobServicesRemote proxy = null;
	//Context ctx = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListJ frame = new ListJ();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void a(){
	 	   
	 	   String[] columnNames = {"Id",
	               "Title" ,
	               "Cost",
	                "State",
	                
	                "Fund of user"
	                };
	 	  /* try{
	 		   ctx = new InitialContext();
	 		   proxy = (JobServicesRemote) ctx.lookup("ejb:/Pidev-EJB/JobServices!com.pidev.services.JobServicesRemote");
	 		   
	 	   }catch(NamingException ex){
	 		   ex.printStackTrace();
	 		   
	 	   }*/

	 	   List<Job> allofThem = JobServiceDelegate.findAllJobs();

	 	   Object[][] data=new Object[allofThem.size()][5];
	 	   
	 	   
	 	   for (int i=0;i<allofThem.size();i++)
	 	   {
	 		   data[i][0]=allofThem.get(i).getId();
	 		   data[i][1]=allofThem.get(i).getTitle();
	 		   data[i][2]=allofThem.get(i).getCost();
	 		   data[i][3]=allofThem.get(i).getState();
	 		   data[i][4]=allofThem.get(i).getUserid();
	 	   }

	 	   table.setModel(new DefaultTableModel(data,columnNames){/**
	 	    * 
	 	    */
	 		   private static final long serialVersionUID = 1L;
	 		   
	 		   public boolean isCellEditable(int row, int col) {
	 			   return false;
	 		   }});
	 	   
	 	   
	    }
	 
	public ListJ() {
		initComponents();
		a();
	}

	/**
	 * Create the frame.
	 */
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 135, 553, 176);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBounds(0, 0, 551, 1);
		 scrollPane.setViewportView(table);
		//contentPane.add(table);
		
		JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = table.getSelectedRow();
		        int aa=(int)table.getValueAt(a,0);
		        int ab=(int)table.getValueAt(a,4);
		        String ac=table.getValueAt(a,3).toString();
		        String message = "Insufficient fund";
		        String message1 = "Already verified";
		        Job job = new Job();
		        job=JobServiceDelegate.findJobById(aa);
		        
		        
		        if(ac.equalsIgnoreCase("On hold")){
		        if(job.getCost()<=ab  ){
		        	
		        	job.setState("Verified");
		        	JobServiceDelegate.update(job);
		            a();
		        	
		        }
		        else {
		        	
		        	JOptionPane.showMessageDialog(new JFrame(), message,
							"Alerte", JOptionPane.INFORMATION_MESSAGE);
							}
		        }else{  
		        	JOptionPane.showMessageDialog(new JFrame(), message1,
						"Alerte", JOptionPane.INFORMATION_MESSAGE); 
		        	}
			}
		});
		button.setText("Approve");
		button.setBounds(596, 125, 116, 49);
		contentPane.add(button);
		
		JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = table.getSelectedRow();
		        int aa=(int)table.getValueAt(a,0);
		        String ab=table.getValueAt(a,3).toString();
		        String message = "Job already verified cannot be removed";
		        
		        if(ab.equalsIgnoreCase("Verified")){
		        	
		        	JOptionPane.showMessageDialog(new JFrame(), message,
							"Alerte", JOptionPane.INFORMATION_MESSAGE);
		        	
		        }
		        else {
		        	//System.out.println(ab);
		        	//System.out.println(aa);
		        	JobServiceDelegate.removeJob(aa);
		            a();
		        	
							}
			}
		});
		button_1.setText("Reject/Delete");
		button_1.setBounds(596, 203, 116, 49);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton();
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home frame = new Home();
				frame.setVisible(true); 
				dispose();
			}
		});
		button_2.setText("Back");
		button_2.setBounds(596, 284, 116, 48);
		contentPane.add(button_2);
		
		JLabel label = new JLabel();
		label.setForeground(Color.GRAY);
		label.setText("Job Proposals Manager");
		label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 36));
		label.setBounds(135, 30, 354, 42);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\omar\\Documents\\PI 2014-2015\\backgroundjavaee.jpg"));
		lblNewLabel.setBounds(0, 0, 722, 418);
		contentPane.add(lblNewLabel);
	}

}
