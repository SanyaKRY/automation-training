package main_task;

public enum BaseForPizza {
	ORDINARY("Ordinary",1), CALSONE("Calzone",1.5);	
	String baseForPizza;
	double price;
	
	public String getBaseForPizza() {
		return baseForPizza;
	}	
	public double getPrice() {
		return price;
	}
	
	private BaseForPizza(String baseForPizza,double price) {		
		this.price=price;
		this.baseForPizza=baseForPizza;		
	}	
	
	static BaseForPizza addBase(String name) {
		for (BaseForPizza base : values()) {
			if (base.getBaseForPizza().equals(name)) {
				return base;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		return "\n"+getBaseForPizza()+"               "+price+"$";
	}
}

