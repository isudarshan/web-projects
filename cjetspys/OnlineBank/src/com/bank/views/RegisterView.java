package com.bank.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.bank.domain.sub.AppUser;
import com.bank.utils.service.ServiceUtils;

public class RegisterView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Create the frame.
	 */
	public RegisterView() {
		setVisible(true);

		setTitle("User Registration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("User Registration");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(204, 13, 154, 41);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "New User, Register Here",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel.setBounds(55, 55, 568, 347);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(43, 48, 118, 16);
		panel.add(lblNewLabel_1);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(43, 95, 118, 16);
		panel.add(lblPassword);

		JLabel lblRetypePassword = new JLabel("Retype Password");
		lblRetypePassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRetypePassword.setBounds(43, 143, 118, 16);
		panel.add(lblRetypePassword);

		JLabel lblSecurityQuestion = new JLabel("Security Question");
		lblSecurityQuestion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSecurityQuestion.setBounds(43, 198, 118, 16);
		panel.add(lblSecurityQuestion);

		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAnswer.setBounds(43, 250, 118, 16);
		panel.add(lblAnswer);

		textField = new JTextField();
		textField.setBounds(192, 46, 153, 22);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(192, 248, 205, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(192, 93, 153, 22);
		panel.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(192, 141, 153, 22);
		panel.add(passwordField_1);

		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {
				"What was your childhood nickname?",
				"In what city did you meet your spouse/significant other?",
				"What is the name of your favorite childhood friend?",
				"What street did you live on in third grade?" }));
		comboBox.setBounds(192, 196, 321, 22);
		panel.add(comboBox);

		final JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Object object = e.getSource();

				if (object.equals(btnSubmit)) {
					
					String name = textField.getText();
					String password1 = new String(passwordField
							.getPassword());
					String password2 = new String(passwordField_1
							.getPassword());
					String answer = textField_1.getText();
					String question = comboBox.getSelectedItem().toString();
					AppUser appUser = new AppUser();
					appUser.setActive(1);
					appUser.setUserName(name);
					appUser.setPassword(password1);
					appUser.setQuestion(question);
					appUser.setAnswer(answer);
					appUser.setCreatedOn(new java.util.Date());
					appUser.setModifiedOn(new java.util.Date());
					appUser.setModifiedBy(1);
					appUser.setCreatedBy(1);
					appUser.setUserRole("user");

					if(name.length() == 0 || name == null){
						
						JOptionPane.showMessageDialog(null, "UserName Required");
						textField.requestFocus();
						return;
					}if(password1.length() == 0 || password1 == null){
						
						JOptionPane.showMessageDialog(null, "Password Required");
						passwordField.requestFocus();
						return;
					}if(password2.length() == 0 || password2 == null){
						
						JOptionPane.showMessageDialog(null, "Retype Password Field Required");
						passwordField_1.requestFocus();
						return;
					}if(answer.length() == 0 || answer == null){
						
						JOptionPane.showMessageDialog(null, "Answer Required");
						textField_1.requestFocus();
						return;
					}
					
					try {
						
						boolean flag = password1.equals(password2);
						if(flag){
							
							ServiceUtils.getAppUserService().create(appUser);
							JOptionPane.showMessageDialog(null, "User Created");
							textField.setText("");
							textField_1.setText("");
							passwordField.setText("");
							passwordField_1.setText("");
							textField.requestFocus();
						}
						else{
							
							JOptionPane.showMessageDialog(null, "Both Passwords must be same");
							passwordField.requestFocus();
							return;
						}

					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}

			}

		});
		btnSubmit.setBounds(192, 309, 97, 25);
		panel.add(btnSubmit);

		final JButton btnReset = new JButton("ReSet");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Object object = e.getSource();
				if (object.equals(btnReset)) {

					textField.setText("");
					textField_1.setText("");
					passwordField.setText("");
					passwordField_1.setText("");
					textField.requestFocus();

				}
			}
		});
		btnReset.setBounds(301, 309, 97, 25);
		panel.add(btnReset);
	}
}
