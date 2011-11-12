/**
 * 
 */
package de.mbenning.weather.wunderground.api.domain;

import java.io.Serializable;

/**
 * @author Martin.Benning
 *
 */
public class WeatherStation implements Serializable {

	private static final long serialVersionUID = 8627853941193497703L;

	private String stationId = null;
	
	private String neighborhood = null;
	
	private String city = null;
	
	private String state = null;
	
	private String country = null;
	
	private String stationType = null;
	
	private String site = null;
	
	public WeatherStation(String stationId) {
		this.stationId = stationId;
	}

	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStationType() {
		return stationType;
	}

	public void setStationType(String stationType) {
		this.stationType = stationType;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}
	
}
