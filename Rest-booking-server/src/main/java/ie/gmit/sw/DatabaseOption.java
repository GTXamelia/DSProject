package ie.gmit.sw;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface DatabaseOption extends Remote{
	
	public void Connect() throws RemoteException;
	
	public void Create(String sql) throws RemoteException;
	
	public void Update(String sql) throws RemoteException;
	
	public void Delete(String sql) throws RemoteException;
	
	public List<Object> Read(String sql) throws RemoteException;
	
	public void Close() throws RemoteException;

}
