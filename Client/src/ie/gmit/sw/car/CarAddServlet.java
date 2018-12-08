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

@WebServlet("/CarAdd")
public class CarAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CarAddServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/CarAdd.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String reg = request.getParameter("reg");
		String year = request.getParameter("year");
		String make = request.getParameter("make");
		String cost = request.getParameter("cost");
		
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/Rest-Server/webapi/car/post");
		String input = reg + " " + year + " " + make + " " + cost;
		ClientResponse response1 = webResource.type("application/json").post(ClientResponse.class, input);
		
		System.out.println(response1); // Server response
		
		response.sendRedirect("/Web-Client/Cars");
	}
	
}
