package com.bank.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import com.bank.domain.sub.AppUser;

public class AdminHomeView {

	private JFrame frmAdminHome;
	private AppUser appUser = null;
	

	/**
	 * Create the application.
	 */
	public AdminHomeView(AppUser appUser) {
		this.appUser = appUser;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminHome = new JFrame();
		frmAdminHome.setVisible(true);
		frmAdminHome.setTitle("Admin Home");
		frmAdminHome.setBounds(100, 100, 450, 300);
		frmAdminHome.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmAdminHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmAdminHome.setJMenuBar(menuBar);
		
		JMenu mnHome = new JMenu("Home");
		menuBar.add(mnHome);
		
		JMenuItem mntmChangePassword = new JMenuItem("Change Password");
		mntmChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChangePasswordView(appUser);
			}
		});
		mnHome.add(mntmChangePassword);
		
		JSeparator separator = new JSeparator();
		mnHome.add(separator);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnHome.add(mntmExit);
	}

}
