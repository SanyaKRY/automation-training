package classes.maintask;

public class SweetRocket extends Sweet {
	
  String nameSweet = "Rocket";
  
  public SweetRocket(int sweetPrice, int sweetWeight, String sweetColor, int amountOfSugarInSweet) {
	super(sweetPrice, sweetWeight, sweetColor, amountOfSugarInSweet);
  }
	
  @Override
  public String toString() {
	return "nameSweet: " + nameSweet + "price: " + sweetPrice + " weight: " + sweetWeight + " colour: " + 
        sweetColor + " sugar: " + amountOfSugarInSweet;
  }

}
