/**
 * 
 */
package de.mbenning.weather.wunderground;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import de.mbenning.weather.wunderground.services.HttpDataReaderServiceTest;
import de.mbenning.weather.wunderground.services.WeatherStationServiceTest;

/**
 * @author Martin.Benning
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ FileDataReaderTest.class, WeatherStationServiceTest.class, HttpDataReaderServiceTest.class })
public class WundergroundCoreTestSuite {

}
