package WebService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.google.gson.Gson;

import ie.gmit.sw.DatabaseOption;

@Path("customer")
public class CustomerResource {
	
	private String service = "/databaseOption";
	private String address = "localhost:1099";

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() throws RemoteException, MalformedURLException, NotBoundException, SQLException {
    	
    	DatabaseOption db = (DatabaseOption)Naming.lookup( "rmi://" + address + service);
    	
    	db.Connect();
    	
    	List<Object> rs = db.Read("SELECT * FROM CUSTOMERS");
    	
    	db.Close();
    	
    	Gson gson = new Gson();
    	
        String jsonResp = gson.toJson(rs);
    	
        return Response.ok(jsonResp, MediaType.APPLICATION_JSON).build();
        
    }
    
    @POST
	@Path("/post")
	@Consumes("application/json")
	public Response createProductInJSON(@PathParam(value = "id") int id) {

		String result = "Customer: " + id;
		
		System.out.println(result);
		
		return Response.status(201).entity(result).build();
	}
    
    @GET
    @Path("/edit/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomer(@PathParam(value = "id") int id) throws RemoteException, MalformedURLException, NotBoundException {
    	
    	DatabaseOption db = (DatabaseOption)Naming.lookup( "rmi://" + address + service);
    	
    	db.Connect();
    	
    	List<Object> rs = db.Read("SELECT * FROM CUSTOMERS WHERE id="+id);
    	
    	db.Close();
    	
    	Gson gson = new Gson();
    	
        String jsonResp = gson.toJson(rs);
    	
        return Response.ok(jsonResp, MediaType.APPLICATION_JSON).build();
    } 
    
    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void putCustomer(String test) throws MalformedURLException, RemoteException, NotBoundException {
    	
    	String[] splited = test.split("\\s+");
    	
    	DatabaseOption db = (DatabaseOption)Naming.lookup( "rmi://" + address + service);
    	
    	db.Connect();
    	
    	db.Update("UPDATE CUSTOMERS SET FIRST='" + splited[1] + "', SECOND='" + splited[2] + "', NUMBER='" + splited[3] + "' WHERE id='" + splited[0] + "'");
    	
    	db.Close();
    }
    
    @DELETE
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public void putIntoDAO(String id) throws MalformedURLException, RemoteException, NotBoundException {
    	
    	System.out.println(id);
    	
    	DatabaseOption db = (DatabaseOption)Naming.lookup( "rmi://" + address + service);
    	
    	db.Connect();
    	
    	db.Update("DELETE FROM CUSTOMERS WHERE id='" + id + "'");
    	
    	db.Close();
    }
    
}
