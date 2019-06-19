package main_task;

public class Sweet implements Comparable<Sweet> {
	
	int sweetPrice;
	int sweetWeight;
	String sweetColor;
	int amountOfSugarInSweet;
	
	public Sweet(int sweetPrice, int sweetWeight, String sweetColor, int amountOfSugarInSweet) {
		this.sweetPrice = sweetPrice;
		this.sweetWeight = sweetWeight;
		this.sweetColor = sweetColor;
		this.amountOfSugarInSweet = amountOfSugarInSweet;
	}
		
	public int getSweetPrice() {
		return sweetPrice;
	}

	public int getSweetWeight() {
		return sweetWeight;
	}

	public String getSweetColor() {
		return sweetColor;
	}

	public int getAmountOfSugarInSweet() {
		return amountOfSugarInSweet;
	}

	@Override
	public String toString() {
		return "price: "+sweetPrice+" weight: "+sweetWeight+" colour: "+
	    sweetColor+" sugar: "+amountOfSugarInSweet;
	}
	@Override
	public int compareTo(Sweet sweet) {
		int result = sweetWeight - sweet.sweetWeight;
		if (result != 0) 
			return (int) result / Math.abs(result);		
		return 0;
	}

}
