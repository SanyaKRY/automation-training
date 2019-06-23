package fundamentals.maintask;

public enum PizzaBases {
	
  ORDINARY("Ordinary", "                    ", 1), CALSONE("Calzone", "                     ", 1.5);	
	
  String pizzaBaseName;
  String spaceBar;     //не несет смысловой нагрузки, создана только  для части 3, внешнего вида
  double pizzaBasePrice;	
	
  PizzaBases(String pizzaBaseName, String spaceBar, double pizzaBasePrice) {	
	this.pizzaBaseName = pizzaBaseName;
	this.spaceBar = spaceBar;
	this.pizzaBasePrice = pizzaBasePrice;	
  }

  public String getPizzaBaseName() {
	return pizzaBaseName;
  }

  public double getPizzaBasePrice() {
	return pizzaBasePrice;
  }
	
  static PizzaBases getPizzaBase(String name) {
	for (PizzaBases pizzaBase : values()) {
	  if (pizzaBase.getPizzaBaseName().equals(name)) {
		return pizzaBase;
	  }
	}
	throw new IllegalArgumentException("incorrect value: " + name);
  }
	
  @Override
  public String toString() {
	return "\n" + pizzaBaseName + spaceBar + pizzaBasePrice + "$";
  }

}
