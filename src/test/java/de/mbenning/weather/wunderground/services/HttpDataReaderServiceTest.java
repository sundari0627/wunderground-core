/**
 * 
 */
package de.mbenning.weather.wunderground.services;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.mbenning.weather.wunderground.api.domain.DataSet;
import de.mbenning.weather.wunderground.api.domain.WeatherStations;
import de.mbenning.weather.wunderground.impl.services.HttpDataReaderService;

/**
 * 
 * 
 * @author Martin.Benning
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"} )
public class HttpDataReaderServiceTest {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
	
	@Autowired
	@Qualifier("httpDataReaderService")
	private HttpDataReaderService httpDataReaderService;
	
    @Test
    public void testInit() throws ParseException {
    	this.httpDataReaderService.setWeatherStation(WeatherStations.INOORDBR35_BOXMEER);
    	try {
    		httpDataReaderService.init();
    		String line = "";
    		do {
    			line = httpDataReaderService.getNextLine();
    			System.out.println(line);
    		} while(line != null);
    	} catch(IOException e) {
    		Assert.assertTrue(false);
    	} 
    }
    
    @Test
    public void testGetCurrentData() {
    	System.out.println("========================================");
    	this.httpDataReaderService.setWeatherStation(WeatherStations.INOORDBR35_BOXMEER);
    	printStationData(httpDataReaderService.getCurrentData());    	
    	
    	this.httpDataReaderService.setWeatherStation(WeatherStations.INORDRHE72_DORTMUND);
    	printStationData(httpDataReaderService.getCurrentData());
    	
    	this.httpDataReaderService.setWeatherStation(WeatherStations.INRWKLEV2_KLEVE);
    	printStationData(httpDataReaderService.getCurrentData());
    	
    	this.httpDataReaderService.setWeatherStation(WeatherStations.IDRENTHE48_COEVORDEN);
    	printStationData(httpDataReaderService.getCurrentData());
    	
    	this.httpDataReaderService.setWeatherStation(WeatherStations.IZEELAND13_GOES);
    	printStationData(httpDataReaderService.getCurrentData());
    }
    
    private void printStationData(DataSet dataSet) {
    	if(dataSet == null || dataSet.getDateTime() == null) {
    		System.out.println("Momentan liegen keine Wetter-Daten vor!");
    	} else {
    		System.out.println(dataSet.getWeatherStation().getCity() + " (" + sdf.format(dataSet.getDateTime())+")");
    		System.out.println("Temperatur: " + dataSet.getTemperature());
    	}
    	System.out.println("========================================");
    }

}
