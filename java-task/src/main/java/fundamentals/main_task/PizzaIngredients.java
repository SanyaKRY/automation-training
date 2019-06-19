package main_task;

public enum PizzaIngredients {
	
	TOMATO_PASTE("Tomato Paste", "                ", 1), CHEESE("Cheese", "                      ", 1),
	SALAMI("Salami", "                      ", 1.5), BACON("Bacon", "                       ", 1.2),
	GARLIC("Garlic", "                      ", 0.3), CORN("Corn", "                        ", 0.7),
	PEPPERONI("Pepperoni", "                   ", 0.6), OLIVES("Olives", "                      ", 0.5);
	
	String ingredientName;
	String spaceBar;     //не несет смысловой нагрузки, создана только  для части 3, внешнего вида 
	double ingredientPrice;
	
	private PizzaIngredients(String ingredientName, String spaceBar, double ingredientPrice) {	
		this.ingredientName = ingredientName;
		this.spaceBar = spaceBar;
		this.ingredientPrice = ingredientPrice;	
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public double getIngredientPrice() {
		return ingredientPrice;
	}
	
	static PizzaIngredients getIngredient(String name) {
		for (PizzaIngredients pizzaIngredient : values()) {
			if (pizzaIngredient.getIngredientName().equals(name)) {
				return pizzaIngredient;
			}
		}
		throw new IllegalArgumentException("incorrect value: "+name);
	}
	
	@Override
	public String toString() {
		return "\n"+ingredientName+spaceBar+ingredientPrice+"$";
	}

}
