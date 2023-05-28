package entities;

import java.util.Date;

public class CityDTO {
	private Integer cityId;
	private String countryId;
	private String cityName;
	private Date foundationDate;
	private Double area;
	private Integer population;
	
	public CityDTO() {
		// TODO Auto-generated constructor stub
	}

	public CityDTO(Integer cityId, String countryId, String cityName, Date foundationDate, Double area,
			Integer population) {
		super();
		this.cityId = cityId;
		this.countryId = countryId;
		this.cityName = cityName;
		this.foundationDate = foundationDate;
		this.area = area;
		this.population = population;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Date getFoundationDate() {
		return foundationDate;
	}

	public void setFoundationDate(Date foundationDate) {
		this.foundationDate = foundationDate;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}
	
	
}
