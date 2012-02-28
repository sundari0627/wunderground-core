/**
 * 
 */
package de.mbenning.weather.wunderground.api.domain;

import java.util.Date;

/**
 * @author Martin.Benning
 *
 */
public enum DataColumnDay {
    
    TIME ("Zeit", "Time", 0, Date.class),
    TEMPERATURE ("Temperatur", "TemperatureC", 1, Double.class),
    DEWPOINT ("Taupunkt", "Dewpoint", 2, Double.class),
    PRESSURE ("Luftdruck hPa", "PressurehPa", 3, Double.class),
    WIND_DIRECTION ("Windrichtung", "WindDirection", 4, String.class),
    WIND_DIRECTION_DEGREES ("Windrichtung Grad", "WindDirectionDegress", 5, Double.class),
    WINDSPEED_KMH ("Windgeschwindigkeit", "WindSpeedKMH", 6, Double.class),
    HUMIDITY ("Luftfeuchtigkeit", "Humidity", 7, Integer.class),
    RAINRATE_HOURLY_MM ("Regenrate mm/h", "HourlyPrecipMM", 6, Double.class);
    
    private String name;
    private String title;
    private int index;
    private Class<?> type;
    
    private DataColumnDay(String name, String title, int index, Class<?> type) {
        this.name = name;
        this.title = title;
        this.index = index;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public int getIndex() {
        return index;
    }

    public Class<?> getType() {
        return type;
    }

}
