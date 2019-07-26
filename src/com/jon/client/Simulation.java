package com.jon.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.jon.model.Customer;
import com.jon.model.Location;
import com.jon.service.CustomerDao;
import com.jon.service.CustomerDaoImpl;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Simulation extends JFrame {

	private JPanel contentPane;
	private JLabel lblLocation;
	private JPanel panel;
	private JLabel lblAtmLocationConfirmation;
	private JButton btnViewDeatails;
	private JButton btnDone;
	private JLabel lblSecurity;
	private JRadioButton btnSecurityYes;
	private JRadioButton btnSecurityNo;
	private JButton btnSimulate;
	private JLabel lblDistanceOfNearest;
	private JTextField distanceInt;
	private JLabel label;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField numberOfCustomer;
	private JLabel lblNumberOfPeople;
	private JTextField locationTxt;
	private JButton btnBack;
	private JLabel lblSutiableAreaFor;
	private JRadioButton btnAreaYes;
	private JRadioButton btnAreaNo;
	private JLabel lblNumberOfTransaction;
	private JTextField transactionTxt;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JLabel lblMarketingPotential;
	private JRadioButton btnMarketingPotentialYes;
	private JRadioButton btnMarketingPotentialNo;
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Simulation frame = new Simulation();
					
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
	public Simulation() {
		setTitle("Simulation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(540, 230, 894, 764);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblLocation());
		contentPane.add(getPanel());
		contentPane.add(getBtnViewDeatails());
		contentPane.add(getBtnDone());
		contentPane.add(getLblSecurity());
		contentPane.add(getBtnSecurityYes());
		contentPane.add(getBtnSecurityNo());
		contentPane.add(getBtnSimulate());
		contentPane.add(getLblDistanceOfNearest());
		contentPane.add(getDistanceInt());
		contentPane.add(getLabel());
		contentPane.add(getNumberOfCustomer());
		contentPane.add(getLblNumberOfPeople());
		contentPane.add(getLocationTxt());
		contentPane.add(getBtnBack());
		contentPane.add(getLblSutiableAreaFor());
		contentPane.add(getBtnAreaYes());
		contentPane.add(getBtnAreaNo());
		contentPane.add(getLblNumberOfTransaction());
		contentPane.add(getTransactionTxt());
		contentPane.add(getLblMarketingPotential());
		contentPane.add(getBtnMarketingPotentialYes());
		contentPane.add(getBtnMarketingPotentialNo());
		
		
	}
	private JLabel getLblLocation() {
		if (lblLocation == null) {
			lblLocation = new JLabel("Location");
			lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblLocation.setBounds(70, 88, 105, 25);
		}
		return lblLocation;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(102, 102, 102));
			panel.setBounds(0, 0, 896, 75);
			panel.setLayout(null);
			panel.add(getLblAtmLocationConfirmation());
		}
		return panel;
	}
	private JLabel getLblAtmLocationConfirmation() {
		if (lblAtmLocationConfirmation == null) {
			lblAtmLocationConfirmation = new JLabel("ATM Location Confirmation Simulator");
			lblAtmLocationConfirmation.setForeground(new Color(0, 51, 153));
			lblAtmLocationConfirmation.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
			lblAtmLocationConfirmation.setBounds(160, 13, 536, 32);
		}
		return lblAtmLocationConfirmation;
	}
	private JButton getBtnViewDeatails() {
		if (btnViewDeatails == null) {
			btnViewDeatails = new JButton("View Deatails");
			btnViewDeatails.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnViewDeatails.setBackground(new Color(255, 255, 255));
			btnViewDeatails.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ViewDetails v = new ViewDetails();
					String address = locationTxt.getText();
					v.displayData(address);
					v.setVisible(true);
					dispose();
				}
			});
			btnViewDeatails.setBounds(625, 176, 157, 35);
		}
		return btnViewDeatails;
	}
	private JButton getBtnDone() {
		if (btnDone == null) {
			btnDone = new JButton("Done");
			btnDone.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnDone.setBackground(new Color(255, 255, 255));
			btnDone.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					CustomerDao cdao = new CustomerDaoImpl();
					Customer c = cdao.countCustomer(locationTxt.getText());
					numberOfCustomer.setText(String.valueOf(c.getCount()));
					
					Customer a = cdao.countTransaction(locationTxt.getText());
					transactionTxt.setText(String.valueOf(a.getNumberOfTransaction()));
			
			}});
			btnDone.setBounds(628, 88, 154, 35);
		}
		return btnDone;
	}
	private JLabel getLblSecurity() {
		if (lblSecurity == null) {
			lblSecurity = new JLabel("Security");
			lblSecurity.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblSecurity.setBounds(70, 379, 96, 29);
		}
		return lblSecurity;
	}
	private JRadioButton getBtnSecurityYes() {
		if (btnSecurityYes == null) {
			btnSecurityYes = new JRadioButton("Yes");
			btnSecurityYes.setFont(new Font("Tahoma", Font.PLAIN, 22));
			btnSecurityYes.setBackground(new Color(0, 153, 153));
			buttonGroup.add(btnSecurityYes);
			btnSecurityYes.setBounds(364, 375, 63, 35);
		}
		return btnSecurityYes;
	}
	private JRadioButton getBtnSecurityNo() {
		if (btnSecurityNo == null) {
			btnSecurityNo = new JRadioButton("No");
			btnSecurityNo.setFont(new Font("Tahoma", Font.PLAIN, 22));
			btnSecurityNo.setBackground(new Color(0, 153, 153));
			buttonGroup.add(btnSecurityNo);
			btnSecurityNo.setBounds(481, 377, 75, 35);
		}
		return btnSecurityNo;
	}
	private JButton getBtnSimulate() {
		if (btnSimulate == null) {
			btnSimulate = new JButton("Check");
			btnSimulate.setIcon(new ImageIcon("D:\\eclipse\\shield.png"));
			btnSimulate.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnSimulate.setBackground(new Color(255, 255, 255));
			btnSimulate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int number = Integer.parseInt(numberOfCustomer.getText());
					Location l = new Location();
					l.setDistanceOfAnotherAtm(Integer.parseInt(distanceInt.getText()));
					Customer c = new Customer();
					c.setNumberOfTransaction(Integer.parseInt(transactionTxt.getText()));
					if(btnSecurityYes.isSelected()) {
						l.setSecurity("Yes");
					}else {
						l.setSecurity("No");
					}
					if(btnAreaYes.isSelected()) {
						l.setSuitableArea("Yes");
					}else {
						l.setSuitableArea("No");
					}
					if(btnMarketingPotentialYes.isSelected()) {
						l.setMarketingPotential("Yes");
					}else {
						l.setMarketingPotential("No");
					}
					if(number>10 && l.getSecurity()=="Yes" && l.getDistanceOfAnotherAtm()>500  && c.getNumberOfTransaction()>20  && l.getSuitableArea() == "Yes" && l.getMarketingPotential()=="Yes")  {
						JOptionPane.showMessageDialog(null, "Yes, this location is suitable for ATM");
					}else {
						JOptionPane.showMessageDialog(null, "Hell NO!, this location is not suitable for ATM");
					}
					
					
				}
			});
			btnSimulate.setBounds(605, 665, 125, 39);
		}
		return btnSimulate;
	}
	private JLabel getLblDistanceOfNearest() {
		if (lblDistanceOfNearest == null) {
			lblDistanceOfNearest = new JLabel("Distance of nearest ATM");
			lblDistanceOfNearest.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblDistanceOfNearest.setBounds(70, 304, 244, 29);
		}
		return lblDistanceOfNearest;
	}
	private JTextField getDistanceInt() {
		if (distanceInt == null) {
			distanceInt = new JTextField();
			distanceInt.setFont(new Font("Tahoma", Font.PLAIN, 20));
			distanceInt.setBounds(353, 290, 198, 35);
			distanceInt.setColumns(10);
		}
		return distanceInt;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setBounds(66, 181, 56, 16);
		}
		return label;
	}
	
	
	
	
	private JTextField getNumberOfCustomer() {
		if (numberOfCustomer == null) {
			numberOfCustomer = new JTextField();
			numberOfCustomer.setEditable(false);
			numberOfCustomer.setFont(new Font("Tahoma", Font.PLAIN, 20));
			numberOfCustomer.setBounds(353, 158, 203, 35);
			numberOfCustomer.setColumns(10);
		}
		return numberOfCustomer;
	}
	private JLabel getLblNumberOfPeople() {
		if (lblNumberOfPeople == null) {
			lblNumberOfPeople = new JLabel("Number of Customer");
			lblNumberOfPeople.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNumberOfPeople.setBounds(70, 167, 232, 16);
		}
		return lblNumberOfPeople;
	}
	private JTextField getLocationTxt() {
		if (locationTxt == null) {
			locationTxt = new JTextField();
			locationTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
			locationTxt.setBounds(353, 90, 203, 35);
			locationTxt.setColumns(10);
		}
		return locationTxt;
	}
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("Back");
			btnBack.setIcon(new ImageIcon("D:\\eclipse\\reply.png"));
			btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnBack.setBackground(new Color(255, 255, 255));
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new ATM().setVisible(true);
					dispose();
				}
			});
			btnBack.setBounds(177, 663, 125, 42);
		}
		return btnBack;
	}
	private JLabel getLblSutiableAreaFor() {
		if (lblSutiableAreaFor == null) {
			lblSutiableAreaFor = new JLabel("Permissible space");
			lblSutiableAreaFor.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblSutiableAreaFor.setBounds(70, 452, 221, 25);
		}
		return lblSutiableAreaFor;
	}
	private JRadioButton getBtnAreaYes() {
		if (btnAreaYes == null) {
			btnAreaYes = new JRadioButton("Yes");
			buttonGroup_1.add(btnAreaYes);
			btnAreaYes.setBackground(new Color(0, 153, 153));
			btnAreaYes.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnAreaYes.setBounds(359, 452, 127, 25);
		}
		return btnAreaYes;
	}
	private JRadioButton getBtnAreaNo() {
		if (btnAreaNo == null) {
			btnAreaNo = new JRadioButton("No");
			buttonGroup_1.add(btnAreaNo);
			btnAreaNo.setBackground(new Color(0, 153, 153));
			btnAreaNo.setFont(new Font("Tahoma", Font.PLAIN, 22));
			btnAreaNo.setBounds(481, 451, 127, 25);
		}
		return btnAreaNo;
	}
	private JLabel getLblNumberOfTransaction() {
		if (lblNumberOfTransaction == null) {
			lblNumberOfTransaction = new JLabel("Number of Transaction");
			lblNumberOfTransaction.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNumberOfTransaction.setBounds(70, 228, 232, 25);
		}
		return lblNumberOfTransaction;
	}
	private JTextField getTransactionTxt() {
		if (transactionTxt == null) {
			transactionTxt = new JTextField();
			transactionTxt.setEditable(false);
			transactionTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
			transactionTxt.setBounds(353, 223, 198, 35);
			transactionTxt.setColumns(10);
		}
		return transactionTxt;
	}
	private JLabel getLblMarketingPotential() {
		if (lblMarketingPotential == null) {
			lblMarketingPotential = new JLabel("Marketing Potential");
			lblMarketingPotential.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblMarketingPotential.setBounds(70, 530, 198, 25);
		}
		return lblMarketingPotential;
	}
	private JRadioButton getBtnMarketingPotentialYes() {
		if (btnMarketingPotentialYes == null) {
			btnMarketingPotentialYes = new JRadioButton("Yes");
			buttonGroup_2.add(btnMarketingPotentialYes);
			btnMarketingPotentialYes.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnMarketingPotentialYes.setBackground(new Color(0, 153, 153));
			btnMarketingPotentialYes.setBounds(359, 530, 127, 25);
		}
		return btnMarketingPotentialYes;
	}
	private JRadioButton getBtnMarketingPotentialNo() {
		if (btnMarketingPotentialNo == null) {
			btnMarketingPotentialNo = new JRadioButton("No");
			buttonGroup_2.add(btnMarketingPotentialNo);
			btnMarketingPotentialNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnMarketingPotentialNo.setBackground(new Color(0, 153, 153));
			btnMarketingPotentialNo.setBounds(481, 530, 127, 25);
		}
		return btnMarketingPotentialNo;
	}
}
