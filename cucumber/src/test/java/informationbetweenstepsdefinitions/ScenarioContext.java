package informationbetweenstepsdefinitions;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
	
  private  Map<String, Object> context;
  
  public ScenarioContext(){
    context = new HashMap<>();
  }

  public void setContext(String key, Object value) {
    context.put(key, value);
  }

  public Object getContext(String key){
    return context.get(key);
  }

  public Boolean isContains(String key){
    return context.containsKey(key);
  }

}