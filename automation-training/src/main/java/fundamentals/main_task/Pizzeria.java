package main_task;

public class Pizzeria {

	public static void main(String[] args) {
		Order orderFromTom = new Order(10000);
		orderFromTom.makePizzaOrder("Margarita",1,"Ordinary","Tomato Paste","Pepperoni","Garlic", "Pepperoni","Bacon");
		orderFromTom.makePizzaOrder("otherPizza",1,"Ordinary","Tomato Paste","Cheese","Salami","Olives");
		orderFromTom.toString();		
		orderFromTom.informationAboutOrder();
		
		//Order orderFrom7717 = new Order(7717);
		//orderFrom7717.makePizzaOrder("Margarita",2,"Calzone","Tomato Paste","Pepperoni","Garlic","Bacon");
		//orderFrom7717.makePizzaOrder("PepperoniOro",3,"Ordinary","Tomato Paste","Cheese","Pepperoni");
		//orderFrom7717.toString();
		//orderFrom7717.informationAboutOrder();
		
		//Order orderFrom4372 = new Order(4372);
		//orderFrom4372.makePizzaOrder("BasePZZ",12,"Ordinary","Tomato Paste");
		//orderFrom4372.toString();	
		//orderFrom4372.informationAboutOrder();
	}

}