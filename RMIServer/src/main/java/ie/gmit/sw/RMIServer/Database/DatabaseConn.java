package ie.gmit.sw.RMIServer.Database;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConn extends UnicastRemoteObject implements DatabaseConnInterface{
	
	public DatabaseConn() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
	
	private static final String JDBC_DRIVER = "org.h2.Driver";   
   	private static final String DB_URL = "jdbc:h2:~/DSProject";

   	private Connection conn;
   	
	public void Connect() {
		System.out.println("test");
	}

}
