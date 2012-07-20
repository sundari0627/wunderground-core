/**
 * 
 */
package de.mbenning.weather.wunderground.api.domain;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author Martin.Benning
 *
 */
public class CSVDataExport extends AbstractDataExport {
	
	
	private String[] header = {"Datum", "Min", "Max"};

	/* (non-Javadoc)
	 * @see de.mbenning.weather.wunderground.api.domain.IDataExport#process(java.util.List)
	 */
	@Override
	public void process(List<DataSet> dataSets) throws IOException {
		if(this.fileOutputPath != null && dataSets != null) {
			FileWriter fw = new FileWriter(new File(this.fileOutputPath + "/" + this.filename));
			for(String h : header) {
				fw.write(h + ";");
			}
			fw.write("\n");
			for (DataSet dataSet : dataSets) {
				if(dataSet != null) {
					fw.write(sdf.format(dataSet.getDateTime()) + ";");
					fw.write(df.format(dataSet.getTemperatureLow().doubleValue()) + ";");
					fw.write(df.format(dataSet.getTemperatureHigh().doubleValue()) + ";");
					fw.write("\n");
				}
			}
			fw.flush();
			fw.close();
		}
	}

}
