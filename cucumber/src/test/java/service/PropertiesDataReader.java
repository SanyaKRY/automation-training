package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

public class PropertiesDataReader {
	
  public static String  getValue(String pathToProperty, String key){
	try (BufferedReader bufferedReader= new BufferedReader(new FileReader(pathToProperty))){
	  Properties properties = new Properties();
	  properties.load(bufferedReader);
	  return properties.getProperty(key);
	} catch (Exception e) {
	  return null;
	}	
  }

}
