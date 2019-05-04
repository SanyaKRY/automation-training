package third_main_task;

import java.util.HashMap;
import java.util.Map;

public class Parking {

	static void addCarToParking(HashMap<Integer, Car> hashMap,String nameCar,Integer carNumbers) {
		if (hashMap.size()>=5) {
			System.out.println("there are not parking slots, parking is full");
			return;
		}
		for (int i = 1; i < 10; i++) {
			if(!hashMap.containsKey(i)) {
				hashMap.put(i,new Car(nameCar,carNumbers));
				break;
			}
		}
	}
	
	static void removeCarFromParking(HashMap<Integer, Car> hashMap,String carBrand,Integer carNumbers) {
		for (Map.Entry<Integer, Car> entry : hashMap.entrySet()) {
			if (entry.getValue().getCarBrand().equals(carBrand)&&entry.getValue().getCarNumbers().equals(carNumbers)){
			hashMap.remove(entry.getKey());
			break;
			}
		}  
	}
	
	static void showParking(HashMap<Integer, Car> hashMap) {
		for (Map.Entry<Integer, Car> entry : hashMap.entrySet()) {
			   System.out.println("Parking spot: "+entry.getKey()+" "+entry.getValue().getCarBrand()+" "+entry.getValue().getCarNumbers());
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		HashMap<Integer,Car> hashMap=new HashMap<Integer,Car>();
		hashMap.put(2, new Car("Tayota",1999));
		hashMap.put(5,new Car( "Nissan",2058));
		showParking(hashMap);
		addCarToParking(hashMap,"BMV",9877);
		addCarToParking(hashMap,"Audi",8451);
		addCarToParking(hashMap,"Mers",9874);
		addCarToParking(hashMap,"Gelek",574);
		showParking(hashMap);
		removeCarFromParking(hashMap,"Tayota",1999);
		showParking(hashMap);
		addCarToParking(hashMap,"Mersss",98754);
		showParking(hashMap);
		
		}
}
