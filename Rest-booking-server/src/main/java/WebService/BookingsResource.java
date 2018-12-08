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

@Path("booking")
public class BookingsResource {
	
	private String service = "/databaseOption";
	private String address = "localhost:1099";

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBookings() throws RemoteException, MalformedURLException, NotBoundException, SQLException, ClassNotFoundException {
    	
    	DatabaseOption db = (DatabaseOption)Naming.lookup( "rmi://" + address + service);
    	
    	db.Connect();
    	
    	List<Object> rs = db.ReadBookings("SELECT * FROM BOOKINGS");
    	
    	db.Close();
    	
    	Gson gson = new Gson();
    	
        String jsonResp = gson.toJson(rs);
    	
        return Response.ok(jsonResp, MediaType.APPLICATION_JSON).build();
    }
    
    @POST
	@Path("/post")
	@Consumes("application/json")
    public void postBooking(String input) throws MalformedURLException, RemoteException, NotBoundException, ClassNotFoundException, SQLException {
    	
    	String[] splited = input.split("\\s+");
    	
    	DatabaseOption db = (DatabaseOption)Naming.lookup( "rmi://" + address + service);
    	
    	db.Connect();
    	
    	db.Create("INSERT INTO BOOKINGS (CUSTOMERID, CARID, DATESTART, DATEEND, FIRST, SECOND, NUMBER, REG, YEAR, MAKE, COST ) VALUES ('" + splited[0] + "', '" + splited[7] + "', '" + splited[5] + "', '" + splited[6] + "', '" + splited[8] + "', '" + splited[9] + "', '" + splited[10] + "', '" + splited[2] + "', '" + splited[3] + "', '" + splited[1] + "', '" + splited[4] + "')");
    	
    	db.Close();
	}
    
    @GET
    @Path("/edit/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBookingbyID(@PathParam(value = "id") int id) throws RemoteException, MalformedURLException, NotBoundException, ClassNotFoundException, SQLException {
    	
    	DatabaseOption db = (DatabaseOption)Naming.lookup( "rmi://" + address + service);
    	
    	db.Connect();
    	
    	List<Object> rs = db.ReadBookings("SELECT * FROM BOOKINGS WHERE id="+id);
    	
    	db.Close();
    	
    	Gson gson = new Gson();
    	
        String jsonResp = gson.toJson(rs);
    	
        return Response.ok(jsonResp, MediaType.APPLICATION_JSON).build();
    } 
    
    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void putBooking(String input) throws MalformedURLException, RemoteException, NotBoundException, ClassNotFoundException, SQLException {
    	
    	String[] splited = input.split("\\s+");
    	
    	DatabaseOption db = (DatabaseOption)Naming.lookup( "rmi://" + address + service);
    	
    	db.Connect();
    	
    	db.Update("UPDATE BOOKINGS SET CUSTOMERID='" + splited[3] + "', CARID='" + splited[7] + "', DATESTART='" + splited[1] + "', DATEEND='" + splited[2] + "', FIRST='" + splited[4] + "', SECOND='" + splited[5] + "', NUMBER='" + splited[6] + "', REG='" + splited[8] + "', YEAR='" + splited[9] + "', MAKE='" + splited[10] + "', COST='" + splited[11] + "' WHERE id='" + splited[0] + "'");
    	
    	db.Update("UPDATE CUSTOMERS SET FIRST='" + splited[4] + "', SECOND='" + splited[5] + "', NUMBER='" + splited[6] + "' WHERE id='" + splited[3] + "'");
    	
    	db.Update("UPDATE CARS SET reg='" + splited[8] + "', YEAR='" + splited[9] + "', MAKE='" + splited[10] + "', COST='" + splited[11] + "' WHERE id='" + splited[7] + "'");
    	
    	db.Close();
    }
    
    @DELETE
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public void delBooking(String id) throws MalformedURLException, RemoteException, NotBoundException, ClassNotFoundException, SQLException {
    	
    	String[] splited = id.split("\\s+");
    	
    	DatabaseOption db = (DatabaseOption)Naming.lookup( "rmi://" + address + service);
    	
    	db.Connect();
    	
    	db.Delete("DELETE FROM BOOKINGS WHERE id='" + splited[0] + "'");
    	
    	db.Delete("DELETE FROM CUSTOMERS WHERE id='" + splited[1] + "'");
    	
    	db.Close();
    }
    
}
