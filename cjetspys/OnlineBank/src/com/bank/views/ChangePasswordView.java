package com.bank.views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

import com.bank.domain.sub.AppUser;
import com.bank.utils.service.ServiceUtils;

@SuppressWarnings("serial")
public class ChangePasswordView extends JFrame {
	private static JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	public ChangePasswordView(AppUser appUser) {
		setVisible(true);
		setSize(600, 600);
		getContentPane().setBackground(Color.GRAY);
		setTitle("Change Password");
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
		getContentPane().setLayout(null);

		JLabel lblChangePassword = new JLabel("Change Password");
		lblChangePassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblChangePassword.setBounds(222, 24, 194, 45);
		getContentPane().add(lblChangePassword);

		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserName.setBounds(53, 90, 145, 14);
		getContentPane().add(lblUserName);

		JLabel lblOldPassword = new JLabel("Old Password");
		lblOldPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOldPassword.setBounds(53, 143, 145, 14);
		getContentPane().add(lblOldPassword);

		JLabel lblConformPassword = new JLabel("Conform Password");
		lblConformPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConformPassword.setBounds(53, 243, 139, 14);
		getContentPane().add(lblConformPassword);

		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewPassword.setBounds(53, 189, 145, 14);
		getContentPane().add(lblNewPassword);

		textField = new JTextField(appUser.getUserName());
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setBounds(256, 89, 231, 23);
		getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = textField.getText();
				String oldPassword = new String(passwordField.getPassword());
				String newPassword = new String(passwordField_1.getPassword());
				String conformPassword = new String(passwordField_2
						.getPassword());
				if (userName.length() == 0 || userName == null) {
					JOptionPane
							.showMessageDialog(null, "User name is required");
					return;
				}
				if (oldPassword.length() == 0 || oldPassword == null) {
					JOptionPane.showMessageDialog(null,
							"Old password is required");
					return;
				}
				if (newPassword.length() == 0 || newPassword == null) {
					JOptionPane.showMessageDialog(null,
							"New password is required");
					return;
				}
				if (conformPassword.length() == 0 || conformPassword == null) {
					JOptionPane.showMessageDialog(null,
							"Conform password is required");
					return;
				}

				try {
					boolean flag = newPassword.equals(conformPassword);
					if (flag) {
						int flag1 = ServiceUtils.getAppUserService()
								.changePassword(userName, oldPassword,
										newPassword);
						if (flag1 == 1) {
							JOptionPane.showMessageDialog(null,
									"Password changed  Successfully");
							textField.setText("");
							passwordField.setText("");
							passwordField_1.setText("");
							passwordField_2.setText("");
							
						} else {
							JOptionPane.showMessageDialog(null,
									"Invalid details");
							textField.setText("");
							passwordField.setText("");
							passwordField_1.setText("");
							passwordField_2.setText("");
						}

					} else {
						JOptionPane.showMessageDialog(null,
							"New password and Conform password must be same");
						passwordField_1.setText("");
						passwordField_2.setText("");
						passwordField_1.requestFocus();
					}
				} catch (Exception e1) {

					e1.printStackTrace();
				}
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSubmit.setBounds(258, 295, 89, 23);
		getContentPane().add(btnSubmit);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				passwordField.setText("");
				passwordField_1.setText("");
				passwordField_2.setText("");

			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnReset.setBounds(374, 295, 89, 23);
		getContentPane().add(btnReset);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passwordField.setBounds(256, 139, 231, 23);
		getContentPane().add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passwordField_1.setBounds(256, 185, 231, 23);
		getContentPane().add(passwordField_1);

		passwordField_2 = new JPasswordField();
		passwordField_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passwordField_2.setBounds(256, 239, 231, 23);
		getContentPane().add(passwordField_2);
	}

}
