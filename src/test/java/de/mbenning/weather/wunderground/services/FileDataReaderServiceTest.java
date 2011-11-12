/**
 * 
 */
package de.mbenning.weather.wunderground.services;

import java.io.IOException;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.mbenning.weather.wunderground.api.domain.DataSet;
import de.mbenning.weather.wunderground.impl.FileDataReader;
import de.mbenning.weather.wunderground.impl.services.FileDataReaderService;

/**
 * @author Martin.Benning
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"} )
public class FileDataReaderServiceTest {
	
	private static final String TEST_FILENAME = "2011-11-10.wg";
    
	private ClassPathResource resource = new ClassPathResource(TEST_FILENAME);
    
    @Autowired
    @Qualifier("fileDataReaderService")
    private FileDataReaderService fileDataReaderService;
    
    @Test
    public void testInit() {
    	try {
    		fileDataReaderService.setFile(resource.getFile());
    		fileDataReaderService.init();
    		Assert.assertEquals(1, fileDataReaderService.getCurrentLine());
    	} catch(IOException e) {
    		Assert.assertTrue(false);
    	}
    }
    
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
	
}
