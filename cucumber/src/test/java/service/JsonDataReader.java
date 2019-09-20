package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import gherkin.deps.com.google.gson.Gson;
import model.ComputeEngineUser;

public class JsonDataReader {
	
  private String ComputeEngineUserJsonPath = "src/test/resources/json/computeEngineUser.json";
	
  private List<ComputeEngineUser> computeEngineUser;
  
  public JsonDataReader(){
	computeEngineUser = getComputeEngineUserData();		 
  }
	
  public List<ComputeEngineUser> getComputeEngineUserData() {		
	Gson gson = new Gson();	 
	try (BufferedReader bufferedReader = new BufferedReader(new FileReader(ComputeEngineUserJsonPath))){	
	  ComputeEngineUser[] computeEngineUser = gson.fromJson(bufferedReader, ComputeEngineUser[].class);
	  return Arrays.asList(computeEngineUser);			
	} catch (Exception e) {
	  System.out.println(e);
	throw new RuntimeException("Json file not found at path : " + ComputeEngineUserJsonPath);
	}
  }
		
  public final ComputeEngineUser getComputeEngineUserByName(String ComputeEngineUserName){		
	for(ComputeEngineUser computeEngineUser : computeEngineUser) {
	  if(computeEngineUser.getName().equalsIgnoreCase(ComputeEngineUserName)) 
		return computeEngineUser;
	}
	return null;
  }

}
