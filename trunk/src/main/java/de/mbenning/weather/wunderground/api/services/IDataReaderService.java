/**
 * 
 */
package de.mbenning.weather.wunderground.api.services;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.List;

import de.mbenning.weather.wunderground.api.domain.DataSet;

/**
 * @author Martin.Benning
 *
 */
public interface IDataReaderService {
	
	void init() throws IOException;
    
	String getNextLine() throws IOException;
	
	String[] nextDataColumns() throws IOException;
	
	DataSet nextDataSet() throws IOException, ParseException, UnsupportedEncodingException;
	
	List<DataSet> readDataSets() throws IOException, ParseException, UnsupportedEncodingException;
	
	DataSet getCurrentData();
	
}
