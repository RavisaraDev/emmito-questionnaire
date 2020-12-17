package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Questions;
import server.RemoteInterface;

import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Enumeration;
import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

public class emmitoSecondQuestionForm extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String questionFourAnswer;
	String questionFiveAnswer;
	String questionSixAnswer;

	private JPanel contentPane;
	private final ButtonGroup questionFourButtonGroup = new ButtonGroup();
	private final ButtonGroup questionFiveButtonGroup = new ButtonGroup();
	private final ButtonGroup questionSixButtonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					emmitoSecondQuestionForm frame = new emmitoSecondQuestionForm();
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
	public emmitoSecondQuestionForm() {
		setBackground(UIManager.getColor("CheckBox.foreground"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 864, 1305);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("CheckBox.foreground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.foreground"));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("Feedback Form");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.BOLD, 40));
		
		JRadioButton radioButton = new JRadioButton("Average");
		questionFourButtonGroup.add(radioButton);
		radioButton.setForeground(Color.WHITE);
		radioButton.setFont(new Font("Dialog", Font.BOLD, 20));
		radioButton.setBackground(UIManager.getColor("Button.foreground"));
		
		JRadioButton radioButton_1 = new JRadioButton("Excellent");
		questionFourButtonGroup.add(radioButton_1);
		radioButton_1.setForeground(Color.WHITE);
		radioButton_1.setFont(new Font("Dialog", Font.BOLD, 20));
		radioButton_1.setBackground(UIManager.getColor("Button.foreground"));
		
		JRadioButton radioButton_2 = new JRadioButton("Below Average");
		questionFourButtonGroup.add(radioButton_2);
		radioButton_2.setForeground(Color.WHITE);
		radioButton_2.setFont(new Font("Dialog", Font.BOLD, 20));
		radioButton_2.setBackground(UIManager.getColor("Button.foreground"));
		
		JRadioButton radioButton_3 = new JRadioButton("Poor");
		questionFourButtonGroup.add(radioButton_3);
		radioButton_3.setForeground(Color.WHITE);
		radioButton_3.setFont(new Font("Dialog", Font.BOLD, 20));
		radioButton_3.setBackground(UIManager.getColor("Button.foreground"));
		
		JLabel lblhowWouldYou = new JLabel("04.How would you rate the value for money of the product?");
		lblhowWouldYou.setForeground(Color.WHITE);
		lblhowWouldYou.setFont(new Font("Dialog", Font.BOLD, 20));
		lblhowWouldYou.setBackground(Color.WHITE);
		
		JLabel lblHowWould_1 = new JLabel("06. How would you rate the user experience of the app ?");
		lblHowWould_1.setForeground(Color.WHITE);
		lblHowWould_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblHowWould_1.setBackground(Color.WHITE);
		
		JLabel lblHowWould = new JLabel("05. How would you rate the performance of the app ?");
		lblHowWould.setForeground(Color.WHITE);
		lblHowWould.setFont(new Font("Dialog", Font.BOLD, 20));
		lblHowWould.setBackground(Color.WHITE);
		
		JRadioButton radioButton_4 = new JRadioButton("Excellent");
		questionFiveButtonGroup.add(radioButton_4);
		radioButton_4.setForeground(Color.WHITE);
		radioButton_4.setFont(new Font("Dialog", Font.BOLD, 20));
		radioButton_4.setBackground(UIManager.getColor("Button.foreground"));
		
		JRadioButton radioButton_5 = new JRadioButton("Average");
		questionFiveButtonGroup.add(radioButton_5);
		radioButton_5.setForeground(Color.WHITE);
		radioButton_5.setFont(new Font("Dialog", Font.BOLD, 20));
		radioButton_5.setBackground(UIManager.getColor("Button.foreground"));
		
		JRadioButton radioButton_6 = new JRadioButton("Below Average");
		questionFiveButtonGroup.add(radioButton_6);
		radioButton_6.setForeground(Color.WHITE);
		radioButton_6.setFont(new Font("Dialog", Font.BOLD, 20));
		radioButton_6.setBackground(UIManager.getColor("Button.foreground"));
		
		JRadioButton radioButton_7 = new JRadioButton("Poor");
		questionFiveButtonGroup.add(radioButton_7);
		radioButton_7.setForeground(Color.WHITE);
		radioButton_7.setFont(new Font("Dialog", Font.BOLD, 20));
		radioButton_7.setBackground(UIManager.getColor("Button.foreground"));
		
		JRadioButton radioButton_8 = new JRadioButton("Average");
		questionSixButtonGroup.add(radioButton_8);
		radioButton_8.setForeground(Color.WHITE);
		radioButton_8.setFont(new Font("Dialog", Font.BOLD, 20));
		radioButton_8.setBackground(UIManager.getColor("Button.foreground"));
		
		JRadioButton radioButton_9 = new JRadioButton("Excellent");
		questionSixButtonGroup.add(radioButton_9);
		radioButton_9.setForeground(Color.WHITE);
		radioButton_9.setFont(new Font("Dialog", Font.BOLD, 20));
		radioButton_9.setBackground(UIManager.getColor("Button.foreground"));
		
		JRadioButton radioButton_10 = new JRadioButton("Below Average");
		questionSixButtonGroup.add(radioButton_10);
		radioButton_10.setForeground(Color.WHITE);
		radioButton_10.setFont(new Font("Dialog", Font.BOLD, 20));
		radioButton_10.setBackground(UIManager.getColor("Button.foreground"));
		
		JRadioButton radioButton_11 = new JRadioButton("Poor");
		questionSixButtonGroup.add(radioButton_11);
		radioButton_11.setForeground(Color.WHITE);
		radioButton_11.setFont(new Font("Dialog", Font.BOLD, 20));
		radioButton_11.setBackground(UIManager.getColor("Button.foreground"));
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				// get first question answer
				Enumeration<AbstractButton> questionOneButtonGroupElement = questionFourButtonGroup.getElements();
				while (questionOneButtonGroupElement.hasMoreElements()) {
					JRadioButton jrdb1 = (JRadioButton) questionOneButtonGroupElement.nextElement();
					if (jrdb1.isSelected()) {
						questionFourAnswer = jrdb1.getText().toString();
					}
				}
				
				// get second question answer
				Enumeration<AbstractButton> questionTwoButtonGroupElement = questionFiveButtonGroup.getElements();
				while (questionTwoButtonGroupElement.hasMoreElements()) {
					JRadioButton jrdb1 = (JRadioButton) questionTwoButtonGroupElement.nextElement();
					if (jrdb1.isSelected()) {
						questionFiveAnswer = jrdb1.getText().toString();
					}
				}
				
				// get third question answer
				Enumeration<AbstractButton> questionThreeButtonGroupElement = questionSixButtonGroup.getElements();
				while (questionThreeButtonGroupElement.hasMoreElements()) {
					JRadioButton jrdb1 = (JRadioButton) questionThreeButtonGroupElement.nextElement();
					if (jrdb1.isSelected()) {
						questionSixAnswer = jrdb1.getText().toString();
					}
				}
				
				// Save second feedback form data in DB
				try {
					String lookupstring = "rmi://localhost:1099/emmitoQuestionnaireServer";
					RemoteInterface remoteInterface = (RemoteInterface)Naming.lookup(lookupstring);
					
					if(remoteInterface.submitSecondFeedbackForm( new Questions(questionFourAnswer, questionFiveAnswer, questionSixAnswer))) {
						
						String loginSessionCookie = remoteInterface.setCookie();
						
						DashboardGUI dashboard = new DashboardGUI(loginSessionCookie);
						dashboard.setVisible(true);
						dashboard.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						dashboard.setResizable(false);
						dispose();
					} else {
						final JDialog dialog = new JDialog();
						dialog.setAlwaysOnTop(true);    
						JOptionPane.showMessageDialog(null,"Something went wrong! Try again.");
					}
					
				} catch(RemoteException | MalformedURLException | NotBoundException error) {
					error.printStackTrace();
					 JOptionPane.showMessageDialog(null,"Run Server First",
							 "ALERT",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setFont(new Font("Dialog", Font.BOLD, 20));
		btnSubmit.setBackground(new Color(0, 206, 209));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(621, Short.MAX_VALUE)
					.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
					.addGap(57))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(89)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(102)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(radioButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
									.addComponent(radioButton_1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
									.addComponent(radioButton_2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
									.addComponent(radioButton_3, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
							.addComponent(lblhowWouldYou)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(108)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(radioButton_4, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
									.addComponent(radioButton_5, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
									.addComponent(radioButton_6, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
									.addComponent(radioButton_7, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
							.addComponent(lblHowWould, GroupLayout.PREFERRED_SIZE, 723, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblHowWould_1, GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE))
					.addGap(30))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(217)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(radioButton_8, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioButton_9, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioButton_10, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioButton_11, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(437, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(36)
					.addComponent(label)
					.addGap(81)
					.addComponent(lblhowWouldYou)
					.addGap(33)
					.addComponent(radioButton_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(radioButton, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(radioButton_2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(radioButton_3)
					.addGap(81)
					.addComponent(lblHowWould, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(radioButton_4, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(radioButton_5, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(radioButton_6, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(radioButton_7, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(85)
					.addComponent(lblHowWould_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addComponent(radioButton_9, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(radioButton_8, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(radioButton_10, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(radioButton_11, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
					.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(48))
		);
		panel.setLayout(gl_panel);
	}

}
