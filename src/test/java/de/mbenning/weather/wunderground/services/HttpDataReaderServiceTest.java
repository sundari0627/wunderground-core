/**
 * 
 */
package de.mbenning.weather.wunderground.services;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import junit.framework.Assert;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.mbenning.weather.wunderground.api.domain.DataSet;
import de.mbenning.weather.wunderground.api.domain.HttpProxy;
import de.mbenning.weather.wunderground.api.domain.WeatherStations;
import de.mbenning.weather.wunderground.impl.services.HttpDataReaderService;
import de.mbenning.weather.wunderground.services.base.AbstractBaseServiceTest;

/**
 * 
 * 
 * @author Martin.Benning
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"} )
public class HttpDataReaderServiceTest extends AbstractBaseServiceTest {
	
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
    	this.printWeatherStationData(httpDataReaderService.getWeatherStation(), httpDataReaderService.getCurrentData());
    	
    	this.httpDataReaderService.setWeatherStation(WeatherStations.INORDRHE72_DORTMUND);
    	this.printWeatherStationData(httpDataReaderService.getWeatherStation(), httpDataReaderService.getCurrentData());
    	
    	this.httpDataReaderService.setWeatherStation(WeatherStations.INRWKLEV2_KLEVE);
    	this.printWeatherStationData(httpDataReaderService.getWeatherStation(), httpDataReaderService.getCurrentData());
    	
    	this.httpDataReaderService.setWeatherStation(WeatherStations.IDRENTHE48_COEVORDEN);
    	this.printWeatherStationData(httpDataReaderService.getWeatherStation(), httpDataReaderService.getCurrentData());
    	
    	this.httpDataReaderService.setWeatherStation(WeatherStations.IZEELAND13_GOES);
    	this.printWeatherStationData(httpDataReaderService.getWeatherStation(), httpDataReaderService.getCurrentData());
    }
    
    @Test
    public void testGetDataByDate() throws Exception {
        // set desired date ...
        Date weatherDate = new DateTime(2011, 8, 15, 0, 0, 0).toDate();
    	this.httpDataReaderService.setWeatherStation(WeatherStations.INOORDBR35_BOXMEER);
    	this.httpDataReaderService.setHttpProxy(new HttpProxy());
    	// set desired date to HttpDataReaderService
    	this.httpDataReaderService.setWeatherDate(weatherDate);
    	// investigate minimum temperature of desired day ...
    	DataSet minTemp = this.httpDataReaderService.minTemperature();
    	this.printWeatherStationData(this.httpDataReaderService.getWeatherStation(), minTemp);
    	// investigate maximum temperature of desired day ...
    	DataSet maxTemp = this.httpDataReaderService.maxTemperature();
        this.printWeatherStationData(this.httpDataReaderService.getWeatherStation(), maxTemp);
    }
    
}
