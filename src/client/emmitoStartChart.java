package client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import server.RemoteInterface;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Dimension;

public class emmitoStartChart extends JFrame {

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
					emmitoStartChart frame = new emmitoStartChart();
					frame.setSize(1150, 1850);
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
	public emmitoStartChart() {
		setPreferredSize(new Dimension(100, 0));
		setSize(new Dimension(4500, 0));
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 992, 1775);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(100, 10));
		contentPane.setSize(new Dimension(4500, 0));
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		panel.setBackground(Color.DARK_GRAY);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 982, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1636, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(51, Short.MAX_VALUE))
		);
		
		JLabel lblAnalyzeFeedbacks = new JLabel("Analyze Feedbacks");
		lblAnalyzeFeedbacks.setFont(new Font("Dialog", Font.BOLD, 40));
		lblAnalyzeFeedbacks.setForeground(Color.WHITE);
		
		
		try {
			BufferedImage imageChartOne = null;
			BufferedImage imageChartTwo = null;
			String[] questionUrls = null;
			
			String lookupstring = "rmi://localhost:1099/emmitoQuestionnaireServer";
			RemoteInterface remoteInterface = (RemoteInterface) Naming.lookup(lookupstring);

			questionUrls = remoteInterface.analyzeAnswers().split("~");

			URL chartOneUrl = new URL(questionUrls[0]);
			URL chartTwoUrl = new URL(questionUrls[1]);
			
			HttpURLConnection connectionForChartOne = (HttpURLConnection) chartOneUrl.openConnection();
			connectionForChartOne.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			imageChartOne = ImageIO.read(connectionForChartOne.getInputStream());
			
			HttpURLConnection connectionForChartTwo = (HttpURLConnection) chartTwoUrl.openConnection();
			connectionForChartTwo.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			imageChartTwo = ImageIO.read(connectionForChartTwo.getInputStream());
			
			JLabel ChartOne = new JLabel(new ImageIcon(imageChartOne));
			
			JLabel ChartTwo = new JLabel(new ImageIcon(imageChartTwo));
			
			JLabel lblChart = new JLabel("Categorized on positive and negative");
			lblChart.setForeground(Color.WHITE);
			lblChart.setFont(new Font("Dialog", Font.BOLD, 25));
			
			JLabel lblNewLabel = new JLabel("Answers frequency");
			lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 25));
			lblNewLabel.setForeground(Color.WHITE);
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(53)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(ChartTwo, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblAnalyzeFeedbacks)
							.addComponent(lblNewLabel)
							.addComponent(ChartOne, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE)
							.addComponent(lblChart))
						.addContainerGap())
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
						.addComponent(lblAnalyzeFeedbacks, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
						.addComponent(lblChart)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(ChartOne, GroupLayout.PREFERRED_SIZE, 594, GroupLayout.PREFERRED_SIZE)
						.addGap(140)
						.addComponent(lblNewLabel)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(ChartTwo, GroupLayout.PREFERRED_SIZE, 584, GroupLayout.PREFERRED_SIZE)
						.addGap(62))
			);
			panel.setLayout(gl_panel);
			contentPane.setLayout(gl_contentPane);
		} catch (NotBoundException | IOException error) {
			error.printStackTrace();
			JOptionPane.showMessageDialog(null, "Run Server First", "ALERT", JOptionPane.WARNING_MESSAGE);
		}
	}
}
