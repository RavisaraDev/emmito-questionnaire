package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import server.RemoteInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class RemoteClient.
 */
public class RemoteClient {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws MalformedURLException the malformed URL exception
	 * @throws RemoteException the remote exception
	 * @throws NotBoundException the not bound exception
	 */
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		try {
			String lookupstring = "rmi://localhost:1099/emmitoQuestionnaireServer";
			RemoteInterface remoteInterface = (RemoteInterface)Naming.lookup(lookupstring);
			
		} catch(RemoteException error) {
			error.printStackTrace();
		}
		
	}

}
