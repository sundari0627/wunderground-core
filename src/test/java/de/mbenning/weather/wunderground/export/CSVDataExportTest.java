/**
 * 
 */
package de.mbenning.weather.wunderground.export;

import java.util.List;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.mbenning.weather.wunderground.api.domain.CSVDataExport;
import de.mbenning.weather.wunderground.api.domain.DataGraphSpan;
import de.mbenning.weather.wunderground.api.domain.DataSet;
import de.mbenning.weather.wunderground.api.domain.HttpProxy;
import de.mbenning.weather.wunderground.api.domain.WeatherStation;
import de.mbenning.weather.wunderground.api.domain.WeatherStations;
import de.mbenning.weather.wunderground.impl.services.HttpDataReaderService;

/**
 * @author Martin.Benning
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"} )
public class CSVDataExportTest {
	
	@Autowired
	@Qualifier("httpDataReaderService")
	private HttpDataReaderService httpDataReaderService;
	
	@Test
	public void testCSVDataExportFile() throws Exception {
		this.httpDataReaderService.setWeatherStation(new WeatherStation("ILIMBURG22")); // WeatherStations.INOORDBR35_BOXMEER
   	   	this.httpDataReaderService.setHttpProxy(new HttpProxy());
   	   	this.httpDataReaderService.setDataGraphSpan(DataGraphSpan.MONTH);
   	   	
   	   	this.httpDataReaderService.setWeatherDate(new DateTime(2012, 1, 1, 0, 0, 0).toDate());
    	List<DataSet> dataSets = this.httpDataReaderService.readDataSets();
    	
    	CSVDataExport export = new CSVDataExport();
		export.setFileOutputPath("D:");
		export.setFilename("INOORDBR35_BOXMEER-Januar-2012.csv");
		export.process(dataSets);
		
		this.httpDataReaderService.setWeatherDate(new DateTime(2012, 2, 1, 0, 0, 0).toDate());
    	dataSets = this.httpDataReaderService.readDataSets();
    	
    	export = new CSVDataExport();
		export.setFileOutputPath("D:");
		export.setFilename("INOORDBR35_BOXMEER-Februar-2012.csv");
		export.process(dataSets);
		
		this.httpDataReaderService.setWeatherDate(new DateTime(2012, 7, 1, 0, 0, 0).toDate());
    	dataSets = this.httpDataReaderService.readDataSets();
    	
    	export = new CSVDataExport();
		export.setFileOutputPath("D:");
		export.setFilename("ILIMBURG22_MEERLO-Juli-2012.csv");
		export.process(dataSets);
	}

}
