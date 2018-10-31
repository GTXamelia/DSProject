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
	
	public void Insert(String sql) throws SQLException {
			
		Statement stmt = this.conn.createStatement();
		
		stmt.execute(sql);
		
	}
	
	public void Update(String sql) throws SQLException {
		
		Statement stmt = this.conn.createStatement();
		
		stmt.execute(sql);
		
	}
	
	public void Delete(String sql) throws SQLException {
		
		Statement stmt = this.conn.createStatement();
		stmt.execute(sql);

	}
	
	public List<Object> Read(String sql) throws SQLException {
		
		ResultSet rs = null;
		
    	ArrayList<Object> list = new ArrayList<>();
			
		Statement stmt = this.conn.createStatement();
		
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			
			Customer c = new Customer(rs.getString(1));
			
			list.add(c);
		}
		
		return list;
	}
	
	public void Close() throws SQLException {
		
		this.conn.close();
		
	}
	
	public static void createTables(Connection conn) {
		
		Statement stmt;
		
		try {
			
			stmt = conn.createStatement();
			
			CreateCustomersTable(stmt);
			
		} catch (SQLException e) {
			
			System.out.println("SQL Error");
		
		}
		
	}
	
	
	private static void CreateCustomersTable(Statement stmt) {
		
		try {
			
			String sql =  "DROP TABLE CUSTOMERS";
			stmt.execute(sql);
			
			sql =  "CREATE TABLE CUSTOMERS"+
					 "(NAME VARCHAR(255) not NULL, "+
					 " PRIMARY KEY (NAME))";
			stmt.execute(sql);
			
			sql =  "INSERT INTO CUSTOMERS (NAME) VALUES ('Cian');";
			stmt.execute(sql);
			
			sql =  "INSERT INTO CUSTOMERS (NAME) VALUES ('Gannon');";
			stmt.execute(sql);

		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}

}
