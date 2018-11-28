package ie.gmit.sw;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RMISetup {

	// Adapted from 'ds wk6 RMI FileServer'
	public static void main(String[] args) throws Exception {
		
		DatabaseOption db = new DatabaseOptionImpl();
		
		LocateRegistry.createRegistry(1099);
		
		Naming.rebind("databaseOption", db);
		
		System.out.println("RMI server started...");
		
		DatabaseOptionImpl.createTables();
		
		// Test DB
		db.Connect();
		db.Close();
	}
	
}
