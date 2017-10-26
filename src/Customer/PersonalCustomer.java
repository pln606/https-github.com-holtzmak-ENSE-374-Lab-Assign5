package Customer;

public class PersonalCustomer extends Customer {
	
	private int creditCardNumber;
	
	public PersonalCustomer(int creditCardNumber, String name, String address, float creditRating, float discountRating) {
		super(name, address, creditRating, discountRating);
		setCreditCardNumber(creditCardNumber);
	}
	
	public void setCreditCardNumber(int creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	
	public int getCreditCardNumber() {
		return creditCardNumber;
	}
}
