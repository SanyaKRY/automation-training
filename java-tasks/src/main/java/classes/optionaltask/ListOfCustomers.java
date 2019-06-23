package classes.optionaltask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ListOfCustomers {
	
  public static void main(String[] args) {
	ArrayList<Customer> customers = new ArrayList<Customer>();
	customers.add(new Customer("Stephenov", "Stephen", "Stephener", "Brest", 11111, 11111));
	customers.add(new Customer("Paulov", "Paulen", "Pauler", "Gomel", 22222, 22222));
	customers.add(new Customer("Markov", "Mark", "Marker", "Minsk", 33333, 33333));
	customers.add(new Customer("Jason", "Jasonen", "Jasoner", "Minsk", 44444, 44444));
	customers.add(new Customer("Richard", "Richarden", "Richarder", "Brest", 55555, 55555));
	customers.add(new Customer("Andrew", "Andrewen", "Andrewer", "Gomel", 66666, 66666));
	customers.add(new Customer());
	Collections.sort(customers);
	Iterator<Customer> iterator = customers.iterator();
	while (iterator.hasNext()) {
	  Customer customer = iterator.next();
	  System.out.println(customer.toString());			
	}
	System.out.println();
	searchByCreditCardNumber(customers, 55555);
	}
	
  static void searchByCreditCardNumber(ArrayList<Customer> customers,int CreditCardNumberLimit) {
	System.out.println("CreditCardNumber<"+CreditCardNumberLimit+" :");
	for (int i = 0; i < customers.size(); i++) {
	  if (customers.get(i).getCreditCardNumber() < CreditCardNumberLimit) {
		System.out.println(customers.get(i).toString());	
	  }
					
	}			
  }

}
