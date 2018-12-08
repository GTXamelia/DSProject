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

import ie.gmit.sw.car.Car;
import ie.gmit.sw.customer.Customer;

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
		
		Gson gson=new Gson();
		
		WebResource wrB = client.resource("http://localhost:8080/Rest-Server/webapi/booking/get");
		WebResource wrCu = client.resource("http://localhost:8080/Rest-Server/webapi/customer/get");
		WebResource wrCa = client.resource("http://localhost:8080/Rest-Server/webapi/car/get");
		
		String rB = wrB.accept(MediaType.APPLICATION_JSON).get(String.class);
		String rCu = wrCu.accept(MediaType.APPLICATION_JSON).get(String.class);
		String rCa = wrCa.accept(MediaType.APPLICATION_JSON).get(String.class);
		
		Type listTypeB = new TypeToken<ArrayList<Bookings>>(){}.getType();
		Type listTypeCu = new TypeToken<ArrayList<Car>>(){}.getType();
		Type listTypeCa = new TypeToken<ArrayList<Customer>>(){}.getType();
		
		List<Bookings> bookings = gson.fromJson(rB, listTypeB);
		List<Customer> customers = gson.fromJson(rCu, listTypeCa);
		List<Car> cars = gson.fromJson(rCa, listTypeCu);

		request.setAttribute("customers", customers);
        request.setAttribute("cars", cars);
		
        request.getRequestDispatcher("/WEB-INF/BookingsAdd.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String carID = request.getParameter("carID");
		String sDate = request.getParameter("sdate");
		String eDate = request.getParameter("edate");
		String custID = request.getParameter("custID");
		
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/Rest-Server/webapi/booking/post");
		String input = carID + " " + sDate + " " + eDate + " " + custID;
		webResource.type("application/json").post(ClientResponse.class, input);
		
		response.sendRedirect("/Web-Client/Bookings");
	}
	
}
