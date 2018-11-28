package ie.gmit.sw.car;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@WebServlet("/CarDelete")
public class CarDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CarDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//System.out.println(request.getParameter("id"));
		
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/Rest-Server/webapi/car/delete");
		ClientResponse response1 = webResource.type("application/json").delete(ClientResponse.class, request.getParameter("id"));
		
		System.out.println(response1); // Server response
		
		response.sendRedirect("/Web-Client/Cars");
	}	
}
