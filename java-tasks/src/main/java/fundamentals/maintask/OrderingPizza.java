package fundamentals.maintask;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;

public class OrderingPizza {
	
  static int orderCounter = 10000;
  final int  ORDER_NUMBER;  
  int pizzaLimitPerPerson = 10;
  String clientName;
  int clientNumber;  
  ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
	
  public OrderingPizza(String clientName, int clientNumber) {		
	this.clientName = clientName;
	this.clientNumber = clientNumber;
	ORDER_NUMBER = ++orderCounter;
	LocalTime localTime = LocalTime.now();
	System.out.print(localTime);	
  }
	
  public void makeOrderPizza(String pizzaName, int countOfPizzas, String pizzaBaseName, String... ingredientName) {
	isExceedingPizzaLimitPerPerson(countOfPizzas);
	pizzas.add(new Pizza(pizzaName, countOfPizzas, this.clientName, pizzaBaseName, ingredientName));		
  }
	
  void showPizzaAttributes() {
	for (Pizza pizza : pizzas) {
	  System.out.println("����� ������ ���� ������ ����: " + pizza.PIZZA_ORDER_NUMBER + " ��� �������: " + clientName + 
	      " ����� �������: "+clientNumber+" �������� ����(�): " + 
		  pizza.pizzaName+" ����������: "+pizza.countOfPizzas);
	}
  }
	
  void removePizzasFromOrder(String pizzaName) {
    Iterator<Pizza> iterator = pizzas.iterator();
	while (iterator.hasNext()) {
	  Pizza pizza = (Pizza) iterator.next();
	  if (pizza.getPizzaName().equals(pizzaName)) {
	    iterator.remove();				
	  }			
	}		
  }
	
  void addNewIngredientToPizza(String pizzaName, String ingridient) {
	Iterator<Pizza> iterator = pizzas.iterator();
	while (iterator.hasNext()) {
	  Pizza pizza = (Pizza) iterator.next();
	  if (pizza.getPizzaName().equals(pizzaName)) {		
	    if (pizza.pizzaIngredients.contains(PizzaIngredients.getIngredient(ingridient))) {
	      System.out.println("�� ���������� �������� ���������� " + ingridient + 
	          " �������  ��� ��� ��������. ��������� �����");
		} else {
		  pizza.pizzaIngredients.add(PizzaIngredients.getIngredient(ingridient));
		}
		System.out.println(pizza.pizzaIngredients.size() >= PizzaIngredients.values().length ? "��� ����������� ��������� � ����� " + pizzaName : "");										
	  }			
	}		
  }
		
  void changeCountOfPizzasInOrder(String pizzaName, int countOfPizzas) {
	for (Pizza pizza : pizzas) {
	  if (pizza.getPizzaName().equals(pizzaName)) {
	    if (pizzaLimitPerPerson + pizza.getCountOfPizzas() - countOfPizzas < 0) {
	      throw new IllegalArgumentException("�� ���������� ��������� ����� ���� �� ������ ��������.");
		}	
		pizzaLimitPerPerson -= (countOfPizzas - pizza.getCountOfPizzas());	
		pizza.setCountOfPizzas(countOfPizzas);
	  }
	}
  }
		
  public void isExceedingPizzaLimitPerPerson(int valuesToCheckNumberOfPizzasPerPerson) {
    if (pizzaLimitPerPerson - valuesToCheckNumberOfPizzasPerPerson < 0) {
      throw new IllegalArgumentException("�� ���������� ��������� ����� ���� �� ������ ��������.");
	}		
	pizzaLimitPerPerson -= valuesToCheckNumberOfPizzasPerPerson;	
  }
	
  @Override
  public String toString() {
	double totalAmountPrice = 0;
	System.out.println("********************************");
	System.out.println("�����: " + ORDER_NUMBER);
	System.out.println("������: " + clientNumber);
	  for (Pizza pizza : pizzas) {
	    double priceForOnePizza = 0;			
		for (PizzaIngredients pizzaIngredients : pizza.pizzaIngredients) {
		  priceForOnePizza += pizzaIngredients.getIngredientPrice();
		}
		for (PizzaBases pizzaBases : pizza.pizzaBases) {
		  priceForOnePizza += pizzaBases.getPizzaBasePrice();
		}					
		System.out.println("��������: " + pizza.getPizzaName());
		System.out.print("--------------------------------");
		System.out.print(pizza.pizzaBases.toString().replaceAll(",|\\[|\\]|end", ""));
		System.out.println(pizza.pizzaIngredients.toString().replaceAll(",|\\[|\\]|end", ""));
		System.out.println("--------------------------------");
		System.out.println("�����:" + priceForOnePizza + "$");
		System.out.println("���-��:" + pizza.countOfPizzas);
		System.out.println("--------------------------------");
		priceForOnePizza *= pizza.countOfPizzas;
		totalAmountPrice += priceForOnePizza;
	  }
	System.out.println("����� �����:" + totalAmountPrice + "$");
	System.out.println("********************************");	
	System.out.println("ыввывыфвывыввыыв");
	return super.toString();
  }

}
