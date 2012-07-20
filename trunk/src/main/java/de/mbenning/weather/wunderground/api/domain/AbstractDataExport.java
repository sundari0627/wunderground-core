/**
 * 
 */
package de.mbenning.weather.wunderground.api.domain;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;


/**
 * @author Martin.Benning
 *
 */
public abstract class AbstractDataExport implements IDataExport {
	
	protected SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
	
	protected DecimalFormat df = new DecimalFormat("#,##0.0");
	
	protected String fileOutputPath = null;
	
	protected String filename = null;

	public String getFileOutputPath() {
		return fileOutputPath;
	}

	public void setFileOutputPath(String fileOutputPath) {
		this.fileOutputPath = fileOutputPath;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
}
