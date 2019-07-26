package com.jon.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ATM extends JFrame {

	private JPanel contentPane;
	private JButton btnAddCustomer;
	private JButton btnSimulator;
	private JPanel panel;
	private JLabel lblAtmLocationConfirmation;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ATM frame = new ATM();
					frame.setResizable(false);
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
	public ATM() {
		
		
		setTitle("ATM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 230, 784, 542);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnAddCustomer());
		contentPane.add(getBtnSimulator());
		contentPane.add(getPanel());
		contentPane.add(getLabel());
	}
	private JButton getBtnAddCustomer() {
		if (btnAddCustomer == null) {
			btnAddCustomer = new JButton("Add Atm User");
			btnAddCustomer.setForeground(new Color(0, 128, 128));
			btnAddCustomer.setFont(new Font("Tahoma", Font.BOLD, 20));
			btnAddCustomer.setBackground(new Color(233, 150, 122));
			btnAddCustomer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					new AddCustomer().setVisible(true);
					dispose();
				}
			});
			btnAddCustomer.setBounds(69, 281, 198, 81);
		}
		return btnAddCustomer;
	}
	private JButton getBtnSimulator() {
		if (btnSimulator == null) {
			btnSimulator = new JButton("Simulator");
			btnSimulator.setForeground(new Color(0, 128, 128));
			btnSimulator.setFont(new Font("Tahoma", Font.BOLD, 20));
			btnSimulator.setBackground(new Color(178, 34, 34));
			btnSimulator.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new Simulation().setVisible(true);
					dispose();
				}
			});
			btnSimulator.setBounds(303, 281, 207, 81);
		}
		return btnSimulator;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(204, 255, 204));
			panel.setBounds(49, 44, 546, 110);
			panel.setLayout(null);
			panel.add(getLblAtmLocationConfirmation());
		}
		return panel;
	}
	private JLabel getLblAtmLocationConfirmation() {
		if (lblAtmLocationConfirmation == null) {
			lblAtmLocationConfirmation = new JLabel("ATM Location Confirmation");
			lblAtmLocationConfirmation.setForeground(new Color(0, 0, 102));
			lblAtmLocationConfirmation.setFont(new Font("Tahoma", Font.BOLD, 33));
			lblAtmLocationConfirmation.setBounds(37, 24, 497, 54);
		}
		return lblAtmLocationConfirmation;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setIcon(new ImageIcon("D:\\eclipse\\atm.jpg"));
			label.setBounds(553, 174, 144, 243);
		}
		return label;
	}
}
