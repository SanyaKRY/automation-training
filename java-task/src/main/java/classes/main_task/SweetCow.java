package main_task;

public class SweetCow extends Sweet {
	
	String nameSweet = "Cow";

	public SweetCow(int sweetPrice, int sweetWeight, String sweetColor, int amountOfSugarInSweet) {
		super(sweetPrice, sweetWeight, sweetColor, amountOfSugarInSweet);
	}
	
	@Override
	public String toString() {
		return "nameSweet: "+nameSweet+"price: "+sweetPrice+" weight: "+sweetWeight+" colour: "+
			    sweetColor+" sugar: "+amountOfSugarInSweet;
	}

}
