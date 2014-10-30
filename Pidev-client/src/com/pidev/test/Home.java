package com.pidev.test;

import gui.Add;
import gui.ListSc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import payment.payment;

import com.pidev.swing.JobList;
import com.pidev.swing.ListJ;
import com.pidev.swing.Statistic;

import Client.interfaces.Adduser;
import Client.interfaces.bloc_unblock;

import claiminterface.addclaim;
import claiminterface.displayclaims;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Adminadd = new JButton("Add user");
		Adminadd.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		Adminadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Adduser frame = new Adduser();
				frame.setVisible(true);
			}
		});
		Adminadd.setBounds(83, 117, 168, 47);
		contentPane.add(Adminadd);
		
		JButton User = new JButton("Block/Unblock user");
		User.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				bloc_unblock frame = new bloc_unblock();
				frame.setVisible(true);
			}
		});
		User.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		User.setBounds(481, 117, 168, 47);
		contentPane.add(User);
		
		JButton Jobs = new JButton("Job's manager");
		Jobs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ListJ frame = new ListJ();
				frame.setVisible(true);
			}
		});
		Jobs.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		Jobs.setBounds(287, 117, 168, 47);
		contentPane.add(Jobs);
		
		JButton Claim = new JButton("Claim management");
		Claim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				displayclaims frame = new displayclaims();
				frame.setVisible(true);
				
			}
		});
		Claim.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		Claim.setBounds(83, 224, 168, 47);
		contentPane.add(Claim);
		
		JButton Payment = new JButton("Payment");
		Payment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				payment frame = new payment();
				frame.setVisible(true);
			}
		});
		Payment.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		Payment.setBounds(481, 224, 168, 47);
		contentPane.add(Payment);
		
		JButton Stats = new JButton("Statistic");
		Stats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dispose();
				Statistic tpc = new Statistic(); 
			    tpc.setVisible(true); 
			}
		});
		Stats.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		Stats.setBounds(287, 224, 168, 47);
		contentPane.add(Stats);
		
		JButton btnCategoryManaging = new JButton("Add category");
		btnCategoryManaging.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Add frame = new Add();
				frame.setVisible(true);
			}
		});
		btnCategoryManaging.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		btnCategoryManaging.setBounds(83, 328, 168, 47);
		contentPane.add(btnCategoryManaging);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		btnExit.setBounds(481, 328, 168, 47);
		contentPane.add(btnExit);
		
		JButton btnCategoryList = new JButton("Category list");
		btnCategoryList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ListSc frame = new ListSc();
				frame.setVisible(true);
			}
		});
		btnCategoryList.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		btnCategoryList.setBounds(287, 328, 168, 47);
		contentPane.add(btnCategoryList);
		
		JLabel lblNewLabel_1 = new JLabel("Freelancer");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 50));
		lblNewLabel_1.setBounds(236, 35, 241, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\omar\\Documents\\PI 2014-2015\\backgroundjavaee.jpg"));
		lblNewLabel.setBounds(0, 0, 719, 410);
		contentPane.add(lblNewLabel);
	}
}
