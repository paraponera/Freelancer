package Client.interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;

import com.pidev.persistence.User;
import com.pidev.test.Home;

import Client.delegate.UserServiceDelegate;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Authentication extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authentication frame = new Authentication();
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
	public Authentication() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JTextArea pswd = new JTextArea();
		pswd.setBackground(Color.LIGHT_GRAY);
		pswd.setBounds(291, 191, 216, 33);
		contentPane.add(pswd);
		
		final JTextArea Login = new JTextArea();
		Login.setBackground(Color.LIGHT_GRAY);
		Login.setBounds(291, 130, 216, 33);
		contentPane.add(Login);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblLogin.setBounds(63, 135, 46, 14);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("PassWord :");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblPassword.setBounds(63, 196, 104, 14);
		contentPane.add(lblPassword);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				User user = UserServiceDelegate.authenticate(Login.getText(), pswd.getText());
						String message = "authentification réussie";
						String message1 = "authentification non réussie";
						if (user!= null ) {
							if( (user.getType().equals("Administrator") == true))
									{
								Home frame = new Home();
								frame.setVisible(true); 
								dispose();
						JOptionPane.showMessageDialog(new JFrame(), message,
						"Alerte", JOptionPane.INFORMATION_MESSAGE);
						}
							else {
								JOptionPane.showMessageDialog(new JFrame(), message1,
										"Pas admin", JOptionPane.ERROR_MESSAGE);
							}
						}
						else {
						JOptionPane.showMessageDialog(new JFrame(), message1,
						"Alerte", JOptionPane.ERROR_MESSAGE);
				             }
						
						
			}
			
			
		}
		               );
		btnConnexion.setBounds(282, 258, 147, 51);
		contentPane.add(btnConnexion);
		
		JLabel label = new JLabel("Freelancer");
		label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 50));
		label.setBounds(132, 34, 241, 34);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\omar\\Documents\\PI 2014-2015\\backgroundjavaee.jpg"));
		lblNewLabel.setBounds(0, 0, 532, 390);
		contentPane.add(lblNewLabel);
	}
}
