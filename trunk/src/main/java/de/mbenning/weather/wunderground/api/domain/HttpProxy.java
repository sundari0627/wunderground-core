/**
 * 
 */
package de.mbenning.weather.wunderground.api.domain;

import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author Martin.Benning
 *
 */
@Component
@Qualifier("httpProxy")
public class HttpProxy {
	
	private boolean isEnabled = Boolean.parseBoolean(ResourceBundle.getBundle("wunderground-core").getString("wunderground.core.http.proxy.enabled"));
	
	private String url = ResourceBundle.getBundle("wunderground-core").getString("wunderground.core.http.proxy.url");
	
	private int port = Integer.parseInt(ResourceBundle.getBundle("wunderground-core").getString("wunderground.core.http.proxy.port"));
	
	private String username = ResourceBundle.getBundle("wunderground-core").getString("wunderground.core.http.proxy.username");
	
	private String password = ResourceBundle.getBundle("wunderground-core").getString("wunderground.core.http.proxy.password");
	
	public HttpProxy() {
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean enabled) {
		this.isEnabled = enabled;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
