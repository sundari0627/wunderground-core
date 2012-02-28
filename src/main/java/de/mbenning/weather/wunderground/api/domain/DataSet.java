/**
 * 
 */
package de.mbenning.weather.wunderground.api.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Martin.Benning
 *
 */
public class DataSet implements Serializable {

    private static final long serialVersionUID = -7467123489487406333L;

    private long id;
    
    private WeatherStation weatherStation = null;
    
    private Date dateTime;
    
    private Double temperature;
    
    private Double dewPoint;

    private Double pressurehPa;
    
    private String windDirection;
    
    private Double windDirectionDegrees;
    
    private Double windSpeedKmh;
    
    private Integer humidity;
    
    private Double rainRateHourlyMm;
    
    /* MONTH */
    private Double temperatureHigh;
    
    private Double temperatureAvg;
    
    private Double temperatureLow;
    
    private DataGraphSpan dataGraphSpan;
    
    public DataSet() {
    }
    
    public DataSet(Date dateTime) {
        this.dateTime = dateTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public WeatherStation getWeatherStation() {
		return weatherStation;
	}

	public void setWeatherStation(WeatherStation weatherStation) {
		this.weatherStation = weatherStation;
	}

	public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(Double dewPoint) {
        this.dewPoint = dewPoint;
    }

    public Double getPressurehPa() {
        return pressurehPa;
    }

    public void setPressurehPa(Double pressurehPa) {
        this.pressurehPa = pressurehPa;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public Double getWindSpeedKmh() {
        return windSpeedKmh;
    }

    public Double getWindDirectionDegrees() {
        return windDirectionDegrees;
    }

    public void setWindDirectionDegrees(Double windDirectionDegrees) {
        this.windDirectionDegrees = windDirectionDegrees;
    }

    public void setWindSpeedKmh(Double windSpeedKmh) {
        this.windSpeedKmh = windSpeedKmh;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Double getRainRateHourlyMm() {
        return rainRateHourlyMm;
    }

    public void setRainRateHourlyMm(Double rainRateHourlyMm) {
        this.rainRateHourlyMm = rainRateHourlyMm;
    }

	public DataGraphSpan getDataGraphSpan() {
		return dataGraphSpan;
	}

	public void setDataGraphSpan(DataGraphSpan dataGraphSpan) {
		this.dataGraphSpan = dataGraphSpan;
	}

	public Double getTemperatureHigh() {
		return temperatureHigh;
	}

	public void setTemperatureHigh(Double temperatureHigh) {
		this.temperatureHigh = temperatureHigh;
	}

	public Double getTemperatureAvg() {
		return temperatureAvg;
	}

	public void setTemperatureAvg(Double temperatureAvg) {
		this.temperatureAvg = temperatureAvg;
	}

	public Double getTemperatureLow() {
		return temperatureLow;
	}

	public void setTemperatureLow(Double temperatureLow) {
		this.temperatureLow = temperatureLow;
	}

}
