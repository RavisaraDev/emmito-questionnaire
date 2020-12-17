package client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class DashboardGUI extends JFrame {
	public static String SessionCookie;
	String cookie;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardGUI frame = new DashboardGUI(SessionCookie);
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
	public DashboardGUI(String loginSessionCookie) {
		cookie = loginSessionCookie;
		setBackground(SystemColor.controlDkShadow);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 834, 1093);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("CheckBox.foreground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.foreground"));

		JButton button = new JButton("Let’s start questionnaire");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emmitoFirstQuestionForm formUI = new emmitoFirstQuestionForm();
				formUI.setVisible(true);
				formUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				formUI.setResizable(false);
				dispose();
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Dialog", Font.BOLD, 23));
		button.setBackground(Color.ORANGE);

		JButton button_1 = new JButton("Analyze Feedbacks");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				String question = "";
//				BufferedImage image = null;

				if (cookie == null) {
					final JDialog dialog = new JDialog();
					dialog.setAlwaysOnTop(true);    
					JOptionPane.showMessageDialog(null,"You need to login first to analyze feedbacks");
				} else {
					emmitoStartChart dashboard = new emmitoStartChart();
					dashboard.setSize(1150, 1850);
					dashboard.setVisible(true);
					
					dashboard.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					dashboard.setResizable(false);
					dispose();
				}
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Dialog", Font.BOLD, 23));
		button_1.setBackground(new Color(0, 206, 209));

		JButton button_2 = new JButton("Admin Log In");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI formUI = new LoginGUI();
				formUI.setVisible(true);
				formUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				formUI.setResizable(false);
				dispose();
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Dialog", Font.BOLD, 23));
		button_2.setBackground(new Color(123, 104, 238));

		JLabel label = new JLabel("Feedback Portal");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.BOLD, 40));

		JLabel label_1 = new JLabel("Welcome to emmito");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Dialog", Font.BOLD, 40));
		
		JLabel lblNewLabel = new JLabel(cookie == null ? "" : "⬤ Logged in as admin");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 25));
		lblNewLabel.setForeground(new Color(0, 255, 51));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(194)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(button, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
						.addComponent(button_1, GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
						.addComponent(button_2, GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE))
					.addGap(185))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(273)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(264))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(56)
					.addComponent(label_1)
					.addGap(18)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
					.addGap(128)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addGap(349))
		);
		panel.setLayout(gl_panel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(panel,
				Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1035, Short.MAX_VALUE));
		contentPane.setLayout(gl_contentPane);
	}

}
