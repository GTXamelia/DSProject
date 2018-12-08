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

@Path("car")
public class CarResource {
	
	private String service = "/databaseOption";
	private String address = "localhost:1099";

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() throws RemoteException, MalformedURLException, NotBoundException, SQLException, ClassNotFoundException {
    	
    	DatabaseOption db = (DatabaseOption)Naming.lookup("rmi://" + address + service);
    	
    	db.Connect();
    	
    	List<Object> rs = db.ReadCar("SELECT * FROM CARS");
    	
    	db.Close();
    	
    	Gson gson = new Gson();
    	
        String jsonResp = gson.toJson(rs);
    	
        return Response.ok(jsonResp, MediaType.APPLICATION_JSON).build();
    }
    
    @POST
	@Path("/post")
	@Consumes("application/json")
    public void postCustomer(String input) throws MalformedURLException, RemoteException, NotBoundException, ClassNotFoundException, SQLException {
    	String[] splited = input.split("\\s+");
    	
    	DatabaseOption db = (DatabaseOption)Naming.lookup( "rmi://" + address + service);
    	
    	db.Connect();
    	
    	db.Create("INSERT INTO CARS (REG, YEAR, MAKE, COST) VALUES ('" + splited[0] + "', '" + splited[1] + "', '" + splited[2] + "', '" + splited[3] + "')");
    	
    	db.Close();
	}
    
    @GET
    @Path("/edit/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomer(@PathParam(value = "id") int id) throws RemoteException, MalformedURLException, NotBoundException, ClassNotFoundException, SQLException {
    	
    	DatabaseOption db = (DatabaseOption)Naming.lookup( "rmi://" + address + service);
    	
    	db.Connect();
    	
    	List<Object> rs = db.ReadCar("SELECT * FROM CARS WHERE id="+id);
    	
    	db.Close();
    	
    	Gson gson = new Gson();
    	
        String jsonResp = gson.toJson(rs);
    	
        return Response.ok(jsonResp, MediaType.APPLICATION_JSON).build();
    } 
    
    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void putCustomer(String test) throws MalformedURLException, RemoteException, NotBoundException, ClassNotFoundException, SQLException {
    	
    	String[] splited = test.split("\\s+");
    	
    	DatabaseOption db = (DatabaseOption)Naming.lookup( "rmi://" + address + service);
    	
    	db.Connect();
    	
    	db.Update("UPDATE CARS SET REG='" + splited[1] + "', YEAR='" + splited[2] + "', MAKE='" + splited[3] + "', COST='" + splited[4] + "' WHERE id='" + splited[0] + "'");
    	
    	db.Update("UPDATE BOOKINGS SET REG='" + splited[1] + "', YEAR='" + splited[2] + "', MAKE='" + splited[3] + "', COST='" + splited[4] + "' WHERE CARID='" + splited[0] + "'");
    	
    	db.Close();
    }
    
    @DELETE
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public void putIntoDAO(String id) throws MalformedURLException, RemoteException, NotBoundException, ClassNotFoundException, SQLException {
    	
    	DatabaseOption db = (DatabaseOption)Naming.lookup( "rmi://" + address + service);
    	
    	db.Connect();
    	
    	db.Delete("DELETE FROM CARS WHERE id='" + id + "'");
    	
    	db.Delete("DELETE FROM BOOKINGS WHERE CARID='" + id + "'");
    	
    	db.Close();
    }
    
}
