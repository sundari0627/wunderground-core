/**
 * 
 */
package de.mbenning.weather.wunderground.api.domain;

/**
 * @author Martin.Benning
 *
 */
public interface IDataListener {
	
	void define(DataSet dataSet); 
	
	void process(DataSet dataSet);

}
