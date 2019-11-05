package service;

import model.ComputeEngine;

public class ComputeEngineCreator {
  public static final String TESTDATA_NUMBER_OF_INSTANCES = "testdata.computerEngine.numberOfInstances";
  public static final String TESTDATA_INSTANCES_FOR = "testdata.computerEngine.instancesFor";
  public static final String TESTDATA_OPERATING_SYSTEM = "testdata.computerEngine.operatingSystem";
  public static final String TESTDATA_VM_CLASS = "testdata.computerEngine.vmClass";
  public static final String TESTDATA_INSTANCE_TYPE = "testdata.computerEngine.instanceType";
  public static final String TESTDATA_ADD_GPUS = "testdata.computerEngine.addGPUs";
  public static final String TESTDATA_NUMBER_OF_GPUS = "testdata.computerEngine.numberOfGPUs";
  public static final String TESTDATA_GPU_TYPE = "testdata.computerEngine.gpuType";
  public static final String TESTDATA_LOCAL_SSD = "testdata.computerEngine.localSSD";
  public static final String TESTDATA_DATACENTER_LOCATION = "testdata.computerEngine.datacenterLocation";
  public static final String TESTDATA_COMMITED_USAGE = "testdata.computerEngine.commitedUsage";
		
  public static ComputeEngine getComputeEngine() {	
	return new ComputeEngine( Integer.parseInt(TestDataReader.getTestData(TESTDATA_NUMBER_OF_INSTANCES)), 
	    TestDataReader.getTestData(TESTDATA_INSTANCES_FOR), 
		TestDataReader.getTestData(TESTDATA_OPERATING_SYSTEM), 
		TestDataReader.getTestData(TESTDATA_VM_CLASS),
		TestDataReader.getTestData(TESTDATA_INSTANCE_TYPE), 
		Boolean.parseBoolean(TestDataReader.getTestData(TESTDATA_ADD_GPUS)), 
		TestDataReader.getTestData(TESTDATA_NUMBER_OF_GPUS), 
		TestDataReader.getTestData(TESTDATA_GPU_TYPE), 
		TestDataReader.getTestData(TESTDATA_LOCAL_SSD), 
		TestDataReader.getTestData(TESTDATA_DATACENTER_LOCATION),
		TestDataReader.getTestData(TESTDATA_COMMITED_USAGE));
  }
}
