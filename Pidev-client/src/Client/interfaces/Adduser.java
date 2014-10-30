package Client.interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import Client.delegate.UserServiceDelegate;

import com.pidev.persistence.User;
import com.pidev.test.Home;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Adduser extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldSecondName;
	private JTextField textFieldEmail;
	private JTextField textFieldCountry;
	private JTextField textFieldCity;
	private JTextField textFieldUsername;
	private JTextField textFieldPwd;
	private JButton btnAdduser;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_7;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adduser frame = new Adduser();
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
	public Adduser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(203, 73, 160, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldSecondName = new JTextField();
		textFieldSecondName.setBounds(203, 114, 160, 20);
		contentPane.add(textFieldSecondName);
		textFieldSecondName.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(203, 159, 160, 20);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldCountry = new JTextField();
		textFieldCountry.setBounds(203, 199, 160, 20);
		contentPane.add(textFieldCountry);
		textFieldCountry.setColumns(10);
		
		textFieldCity = new JTextField();
		textFieldCity.setBounds(203, 244, 160, 20);
		contentPane.add(textFieldCity);
		textFieldCity.setColumns(10);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(203, 288, 160, 20);
		contentPane.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		textFieldPwd = new JTextField();
		textFieldPwd.setBounds(203, 327, 160, 20);
		contentPane.add(textFieldPwd);
		textFieldPwd.setColumns(10);
		
		btnAdduser = new JButton("Add Administrator");
		btnAdduser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				User user =new User();
				user.setCity(textFieldCity.getText());
				user.setCountry(textFieldCountry.getText());
				user.setE_mail(textFieldEmail.getText());
				user.setFirst_name(textFieldName.getText());
				user.setFund(0);
				user.setLast_name(textFieldSecondName.getText());
				user.setPwd(textFieldPwd.getText());
				user.setState(true);
				user.setType("Administrator");
				user.setUsername(textFieldUsername.getText());
				if(textFieldCity.getText().equals("") || textFieldCountry.getText().equals("") || textFieldEmail.getText().equals("") || textFieldName.getText().equals("") || textFieldSecondName.getText().equals("") || textFieldPwd.getText().equals("") || textFieldUsername.getText().equals("")  )
				{
					String message = "error empty field";
					JOptionPane.showMessageDialog(new JFrame(), message,"alert",JOptionPane.INFORMATION_MESSAGE);	
				}
				else {
				UserServiceDelegate.saveEmployee(user);
				String message = "Add successful";
				JOptionPane.showMessageDialog(new JFrame(), message,"alert",JOptionPane.INFORMATION_MESSAGE);
				
				}
			}
		});
		btnAdduser.setBounds(254, 408, 170, 35);
		contentPane.add(btnAdduser);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setBounds(66, 76, 89, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Second Name");
		lblNewLabel_1.setBounds(66, 117, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setBounds(66, 162, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Country");
		lblNewLabel_3.setBounds(66, 202, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("City");
		lblNewLabel_4.setBounds(66, 250, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("UserName");
		lblNewLabel_5.setBounds(66, 291, 66, 14);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Password");
		lblNewLabel_6.setBounds(66, 330, 66, 14);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_8 = new JLabel("Add Administrator");
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(165, 24, 149, 14);
		contentPane.add(lblNewLabel_8);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Home frame = new Home();
				frame.setVisible(true); 
				dispose();
			}
		});
		btnBack.setBounds(30, 408, 170, 35);
		contentPane.add(btnBack);
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\omar\\Documents\\PI 2014-2015\\backgroundjavaee.jpg"));
		lblNewLabel_7.setBounds(0, 0, 434, 474);
		contentPane.add(lblNewLabel_7);
	}
}
