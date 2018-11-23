package ie.gmit.sw.car;

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

@WebServlet("/CarsEdit")
public class CarEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CarEditServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(request.getParameter("id"));
		
		Client client = Client.create();
		
		WebResource wr = client.resource("http://localhost:8080/Rest-Server/webapi/car/edit/" + request.getParameter("id"));
		
		String r = wr.accept(MediaType.APPLICATION_JSON).get(String.class);
		
		Gson gson=new Gson();
		
		Type listType = new TypeToken<ArrayList<Car>>(){}.getType();
		
		List<Car> cars = gson.fromJson(r, listType);

        request.setAttribute("cars", cars);
        
        request.getRequestDispatcher("/WEB-INF/CarsEdit.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String num = request.getParameter("num");
		
		System.out.println(id + " " + fname + " " + lname + " " + num);
		
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/Rest-Server/webapi/car/update");
		String input = id + " "+ fname + " " + lname + " " + num;
		ClientResponse response1 = webResource.type("application/json").put(ClientResponse.class, input);
		
		System.out.println(response1); // Server response
		
		response.sendRedirect("/Web-Client/Customers");
	}
	
}