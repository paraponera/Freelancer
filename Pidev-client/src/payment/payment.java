package payment;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JTextField;

import com.pidev.persistence.*;
import com.pidev.test.Home;

 import Client.delegate.PaymentServiceDelegate;
import Client.delegate.UserServiceDelegate;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class payment extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					payment frame = new payment();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public payment() {
		
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList listpay = new JList();
		listpay.setBounds(47, 92, 373, 265);
		contentPane.add(listpay);
		
		JLabel lblLaListeDes = new JLabel("La liste des  payements ");
		lblLaListeDes.setForeground(Color.RED);
		lblLaListeDes.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLaListeDes.setBounds(241, 11, 269, 52);
		contentPane.add(lblLaListeDes);
		
		
		
		JLabel lblLeSoldeDe = new JLabel("le solde de votre compte est de :");
		lblLeSoldeDe.setBounds(493, 120, 175, 14);
		contentPane.add(lblLeSoldeDe);
		 JTextArea solde = new JTextArea();
		 solde.setEditable(false);
		solde.setBounds(503, 145, 120, 35);
		contentPane.add(solde);


		JLabel lblDt = new JLabel("DT");
		lblDt.setBounds(641, 147, 46, 14);
		contentPane.add(lblDt);
		List<Payment> p = PaymentServiceDelegate.findAll();
		DefaultListModel model = new DefaultListModel();
		double so = 0.0;
		for (int i = 0; i < p.size(); i++) {
			User u = UserServiceDelegate.findUserById(p.get(i).getIdfreelancer());
			User u1 = UserServiceDelegate.findUserById(p.get(i).getIdjobowner());
			System.out.print(u.getUsername());
			model.addElement("Name Freelancer :    "+u.getUsername()+"     Name job owner :    "+u1.getUsername()) ;
			
			so = p.get(i).getSolde()+so;
		}
		
		so = so * 0.12;

		for (int i = 0; i < p.size(); i++) {
		p.get(i).setCompte(so);
		PaymentServiceDelegate.updatePayment(p.get(i));
		}
		solde.setText(so+" ");
		listpay.setModel(model);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home frame = new Home();
				frame.setVisible(true); 
				dispose();
			}
		});
		btnNewButton.setBounds(503, 221, 126, 35);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\omar\\Documents\\PI 2014-2015\\backgroundjavaee.jpg"));
		lblNewLabel.setBounds(0, 0, 697, 434);
		contentPane.add(lblNewLabel);
//		for (Payment payment : PaymentServiceDelegate.findAll()) {
//			System.out.print(payment.getIdfreelancer());
//			User u = UserServiceDelegate.findUserById(payment.getIdfreelancer());
////			model.addElement("Name Freelancer"+u.getUsername()) ;
//			
//			//solde.setText((Float)(payment.getSolde()));
//			
//			listpay.setModel(model);
//		}
      
	}
}
