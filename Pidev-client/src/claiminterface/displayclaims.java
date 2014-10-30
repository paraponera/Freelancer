package claiminterface;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.management.modelmbean.ModelMBean;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;

import com.pidev.persistence.*;
import com.pidev.test.Home;

import Client.delegate.UserServiceDelegate;
import Client.delegate.UserServiceDelgate2;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.ImageIcon;


public class displayclaims extends JFrame {

	private JPanel contentPane;
	private JTextField mail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					displayclaims frame = new displayclaims();
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
	public displayclaims() {
		setResizable(false);
		final List<Integer> idct=new ArrayList<Integer>();
		
	
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAllClaims = new JLabel("                            All Claims");
		lblAllClaims.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblAllClaims.setForeground(Color.RED);
		lblAllClaims.setBounds(81, 3, 369, 42);
		contentPane.add(lblAllClaims);
		
		final JList list = new JList();
		
		final JTextArea textArea = new JTextArea();
		textArea.setBounds(240, 69, 185, 287);
		contentPane.add(textArea);
		list.addMouseListener(new MouseAdapter() {
			
			
			public void mousePressed(MouseEvent e) {
				
				
				
				Claim c  =	UserServiceDelgate2.findClaimById(idct.get(list.getSelectedIndex()));
				textArea.setText("E mail : "+c.getEmail()+"\n"+
									"Titre :"+c.getTitle()+"\n"+
									"Contenu : "+c.getContenu()+"\n"
									
						);
				
				
				
				
				
			}
		});
		list.setForeground(Color.GRAY);
		list.setBounds(26, 70, 175, 287);
		contentPane.add(list);
		
		JLabel lblEmail = new JLabel("E_mail");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setBounds(49, 45, 118, 14);
		contentPane.add(lblEmail);
		
		JLabel lblContent = new JLabel("Content");
		lblContent.setForeground(Color.BLACK);
		lblContent.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblContent.setBounds(271, 44, 118, 14);
		contentPane.add(lblContent);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setForeground(new Color(255, 0, 0));
		btnDelete.setIcon(new ImageIcon("C:\\Users\\aymen balti\\Desktop\\delete.png"));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Claim c  =	UserServiceDelgate2.findClaimById(idct.get(list.getSelectedIndex()));
				UserServiceDelgate2.deleteclaim(c);
				
				DefaultListModel model = new DefaultListModel();
				List<Claim> cl = UserServiceDelgate2.findAllClaim();
				for (Claim claim : cl) {
					idct.add(claim.getId());
					model.addElement(claim.getEmail());
					
					
					
					list.setModel(model);
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				}}	
		});
		btnDelete.setBounds(39, 383, 162, 42);
		contentPane.add(btnDelete);
		
		JButton btnAnswer = new JButton("Answer");
		btnAnswer.setIcon(new ImageIcon("C:\\Users\\aymen balti\\Desktop\\ok.png"));
		btnAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAnswer.setForeground(new Color(50, 205, 50));
		btnAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Claim c  =	UserServiceDelgate2.findClaimById(idct.get(list.getSelectedIndex()));
			String [] to = {c.getEmail()};
				String host = "smtp.gmail.com";
		        Properties props = System.getProperties();
		        props.put("mail.smtp.starttls.enable", "true");
		        props.put("mail.smtp.host", host);
		        props.put("mail.smtp.user", "med.benamor@esprit.tn");
		        props.put("mail.smtp. password", "05061992");
		        props.put("mail.smtp.port", 587);
		        props.put("mail.smtp.auth", "true");
		        Session session = Session.getDefaultInstance(props, null);
		        MimeMessage mimeMessage = new MimeMessage(session);
		        try {

		  
		            mimeMessage.setFrom(new InternetAddress("med.benamor@esprit.tn"));
		            InternetAddress[] toAddress = new InternetAddress[to.length];
		            for (int i = 0; i < to.length; i++) {
		                toAddress[i] = new InternetAddress(to[i]);
		            }
		            for (int i = 0; i < toAddress.length; i++) {
		                 mimeMessage.addRecipient(javax.mail.Message.RecipientType.TO, toAddress[i]);

		            }
		            
		            mimeMessage.setSubject("");
		            mimeMessage.setText(mail.getText());
		            Transport transport =session.getTransport("smtp");
		            transport.connect(host,"med.benamor@esprit.tn","05061992");
		             transport.sendMessage(mimeMessage,mimeMessage.getAllRecipients() );
		            transport.close();
		           
		        } catch (MessagingException me) {
		            me.printStackTrace();

		        }
		       
		    }
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			
		});
		btnAnswer.setBounds(502, 281, 155, 42);
		contentPane.add(btnAnswer);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home frame = new Home();
				frame.setVisible(true); 
				dispose();
			}
		});
		btnBack.setForeground(Color.RED);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(502, 383, 162, 42);
		contentPane.add(btnBack);
		
		mail = new JTextField();
		mail.setBounds(502, 71, 155, 173);
		contentPane.add(mail);
		mail.setColumns(10);
		
		JLabel lblWriteYourMessage = new JLabel("Write your message below");
		lblWriteYourMessage.setForeground(Color.BLACK);
		lblWriteYourMessage.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblWriteYourMessage.setBounds(460, 41, 239, 23);
		contentPane.add(lblWriteYourMessage);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\omar\\Documents\\PI 2014-2015\\backgroundjavaee.jpg"));
		lblNewLabel.setBounds(0, 3, 709, 453);
		contentPane.add(lblNewLabel);
		
	
		
		
		DefaultListModel model = new DefaultListModel();
		List<Claim> cl = UserServiceDelgate2.findAllClaim();
		for (Claim claim : cl) {
			idct.add(claim.getId());
			model.addElement(claim.getEmail());
			
			
			
			list.setModel(model);
			
			
			
		}
		
	}
}
