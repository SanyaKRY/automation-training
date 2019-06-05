package model;

public class ComputeEngineUser {

	private int numberOfInstances;
	private String instancesFor;
	private String OperatingSystem;
	private String VMClass;
	private String InstanceType;
	private boolean addGPUs;
	private String NumberOfGPUs;
	private String GPUType;
	private String LocalSSD;
	private String DatacenterLocation;
	private String CommitedUsage;
	
	public ComputeEngineUser(int numberOfInstances, String instancesFor, String operatingSystem, String vMClass,
			String instanceType, boolean addGPUs, String numberOfGPUs, String gPUType, String localSSD,
			String datacenterLocation, String commitedUsage) {
		super();
		this.numberOfInstances = numberOfInstances;
		this.instancesFor = instancesFor;
		this.OperatingSystem = operatingSystem;
		this.VMClass = vMClass;
		this.InstanceType = instanceType;
		this.addGPUs = addGPUs;
		this.NumberOfGPUs = numberOfGPUs;
		this.GPUType = gPUType;
		this.LocalSSD = localSSD;
		this.DatacenterLocation = datacenterLocation;
		this.CommitedUsage = commitedUsage;
	}
	
	public String getNumberOfInstances() {
		return Integer.toString (numberOfInstances);
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
		return OperatingSystem;
	}
	public void setOperatingSystem(String operatingSystem) {
		OperatingSystem = operatingSystem;
	}
	public String getVMClass() {
		return VMClass;
	}
	public void setVMClass(String vMClass) {
		VMClass = vMClass;
	}
	public String getInstanceType() {
		return InstanceType;
	}
	public void setInstanceType(String instanceType) {
		InstanceType = instanceType;
	}
	public boolean isAddGPUs() {
		return addGPUs;
	}
	public void setAddGPUs(boolean addGPUs) {
		this.addGPUs = addGPUs;
	}
	public String getNumberOfGPUs() {
		return NumberOfGPUs;
	}
	public void setNumberOfGPUs(String numberOfGPUs) {
		NumberOfGPUs = numberOfGPUs;
	}
	public String getGPUType() {
		return GPUType;
	}
	public void setGPUType(String gPUType) {
		GPUType = gPUType;
	}
	public String getLocalSSD() {
		return LocalSSD;
	}
	public void setLocalSSD(String localSSD) {
		LocalSSD = localSSD;
	}
	public String getDatacenterLocation() {
		return DatacenterLocation;
	}
	public void setDatacenterLocation(String datacenterLocation) {
		DatacenterLocation = datacenterLocation;
	}
	public String getCommitedUsage() {
		return CommitedUsage;
	}
	public void setCommitedUsage(String commitedUsage) {
		CommitedUsage = commitedUsage;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CommitedUsage == null) ? 0 : CommitedUsage.hashCode());
		result = prime * result + ((DatacenterLocation == null) ? 0 : DatacenterLocation.hashCode());
		result = prime * result + ((GPUType == null) ? 0 : GPUType.hashCode());
		result = prime * result + ((InstanceType == null) ? 0 : InstanceType.hashCode());
		result = prime * result + ((LocalSSD == null) ? 0 : LocalSSD.hashCode());
		result = prime * result + ((NumberOfGPUs == null) ? 0 : NumberOfGPUs.hashCode());
		result = prime * result + ((OperatingSystem == null) ? 0 : OperatingSystem.hashCode());
		result = prime * result + ((VMClass == null) ? 0 : VMClass.hashCode());
		result = prime * result + (addGPUs ? 1231 : 1237);
		result = prime * result + ((instancesFor == null) ? 0 : instancesFor.hashCode());
		result = prime * result + numberOfInstances;
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
		ComputeEngineUser other = (ComputeEngineUser) obj;
		if (CommitedUsage == null) {
			if (other.CommitedUsage != null)
				return false;
		} else if (!CommitedUsage.equals(other.CommitedUsage))
			return false;
		if (DatacenterLocation == null) {
			if (other.DatacenterLocation != null)
				return false;
		} else if (!DatacenterLocation.equals(other.DatacenterLocation))
			return false;
		if (GPUType == null) {
			if (other.GPUType != null)
				return false;
		} else if (!GPUType.equals(other.GPUType))
			return false;
		if (InstanceType == null) {
			if (other.InstanceType != null)
				return false;
		} else if (!InstanceType.equals(other.InstanceType))
			return false;
		if (LocalSSD == null) {
			if (other.LocalSSD != null)
				return false;
		} else if (!LocalSSD.equals(other.LocalSSD))
			return false;
		if (NumberOfGPUs == null) {
			if (other.NumberOfGPUs != null)
				return false;
		} else if (!NumberOfGPUs.equals(other.NumberOfGPUs))
			return false;
		if (OperatingSystem == null) {
			if (other.OperatingSystem != null)
				return false;
		} else if (!OperatingSystem.equals(other.OperatingSystem))
			return false;
		if (VMClass == null) {
			if (other.VMClass != null)
				return false;
		} else if (!VMClass.equals(other.VMClass))
			return false;
		if (addGPUs != other.addGPUs)
			return false;
		if (instancesFor == null) {
			if (other.instancesFor != null)
				return false;
		} else if (!instancesFor.equals(other.instancesFor))
			return false;
		if (numberOfInstances != other.numberOfInstances)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "ComputeEngineUser [numberOfInstances=" + numberOfInstances + ", instancesFor=" + instancesFor
				+ ", OperatingSystem=" + OperatingSystem + ", VMClass=" + VMClass + ", InstanceType=" + InstanceType
				+ ", addGPUs=" + addGPUs + ", NumberOfGPUs=" + NumberOfGPUs + ", GPUType=" + GPUType + ", LocalSSD="
				+ LocalSSD + ", DatacenterLocation=" + DatacenterLocation + ", CommitedUsage=" + CommitedUsage + "]";
	}
	
}
