package model;

public class ComputeEngine {
  private int numberOfInstances;
  private String instancesFor;
  private String operatingSystem;
  private String vmClass;
  private String instanceType;
  private boolean addGPUs;
  private String numberOfGPUs;
  private String gpuType;
  private String localSSD;
  private String datacenterLocation;
  private String commitedUsage;
  public ComputeEngine(int numberOfInstances, String instancesFor, String operatingSystem, String vmClass,
	  String instanceType, boolean addGPUs, String numberOfGPUs, String gpuType, String localSSD,
	  String datacenterLocation, String commitedUsage) {
	super();
	this.numberOfInstances = numberOfInstances;
	this.instancesFor = instancesFor;
	this.operatingSystem = operatingSystem;
	this.vmClass = vmClass;
	this.instanceType = instanceType;
	this.addGPUs = addGPUs;
	this.numberOfGPUs = numberOfGPUs;
	this.gpuType = gpuType;
	this.localSSD = localSSD;
	this.datacenterLocation = datacenterLocation;
	this.commitedUsage = commitedUsage;
  }
  public String getNumberOfInstances() {
	  return Integer.toString(numberOfInstances);
  }
  public void setNumberOfInstances(int numberOfInstances) {
	this.numberOfInstances = numberOfInstances;
  }
  public String getInstancesFor() {
	return instancesFor;
  }
  public void setInstancesFor(String instancesFor) {
	this.instancesFor = instancesFor;
  }
  public String getOperatingSystem() {
	return operatingSystem;
  }
  public void setOperatingSystem(String operatingSystem) {
	this.operatingSystem = operatingSystem;
  }
  public String getVmClass() {
	return vmClass;
  }
  public void setVmClass(String vmClass) {
	this.vmClass = vmClass;
  }
  public String getInstanceType() {
	return instanceType;
  }
  public void setInstanceType(String instanceType) {
	this.instanceType = instanceType;
  }
  public boolean isAddGPUs() {
	return addGPUs;
  }
  public void setAddGPUs(boolean addGPUs) {
	this.addGPUs = addGPUs;
  }
  public String getNumberOfGPUs() {
	return numberOfGPUs;
  }
  public void setNumberOfGPUs(String numberOfGPUs) {
	this.numberOfGPUs = numberOfGPUs;
  }
  public String getGpuType() {
	return gpuType;
  }
  public void setGpuType(String gpuType) {
	this.gpuType = gpuType;
  }
  public String getLocalSSD() {
	return localSSD;
  }
  public void setLocalSSD(String localSSD) {
	this.localSSD = localSSD;
  }
  public String getDatacenterLocation() {
	return datacenterLocation;
  }
  public void setDatacenterLocation(String datacenterLocation) {
	this.datacenterLocation = datacenterLocation;
  }
  public String getCommitedUsage() {
	return commitedUsage;
  }
  public void setCommitedUsage(String commitedUsage) {
	this.commitedUsage = commitedUsage;
  }
  @Override
  public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (addGPUs ? 1231 : 1237);
	result = prime * result + ((commitedUsage == null) ? 0 : commitedUsage.hashCode());
	result = prime * result + ((datacenterLocation == null) ? 0 : datacenterLocation.hashCode());
	result = prime * result + ((gpuType == null) ? 0 : gpuType.hashCode());
	result = prime * result + ((instanceType == null) ? 0 : instanceType.hashCode());
	result = prime * result + ((instancesFor == null) ? 0 : instancesFor.hashCode());
	result = prime * result + ((localSSD == null) ? 0 : localSSD.hashCode());
	result = prime * result + ((numberOfGPUs == null) ? 0 : numberOfGPUs.hashCode());
	result = prime * result + numberOfInstances;
	result = prime * result + ((operatingSystem == null) ? 0 : operatingSystem.hashCode());
	result = prime * result + ((vmClass == null) ? 0 : vmClass.hashCode());
	return result;
  }
  @Override
  public boolean equals(Object obj) {
	if (this == obj)
	  return true;
	if (obj == null)
	  return false;
	if (getClass() != obj.getClass())
	  return false;
	ComputeEngine other = (ComputeEngine) obj;
	if (addGPUs != other.addGPUs)
	  return false;
	if (commitedUsage == null) {
	  if (other.commitedUsage != null)
		return false;
	} else if (!commitedUsage.equals(other.commitedUsage))
	  return false;
	if (datacenterLocation == null) {
	  if (other.datacenterLocation != null)
		return false;
	} else if (!datacenterLocation.equals(other.datacenterLocation))
	  return false;
	if (gpuType == null) {
	  if (other.gpuType != null)
		return false;
	} else if (!gpuType.equals(other.gpuType))
	  return false;
	if (instanceType == null) {
	  if (other.instanceType != null)
		return false;
	} else if (!instanceType.equals(other.instanceType))
	  return false;
	if (instancesFor == null) {
	  if (other.instancesFor != null)
		return false;
	} else if (!instancesFor.equals(other.instancesFor))
	  return false;
	if (localSSD == null) {
	  if (other.localSSD != null)
		return false;
	} else if (!localSSD.equals(other.localSSD))
	  return false;
	if (numberOfGPUs == null) {
	  if (other.numberOfGPUs != null)
		return false;
	} else if (!numberOfGPUs.equals(other.numberOfGPUs))
	  return false;
	if (numberOfInstances != other.numberOfInstances)
	  return false;
	if (operatingSystem == null) {
	  if (other.operatingSystem != null)
		return false;
	} else if (!operatingSystem.equals(other.operatingSystem))
	  return false;
	if (vmClass == null) {
	  if (other.vmClass != null)
		return false;
	} else if (!vmClass.equals(other.vmClass))
	  return false;
	  return true;
	}
  @Override
  public String toString() {
	return "ComputeEngine [numberOfInstances=" + numberOfInstances + ", instancesFor=" + instancesFor
	    + ", operatingSystem=" + operatingSystem + ", vmClass=" + vmClass + ", instanceType=" + instanceType
		+ ", addGPUs=" + addGPUs + ", numberOfGPUs=" + numberOfGPUs + ", gpuType=" + gpuType + ", localSSD="
		+ localSSD + ", datacenterLocation=" + datacenterLocation + ", commitedUsage=" + commitedUsage + "]";
  }
	 
}
