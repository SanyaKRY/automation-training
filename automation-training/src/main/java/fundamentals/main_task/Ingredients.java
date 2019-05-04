package main_task;

public enum Ingredients {
	TOMATO_PASTE("Tomato Paste",1), CHEESE("Cheese",1), SALAMI("Salami",1.5), BACON("Bacon",1.2), GARLIC("Garlic",0.3),
	CORN("Corn",0.7), PEPPERONI("Pepperoni",0.6), OLIVES("Olives",0.5);	
	String ingredient;
	double price;
	
	public String getIngredient() {
		return ingredient;
	}		
	public double getPrice() {
		return price;
	}
	
	private Ingredients(String ingredient,double price) {		
		this.price=price;	
		this.ingredient=ingredient;			
	}
	
	static Ingredients addIngredient(String name) {
		for (Ingredients ingredient : values()) {
			if (ingredient.getIngredient().equals(name)) {
				return ingredient;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {		
		return ingredient+"           "+price+"$"+"\n";
	}
}

