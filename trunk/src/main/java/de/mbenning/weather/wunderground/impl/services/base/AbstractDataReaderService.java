/**
 * 
 */
package de.mbenning.weather.wunderground.impl.services.base;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import de.mbenning.weather.wunderground.api.domain.DataColumn;
import de.mbenning.weather.wunderground.api.domain.DataSet;
import de.mbenning.weather.wunderground.api.domain.IDataListener;
import de.mbenning.weather.wunderground.api.domain.WeatherStation;
import de.mbenning.weather.wunderground.api.services.IDataReaderService;

/**
 * @author Martin.Benning
 *
 */
public abstract class AbstractDataReaderService implements IDataReaderService {
	
    protected final static String SEPARATOR = ResourceBundle.getBundle("wunderground-core").getString("wunderground.core.data.separator");
    protected final static String ENCODING = ResourceBundle.getBundle("wunderground-core").getString("wunderground.core.data.encoding");
    
    protected String source = null;
    protected Scanner scanner = null;
    protected long currentLine = 1;    
    
    protected WeatherStation weatherStation;
    protected boolean isStationChanged = false;
    
    protected List<IDataListener> listeners = new ArrayList<IDataListener>();

	/* (non-Javadoc)
	 * @see de.mbenning.weather.wunderground.api.services.IDataReaderService#getNextLine()
	 */
	public String getNextLine() throws IOException {
		init();
        if(scanner.hasNext()) {
            currentLine++;
            String line = scanner.nextLine();
            if(line != null && line.contains("<br>")) {
            	line = null;
            	if(scanner.hasNext()) {
            		line = scanner.nextLine();
            	}
            }
            return line;
        }
        return null;
	}

	/* (non-Javadoc)
	 * @see de.mbenning.weather.wunderground.api.services.IDataReaderService#nextDataColumns()
	 */
	public String[] nextDataColumns() throws IOException {
		String line = this.getNextLine();
		if(line != null) {
			return line.split(SEPARATOR);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see de.mbenning.weather.wunderground.api.services.IDataReaderService#nextDataSet()
	 */
	public DataSet nextDataSet() throws IOException, ParseException, UnsupportedEncodingException {
		DataSet dataSet = new DataSet();
		dataSet.setWeatherStation(this.weatherStation);
        String[] columns = this.nextDataColumns();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        if(columns != null && columns.length > 0 && !columns[0].isEmpty()) {
	        dataSet.setDateTime(sdf.parse(columns[DataColumn.TIME.getIndex()]));
	        dataSet.setTemperature(Double.valueOf(columns[DataColumn.TEMPERATURE.getIndex()]));
	        dataSet.setDewPoint(Double.valueOf(columns[DataColumn.DEWPOINT.getIndex()]));
	        dataSet.setPressurehPa(Double.valueOf(columns[DataColumn.PRESSURE.getIndex()]));
	        dataSet.setWindDirection(new String(columns[DataColumn.WIND_DIRECTION.getIndex()].getBytes(), ENCODING));
	        dataSet.setWindDirectionDegrees(Double.valueOf(columns[DataColumn.WIND_DIRECTION_DEGREES.getIndex()]));
	        dataSet.setWindSpeedKmh(Double.valueOf(columns[DataColumn.WINDSPEED_KMH.getIndex()]));
	        dataSet.setHumidity(Integer.valueOf(DataColumn.HUMIDITY.getIndex()));
	        dataSet.setRainRateHourlyMm(Double.valueOf(columns[DataColumn.RAINRATE_HOURLY_MM.getIndex()]));
        }
        
        return dataSet;
	}

	/* (non-Javadoc)
	 * @see de.mbenning.weather.wunderground.api.services.IDataReaderService#readDataSets()
	 */
	public List<DataSet> readDataSets() throws IOException, ParseException, UnsupportedEncodingException {
		init();
		List<DataSet> datasets = new ArrayList<DataSet>();
        while(this.scanner.hasNext()) {
        	DataSet next = nextDataSet();
        	if(next != null && next.getDateTime() != null) {
        		datasets.add(next);
        	}
        }
        return datasets;
	}
	
	public DataSet getCurrentData() {
		try {
			List<DataSet> dataSets = this.readDataSets();
			DataSet currentDataSet = dataSets.get((dataSets.size()-1));
			this.handleListeners(currentDataSet);
			return currentDataSet;
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<DataSet> findDataSetsByDateTime(String dateTime) throws UnsupportedEncodingException, IOException, ParseException {
		List<DataSet> dataSets = this.readDataSets();
		List<DataSet> result = new ArrayList<DataSet>(); 
		for (DataSet dataSet : dataSets) {
			
		}
		return result;
	}
	
	protected void handleListeners(DataSet dataSet) {
		if(dataSet != null) {
			for(IDataListener listener : this.listeners) {
				if(listener.isConditionSatisfied(dataSet)) {
					listener.process(dataSet);
				}
			}
		}
	}
	
	public void registerListener(IDataListener dataListener) {
		if(dataListener != null) {
			this.listeners.add(dataListener);
		}
	}

	public void removeListener(IDataListener dataListener) {
		if(dataListener != null && this.listeners.contains(dataListener)) {
			this.listeners.remove(dataListener);
		}
	}
	
	public long getCurrentLine() {
		return currentLine;
	}

	public String getSourceId() {
		return source;
	}

	public void setSource(String sourceId) {
		this.source = sourceId;
	}

	public WeatherStation getWeatherStation() {
		return weatherStation;
	}

	public void setWeatherStation(WeatherStation weatherStation) {
		this.isStationChanged = true;
		this.weatherStation = weatherStation;
	}

}
