package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sun.jersey.api.client.WebResource;
import entities.CityDTO;
import entities.CountryDTO;

import com.sun.jersey.api.client.Client;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;

/**
 * Servlet implementation class InsertCity
 */
@WebServlet("/InsertCity")
public class InsertCity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String cityName = request.getParameter("cityName");
		String countryId = request.getParameter("countryId");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date foundationDate = null;
		try {
			foundationDate = sf.parse(request.getParameter("foundationDate"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Double area = Double.parseDouble(request.getParameter("area")) ;
		Integer population = Integer.parseInt(request.getParameter("population"));
		
		CityDTO cityDto = new CityDTO(0, countryId, cityName,  foundationDate, area, population);		
		Gson son = new Gson();
		String dataCity = son.toJson(cityDto);
		
		Client client = Client.create();
		WebResource resource = client.resource("http://localhost:8080/WEBSERV_Lab04_Webservices/rest/cityService");
		ClientResponse clientResource = resource.type("application/json").post(ClientResponse.class, dataCity);
		String result = clientResource.getEntity(String.class);	
		Boolean bl = son.fromJson(result, Boolean.class);
		if(bl) {
			request.getRequestDispatcher("LoadCity").forward(request, response);
		}else {
			WebResource rs = client.resource("http://localhost:8080/WEBSERV_Lab04_Webservices/rest/cityService/getCountry");
			
			String data = rs.get(String.class);
			GenericType<List<CountryDTO>> listType = new GenericType<List<CountryDTO>>() {};
			List<CountryDTO> listCountry = son.fromJson(data, listType.getType());
			
			request.setAttribute("err", "Insert failed!");
			request.setAttribute("list", listCountry);
			request.getRequestDispatcher("insertCity.jsp").forward(request, response);
//			request.getRequestDispatcher("PreInsertCity").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
