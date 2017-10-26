package Customer;

public class PersonalCustomer extends Customer {
	
	private int creditCardNumber;
	
	public void setCreditCardNumber(int creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	
	public int getCreditCardNumber() {
		return creditCardNumber;
	}
}
