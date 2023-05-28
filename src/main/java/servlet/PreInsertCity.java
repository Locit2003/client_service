package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import entities.CityDTO;
import entities.CountryDTO;

/**
 * Servlet implementation class PreInsertCity
 */
@WebServlet("/PreInsertCity")
public class PreInsertCity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreInsertCity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Client client = Client.create();
		WebResource resource = client.resource("http://localhost:8080/WEBSERV_Lab04_Webservices/rest/cityService/getCountry");
		
		String data = resource.get(String.class);
		Gson son = new Gson();
		GenericType<List<CountryDTO>> listType = new GenericType<List<CountryDTO>>() {};
		List<CountryDTO> listCountry = son.fromJson(data, listType.getType());
		
		request.setAttribute("list", listCountry);
		request.getRequestDispatcher("insertCity.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
