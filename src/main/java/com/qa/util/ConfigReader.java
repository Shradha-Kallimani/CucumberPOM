package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader 
{
	private Properties prop;
	
	/* This method is used to load the properties from the config.properties file 
	 * @return it returns Properties prop object
	 */
	
	public Properties init_prop()
	{
		prop = new Properties();
		try {
			FileInputStream fi = new FileInputStream("src/test/resources/config/config.properties");
			try {
				prop.load(fi);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
			return prop;	 
	}

}
