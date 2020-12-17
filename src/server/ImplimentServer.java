package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Stack;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import classes.Questions;

public class ImplimentServer extends UnicastRemoteObject implements RemoteInterface {

	private static final long serialVersionUID = 1L;
	static Connection conn;
	private String sessionCookie = null;

	// Implement server
	protected ImplimentServer() throws RemoteException {
		super();

		// Implement DB connection
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emmito", "root", "");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Authenticating user
	@Override
	public boolean checkUser(String user, String password) throws RemoteException {
		String query = "SELECT id, username, password FROM users WHERE username=? and password=?";

		System.out.println("Authenticating user...");
		try {
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, user);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				sessionCookie = String.valueOf(rs.getInt("id"));
				System.out.println("User found.");
				return true;
			} else {
				System.out.println("No user found.");
				return false;
			}
		} catch (Exception e) {
			final JDialog dialog = new JDialog();
			dialog.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(null, "Error" + e.toString());
		}
		return false;
	}

	// submit first feedback form
	@Override
	public boolean submitFirstFeedbackForm(Questions questionSetAnswers) throws RemoteException {
		String query = "INSERT INTO `answers`( `answerOne`, `answerTwo`, `answerThree`) VALUES (?,?,?)";

		try {
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, questionSetAnswers.getQuestionOneAnswer());
			pst.setString(2, questionSetAnswers.getQuestionTwoAnswer());
			pst.setString(3, questionSetAnswers.getQuestionThreeAnswer());
			pst.executeUpdate();

			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	// submit second feedback form
	@Override
	public boolean submitSecondFeedbackForm(Questions questionSetAnswers) throws RemoteException {

		String getLastRecordIdquery = "SELECT MAX(Id) FROM answers";
		String updateRecordQuery = "UPDATE `answers` SET answerFour = ?, answerFive = ?, answerSix = ? WHERE id = ?";
		int lastRecordId = 0;

		// Get last record ID
		try (PreparedStatement firstStatement = conn.prepareStatement(getLastRecordIdquery)) {
			ResultSet rs = firstStatement.executeQuery(getLastRecordIdquery);
			while (rs.next()) {
				lastRecordId = rs.getInt("MAX(Id)");
			}

			// Update table with second feedback form data
			try (PreparedStatement secondStatement = conn.prepareStatement(updateRecordQuery)) {
				secondStatement.setString(1, questionSetAnswers.getQuestionOneAnswer());
				secondStatement.setString(2, questionSetAnswers.getQuestionTwoAnswer());
				secondStatement.setString(3, questionSetAnswers.getQuestionThreeAnswer());
				secondStatement.setInt(4, lastRecordId);
				secondStatement.executeUpdate();

				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	static Stack<String> getAnswersData(String answerNumber) {
		Stack<String> answerStack = new Stack<String>();

		String getQuestionAnswers = "SELECT (`" + answerNumber + "`)  FROM `answers`";

		try (PreparedStatement questionAnswersStatement = conn.prepareStatement(getQuestionAnswers)) {
			ResultSet rs = questionAnswersStatement.executeQuery();
			int excellent = 0;
			int average = 0;
			int belowAverage = 0;
			int poor = 0;

			while (rs.next()) {
				if (rs.getString(1).equals("Excellent")) {
					excellent++;
				} else if (rs.getString(1).equals("Average")) {
					average++;
				} else if (rs.getString(1).equals("Below Average")) {
					belowAverage--;
				} else if (rs.getString(1).equals("Poor")) {
					poor--;
				}
			}

			answerStack.push(Integer.toString(excellent));
			answerStack.push(Integer.toString(average));
			answerStack.push(Integer.toString(belowAverage));
			answerStack.push(Integer.toString(poor));

			return answerStack;
		} catch (SQLException e) {
			e.printStackTrace();
			return answerStack;
		}
	}

	// Get data to show the chart
	@Override
	public String analyzeAnswers() throws RemoteException {
		String chartUrl = "";
		
		Stack<String> questionOneAnswerStack = new Stack<String>();
		Stack<String> questionTwoAnswerStack = new Stack<String>();
		Stack<String> questionThreeAnswerStack = new Stack<String>();
		Stack<String> questionFourAnswerStack = new Stack<String>();
		Stack<String> questionFiveAnswerStack = new Stack<String>();
		Stack<String> questionSixAnswerStack = new Stack<String>();

		questionOneAnswerStack = getAnswersData("answerOne");
		questionTwoAnswerStack = getAnswersData("answerTwo");
		questionThreeAnswerStack = getAnswersData("answerThree");
		questionFourAnswerStack = getAnswersData("answerFour");
		questionFiveAnswerStack = getAnswersData("answerFive");
		questionSixAnswerStack = getAnswersData("answerSix");

		chartUrl = "https://quickchart.io/chart?bkg=transparent&c={type:'bar',data:{labels:['Q1','Q2','Q3','Q4','Q5','Q6'],datasets:[{label:'Excellent',backgroundColor:'rgb(75,192,192)',data:["+questionOneAnswerStack.get(0)+","+questionTwoAnswerStack.get(0)+","+questionThreeAnswerStack.get(0)+","+questionFourAnswerStack.get(0)+","+questionFiveAnswerStack.get(0)+","+questionSixAnswerStack.get(0)+"],},{label:'Average',backgroundColor:'rgb(54,162,235)',data:["+questionOneAnswerStack.get(1)+","+questionTwoAnswerStack.get(1)+","+questionThreeAnswerStack.get(1)+","+questionFourAnswerStack.get(1)+","+questionFiveAnswerStack.get(1)+","+questionSixAnswerStack.get(1)+"],},{label:'BelowAverage',backgroundColor:'rgb(255,165,0)',data:["+questionOneAnswerStack.get(2)+","+questionTwoAnswerStack.get(2)+","+questionThreeAnswerStack.get(2)+","+questionFourAnswerStack.get(2)+","+questionFiveAnswerStack.get(2)+","+questionSixAnswerStack.get(2)+"],},{label:'Poor',backgroundColor:'rgb(255,0,0)',data:["+questionOneAnswerStack.get(3)+","+questionTwoAnswerStack.get(3)+","+questionThreeAnswerStack.get(3)+","+questionFourAnswerStack.get(3)+","+questionFiveAnswerStack.get(3)+","+questionSixAnswerStack.get(3)+"],},],},options:{legend:{labels:{fontColor:'white'}},title:{display:true,text:'',},scales:{xAxes:[{stacked:true,ticks:{fontColor:'white'},},],yAxes:[{stacked:true,gridLines:{color:'white'},ticks:{fontColor:'white'},},],},},}"+"~"+"https://quickchart.io/chart?bkg=transparent&c={type:'bar',data:{labels:['Q1','Q2','Q3','Q4','Q5','Q6'],datasets:[{label:'Exelent',backgroundColor:'rgb(255,99,132)',stack:'Stack0',data:["+Integer.toString(Math.abs(Integer.parseInt(questionOneAnswerStack.get(0))))+","+Integer.toString(Math.abs(Integer.parseInt(questionTwoAnswerStack.get(0))))+","+Integer.toString(Math.abs(Integer.parseInt(questionThreeAnswerStack.get(0))))+","+Integer.toString(Math.abs(Integer.parseInt(questionFourAnswerStack.get(0))))+","+Integer.toString(Math.abs(Integer.parseInt(questionFiveAnswerStack.get(0))))+","+Integer.toString(Math.abs(Integer.parseInt(questionSixAnswerStack.get(0))))+"],},{label:'Average',backgroundColor:'rgb(54,162,235)',stack:'Stack1',data:["+Integer.toString(Math.abs(Integer.parseInt(questionOneAnswerStack.get(1))))+","+Integer.toString(Math.abs(Integer.parseInt(questionTwoAnswerStack.get(1))))+","+Integer.toString(Math.abs(Integer.parseInt(questionThreeAnswerStack.get(1))))+","+Integer.toString(Math.abs(Integer.parseInt(questionFourAnswerStack.get(1))))+","+Integer.toString(Math.abs(Integer.parseInt(questionFiveAnswerStack.get(1))))+","+Integer.toString(Math.abs(Integer.parseInt(questionSixAnswerStack.get(1))))+"],},{label:'Belowaverage',backgroundColor:'rgb(75,192,192)',stack:'Stack2',data:["+Integer.toString(Math.abs(Integer.parseInt(questionOneAnswerStack.get(2))))+","+Integer.toString(Math.abs(Integer.parseInt(questionTwoAnswerStack.get(2))))+","+Integer.toString(Math.abs(Integer.parseInt(questionThreeAnswerStack.get(2))))+","+Integer.toString(Math.abs(Integer.parseInt(questionFourAnswerStack.get(2))))+","+Integer.toString(Math.abs(Integer.parseInt(questionFiveAnswerStack.get(2))))+","+Integer.toString(Math.abs(Integer.parseInt(questionSixAnswerStack.get(2))))+"],},{label:'Poor',backgroundColor:'rgb(75,142,112)',stack:'Stack3',data:["+Integer.toString(Math.abs(Integer.parseInt(questionOneAnswerStack.get(3))))+","+Integer.toString(Math.abs(Integer.parseInt(questionTwoAnswerStack.get(3))))+","+Integer.toString(Math.abs(Integer.parseInt(questionThreeAnswerStack.get(3))))+","+Integer.toString(Math.abs(Integer.parseInt(questionFourAnswerStack.get(3))))+","+Integer.toString(Math.abs(Integer.parseInt(questionFiveAnswerStack.get(3))))+","+Integer.toString(Math.abs(Integer.parseInt(questionSixAnswerStack.get(3))))+"],},],},options:{legend:{labels:{fontColor:'white'}},title:{display:true,text:'',},tooltips:{mode:'index',intersect:false,},responsive:true,scales:{xAxes:[{stacked:true,ticks:{fontColor:'white'},},],yAxes:[{stacked:true,gridLines:{color:'white'},ticks:{fontColor:'white'},},],},},}";
		return chartUrl;
	}

	@Override
	public boolean collectData(Questions questionSetAnswers) throws RemoteException {
		Vector<String> answerVector = new Vector<String>();

		answerVector.add(questionSetAnswers.getQuestionOneAnswer());
		answerVector.add(questionSetAnswers.getQuestionTwoAnswer());
		answerVector.add(questionSetAnswers.getQuestionThreeAnswer());

		return true;
	}

	@Override
	public String setCookie() throws RemoteException {
		String loginSessionCookie = sessionCookie;
		return loginSessionCookie;
	}

}
