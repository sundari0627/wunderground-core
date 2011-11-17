/**
 * 
 */
package de.mbenning.weather.wunderground.services.base;

import java.text.SimpleDateFormat;

import de.mbenning.weather.wunderground.api.domain.DataSet;
import de.mbenning.weather.wunderground.api.domain.WeatherStation;

/**
 * @author Martin.Benning
 *
 */
public abstract class AbstractBaseServiceTest {
	
	protected SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");

	protected void printWeatherStationData(WeatherStation weatherStation, DataSet dataSet) {
		String city 	= weatherStation.getCity() != null ? weatherStation.getCity() : "";
		String state 	= weatherStation.getState() != null ? weatherStation.getState() : "";
		String country 	= weatherStation.getCountry() != null ? weatherStation.getCountry() : "";
		
		System.out.println(weatherStation.getStationId() + " " + city + " " + state + " " + country);
		
		System.out.println("DATETIME\t TEMP\tDEW\tWSPD");
		if(dataSet != null) {
			System.out.println(sdf.format(dataSet.getDateTime()) + " " + dataSet.getTemperature() + "\t" + dataSet.getDewPoint() + "\t" + dataSet.getWindSpeedKmh());
		} else {
			System.out.println("could not receive weather data");
		}
		
		System.out.println("");
	}
	
}
