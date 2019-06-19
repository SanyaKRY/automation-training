package threads;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Car implements Runnable {
	
	String carName;
	Parking parking;
	Semaphore semaphore;		
	
	public Car(String carName, Parking parking, Semaphore semaphore) {
		super();
		this.carName = carName;
		this.parking = parking;
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		try {
		if (semaphore.tryAcquire(2000, TimeUnit.MILLISECONDS)) {
			parking.addCarToParking(this);
			Thread.sleep(3000);
			parking.removeCarFromParking(this);
			semaphore.release();
		} else {
				System.out.println("---"+this.carName+" didn't wait for a parking place and went to another parking."+" Thread name:" + Thread.currentThread().getName());
		}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}

}
