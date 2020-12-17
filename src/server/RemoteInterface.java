package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import classes.Questions;

// TODO: Auto-generated Javadoc
/**
 * The Interface RemoteInterface.
 */
public interface RemoteInterface extends Remote{
	
	/**
	 * Check user.
	 *
	 * @param user the user
	 * @param password the password
	 * @return true, if successful
	 * @throws RemoteException the remote exception
	 */
	public boolean checkUser(String user , String password) throws RemoteException;
	
	/**
	 * Submit first feedback form.
	 *
	 * @param questionSetAnswers the question set answers
	 * @return true, if successful
	 * @throws RemoteException the remote exception
	 */
	public boolean submitFirstFeedbackForm(Questions questionSetAnswers) throws RemoteException;
	
	/**
	 * Submit second feedback form.
	 *
	 * @param questionSetAnswers the question set answers
	 * @return true, if successful
	 * @throws RemoteException the remote exception
	 */
	public boolean submitSecondFeedbackForm(Questions questionSetAnswers) throws RemoteException;
	
	/**
	 * Collect data.
	 *
	 * @param questionSetAnswers the question set answers
	 * @return true, if successful
	 * @throws RemoteException the remote exception
	 */
	public boolean collectData(Questions questionSetAnswers) throws RemoteException;
	
	/**
	 * Analyze answers.
	 *
	 * @return the string
	 * @throws RemoteException the remote exception
	 */
	public String analyzeAnswers() throws RemoteException;
	
	/**
	 * Sets the cookie.
	 *
	 * @return the string
	 * @throws RemoteException the remote exception
	 */
	public String setCookie() throws RemoteException;
}
