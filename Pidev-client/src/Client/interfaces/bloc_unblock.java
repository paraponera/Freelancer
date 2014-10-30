package Client.interfaces;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.LineBorder;

import Client.delegate.UserServiceDelegate;

import com.pidev.persistence.Claim;
import com.pidev.persistence.User;
import com.pidev.test.Home;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class bloc_unblock extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bloc_unblock frame = new bloc_unblock();
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
	public bloc_unblock() {
		
		final List<Integer> a =new ArrayList<Integer>(); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 472);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		final JButton btnBlock = new JButton("Block");
		final JButton btnUnblock = new JButton("UnBlock");
		final JList list = new JList();
		list.setBackground(Color.PINK);
		final JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		btnBlock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				User u = UserServiceDelegate.findUserById(a.get(list.getSelectedIndex()));
				u.setState(false);
				boolean t = true;
				
				mail m = new mail();
				t =m.mailblock(u, "you are blocked", "sorry you are blcked because a user complains about you");
				if(t == true)
				{
					String  sta ;
					if (u.getState()== true)
						sta="unblocked";
					else sta="blocked";
					
				UserServiceDelegate.Block(u);
				textArea.setText("First name : "+u.getFirst_name()+"\n\n"+
						"Laste name :"+u.getLast_name()+"\n\n"+
						"Country : "+u.getCountry()+"\n\n"+
						"Adress : "+u.getCity()+"\n\n"+
						"Birth day : "+u.getType()+"\n\n"+
						"CIN : "+u.getUsername()+"\n\n"+
						"E-mail : "+u.getE_mail()+"\n\n"+
						"Etat : "+sta+"\n\n"
				);
				String message = "a mail have been send";
				JOptionPane.showMessageDialog(new JFrame(), message,"alert",JOptionPane.INFORMATION_MESSAGE);
				if(u.getState()== true)
				{
				btnBlock.setVisible(true);
				btnUnblock.setVisible(false);
				}
				else
				{
				btnBlock.setVisible(false);
				btnUnblock.setVisible(true);
				}
				}
				else
				{
					String message = "problem with your mail";
					JOptionPane.showMessageDialog(new JFrame(), message,"alert",JOptionPane.ERROR_MESSAGE);
				}
				
				
				
			}
		});
		btnBlock.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBlock.setForeground(Color.RED);
		btnBlock.setBounds(423, 357, 120, 46);
		contentPane.add(btnBlock);
		
		
		btnUnblock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				User u = UserServiceDelegate.findUserById(a.get(list.getSelectedIndex()));
				u.setState( true );
				boolean t = true;
				mail m = new mail();
				t =m.mailblock(u, "you are blocked", "Your count is now activated you are unblocked");
				if(t == true)
				{
					
					String  sta ;
					if (u.getState()== true)
						sta="unblocked";
					else sta="blocked";
					
				UserServiceDelegate.Unblock(u);
				textArea.setText("First name : "+u.getFirst_name()+"\n\n"+
						"Laste name :"+u.getLast_name()+"\n\n"+
						"Country : "+u.getCountry()+"\n\n"+
						"Adress : "+u.getCity()+"\n\n"+
						"Birth day : "+u.getType()+"\n\n"+
						"CIN : "+u.getUsername()+"\n\n"+
						"E-mail : "+u.getE_mail()+"\n\n"+
						"Etat : "+sta+"\n\n"
				);
				String message = "a mail have been send";
				JOptionPane.showMessageDialog(new JFrame(), message,"alert",JOptionPane.INFORMATION_MESSAGE);
				if(u.getState()== true)
				{
					btnBlock.setVisible(true);
				btnUnblock.setVisible(false);
				}
				else
				{
			    btnBlock.setVisible(false);
				btnUnblock.setVisible(true);
				}
				}
				else
				{
					String message = "problem with your mail";
					JOptionPane.showMessageDialog(new JFrame(), message,"alert",JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		btnUnblock.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUnblock.setForeground(Color.GREEN);
		btnUnblock.setBounds(566, 357, 110, 46);
		contentPane.add(btnUnblock);
		
		textArea.setBounds(413, 79, 246, 257);
		contentPane.add(textArea);
	
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				User u = UserServiceDelegate.findUserById(a.get(list.getSelectedIndex()));
				
				String  sta ;
				if (u.getState()== true)
					sta="unblocked";
				else sta="blocked";
				
				textArea.setText("First name : "+u.getFirst_name()+"\n\n"+
				"Laste name :"+u.getLast_name()+"\n\n"+
				"Country : "+u.getCountry()+"\n\n"+
				"Adress : "+u.getCity()+"\n\n"+
				"Birth day : "+u.getType()+"\n\n"+
				"CIN : "+u.getUsername()+"\n\n"+
				"E-mail : "+u.getE_mail()+"\n\n"+
				"Etat : "+sta+"\n\n"
				);
				if(u.getState()== true)
				{
				btnBlock.setVisible(true);
				btnUnblock.setVisible(false);
				}
				else
				{
				btnBlock.setVisible(false);
				btnUnblock.setVisible(true);
				}
			}
		});
		list.setBounds(54, 79, 202, 311);
		contentPane.add(list);
		
		JLabel lblBlockUnblock = new JLabel("Block / UnBlock");
		lblBlockUnblock.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBlockUnblock.setForeground(Color.RED);
		lblBlockUnblock.setBounds(323, 27, 165, 14);
		contentPane.add(lblBlockUnblock);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home frame = new Home();
				frame.setVisible(true); 
				dispose();
			}
		});
		btnNewButton.setBounds(290, 359, 120, 46);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\omar\\Documents\\PI 2014-2015\\backgroundjavaee.jpg"));
		label.setBounds(0, 0, 722, 433);
		contentPane.add(label);
		
		
		
		
		DefaultListModel model = new DefaultListModel();
		List<User> ul = UserServiceDelegate.findAllUsers();
		for (User user : ul) 
		{
			if(user.getType().equals("Administrator") == false )
			{
			model.addElement(user.getFirst_name()+"            "+user.getType()); list.setModel(model);
			a.add(user.getId());
			}
		}
	}
}
