package main_task;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

public class Parking {
	List<Car> listCars;
	
	public Parking() {
		listCars = new ArrayList<>();
	}
	
	synchronized void addCar(Car car) {
		try {
			listCars.add(car);
			String infomation = String.format("%s + The car on the parking: %s %s parked time %s", listCars.size(), car.getCarModel(), Thread.currentThread().getName(),car.parkingTime);
			System.out.println(infomation);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	synchronized void removeCar(Car parkedCar) {
		try {
			Iterator<Car> iterator = listCars.iterator();
			while (iterator.hasNext()) {
				Car car = iterator.next();
				if (parkedCar.equals(car))
					iterator.remove();
			}
			notifyAll();
			System.out.println(listCars.size() + " - The car is taken from the parking: " + Thread.currentThread().getName());
		} catch (ConcurrentModificationException e) {
			 e.printStackTrace();
		}
	}
}
