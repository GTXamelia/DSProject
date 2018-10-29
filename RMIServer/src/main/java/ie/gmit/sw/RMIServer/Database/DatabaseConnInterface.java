package ie.gmit.sw.RMIServer.Database;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DatabaseConnInterface extends Remote{
	
	public void Connect() throws RemoteException;

}
