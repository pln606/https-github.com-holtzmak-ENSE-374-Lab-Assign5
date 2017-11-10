/*
 * CorporateCustomer.java
 *
 * DESCRIPTION:
 * Class CorporateCustomer for Lab Assignment 5
 *
 * ENSE 374-092 Lab Assignment 5
 * 
 * @author Kelly Holtzman
 * I.D.: 200366225
 */

package Customer;

public class CorporateCustomer extends Customer {
	/* Class CorporateCustomer extends Class Customer
	 * It holds the variables for a CorporateCustomer
	 */
	
	private String contactName;
	
	/**
	 * @param contactName
	 * 		the CorporateCustomer's contact name
	 * 
	 **/
	
	public CorporateCustomer(String contactName, String name, String address, float creditRating, float discountRating) {
		super(name, address, creditRating, discountRating);
		setContactName(contactName);
	}
	
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	
	public String getContactName() {
		return contactName;
	}
}
