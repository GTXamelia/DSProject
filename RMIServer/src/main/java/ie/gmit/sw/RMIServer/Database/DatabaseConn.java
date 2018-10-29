package ie.gmit.sw.RMIServer.Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConn implements DatabaseConnInterface{
	
	private static final String JDBC_DRIVER = "org.h2.Driver";   
   	private static final String DB_URL = "jdbc:h2:~/DSProject";

   	private Connection conn;

	@Override
	public void Connect() {
		
		
	}

}
