/**
 * 
 */
package de.mbenning.weather.wunderground.api.services;

import de.mbenning.weather.wunderground.api.domain.IDataExport;


/**
 * @author Martin.Benning
 *
 */
public interface IExportService {

	void process(IDataExport dataExport);
	
}
