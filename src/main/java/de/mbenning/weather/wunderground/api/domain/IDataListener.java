/**
 * 
 */
package de.mbenning.weather.wunderground.api.domain;

/**
 * @author Martin.Benning
 *
 */
public interface IDataListener {
	
	boolean isConditionSatisfied(DataSet dataSet); 
	
	void process(DataSet dataSet);

}
