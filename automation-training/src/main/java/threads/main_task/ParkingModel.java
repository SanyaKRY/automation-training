package main_task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class ParkingModel {

	static void waitThreadsCars(List<ThreadCar> threadCar) {
		 try{
			 for(ThreadCar thread: threadCar)
				 thread.thread.join();
		 } catch (InterruptedException e){
			 System.out.println(e.getMessage());
         }
	}

static void createThreadsCars(List<ThreadCar> threadCar,Parking parking,Semaphore semaphore) throws InterruptedException {
	for (int i = 0; i <30; i++) {
		threadCar.add(new ThreadCar("Car"+i,parking,semaphore));
		Thread.sleep(500);
	}
}

public static void main(String[] args) throws InterruptedException {
	Parking parking = new Parking(); 		
	Semaphore semaphore = new Semaphore(3,true);
	List<ThreadCar> threadCar = new ArrayList<>();
	createThreadsCars(threadCar,parking,semaphore);
	waitThreadsCars(threadCar);	
}

}
