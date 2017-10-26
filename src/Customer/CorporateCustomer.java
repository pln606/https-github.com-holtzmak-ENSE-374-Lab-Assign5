package Customer;

public class CorporateCustomer extends Customer {
	
	private String contactName;
	
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
