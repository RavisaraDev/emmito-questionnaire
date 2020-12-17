package classes;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import server.RemoteInterface;

public class showImageFromUrl {
	public static void show() { 
		String question = "";
		BufferedImage image = null;
		
		try {
			String lookupstring = "rmi://localhost:1099/emmitoQuestionnaireServer";
			RemoteInterface remoteInterface = (RemoteInterface)Naming.lookup(lookupstring);
			
			question = remoteInterface.analyzeAnswers();
			
			URL url = new URL(question);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			image = ImageIO.read(con.getInputStream());
			
			JFrame frame = new JFrame();
			frame.setForeground(Color.WHITE);
			// frame.setIconImage(Toolkit.getDefaultToolkit().getImage(ComplainsUI.class.getResource("/images/cupcake.png")));
			frame.setResizable(false);
			frame.setBackground(Color.WHITE);
			frame.setSize(1030, 850);
			JLabel label = new JLabel(new ImageIcon(image));
			frame.getContentPane().add(label);
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
		} catch(NotBoundException | IOException error) {
			error.printStackTrace();
			 JOptionPane.showMessageDialog(null,"Run Server First",
					 "ALERT",JOptionPane.WARNING_MESSAGE);
		}
	}
}
