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
		
		WebResource wr = client.resource("http://localhost:8080/Rest-Server/webapi/booking/get");
		
		String r = wr.accept(MediaType.APPLICATION_JSON).get(String.class);
		
		Gson gson=new Gson();
		
		Type listType = new TypeToken<ArrayList<Bookings>>(){}.getType();
		
		List<Bookings> bookings = gson.fromJson(r, listType);

        request.setAttribute("bookings", bookings);
        
        request.getRequestDispatcher("/WEB-INF/Bookings.jsp").forward(request, response);
        
	}
	
}
