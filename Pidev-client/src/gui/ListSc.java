package gui;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.pidev.persistence.Sous_Categories;
import com.pidev.test.Home;

import delegate.CategoriesServiceDelegate;
import javax.swing.ImageIcon;


public class ListSc extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTextField id;
	private JTable table;

	public JFrame getFrame() {
		return frame;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListSc frame = new ListSc();
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
	public ListSc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 726, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Manage Sous Categories");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(319, 11, 361, 23);
		contentPane.add(lblNewLabel);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CategoriesServiceDelegate.Delete(Integer.valueOf(id.getText()));
				
				try {

					List<Sous_Categories> scs = new ArrayList<Sous_Categories>();

					scs = CategoriesServiceDelegate.getAll();
					String[][] donnes = new String[scs.size()][7];
					for (int i = 0; i < scs.size(); i++) {

						donnes[i][0] = String.valueOf(scs.get(i).getId_Sc());
						donnes[i][1] = scs.get(i).getName();
						donnes[i][2] = String.valueOf(scs.get(i).getCategories().getId_Ca());
						donnes[i][3] = String.valueOf(scs.get(i).getCategories().getName());
						
						
						
					}

					table.setModel(new javax.swing.table.DefaultTableModel(donnes,
							new String[] { "ID", "Sous Categories","ID_C","Categories" }));

				} catch (Exception e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Sous Categories Deleted",
						"Sous Categories Deleted", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(10, 160, 91, 23);
		contentPane.add(btnDelete);

		id = new JTextField();
		id.setBounds(66, 82, 124, 20);
		contentPane.add(id);
		id.setColumns(10);

		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setBounds(10, 83, 46, 14);
		contentPane.add(lblId);
		/*
		 * JScrollPane scrollPane = new JScrollPane(); scrollPane.setBounds(239,
		 * 74, 421, 323); contentPane.add(scrollPane);
		 */ 

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setViewportView(table);
		scrollPane.setBounds(356, 81, 324, 198);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new Model());
		try {

			List<Sous_Categories> scs = new ArrayList<Sous_Categories>();

			scs = CategoriesServiceDelegate.getAll();
			String[][] donnes = new String[scs.size()][10];
			for (int i = 0; i < scs.size(); i++) {

				donnes[i][0] = String.valueOf(scs.get(i).getId_Sc());
				donnes[i][1] = scs.get(i).getName();
				donnes[i][2] = String.valueOf(scs.get(i).getCategories().getId_Ca());
				donnes[i][3] = String.valueOf(scs.get(i).getCategories().getName());
				
				
				
				
			}

			table.setModel(new javax.swing.table.DefaultTableModel(donnes,
					new String[] { "ID", "Sous Categories","ID_C","Categories" }));


		} catch (Exception exception) {
			exception.printStackTrace();
		}

		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home frame = new Home();
				frame.setVisible(true); 
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(10, 217, 91, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\omar\\Documents\\PI 2014-2015\\backgroundjavaee.jpg"));
		lblNewLabel_1.setBounds(10, 0, 700, 433);
		contentPane.add(lblNewLabel_1);
	}
		}
		
	



	