package exceptions;

public class MyException extends Exception {
	
  double number;
  String message;
	
  public MyException(double number, String message) {
	super();
	this.number = number;
	this.message = message;
  }	
	
  @Override
  public String toString() {
	return message + " " + number;
  }

}
