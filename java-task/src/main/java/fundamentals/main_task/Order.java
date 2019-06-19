package main_task;

public class Order {
	
public static void main(String[] args) {
		
		OrderingPizza orderFromMargarita = new OrderingPizza("Margarit", 7717);
		orderFromMargarita.makeOrderPizza("Margarita", 2, "Calzone", "Tomato Paste", "Pepperoni", "Garlic", "Bacon");
		orderFromMargarita.makeOrderPizza("PepperonioOro", 3, "Calzone", "Tomato Paste", "Cheese", "Salami", "Olives");
		orderFromMargarita.showPizzaAttributes();
		orderFromMargarita.toString();
		
		OrderingPizza orderFromUnknown = new OrderingPizza("Unknown", 4372);
		orderFromUnknown.makeOrderPizza("BasePZZ", 12, "Ordinary", "Tomato Paste", "Cheese");
		orderFromUnknown.showPizzaAttributes();
		
	}

}
