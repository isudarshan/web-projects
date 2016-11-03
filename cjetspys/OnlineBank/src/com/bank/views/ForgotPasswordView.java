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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import com.bank.domain.sub.AppUser;
import com.bank.utils.loggers.AppLogger;
import com.bank.utils.service.ServiceUtils;

@SuppressWarnings("serial")
public class ForgotPasswordView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	static Logger LOG = AppLogger.getLogger();

	/**
	 * Create the frame.
	 */
	public ForgotPasswordView() {
		setVisible(true);
		setFont(new Font("Tahoma", Font.PLAIN, 13));
		setTitle("Forgot Password");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 354);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblForgotPassword = new JLabel("Forgot Password ???");
		lblForgotPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblForgotPassword.setBounds(128, 13, 220, 40);
		contentPane.add(lblForgotPassword);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setBounds(156, 86, 338, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		final JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"What was your childhood nickname?", "In what city did you meet your spouse/significant other? ", "What is the name of your favorite childhood friend?", "What street did you live on in third grade?"}));
		comboBox.setBounds(156, 133, 338, 20);
		contentPane.add(comboBox);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_1.setBounds(156, 176, 338, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppUser appUser = null;
				String userName = textField.getText();
				String question = comboBox.getSelectedItem().toString();
				String answer = textField_1.getText();
				
				LOG.debug("User Name : "+userName);
				LOG.debug("Question : "+question);
				LOG.debug("Answer : "+answer);
				
				
				if (userName.length() == 0 || userName == null) {
					JOptionPane
							.showMessageDialog(null, "User name is required");
					return;
				}
				if (answer.length() == 0 || answer == null) {
					JOptionPane.showMessageDialog(null, "Answer is required");
					return;
				}

				try {

					appUser = ServiceUtils.getAppUserService().getPassword(
							userName, question, answer);
					if (appUser != null) {

						JOptionPane.showMessageDialog(null,
								"Your Passwors is :" + appUser.getPassword());
						textField.setText("");
						textField_1.setText("");

					} else {

						JOptionPane.showMessageDialog(null,
								"Invalid Username or Password");
						textField.setText("");
						textField_1.setText("");
					}

					/* LOG.debug(userName+"t"+question+"\t"+answer+"\n"); */

				} catch (Exception e1) {

					e1.printStackTrace();
				}

			}
		});
		btnSubmit.setBounds(156, 228, 89, 23);
		contentPane.add(btnSubmit);

		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField.requestFocus();
			}
		});
		btnReset.setBounds(255, 228, 130, 23);
		contentPane.add(btnReset);

		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUserName.setBounds(29, 86, 125, 14);
		contentPane.add(lblUserName);

		JLabel lblSecurityQuestion = new JLabel("Security Question");
		lblSecurityQuestion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSecurityQuestion.setBounds(29, 133, 125, 14);
		contentPane.add(lblSecurityQuestion);

		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAnswer.setBounds(30, 176, 77, 14);
		contentPane.add(lblAnswer);
	}
}
