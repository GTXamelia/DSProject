package ie.gmit.sw.bookings;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import ie.gmit.sw.customer.Customer;

import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

@WebServlet("/Bookings")
public class BookingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public BookingsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Client client = Client.create();
		
		WebResource wrB = client.resource("http://localhost:8080/Rest-Server/webapi/booking/get");
		
		WebResource wrC = client.resource("http://localhost:8080/Rest-Server/webapi/customer/get");
		
		String rB = wrB.accept(MediaType.APPLICATION_JSON).get(String.class);
		
		String rC = wrC.accept(MediaType.APPLICATION_JSON).get(String.class);
		
		Gson gson=new Gson();
		
		Type listTypeB = new TypeToken<ArrayList<Bookings>>(){}.getType();
		
		Type listTypeC = new TypeToken<ArrayList<Bookings>>(){}.getType();
		
		List<Bookings> bookings = gson.fromJson(rB, listTypeB);
		
		List<Customer> customers = gson.fromJson(rC, listTypeC);

        request.setAttribute("bookings", bookings);
        
        request.setAttribute("customers", customers);
        
        request.getRequestDispatcher("/WEB-INF/Bookings.jsp").forward(request, response);
        
	}
	
}
