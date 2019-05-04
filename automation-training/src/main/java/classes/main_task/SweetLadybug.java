package main_task;

public class SweetLadybug extends Sweet{
	String nameSweet="Ladybug";

	public SweetLadybug(int price, int weight, String colour, int sugar) {
		super(price,weight,colour,sugar);
	}
	
	@Override
	public String toString() {
		return "nameSweet: "+nameSweet+" price: "+price+" weight: "+weight+" colour: "+colour+" sugar: "+sugar;
	}

}
