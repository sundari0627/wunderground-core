/**
 * 
 */
package de.mbenning.weather.wunderground.api.services;

import java.util.List;

import de.mbenning.weather.wunderground.api.domain.WeatherStation;

/**
 * @author Martin.Benning
 *
 */
public interface IWeatherStationService {

	List<WeatherStation> findAllWeatherStationsByCountry(String country);
	
	WeatherStation getWeatherStation(String country, String id);
	
}
