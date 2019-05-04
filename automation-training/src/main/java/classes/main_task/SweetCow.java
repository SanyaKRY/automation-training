package main_task;

public class SweetCow extends Sweet{
	String nameSweet="Cow";

	public SweetCow(int price, int weight, String colour, int sugar) {
		super(price, weight, colour,sugar);
	}
	@Override
	public String toString() {
		return "nameSweet: "+nameSweet+" price: "+price+" weight: "+weight+" colour: "+colour+" sugar: "+sugar;
	}

}
