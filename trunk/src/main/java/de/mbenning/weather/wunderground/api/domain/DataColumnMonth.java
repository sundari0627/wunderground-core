/**
 * 
 */
package de.mbenning.weather.wunderground.api.domain;

import java.util.Date;

/**
 * @author Martin.Benning
 *
 */
public enum DataColumnMonth {
	
    TIME ("Zeit", "Time", 0, Date.class),
    TEMPERATURE_HIGH ("Temperatur max.", "TemperatureHighC", 1, Double.class),
    TEMPERATURE_AVG ("Temperatur durchschnitt", "TemperatureAvgC", 2, Double.class),
    TEMPERATURE_LOW ("Temperatur min.", "TemperatureLowC", 3, Double.class),
    DEWPOINT_HIGH ("Taupunkt max.", "DewpointHighC", 4, Double.class),
    DEWPOINT_AVG ("Taupunkt durchschnitt", "DewpointAvgC", 5, Double.class),
    DEWPOINT_LOW ("Taupunkt max.", "DewpointLowC", 6, Double.class);
    
    private String name;
    private String title;
    private int index;
    private Class<?> type;
    
    private DataColumnMonth(String name, String title, int index, Class<?> type) {
        this.name = name;
        this.title = title;
        this.index = index;
        this.type = type;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Class<?> getType() {
		return type;
	}

	public void setType(Class<?> type) {
		this.type = type;
	}
}
