/*
 * PersonalCustomer.java
 *
 * DESCRIPTION:
 * Class PersonalCustomer for Lab Assignment 4
 *
 * ENSE 374-092 Lab Assignment 4
 * 
 * @author Kelly Holtzman
 * I.D.: 200366225
 */

package Customer;

public class PersonalCustomer extends Customer {
	/* Class PersonalCustomer extends Class Customer
	 * It holds the variables for a PersonalCustomer
	 */
	
	private int creditCardNumber;
	
	/**
	 * @param creditCardNumber
	 * 		the PersonalCustomer's credit card number, for payment
	 **/
	
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
