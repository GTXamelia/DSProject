package ie.gmit.sw;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RMISetup {

	public static void main(String[] args) throws Exception {
		
		DatabaseOption db = new DatabaseOptionImpl();
		
		LocateRegistry.createRegistry(1099);
		
		Naming.rebind("databaseOption", db);
		
		System.out.println("RMI server started...");
		
		Connection conn = DriverManager.getConnection ("jdbc:h2:~/DSProject", "","");
		
		DatabaseOptionImpl.createTables(conn);
		
		// Test DB
		db.Connect();
		db.Close();
	}
	
}
