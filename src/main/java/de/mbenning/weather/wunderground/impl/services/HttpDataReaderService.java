/**
 * 
 */
package de.mbenning.weather.wunderground.impl.services;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import de.mbenning.weather.wunderground.api.domain.HttpProxy;
import de.mbenning.weather.wunderground.impl.services.base.AbstractDataReaderService;

/**
 * @author Martin.Benning
 *
 */
@Service
@Scope("prototype")
@Qualifier("httpDataReaderService")
public class HttpDataReaderService extends AbstractDataReaderService {
	
	private HttpURLConnection connection = null;
	
	private String url = ResourceBundle.getBundle("wunderground-core").getString("wunderground.core.http.url");
	
	@Autowired
	@Qualifier("httpProxy")
	private HttpProxy httpProxy;

	/* (non-Javadoc)
	 * @see de.mbenning.weather.wunderground.api.services.IDataReaderService#init()
	 */
	public void init() throws IOException {
		if((this.scanner == null && this.connection == null && this.weatherStation != null) || isStationChanged) {
			this.currentLine = 1;
			if(httpProxy != null && httpProxy.isEnabled()) {
				System.setProperty("proxySet", "true");
				System.setProperty("http.proxyHost", httpProxy.getUrl());
				System.setProperty("http.proxyPort", Integer.toString(httpProxy.getPort()));
			}
			
			URL url = new URL(this.url.replace("{1}", this.weatherStation.getStationId()));
			this.connection = (HttpURLConnection)url.openConnection();
			this.connection.setRequestMethod("GET");
			this.connection.setUseCaches (false);
			
			this.scanner = new Scanner(this.connection.getInputStream());
			String line = this.scanner.nextLine();
			if(line == null || !StringUtils.hasText(line) ) {
				this.scanner.nextLine();
			}
			isStationChanged = false;
		}
	}

	public HttpProxy getHttpProxy() {
		return httpProxy;
	}

	public void setHttpProxy(HttpProxy httpProxy) {
		this.httpProxy = httpProxy;
	}

}
