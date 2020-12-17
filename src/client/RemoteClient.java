package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import server.RemoteInterface;

public class RemoteClient {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		try {
			String lookupstring = "rmi://localhost:1099/emmitoQuestionnaireServer";
			RemoteInterface remoteInterface = (RemoteInterface)Naming.lookup(lookupstring);
			
			Boolean isUserExist = remoteInterface.checkUser("admin", "admin");
			System.out.println(isUserExist);
			
		} catch(RemoteException error) {
			error.printStackTrace();
		}
		
	}

}
