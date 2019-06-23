package classes.optionaltask;

public class Customer implements Comparable<Customer> {
	
  String name;
  String middleName;
  String surname;
  String address;
  int creditCardNumber;
  int bankAccountNumber;
	
  public Customer(String name, String middleName, String surname, String address, int creditCardNumber, int bankAccountNumber) {
	this.name = name;
	this.middleName = middleName;
	this.surname = surname;
	this.address = address;
	this.creditCardNumber = creditCardNumber;
	this.bankAccountNumber = bankAccountNumber;
  }
	
  public Customer() {
	name = "unknown";
	middleName = "unknown";
	surname = "unknown";
	address = "unknown";
	creditCardNumber = 99999;
	bankAccountNumber = 99999;
  }

  public String getName() {
	return name;
  }

  public void setName(String name) {
	this.name = name;
  }

  public String getMiddleName() {
	return middleName;
  }

  public void setMiddleName(String middleName) {
	this.middleName = middleName;
  }
	
  public String getSurname() {
	return name;
  }

  public void setSurname(String name) {
	this.name = name;
  }

  public String getAddress() {
	return address;
  }

  public void setAddress(String address) {
	this.address = address;
  }

  public int getCreditCardNumber() {
	return creditCardNumber;
  }

  public void setCreditCardNumber(int creditCardNumber) {
	this.creditCardNumber = creditCardNumber;
  }

  public int getBankAccountNumber() {
	return bankAccountNumber;
  }

  public void setBankAccountNumber(int bankAccountNumber) {
	this.bankAccountNumber = bankAccountNumber;
  }

  public int compareTo(Customer customer) {
	return this.name.compareTo(customer.getName());
  }	
	
  @Override
  public String toString() {
	return name + " " + middleName + " " + surname + " " + address + " " + creditCardNumber + " " + bankAccountNumber;
  }
}
