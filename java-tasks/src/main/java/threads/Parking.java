package threads;

import java.util.ArrayList;
import java.util.List;

public class Parking {
	
  List<Car> parking = new ArrayList<>();
	
  void addCarToParking(Car car) {
	parking.add(car);
	System.out.println("Parking size: " + parking.size() + ". " + car.carName + " got a parking place. " + 
	    " Thread name:" + Thread.currentThread().getName());						
  }
	
  void removeCarFromParking(Car car) {
	parking.remove(car);
	System.out.println("Parking size: " + parking.size() + ". " + car.carName + " left parking. " + 
	    " Thread name:" + Thread.currentThread().getName());
  }

}
