package main_task;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ThreadCar implements Runnable{
	Thread thread;
	Parking parking;
	Semaphore semaphore;
	public ThreadCar(String name,Parking parkin,Semaphore semaphore) {
		thread = new Thread(this,name);
		this.parking=parkin;
		this.semaphore=semaphore;
		thread.start();
	}	
	@Override
	public void run() {
		try {
			Car car=new Car(getRandomModel(),getRandomNumberInRange(1,5));
			System.out.println("Thread name= "+ Thread.currentThread().getName()+"   car:"+car);
			if (semaphore.tryAcquire(2000, TimeUnit.MILLISECONDS)) {
				parking.addCar(car);
				Thread.sleep(car.getParkingTime()*1000);
				parking.removeCar(car);
				semaphore.release();
				} else {
					System.out.println("   There is no place for a car on the parking: "+car.carModel+" Thread name:" + Thread.currentThread().getName());
				}
		} catch (InterruptedException e) {
			e.printStackTrace();
			}
	}	
	
	CarModel getRandomModel() {
        Random random = new Random();
        return CarModel.values()[random.nextInt(CarModel.values().length)];
    }
	
	int getRandomNumberInRange(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

}
