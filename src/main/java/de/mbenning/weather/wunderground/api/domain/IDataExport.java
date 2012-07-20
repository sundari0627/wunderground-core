/**
 * 
 */
package de.mbenning.weather.wunderground.api.domain;

import java.io.IOException;
import java.util.List;

/**
 * @author Martin.Benning
 *
 */
public interface IDataExport {

	void process(List<DataSet> dataSets) throws IOException;
	
}
