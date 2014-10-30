package claiminterface;

//import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

//import Client.delegate.UserServiceDelegate;
import Client.delegate.UserServiceDelgate2;

import com.pidev.persistence.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
//import javax.swing.ImageIcon;

public class addclaim extends JFrame {

	private JPanel contentPane;
	private JTextField mail;
	private JTextField title;
	private JTextField content;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addclaim frame = new addclaim();
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
	public addclaim() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddNewClaim = new JLabel("                                                   Add New Claim");
		lblAddNewClaim.setForeground(Color.RED);
		lblAddNewClaim.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddNewClaim.setBounds(5, 5, 575, 33);
		contentPane.add(lblAddNewClaim);
		
		JLabel lblEmail = new JLabel("E_mail:");
		lblEmail.setForeground(Color.BLUE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEmail.setBounds(10, 49, 82, 20);
		contentPane.add(lblEmail);
		
		mail = new JTextField();
		mail.setBounds(105, 50, 433, 20);
		contentPane.add(mail);
		mail.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Title:");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(7, 97, 69, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Content:");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(5, 233, 87, 33);
		contentPane.add(lblNewLabel_1);
		
		title = new JTextField();
		title.setBounds(107, 98, 433, 20);
		contentPane.add(title);
		title.setColumns(10);
		
		content = new JTextField();
		content.setBounds(110, 146, 433, 212);
		contentPane.add(content);
		content.setColumns(10);
		
		JButton btnSubmit = new JButton("Validate");
		btnSubmit.setForeground(new Color(50, 205, 50));
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Claim rec=new Claim();
				rec.setContenu(content.getText());
				rec.setEmail(mail.getText());
				rec.setTitle(title.getText());
				UserServiceDelgate2.Create(rec);
				
				
				
			}
		});
		btnSubmit.setBounds(265, 388, 160, 47);
		contentPane.add(btnSubmit);
	}
}
