package ie.gmit.sw.customer;

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

@WebServlet("/CustomerAdd")
public class CustomerAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CustomerAddServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/CustomerAdd.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String num = request.getParameter("num");
		
		System.out.println(fname + " " + lname + " " + num);
		
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/Rest-Server/webapi/customer/update");
		String input = fname + " " + lname + " " + num;
		webResource.type("application/json").put(ClientResponse.class, input);
		
		response.sendRedirect("/Web-Client/Customers");
	}
	
}
