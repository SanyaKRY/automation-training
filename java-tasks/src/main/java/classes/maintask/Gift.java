package classes.maintask;

import java.util.ArrayList;
import java.util.Collections;

public class Gift {

  public static void main(String[] args) {
		
    ArrayList<Sweet> sweets = new ArrayList<Sweet>();
	sweets.add(new SweetLadybug(1, 60, "Green", 10));
	sweets.add(new SweetRocket(2, 50, "Red", 20));
	sweets.add(new SweetCow(3, 40, "Pink", 30));
	sweets.add(new SweetLadybug(4, 30, "Orange", 40));
	sweets.add(new SweetRocket(5, 20, "Blue", 50));
	sweets.add(new SweetCow(6, 10, "Yellow", 60));		
	for (Sweet somethingSweet : sweets) {
	  System.out.println(somethingSweet);
	}		
	System.out.println("sort by weight: ");
	Collections.sort(sweets);		
	for (Sweet somethingSweet : sweets) {
	  System.out.println(somethingSweet);
	}		
	int amountOfSugar = 30;
	findSweetsBySugar(sweets,amountOfSugar);

  }
	
  static void findSweetsBySugar(ArrayList<Sweet> sweets,int amountOfSugar) {
    int sumSweetsForPrice = 0;
	System.out.println("sweets contain < "+amountOfSugar+" amount of sugar:");
	for (int i = 0; i < sweets.size(); i++) {
	  if (sweets.get(i).getAmountOfSugarInSweet() < amountOfSugar) {
		System.out.println(sweets.get(i).toString());	
	  }
	  sumSweetsForPrice += sweets.get(i).getSweetPrice();				
	}
	System.out.println("price of the whole gift: "+sumSweetsForPrice);
  }

}
