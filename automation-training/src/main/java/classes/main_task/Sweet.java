package main_task;

public class Sweet implements Comparable<Sweet>{
	int price;
	int weight;
	String colour;
	int sugar;
	
	public int getPrice() {
		return price;
	}

	public int getWeight() {
		return weight;
	}

	public String getColour() {
		return colour;
	}

	public int getSugar() {
		return sugar;
	}

	public Sweet(int price, int weight, String colour, int sugar) {
		this.price=price;
		this.weight=weight;
		this.colour=colour;
		this.sugar=sugar;
	}
	@Override
	public String toString() {
		return "price: "+price+" weight: "+weight+" colour: "+colour+" sugar: "+sugar;
	}
	@Override
	public int compareTo(Sweet sweet) {
		int result= weight-sweet.weight;
		if (result!=0) 
			return (int) result/Math.abs(result);		
		return 0;
	}

}
