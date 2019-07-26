package com.jon.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jon.model.Customer;
import com.jon.service.CustomerDao;
import com.jon.service.CustomerDaoImpl;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AddCustomer extends JFrame {

	private JPanel contentPane;
	private JLabel lblName;
	private JLabel lblName_1;
	private JLabel lblAddress;
	private JLabel lblCustomerInformation;
	private JButton btnAdd;
	private JTextField accountNumberInt;
	private JTextField nameTxt;
	private JTextField addressTxt;
	private JButton btnBack;
	private JLabel lblNumberOfTransaction;
	private JTextField noOfTransaction;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCustomer frame = new AddCustomer();
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
	public AddCustomer() {
		
		setTitle("Customer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(540, 230, 644, 515);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblName());
		contentPane.add(getLblName_1());
		contentPane.add(getLblAddress());
		contentPane.add(getLblCustomerInformation());
		contentPane.add(getBtnAdd());
		contentPane.add(getAccountNumberInt());
		contentPane.add(getNameTxt());
		contentPane.add(getAddressTxt());
		contentPane.add(getBtnBack());
		contentPane.add(getLblNumberOfTransaction());
		contentPane.add(getNoOfTransaction());
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Account Number");
			lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblName.setBounds(86, 107, 163, 16);
		}
		return lblName;
	}
	private JLabel getLblName_1() {
		if (lblName_1 == null) {
			lblName_1 = new JLabel("Name");
			lblName_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblName_1.setBounds(86, 186, 135, 16);
		}
		return lblName_1;
	}
	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("Address");
			lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblAddress.setBounds(86, 258, 123, 16);
		}
		return lblAddress;
	}
	private JLabel getLblCustomerInformation() {
		if (lblCustomerInformation == null) {
			lblCustomerInformation = new JLabel("Customer Information");
			lblCustomerInformation.setFont(new Font("Tahoma", Font.BOLD, 24));
			lblCustomerInformation.setForeground(new Color(0, 0, 128));
			lblCustomerInformation.setBounds(181, 13, 285, 38);
		}
		return lblCustomerInformation;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnAdd.setIcon(new ImageIcon("D:\\eclipse\\add.png"));
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Customer c = new Customer();
					c.setAccountnumber(Integer.parseInt(accountNumberInt.getText()));
					c.setName(nameTxt.getText());
					c.setAddress(addressTxt.getText());
					c.setNumberOfTransaction(Integer.parseInt(noOfTransaction.getText()));
					CustomerDao cdao = new CustomerDaoImpl();
					
					if(cdao.addCustomer(c)) {
						
						clear();
						
					}else {
						JOptionPane.showMessageDialog(null, "Added Failed due to technical problems...haha..");
					}
				}
			});
			btnAdd.setBounds(368, 391, 135, 45);
		}
		return btnAdd;
	}
	private JTextField getAccountNumberInt() {
		if (accountNumberInt == null) {
			accountNumberInt = new JTextField();
			accountNumberInt.setFont(new Font("Tahoma", Font.PLAIN, 20));
			accountNumberInt.setBounds(356, 100, 232, 31);
			accountNumberInt.setColumns(10);
		}
		return accountNumberInt;
	}
	private JTextField getNameTxt() {
		if (nameTxt == null) {
			nameTxt = new JTextField();
			nameTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
			nameTxt.setBounds(356, 179, 232, 31);
			nameTxt.setColumns(10);
		}
		return nameTxt;
	}
	private JTextField getAddressTxt() {
		if (addressTxt == null) {
			addressTxt = new JTextField();
			addressTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
			addressTxt.setBounds(356, 251, 232, 31);
			addressTxt.setColumns(10);
		}
		return addressTxt;
	}
	
	private void clear() {
		accountNumberInt.setText(null);
		nameTxt.setText(null);
		addressTxt.setText(null);
		noOfTransaction.setText(null);
	}
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("Back");
			btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnBack.setIcon(new ImageIcon("D:\\eclipse\\reply.png"));
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new ATM().setVisible(true);
					dispose();
				}
			});
			btnBack.setBounds(86, 391, 111, 45);
		}
		return btnBack;
	}
	private JLabel getLblNumberOfTransaction() {
		if (lblNumberOfTransaction == null) {
			lblNumberOfTransaction = new JLabel("No. of transaction(7 days)\r\n");
			lblNumberOfTransaction.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNumberOfTransaction.setBounds(82, 321, 262, 32);
		}
		return lblNumberOfTransaction;
	}
	private JTextField getNoOfTransaction() {
		if (noOfTransaction == null) {
			noOfTransaction = new JTextField();
			noOfTransaction.setFont(new Font("Tahoma", Font.PLAIN, 20));
			noOfTransaction.setBounds(356, 325, 226, 31);
			noOfTransaction.setColumns(10);
		}
		return noOfTransaction;
	}
}
