package main_task;

public class Car {
	CarModel carModel;
	int parkingTime;
	
	public CarModel getCarModel() {
		return carModel;
	}
	
	public int getParkingTime() {
		return parkingTime;
	}

	public Car(CarModel carModel,int parkingTime) {
		this.carModel=carModel;
		this.parkingTime=parkingTime;
	}
	@Override
	public String toString() {
		return carModel+" parkingTime:"+parkingTime;
	}

}
