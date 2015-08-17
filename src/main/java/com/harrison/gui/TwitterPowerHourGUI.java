package com.harrison.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class TwitterPowerHourGUI implements ActionListener {

	private JFrame frmTwitterPowerHour;
	private JTextField hashTf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					TwitterPowerHourGUI window = new TwitterPowerHourGUI();
					window.frmTwitterPowerHour.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void actionPerformed(ActionEvent e) {
	    String cmd = e.getActionCommand();

	    if (OK.equals(cmd)) { //Process the password.
	        char[] input = passwordField.getPassword();
	        if (isPasswordCorrect(input)) {
	            JOptionPane.showMessageDialog(controllingFrame,
	                "Success! You typed the right password.");
	        } else {
	            JOptionPane.showMessageDialog(controllingFrame,
	                "Invalid password. Try again.",
	                "Error Message",
	                JOptionPane.ERROR_MESSAGE);
	        }

	        //Zero out the possible password, for security.
	        Arrays.fill(input, '0');

	        passwordField.selectAll();
	        resetFocus();
	    } //else
	}

	/**
	 * Create the application.
	 */
	public TwitterPowerHourGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTwitterPowerHour = new JFrame();
		frmTwitterPowerHour.setTitle("Twitter Power Hour!!!");
		frmTwitterPowerHour.setBounds(100, 100, 450, 300);
		frmTwitterPowerHour.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTwitterPowerHour.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblHashtag = new JLabel("Hashtag: #");
		lblHashtag.setToolTipText("Do not include the hash.");
		frmTwitterPowerHour.getContentPane().add(lblHashtag);
		
		hashTf = new JTextField();
		hashTf.setToolTipText("Do not include the hash.");
		frmTwitterPowerHour.getContentPane().add(hashTf);
		hashTf.setColumns(10);
		
		JPasswordField passwordField = new JPasswordField(10);
		passwordField.setActionCommand(OK);
		passwordField.addActionListener(this);
	}

}
