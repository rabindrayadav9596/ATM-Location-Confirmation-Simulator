package com.jon.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.jon.model.Customer;
import com.jon.service.CustomerDao;
import com.jon.service.CustomerDaoImpl;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class ViewDetails extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewDetails frame = new ViewDetails();
					
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
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
	public ViewDetails() {
		setTitle("ViewDetails");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(540, 230, 855, 560);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane());
		contentPane.add(getBtnBack());
		
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(76, 35, 716, 374);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Account Number", "Name", "Address","Number of Transaction"
				}
			));
		}
		return table;
	}
//	public void displayData1() {
//		CustomerDao cdao = new CustomerDaoImpl();
//		List<Customer> clist = cdao.viewDetailsBaneshwar(); 
//		
//		DefaultTableModel  model = (DefaultTableModel) table.getModel();
//		model.setRowCount(0);
//		
//		for(Customer c: clist) {
//			model.addRow( new Object[] {c.getAccountnumber(),c.getName(),c.getAddress()});
//		}
//	}
//	public void displayData2() {
//		CustomerDao cdao = new CustomerDaoImpl();
//		List<Customer> clist = cdao.viewDetailsKirtipur(); 
//		
//		DefaultTableModel  model = (DefaultTableModel) table.getModel();
//		model.setRowCount(0);
//		
//		for(Customer c: clist) {
//			model.addRow( new Object[] {c.getAccountnumber(), c.getName(),c.getAddress()});
//		}
//	}
//	public void displayData3() {
//		CustomerDao cdao = new CustomerDaoImpl();
//		List<Customer> clist = cdao.viewDetailsPutalisadak(); 
//		
//		DefaultTableModel  model = (DefaultTableModel) table.getModel();
//		model.setRowCount(0);
//		
//		for(Customer c: clist) {
//			model.addRow( new Object[] {c.getAccountnumber(),c.getName(), c.getAddress()});
//		}
//	}
	
	public void displayData(String address) {
	CustomerDao cdao = new CustomerDaoImpl();
	List<Customer> clist = cdao.viewDetails(address); 
	
	DefaultTableModel  model = (DefaultTableModel) table.getModel();
	model.setRowCount(0);
	
	for(Customer c: clist) {
		model.addRow( new Object[] {c.getAccountnumber(),c.getName(),c.getAddress(), c.getNumberOfTransaction()});
	}
}

	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("Back");
			btnBack.setIcon(new ImageIcon("D:\\eclipse\\reply.png"));
			btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new Simulation().setVisible(true);
					dispose();
				}
			});
			btnBack.setBounds(370, 439, 131, 33);
		}
		return btnBack;
	}
}
