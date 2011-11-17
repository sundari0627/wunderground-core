/**
 * 
 */
package de.mbenning.weather.wunderground.services;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.mbenning.weather.wunderground.api.domain.DataSet;
import de.mbenning.weather.wunderground.api.domain.WeatherStation;
import de.mbenning.weather.wunderground.api.services.IWeatherStationService;
import de.mbenning.weather.wunderground.impl.services.HttpDataReaderService;
import de.mbenning.weather.wunderground.services.base.AbstractBaseServiceTest;

/**
 * @author Martin.Benning
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"} )
public class WeatherStationServiceTest extends AbstractBaseServiceTest {
	
	@Autowired
	@Qualifier("weatherStationService")
	private IWeatherStationService weatherStationService;
	
	@Autowired
	@Qualifier("httpDataReaderService")
	private HttpDataReaderService httpDataReaderService;
	
	@Test
	public void testFindAllWeatherStationsByCountry() throws Exception {
		List<WeatherStation> weatherStations = weatherStationService.findAllWeatherStationsByCountry("Netherlands");
		for (WeatherStation weatherStation : weatherStations) {
			System.out.println(weatherStation.getStationId() + " " + weatherStation.getNeighborhood());
		}
	}
	
    @Test
    public void testGetCountryStations() {
    	List<WeatherStation> weatherStations = this.weatherStationService.findAllWeatherStationsByCountry("Netherlands");
    	for (WeatherStation weatherStation : weatherStations) {
    		this.httpDataReaderService.setWeatherStation(weatherStation);
    		DataSet dataSet = this.httpDataReaderService.getCurrentData();
    		this.printWeatherStationData(weatherStation, dataSet);
		}
    }
    
    @Test
    public void testGetWeatherStation() throws Exception {
    	WeatherStation weatherStation = this.weatherStationService.getWeatherStation("Netherlands", "INOORDBR35");
    	Assert.assertNotNull(weatherStation);
    	
    	Assert.assertEquals("INOORDBR35", weatherStation.getStationId());
    	Assert.assertEquals("Netherlands", weatherStation.getCountry());
    	Assert.assertEquals("Boxmeer", weatherStation.getCity());
    }

}
