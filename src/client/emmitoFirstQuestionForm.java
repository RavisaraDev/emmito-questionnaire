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

// TODO: Auto-generated Javadoc
/**
 * The Class emmitoFirstQuestionForm.
 */
public class emmitoFirstQuestionForm extends JFrame {
	
	/** The question one answer. */
	String questionOneAnswer;
	
	/** The question two answer. */
	String questionTwoAnswer;
	
	/** The question three answer. */
	String questionThreeAnswer;
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The content pane. */
	private JPanel contentPane;
	
	/** The question one button group. */
	private final ButtonGroup questionOneButtonGroup = new ButtonGroup();
	
	/** The question two button group. */
	private final ButtonGroup questionTwoButtonGroup = new ButtonGroup();
	
	/** The question three button group. */
	private final ButtonGroup questionThreeButtonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					emmitoFirstQuestionForm frame = new emmitoFirstQuestionForm();
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
	public emmitoFirstQuestionForm() {
		setBackground(UIManager.getColor("CheckBox.foreground"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 826, 1305);
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
		questionOneButtonGroup.add(radioButton);
		radioButton.setForeground(Color.WHITE);
		radioButton.setFont(new Font("Dialog", Font.BOLD, 20));
		radioButton.setBackground(UIManager.getColor("Button.foreground"));
		
		JRadioButton radioButton_1 = new JRadioButton("Excellent");
		questionOneButtonGroup.add(radioButton_1);
		radioButton_1.setForeground(Color.WHITE);
		radioButton_1.setFont(new Font("Dialog", Font.BOLD, 20));
		radioButton_1.setBackground(UIManager.getColor("Button.foreground"));
		
		JRadioButton radioButton_2 = new JRadioButton("Below Average");
		questionOneButtonGroup.add(radioButton_2);
		radioButton_2.setForeground(Color.WHITE);
		radioButton_2.setFont(new Font("Dialog", Font.BOLD, 20));
		radioButton_2.setBackground(UIManager.getColor("Button.foreground"));
		
		JRadioButton radioButton_3 = new JRadioButton("Poor");
		questionOneButtonGroup.add(radioButton_3);
		radioButton_3.setForeground(Color.WHITE);
		radioButton_3.setFont(new Font("Dialog", Font.BOLD, 20));
		radioButton_3.setBackground(UIManager.getColor("Button.foreground"));
		
		JLabel label_1 = new JLabel("01. What is the first reaction to this product ?");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Dialog", Font.BOLD, 20));
		label_1.setBackground(Color.WHITE);
		
		JLabel label_2 = new JLabel("03. How easy its is to find features that you expect");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Dialog", Font.BOLD, 20));
		label_2.setBackground(Color.WHITE);
		
		JLabel label_3 = new JLabel("from this app ?");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Dialog", Font.BOLD, 20));
		label_3.setBackground(Color.WHITE);
		
		JLabel label_4 = new JLabel("02. How would you rate the quality of the product ?");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Dialog", Font.BOLD, 20));
		label_4.setBackground(Color.WHITE);
		
		JRadioButton radioButton_4 = new JRadioButton("Excellent");
		questionTwoButtonGroup.add(radioButton_4);
		radioButton_4.setForeground(Color.WHITE);
		radioButton_4.setFont(new Font("Dialog", Font.BOLD, 20));
		radioButton_4.setBackground(UIManager.getColor("Button.foreground"));
		
		JRadioButton radioButton_5 = new JRadioButton("Average");
		questionTwoButtonGroup.add(radioButton_5);
		radioButton_5.setForeground(Color.WHITE);
		radioButton_5.setFont(new Font("Dialog", Font.BOLD, 20));
		radioButton_5.setBackground(UIManager.getColor("Button.foreground"));
		
		JRadioButton radioButton_6 = new JRadioButton("Below Average");
		questionTwoButtonGroup.add(radioButton_6);
		radioButton_6.setForeground(Color.WHITE);
		radioButton_6.setFont(new Font("Dialog", Font.BOLD, 20));
		radioButton_6.setBackground(UIManager.getColor("Button.foreground"));
		
		JRadioButton radioButton_7 = new JRadioButton("Poor");
		questionTwoButtonGroup.add(radioButton_7);
		radioButton_7.setForeground(Color.WHITE);
		radioButton_7.setFont(new Font("Dialog", Font.BOLD, 20));
		radioButton_7.setBackground(UIManager.getColor("Button.foreground"));
		
		JRadioButton radioButton_8 = new JRadioButton("Average");
		questionThreeButtonGroup.add(radioButton_8);
		radioButton_8.setForeground(Color.WHITE);
		radioButton_8.setFont(new Font("Dialog", Font.BOLD, 20));
		radioButton_8.setBackground(UIManager.getColor("Button.foreground"));
		
		JRadioButton radioButton_9 = new JRadioButton("Excellent");
		questionThreeButtonGroup.add(radioButton_9);
		radioButton_9.setForeground(Color.WHITE);
		radioButton_9.setFont(new Font("Dialog", Font.BOLD, 20));
		radioButton_9.setBackground(UIManager.getColor("Button.foreground"));
		
		JRadioButton radioButton_10 = new JRadioButton("Below Average");
		questionThreeButtonGroup.add(radioButton_10);
		radioButton_10.setForeground(Color.WHITE);
		radioButton_10.setFont(new Font("Dialog", Font.BOLD, 20));
		radioButton_10.setBackground(UIManager.getColor("Button.foreground"));
		
		JRadioButton radioButton_11 = new JRadioButton("Poor");
		questionThreeButtonGroup.add(radioButton_11);
		radioButton_11.setForeground(Color.WHITE);
		radioButton_11.setFont(new Font("Dialog", Font.BOLD, 20));
		radioButton_11.setBackground(UIManager.getColor("Button.foreground"));
		
		JButton button = new JButton("Next");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				// get first question answer
				Enumeration<AbstractButton> questionOneButtonGroupElement = questionOneButtonGroup.getElements();
				while (questionOneButtonGroupElement.hasMoreElements()) {
					JRadioButton jrdb1 = (JRadioButton) questionOneButtonGroupElement.nextElement();
					if (jrdb1.isSelected()) {
						questionOneAnswer = jrdb1.getText().toString();
					}
				}
				
				// get second question answer
				Enumeration<AbstractButton> questionTwoButtonGroupElement = questionTwoButtonGroup.getElements();
				while (questionTwoButtonGroupElement.hasMoreElements()) {
					JRadioButton jrdb1 = (JRadioButton) questionTwoButtonGroupElement.nextElement();
					if (jrdb1.isSelected()) {
						questionTwoAnswer = jrdb1.getText().toString();
					}
				}
				
				// get third question answer
				Enumeration<AbstractButton> questionThreeButtonGroupElement = questionThreeButtonGroup.getElements();
				while (questionThreeButtonGroupElement.hasMoreElements()) {
					JRadioButton jrdb1 = (JRadioButton) questionThreeButtonGroupElement.nextElement();
					if (jrdb1.isSelected()) {
						questionThreeAnswer = jrdb1.getText().toString();
					}
				}
				
				// Save first feedback form data in DB
				try {
					String lookupstring = "rmi://localhost:1099/emmitoQuestionnaireServer";
					RemoteInterface remoteInterface = (RemoteInterface)Naming.lookup(lookupstring);
					
					if(remoteInterface.submitFirstFeedbackForm( new Questions(questionOneAnswer, questionTwoAnswer, questionThreeAnswer))) {
						emmitoSecondQuestionForm formUI = new emmitoSecondQuestionForm();
						formUI.setVisible(true);
						formUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						formUI.setResizable(false);
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
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Dialog", Font.BOLD, 20));
		button.setBackground(new Color(123, 104, 238));
		
		JButton btnGoBack = new JButton("Go back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String lookupstring = "rmi://localhost:1099/emmitoQuestionnaireServer";
					RemoteInterface remoteInterface = (RemoteInterface)Naming.lookup(lookupstring);
					String loginSessionCookie = remoteInterface.setCookie();
					
					DashboardGUI dashboard = new DashboardGUI(loginSessionCookie);
					dashboard.setVisible(true);
					dashboard.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					dashboard.setResizable(false);
					dispose();
					
				} catch (RemoteException | MalformedURLException | NotBoundException e1) {
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
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(394, Short.MAX_VALUE)
					.addComponent(btnGoBack, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
					.addGap(57))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(91)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(102)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(radioButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
								.addComponent(radioButton_1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
								.addComponent(radioButton_2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
								.addComponent(radioButton_3, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
						.addComponent(label_2)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(45)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 685, GroupLayout.PREFERRED_SIZE))
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 723, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4, GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(106)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(radioButton_4, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
								.addComponent(radioButton_5, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
								.addComponent(radioButton_6, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
								.addComponent(radioButton_7, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 424, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(106)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(radioButton_8, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
								.addComponent(radioButton_9, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
								.addComponent(radioButton_10, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
								.addComponent(radioButton_11, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 424, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(36)
					.addComponent(label)
					.addGap(82)
					.addComponent(label_1)
					.addGap(33)
					.addComponent(radioButton_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(radioButton, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(radioButton_2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(radioButton_3)
					.addGap(81)
					.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(radioButton_4, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(radioButton_5, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(radioButton_6, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(radioButton_7, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addComponent(radioButton_9, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(radioButton_8, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(radioButton_10, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(radioButton_11, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(83)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnGoBack, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
					.addGap(48))
		);
		panel.setLayout(gl_panel);
	}
}
