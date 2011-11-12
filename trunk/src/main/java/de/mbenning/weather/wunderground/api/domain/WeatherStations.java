/**
 * 
 */
package de.mbenning.weather.wunderground.api.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Martin.Benning
 *
 */
public final class WeatherStations {
	
	public final static WeatherStation INOORDBR35_BOXMEER = new WeatherStation("INOORDBR35");
	static {
		INOORDBR35_BOXMEER.setNeighborhood("luneven weatherstation");
		INOORDBR35_BOXMEER.setCity("Boxmeer");
		INOORDBR35_BOXMEER.setState("Noord-Brabant");
		INOORDBR35_BOXMEER.setCountry("Niederlande");
		INOORDBR35_BOXMEER.setStationType("ws-4000 (ukkel)");
	};
	
	public final static WeatherStation INORDRHE72_DORTMUND = new WeatherStation("INORDRHE72");
	static {
		INORDRHE72_DORTMUND.setNeighborhood("Dortmund Mengede");
		INORDRHE72_DORTMUND.setCity("Dortmund");
		INORDRHE72_DORTMUND.setState("Nordrhein-Westfalen");
		INORDRHE72_DORTMUND.setCountry("Deutschland");
		INORDRHE72_DORTMUND.setStationType("Davis Vantage Pro 2 Plus");
	};
	
	public final static WeatherStation IZEELAND13_GOES = new WeatherStation("IZEELAND13");
	static {
		IZEELAND13_GOES.setNeighborhood("");
		IZEELAND13_GOES.setCity("Goes");
		IZEELAND13_GOES.setState("Zeeland");
		IZEELAND13_GOES.setCountry("Niederlande");
		IZEELAND13_GOES.setStationType("Vantage Pro2");
	};
	
	public final static WeatherStation IDRENTHE48_COEVORDEN = new WeatherStation("IDRENTHE48");
	static {
		IDRENTHE48_COEVORDEN.setNeighborhood("Weerstation Coevorden");
		IDRENTHE48_COEVORDEN.setCity("Coevorden");
		IDRENTHE48_COEVORDEN.setState("Drenthe");
		IDRENTHE48_COEVORDEN.setCountry("Niederlande");
		IDRENTHE48_COEVORDEN.setStationType("");
		IDRENTHE48_COEVORDEN.setSite("http://www.weerstation-coevorden.nl/");
	};
	
	public final static WeatherStation INORDRHE110_GOCH = new WeatherStation("INORDRHE110");
	static {
		INORDRHE110_GOCH.setNeighborhood("");
		INORDRHE110_GOCH.setCity("Goch");
		INORDRHE110_GOCH.setState("Nordrhein-Westfalen");
		INORDRHE110_GOCH.setCountry("Deutschland");
		INORDRHE110_GOCH.setStationType("TFA Nexus");
	};
	
	public final static WeatherStation INRWKLEV2_KLEVE = new WeatherStation("INRWKLEV2");
	static {
		INRWKLEV2_KLEVE.setNeighborhood("Kleve-Duffelward");
		INRWKLEV2_KLEVE.setCity("Kleve");
		INRWKLEV2_KLEVE.setState("Nordrhein-Westfalen");
		INRWKLEV2_KLEVE.setCountry("Deutschland");
		INRWKLEV2_KLEVE.setStationType("Davis Vantage Pro2 ");
		INRWKLEV2_KLEVE.setSite("http://www.maxxa.de/");
	};
	
	public static final Map<String, WeatherStation> ALL = new HashMap<String, WeatherStation>();
	static {
		ALL.put("INRWKLEV2", INRWKLEV2_KLEVE);
		ALL.put("INORDRHE110", INORDRHE110_GOCH);
		ALL.put("IDRENTHE48", IDRENTHE48_COEVORDEN);
		ALL.put("IZEELAND13", IZEELAND13_GOES);
		ALL.put("INORDRHE72", INORDRHE72_DORTMUND);
		ALL.put("INOORDBR35", INOORDBR35_BOXMEER);
	};
	
}
