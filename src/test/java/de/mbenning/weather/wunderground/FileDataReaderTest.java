/**
 * 
 */
package de.mbenning.weather.wunderground;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.mbenning.weather.wunderground.api.domain.DataSet;
import de.mbenning.weather.wunderground.api.domain.HttpProxy;
import de.mbenning.weather.wunderground.api.domain.WeatherStations;
import de.mbenning.weather.wunderground.impl.FileDataReader;
import de.mbenning.weather.wunderground.impl.listeners.FreezeListener;
import de.mbenning.weather.wunderground.impl.services.HttpDataReaderService;

/**
 * @author Martin.Benning
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"} )
public class FileDataReaderTest {
    
    private static final String TEST_FILENAME = "2011-11-10.wg";
    
    protected ClassPathResource resource = new ClassPathResource(TEST_FILENAME);

    @Test
    public void testNextDataSet() throws Exception {
        FileDataReader fileDataReader = new FileDataReader(resource.getFile());
        List<DataSet> datasets = fileDataReader.readDataSets();
        for (DataSet dataSet2 : datasets) {
            System.out.println(dataSet2.getDateTime()
                    + " "
                    + dataSet2.getTemperature()
                    + " "
                    + dataSet2.getWindDirection()
                    + " "
                    + dataSet2.getWindDirectionDegrees()
                    + " "
                    + dataSet2.getWindSpeedKmh());
        }
    }
    
    @Test
    public void testListeners() throws Exception {
    	HttpDataReaderService dataReader = new HttpDataReaderService();
    	dataReader.setWeatherStation(WeatherStations.ALL.get("IDRENTHE48"));
    	dataReader.setHttpProxy(new HttpProxy());
    	dataReader.registerListener(new FreezeListener());
    	
        DataSet current = dataReader.getCurrentData();
    }
    
    @Test
    public void testMinTemperature() throws Exception {
    	HttpDataReaderService dataReader = new HttpDataReaderService();
    	dataReader.setHttpProxy(new HttpProxy());
    	dataReader.setWeatherStation(WeatherStations.ALL.get("INOORDBR35"));
    	DataSet min = dataReader.minTemperature();
    	Assert.assertNotNull(min);
    	System.out.println(min.getDateTime() + " " + min.getTemperature());
    }
    
    @Test
    public void testMinDewPoint() throws Exception {
    	HttpDataReaderService dataReader = new HttpDataReaderService();
    	dataReader.setHttpProxy(new HttpProxy());
    	dataReader.setWeatherStation(WeatherStations.ALL.get("INOORDBR35"));
    	DataSet min = dataReader.minDewPoint();
    	Assert.assertNotNull(min);
    	System.out.println(min.getDateTime() + " " + min.getDewPoint());
    }
    
    @Test
    public void testMaxTemperature() throws Exception {
    	HttpDataReaderService dataReader = new HttpDataReaderService();
    	dataReader.setHttpProxy(new HttpProxy());
    	dataReader.setWeatherStation(WeatherStations.ALL.get("INOORDBR35"));
    	DataSet max = dataReader.maxTemperature();
    	Assert.assertNotNull(max);
    	System.out.println(max.getDateTime() + " " + max.getTemperature());
    }
    
    @Test
    public void testMaxDewPoint() throws Exception {
    	HttpDataReaderService dataReader = new HttpDataReaderService();
    	dataReader.setHttpProxy(new HttpProxy());
    	dataReader.setWeatherStation(WeatherStations.ALL.get("INOORDBR35"));
    	DataSet max = dataReader.maxDewPoint();
    	Assert.assertNotNull(max);
    	System.out.println(max.getDateTime() + " " + max.getDewPoint());
    }
    
}
