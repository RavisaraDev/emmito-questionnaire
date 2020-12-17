package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RemoteServer {

	public static void main(String[] args) {
		try {
			System.out.println("Server Starting...");
			Registry createRegistry = LocateRegistry.createRegistry(1099);
			RemoteInterface questionnaireRemoteInterface = new ImplimentServer();
			createRegistry.rebind("emmitoQuestionnaireServer", questionnaireRemoteInterface);
			System.out.println("Server Started.");
		} catch(RemoteException error) {
			error.printStackTrace();
		}
	}

}
