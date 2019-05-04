package main_task;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Order {
	int clientNumber;
	int numberOfOrder;
	static int generationNumberOfOrder=10000;
	
	public int getNumberOfOrder() {
		return numberOfOrder;
	}

	public int getСlientNumber() {
		return clientNumber;
	}

	ArrayList<Pizza> pizzas= new ArrayList<Pizza>();	
	
	public Order(int numberOfClient) {
		numberOfOrder=generationNumberOfOrder++;
		this.clientNumber=numberOfClient;
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime);			
		}	
	
	public void makePizzaOrder(String namePizza,int numberOfPizzas,String nameBaseForPizza,String... nameOfIngredients){
		if (numberOfPizzas<10&&pizzas.size()<10) {
			for (int i = 0; i < numberOfPizzas; i++) {
				pizzas.add(new Pizza(namePizza, nameBaseForPizza, nameOfIngredients));
			}			
		} else {
			System.out.println("Вы заказали больше 10 пицц.");
			throw new NullPointerException();
		}		
	}	
	
	void removePizza(String namePizza) {		
		for (Pizza pizza : pizzas) {
			if(pizza.getNamePizza().equals(namePizza)) {
				pizzas.remove(pizza);
				System.out.println("Вы удалили пиццу из заказа: "+pizza.getNamePizza());
				break;
			}	
			 		
		}		
	}	
	
	void addIngridientInPizza(String namePizza,String ingredient){		
		for (Pizza pizza : pizzas) {
			if(pizza.getNamePizza().equals(namePizza)) {
				pizza.addIngredientInPizza(ingredient);
				return;				 
			}			 		
		}		
	}	
	
	void addPizza(String namePizza) {			
		if (pizzas.size()<10) {
			for (Pizza pizza : pizzas) {
				 if(pizza.getNamePizza().equals(namePizza)) {
					 pizzas.add(pizza);
					 System.out.println("Вы добавили пиццу в заказ: "+pizza.getNamePizza());
					 break;
			     }			
		    }		
		} else {
			System.out.println("Вы заказали больше 10 пицц.");
			throw new NullPointerException();
		}
	}		
	
	void informationAboutOrder() {
		System.out.println("Номер заказа: "+numberOfOrder+" номер клиента: "+clientNumber);
		ArrayList<Pizza> newList = new ArrayList<Pizza>(); 		  
	      
        for (Pizza element : pizzas) {   
            if (!newList.contains(element)) {   
                newList.add(element); 
            } 
        } 
        for (Pizza pizza : newList) {
        System.out.print("Название: "+pizza.namePizza);
        System.out.print(" Количество: "+Collections.frequency(pizzas,pizza));
        System.out.println();
        }
        System.out.print("Номера пицц: ");
        for (Pizza pizza : pizzas) {
			System.out.print(pizza.getNumberOfOrderPizza()+" ");
		}
        System.out.println();
	}
	
	@Override
	public String toString() {
		double allSum = 0;
		System.out.println("******************************");
		System.out.print("Заказ:     "+numberOfOrder+"\n");			
		System.out.print("Клиент:    "+clientNumber+"\n");	
		ArrayList<Pizza> newList = new ArrayList<Pizza>();
		for (Pizza element : pizzas) {
			if (!newList.contains(element)) {
				newList.add(element); 
            }            
        } 		
		for (Pizza pizza : newList) {
			System.out.println("Название:  "+pizza.namePizza);
			System.out.print("------------------------------");			
			System.out.println(pizza.base.toString().replaceAll(",|\\[|\\]|end", ""));
			System.out.print(pizza.ingredients.toString().replaceAll(",|\\[|\\]|end", ""));
			System.out.println("------------------------------");			
			System.out.println("Всего:            "+Collections.frequency(pizzas,pizza)*pizza.sumPricePizza()+"$");
			allSum+=Collections.frequency(pizzas,pizza)*pizza.sumPricePizza();
			System.out.println("Количество:       "+Collections.frequency(pizzas,pizza));
			System.out.println("------------------------------");			
			}	
		System.out.println("Общая сумма: "+allSum+"$");
		System.out.println("******************************");
		return "";
	}
}
