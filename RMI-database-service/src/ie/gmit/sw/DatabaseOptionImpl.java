package ie.gmit.sw;

import java.rmi.*;
import java.rmi.server.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseOptionImpl extends UnicastRemoteObject implements DatabaseOption {
	private static final long serialVersionUID = 1L;

	private Connection conn = null;
	
	public DatabaseOptionImpl() throws RemoteException{
		super();
	}

	public void Connect() throws ClassNotFoundException, SQLException {
			
		Class.forName ("org.h2.Driver");
	
		this.conn = DriverManager.getConnection ("jdbc:h2:~/DSProject", "","");
		
	}
	
	public void Create(String sql) throws SQLException {
			
		Statement stmt = this.conn.createStatement();
		
		stmt.execute(sql);
		
	}
	
	public List<Object> Read(String sql) throws SQLException {
		
		ResultSet rs = null;
		
    	ArrayList<Object> list = new ArrayList<>();
			
		Statement stmt = this.conn.createStatement();
		
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			
			Customer c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			
			list.add(c);
		}
		
		return list;
	}
	
	public List<Object> ReadCar(String sql) throws SQLException {
		
		ResultSet rs = null;
		
    	ArrayList<Object> list = new ArrayList<>();
			
		Statement stmt = this.conn.createStatement();
		
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			
			Car c = new Car(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getDouble(5));
			
			list.add(c);
		}
		
		return list;
	}
	
	public void Update(String sql) throws SQLException {
		
		Statement stmt = this.conn.createStatement();
		
		stmt.execute(sql);
		
		System.out.println("User Updating...");
		
	}
	
	public void Delete(String sql) throws SQLException {
		
		Statement stmt = this.conn.createStatement();
		
		stmt.execute(sql);
		
	}
	
	public void Close() throws SQLException {
		
		this.conn.close();
		
	}
	
	public static void createTables() throws SQLException {
		
		Connection connTest = DriverManager.getConnection ("jdbc:h2:~/DSProject", "","");
		
		CreateCustomersTable(connTest);
		
	}
	
	private static void CreateCustomersTable(Connection connTest) throws SQLException {
		
		Statement stmt= connTest.createStatement();
		String sql;
		
		// Rest Table used for testing only
		sql =  "DROP TABLE CUSTOMERS";
		stmt.execute(sql);
		
		sql =  "DROP TABLE CARS";
		stmt.execute(sql);
		
		//sql =  "CREATE TABLE CUSTOMERS" + "(NAME VARCHAR(255) not NULL, " +  " PRIMARY KEY (NAME))";
			
		sql = "CREATE TABLE CUSTOMERS (" + 
			  "`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
			  "FIRST VARCHAR(255) NOT NULL," +
			  "SECOND VARCHAR(255) NOT NULL," +
			  "NUMBER VARCHAR(255) NOT NULL" +
			  ");";
		stmt.execute(sql);
		
		sql = "CREATE TABLE CARS (" + 
			  "`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
			  "REG VARCHAR(255) NOT NULL," +
			  "YEAR INT NOT NULL," +
			  "MAKE VARCHAR(255) NOT NULL," +
			  "COST DOUBLE NOT NULL" +
			  ");";
		stmt.execute(sql);
		
		sql =  "INSERT INTO CUSTOMERS (FIRST, SECOND, NUMBER) VALUES ('Cian', 'Gannon', '1234567')";
		stmt.execute(sql);
		
		sql =  "INSERT INTO CUSTOMERS (FIRST, SECOND, NUMBER) VALUES ('Test', 'Gannon', '1234567')";
		stmt.execute(sql);
		
		sql =  "INSERT INTO CUSTOMERS (FIRST, SECOND, NUMBER) VALUES ('Test', 'Test', '9999999')";
		stmt.execute(sql);
		
		
		sql =  "INSERT INTO CARS (REG, YEAR, MAKE, COST) VALUES ('07-GA-7643', '2007', 'Ford', '230.50')";
		stmt.execute(sql);	
	}

}
