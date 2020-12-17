package client;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import server.RemoteInterface;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Font;

public class LoginGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameInput;
	private JTextField passwordInput;

	
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
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
	public LoginGUI() {
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 996);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		usernameInput = new JTextField();
		usernameInput.setFont(new Font("Dialog", Font.BOLD, 18));
		usernameInput.setToolTipText("Username");
		usernameInput.setBackground(Color.LIGHT_GRAY);
		usernameInput.setColumns(10);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		usernameLabel.setForeground(Color.WHITE);
		
		passwordInput = new JTextField();
		passwordInput.setFont(new Font("Dialog", Font.BOLD, 18));
		passwordInput.setToolTipText("Password");
		passwordInput.setBackground(Color.LIGHT_GRAY);
		passwordInput.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		passwordLabel.setForeground(Color.WHITE);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setFont(new Font("Dialog", Font.BOLD, 20));
		btnLogIn.setForeground(Color.WHITE);
		btnLogIn.setBackground(new Color(102, 51, 204));
		
		// Handle login function
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user  = usernameInput.getText();
				String password = passwordInput.getText();
				
				if (password.isEmpty() || user.isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Username or Password Field can't be Empty", "Error", 1);									
				} else {
					try {
						
						
						String lookupstring = "rmi://localhost:1099/emmitoQuestionnaireServer";
						RemoteInterface remoteInterface = (RemoteInterface)Naming.lookup(lookupstring);
						
						if(remoteInterface.checkUser(user, password)) {
							
							String loginSessionCookie = remoteInterface.setCookie(); 
							
							DashboardGUI dashboard = new DashboardGUI(loginSessionCookie);
							dashboard.setVisible(true);
						  	dashboard.setLocationRelativeTo(null);
					        dispose();
						} else {
							final JDialog dialog = new JDialog();
							dialog.setAlwaysOnTop(true);    
							JOptionPane.showMessageDialog(null,"User Name or Password  Invalid");
						}
						
					} catch(RemoteException | MalformedURLException | NotBoundException error) {
						error.printStackTrace();
						 JOptionPane.showMessageDialog(null,"Run Server First",
								 "ALERT",JOptionPane.WARNING_MESSAGE);
					}
				}
				
			}
		});
		
		JLabel lblLogIn = new JLabel("Log In");
		lblLogIn.setFont(new Font("Dialog", Font.BOLD, 45));
		lblLogIn.setForeground(Color.WHITE);
		
		JLabel lblLogInTo = new JLabel("Log In to the system");
		lblLogInTo.setFont(new Font("Dialog", Font.BOLD, 20));
		lblLogInTo.setForeground(Color.WHITE);
		
		JButton btnGoBack = new JButton("Go back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					String lookupstring = "rmi://localhost:1099/emmitoQuestionnaireServer";
					RemoteInterface remoteInterface = (RemoteInterface)Naming.lookup(lookupstring);
					
					String loginSessionCookie = remoteInterface.setCookie(); 
					
					DashboardGUI dashboard = new DashboardGUI(loginSessionCookie);
					dashboard.setVisible(true);
				  	dashboard.setLocationRelativeTo(null);
			        dispose();
				} catch (MalformedURLException | RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

			}
		});
		
		btnGoBack.setForeground(Color.WHITE);
		btnGoBack.setFont(new Font("Dialog", Font.BOLD, 20));
		btnGoBack.setBackground(new Color(255, 153, 0));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(59)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnGoBack, GroupLayout.PREFERRED_SIZE, 470, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(411, Short.MAX_VALUE))
							.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnLogIn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
									.addComponent(usernameLabel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblLogIn, Alignment.LEADING)
									.addComponent(lblLogInTo, Alignment.LEADING)
									.addComponent(usernameInput, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
									.addComponent(passwordInput, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE))
								.addGap(70)))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(37)
					.addComponent(lblLogIn)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblLogInTo)
					.addGap(101)
					.addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(usernameInput, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(59)
					.addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(passwordInput, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(110)
					.addComponent(btnLogIn, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addComponent(btnGoBack, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(134, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
