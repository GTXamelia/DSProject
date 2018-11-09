package WebService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
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
        
        System.out.println(jsonResp);
    	
        return Response.ok(jsonResp, MediaType.APPLICATION_JSON).build();
        
    }
    
}
