package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Label;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.pidev.persistence.Categories;
import com.pidev.persistence.Sous_Categories;
import com.pidev.services.CategoriesServicesRemote;
import com.pidev.services.SousCategoriesServicesRemote;
import com.pidev.test.Home;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class Add extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblName;
	private JTextField textField;
	private JButton btnNewButton;
	private JLabel lblName_1;
	private JTextField textField_1;
	private JLabel lblNewLabel;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add frame = new Add();
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
	public Add() {
		setTitle("Add Categories");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 187);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblName = new JLabel("Sous Categories");
		lblName.setBounds(0, 45, 106, 14);
		panel.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(103, 42, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		lblName_1 = new JLabel("Categories");
		lblName_1.setBounds(206, 45, 84, 14);
		panel.add(lblName_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(300, 42, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton = new JButton("Add");
		btnNewButton.setBounds(428, 42, 89, 20);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Context context = new InitialContext();
					CategoriesServicesRemote categoriesServicesRemote = (CategoriesServicesRemote) context.lookup("ejb:/Pidev-EJB/CategoriesServices!com.pidev.services.CategoriesServicesRemote");
					SousCategoriesServicesRemote sousCategoriesServicesRemote = (SousCategoriesServicesRemote) context.lookup("ejb:/Pidev-EJB/SousCategoriesServices!com.pidev.services.SousCategoriesServicesRemote");
					Sous_Categories sc = new Sous_Categories();
					sc.setName(textField.getText());
					Categories categories2 = new Categories();
					categories2.setName(textField_1.getText());
					List<Sous_Categories> scs = new ArrayList<Sous_Categories>();
					scs.add(sc);
					categories2.assignSousCategoriesToThisClass(scs);
					categoriesServicesRemote.insertCategories(categories2);
					
				}catch(Exception exception) {
					exception.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home frame = new Home();
				frame.setVisible(true); 
				dispose();
			}
		});
		btnNewButton_1.setBounds(428, 82, 89, 23);
		panel.add(btnNewButton_1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\omar\\Documents\\PI 2014-2015\\backgroundjavaee.jpg"));
		lblNewLabel.setBounds(0, 0, 527, 138);
		panel.add(lblNewLabel);
	}

}
