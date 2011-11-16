/**
 * 
 */
package de.mbenning.weather.wunderground.impl.listeners;

import de.mbenning.weather.wunderground.api.domain.DataSet;
import de.mbenning.weather.wunderground.api.domain.IDataListener;

/**
 * @author Martin.Benning
 *
 */
public class FreezeListener implements IDataListener {

	/* (non-Javadoc)
	 * @see de.mbenning.weather.wunderground.api.domain.IDataListener#define(de.mbenning.weather.wunderground.api.domain.DataSet)
	 */
	public boolean isConditionSatisfied(DataSet dataSet) {
		if(dataSet != null) {
			if(dataSet.getTemperature() != null && dataSet.getTemperature().doubleValue() <= 0.0) {
				return true;
			}
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see de.mbenning.weather.wunderground.api.domain.IDataListener#process(de.mbenning.weather.wunderground.api.domain.DataSet)
	 */
	public void process(DataSet dataSet) {
		System.out.println("************************************************");
		System.out.println("              !!! FREEZE ALERT !!!");
		System.out.println("************************************************");
		System.out.println(dataSet.getWeatherStation().getStationId() + " " + dataSet.getDateTime() + " " + dataSet.getTemperature());
	}

}
