package ie.gmit.sw;

import java.rmi.*;
import java.sql.SQLException;
import java.util.List;

public interface DatabaseOption extends Remote{
	
	public void Connect() throws RemoteException, ClassNotFoundException, SQLException;
	
	public void Execute(String sql) throws RemoteException, SQLException;
	
	public List<Object> Read(String sql) throws RemoteException, SQLException;
	
	public void Close() throws RemoteException, SQLException;

}
