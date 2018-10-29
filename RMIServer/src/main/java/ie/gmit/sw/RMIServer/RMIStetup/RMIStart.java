package ie.gmit.sw.RMIServer.RMIStetup;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import ie.gmit.sw.RMIServer.Database.DatabaseConn;

public class RMIStart {

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		
		DatabaseConn db = new DatabaseConn();
		
		LocateRegistry.createRegistry(1099);

		//Bind our remote object to the registry with the human-readable name "databaseService"
		Naming.rebind("databaseConn", db);
	}

}
