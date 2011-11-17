/**
 * 
 */
package de.mbenning.weather.wunderground.api.domain;

import java.util.Comparator;

/**
 * @author Martin.Benning
 *
 */
public class DataSetTempComparator implements Comparator<DataSet> {

	public int compare(DataSet dataSet1, DataSet dataSet2) {
		if(dataSet1 != null && dataSet2 != null) {
			if(dataSet1.getTemperature() != null && dataSet2.getTemperature() != null) {
				if(dataSet1.getTemperature().doubleValue() > dataSet2.getTemperature().doubleValue()) {
					return 1;
				} else {
					return -1;
				}
			}
		}
		return 0;
	}

}
