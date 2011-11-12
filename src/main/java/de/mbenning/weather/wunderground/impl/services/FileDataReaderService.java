/**
 * 
 */
package de.mbenning.weather.wunderground.impl.services;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import de.mbenning.weather.wunderground.impl.services.base.AbstractDataReaderService;

/**
 * @author Martin.Benning
 *
 */
@Service
@Scope("prototype")
@Qualifier("fileDataReaderService")
public class FileDataReaderService extends AbstractDataReaderService {
	
	private File file = null;

	/* (non-Javadoc)
	 * @see de.mbenning.weather.wunderground.api.services.IDataReaderService#init()
	 */
	public void init() throws IOException {
		if(this.scanner == null && this.file != null) {
            this.scanner = new Scanner(this.file);
            this.scanner.nextLine();
        }
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

}
