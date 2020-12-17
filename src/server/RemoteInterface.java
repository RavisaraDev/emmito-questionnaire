package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import classes.Questions;

public interface RemoteInterface extends Remote{
	public boolean checkUser(String user , String password) throws RemoteException;
	public boolean submitFirstFeedbackForm(Questions questionSetAnswers) throws RemoteException;
	public boolean submitSecondFeedbackForm(Questions questionSetAnswers) throws RemoteException;
	public boolean collectData(Questions questionSetAnswers) throws RemoteException;
	public String analyzeAnswers() throws RemoteException;
	public String setCookie() throws RemoteException;
}
