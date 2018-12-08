package ie.gmit.sw.bookings;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@WebServlet("/BookingsAdd")
public class BookingAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public BookingAddServlet() {
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
		
        request.getRequestDispatcher("/WEB-INF/BookingsAdd.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String carID = request.getParameter("carID");
		String customerID = request.getParameter("customerID");
		String sDate = request.getParameter("sdate");
		String eDate = request.getParameter("edate");
		String fName = request.getParameter("fname");
		String sName = request.getParameter("lname");
		String num = request.getParameter("num");
		String reg = request.getParameter("reg");
		String year = request.getParameter("year");
		String make = request.getParameter("make");
		String cost = request.getParameter("cost");
		
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/Rest-Server/webapi/booking/post");
		String input = sDate + " " + eDate + " " + customerID + " " + fName + " " + sName + " " + num + " "+ carID + " " + reg + " " + year + " " + make + " " + cost;
		webResource.type("application/json").post(ClientResponse.class, input);
		
		response.sendRedirect("/Web-Client/Bookings");
	}
	
}
