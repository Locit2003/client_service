package servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jersey.api.client.WebResource;

import entities.CityDTO;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
/**
 * Servlet implementation class SearchCityByCountry
 */
@WebServlet("/SearchCityByCountry")
public class SearchCityByCountry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCityByCountry() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String countryName = request.getParameter("countryName");
		
		Client client = Client.create();
		if(countryName==null || countryName.length()==0)
			countryName = " ";
		
		String NameSearch = URLEncoder.encode(countryName, "UTF-8");
				
		WebResource resource = client.resource("http://localhost:8080/WEBSERV_Lab04_Webservices/rest/cityService/getCitiesByCountryName/"+NameSearch);
		String data = resource.get(String.class);
		
		Gson son = new Gson();
		GenericType<List<CityDTO>> listType = new GenericType<List<CityDTO>>() {};
		List<CityDTO> listCity = son.fromJson(data, listType.getType());
		
		request.setAttribute("list", listCity);
		request.getRequestDispatcher("listCity.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
