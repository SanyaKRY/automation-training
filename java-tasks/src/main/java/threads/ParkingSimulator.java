package threads;

import java.util.concurrent.Semaphore;

public class ParkingSimulator {

  public static void main(String[] args) throws InterruptedException {
	
  final int NUMBER_OF_CARS = 30;
  final int NUMBER_OF_PARKING_SPACES = 4;
		
  Parking parking = new Parking();
  Semaphore Semaphore = new Semaphore(NUMBER_OF_PARKING_SPACES, true);
		
  for (int i = 0; i < NUMBER_OF_CARS; i++) {
	new Thread(new Car("Car"+i, parking, Semaphore)).start();
	Thread.sleep(500);
  }

  }

}
