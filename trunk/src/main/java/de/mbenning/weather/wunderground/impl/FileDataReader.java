/**
 * 
 */
package de.mbenning.weather.wunderground.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import de.mbenning.weather.wunderground.api.domain.DataColumn;
import de.mbenning.weather.wunderground.api.domain.DataSet;

/**
 * @author Martin.Benning
 *
 */
public class FileDataReader {
    
    private final static String SEPARATOR = ",";
    
    private final static String ENCODING = "UTF-8";
    
    private File file = null; 
    
    private long currentLine = 1;
    
    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Scanner getFileScanner() {
        return fileScanner;
    }

    public void setFileScanner(Scanner fileScanner) {
        this.fileScanner = fileScanner;
    }

    private String filePath = null;
    
    private Scanner fileScanner = null;
    
    public FileDataReader(String filePath) throws FileNotFoundException {
        this.file = new File(filePath);
        if(this.file != null) {
            init();
        }
    }
    
    public FileDataReader(File file) throws FileNotFoundException {
        this.file = file;
        if(this.file != null) {
            init();
        }
    }
    
    public void init() throws FileNotFoundException {
        if(this.fileScanner == null && file != null) {
            this.fileScanner = new Scanner(this.file);
            fileScanner.nextLine();
        }
    }
    
    public String getNextLine() throws FileNotFoundException {
        init();
        if(fileScanner.hasNext()) {
            currentLine++;
            return fileScanner.nextLine();
        }
        return null;
    }
    
    public String[] nextDataColumns() throws FileNotFoundException {
        return this.getNextLine().split(SEPARATOR);
    }
    
    public DataSet nextDataSet() throws FileNotFoundException, ParseException, UnsupportedEncodingException {
        DataSet dataSet = new DataSet();
        String[] columns = this.nextDataColumns();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        dataSet.setDateTime(sdf.parse(columns[DataColumn.TIME.getIndex()]));
        dataSet.setTemperature(Double.valueOf(columns[DataColumn.TEMPERATURE.getIndex()]));
        dataSet.setDewPoint(Double.valueOf(columns[DataColumn.DEWPOINT.getIndex()]));
        dataSet.setPressurehPa(Double.valueOf(columns[DataColumn.PRESSURE.getIndex()]));
        dataSet.setWindDirection(new String(columns[DataColumn.WIND_DIRECTION.getIndex()].getBytes(), ENCODING));
        dataSet.setWindDirectionDegrees(Double.valueOf(columns[DataColumn.WIND_DIRECTION_DEGREES.getIndex()]));
        dataSet.setWindSpeedKmh(Double.valueOf(columns[DataColumn.WINDSPEED_KMH.getIndex()]));
        dataSet.setHumidity(Integer.valueOf(DataColumn.HUMIDITY.getIndex()));
        dataSet.setRainRateHourlyMm(Double.valueOf(columns[DataColumn.RAINRATE_HOURLY_MM.getIndex()]));
        
        return dataSet;
    }
    
    public List<DataSet> readDataSets() throws FileNotFoundException, ParseException, UnsupportedEncodingException {
        List<DataSet> datasets = new ArrayList<DataSet>();
        while(this.fileScanner.hasNext()) {
            datasets.add(nextDataSet());
        }
        return datasets;
    }
    
}
