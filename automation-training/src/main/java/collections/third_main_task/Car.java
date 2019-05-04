package third_main_task;

public class Car {
	String carBrand;
	int carNumbers;	

	public String getCarBrand() {
		return carBrand;
	}

	public Integer getCarNumbers() {
		return carNumbers;
	}

	public Car(String carBrand,int carNumbers) {
		super();	
		this.carBrand = carBrand;
		this.carNumbers=carNumbers;		
	}
}
