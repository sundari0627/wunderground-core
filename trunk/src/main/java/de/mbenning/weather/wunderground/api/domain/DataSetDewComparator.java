/**
 * 
 */
package de.mbenning.weather.wunderground.api.domain;

import java.util.Comparator;

/**
 * @author Martin.Benning
 *
 */
public class DataSetDewComparator implements Comparator<DataSet> {

	public int compare(DataSet dataSet1, DataSet dataSet2) {
		if(dataSet1 != null && dataSet2 != null) {
			if(dataSet1.getDewPoint() != null && dataSet2.getDewPoint() != null) {
				if(dataSet1.getDewPoint().doubleValue() > dataSet2.getDewPoint().doubleValue()) {
					return 1;
				} else {
					return -1;
				}
			}
		}
		return 0;
	}

}
