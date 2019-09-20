package model;

public class ComputeEngineUser {
	
  private String name;
  private int numberOfInstances;
  private String instancesFor;
  private String operatingSystem;
  private String VMClass;
  private String instanceType;
  private boolean addGPUs;
  private String numberOfGPUs;
  private String GPUType;
  private String localSSD;
  private String datacenterLocation;
  private String commitedUsage;

  public String getName() {
	return name;
  }
  
  public int getNumberOfInstances() {
	return numberOfInstances;
  }
  
  public String getInstancesFor() {
	return instancesFor;
  }
	
  public String getOperatingSystem() {
	return operatingSystem;
  }
	
  public String getVMClass() {
	return VMClass;
  }
	
  public String getInstanceType() {
	return instanceType;
  }
	
  public boolean isAddGPUs() {
	return addGPUs;
  }
	
  public String getNumberOfGPUs() {
	return numberOfGPUs;
  }
	
  public String getGPUType() {
	return GPUType;
  }
	
  public String getLocalSSD() {
	return localSSD;
  }
	
  public String getDatacenterLocation() {
	return datacenterLocation;
  }
	
  public String getCommitedUsage() {
	return commitedUsage;
  }

}
