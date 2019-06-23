package fundamentals.maintask;

import java.util.EnumSet;

public class Pizza {
	
  static int pizzaOrderNumberCounter = 10000;
  final int PIZZA_ORDER_NUMBER;
  String pizzaName;
  int countOfPizzas;
  EnumSet<PizzaBases> pizzaBases = EnumSet.noneOf(PizzaBases.class);
  EnumSet<PizzaIngredients> pizzaIngredients = EnumSet.noneOf(PizzaIngredients.class);
	
  public Pizza(String pizzaName, int countOfPizzas, String clientName, String pizzaBaseName, String ...ingredientName) {
    PIZZA_ORDER_NUMBER = ++pizzaOrderNumberCounter;		
	this.pizzaName = pizzaName.length() > 4 && pizzaName.length() < 20 ? pizzaName : clientName + PIZZA_ORDER_NUMBER;		
	this.countOfPizzas = countOfPizzas;
	pizzaBases.add(PizzaBases.getPizzaBase(pizzaBaseName));
	for (String ingridient : ingredientName) {
	  if (pizzaIngredients.contains(PizzaIngredients.getIngredient(ingridient))) {
	    System.out.println("вы попытались добавить ингредиент " + ingridient +
		    " который уже был добавлен. Проверте заказ");
	  } else {
	    pizzaIngredients.add(PizzaIngredients.getIngredient(ingridient));
	  }							
	}
	  displayMessageIfPizzaContainsAllIngredients();
	}	
	
  public String getPizzaName() {
	return pizzaName;
  }
	
  public int getCountOfPizzas() {
	return countOfPizzas;
  }

  public void setCountOfPizzas(int countOfPizzas) {
	this.countOfPizzas = countOfPizzas;
  }
		
  void displayMessageIfPizzaContainsAllIngredients() {
	System.out.println(pizzaIngredients.size() >= PizzaIngredients.values().length ? 
	    "все ингредиенты добавлены в пиццу "+pizzaName : "");		
  }

}
