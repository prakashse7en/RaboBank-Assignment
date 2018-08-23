package com.reader.main;

import static com.reader.constants.CommonConstants.CSVFORMAT;
import static com.reader.constants.CommonConstants.FILE_PATH;
import static com.reader.constants.CommonConstants.XMLFORMAT;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.reader.csvreader.OpenCSVReader;
import com.reader.xmlreader.CustomerParserSAX;

public class CustomerStatementReader {
 
	public static void main(String[] args) {
		try{
		File folder = new File(FILE_PATH);
		File[] listOfFiles = folder.listFiles();
		Path path = null;
		String contentType = null;
		for (File file : listOfFiles) {
		    if (file.isFile()) {
		    	path = file.toPath(); 
				contentType = Files.probeContentType(path);
		    	if(contentType.equalsIgnoreCase(CSVFORMAT)){
		    		//perform csv ops
		    		new OpenCSVReader().genrateCSVReport(new FileReader(file));
		    	}else if(contentType.equalsIgnoreCase(XMLFORMAT)){
		    		//perform xml ops
		    		new CustomerParserSAX().genrateXMLReport(file);
		    	}
		    }
		} 
		}catch(IOException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
