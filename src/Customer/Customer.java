package Customer;

public class Customer {
	
	private String name;
	private String address;
	private float creditRating;
	private float discountRating;
	
	public Customer() {
		this.name = "null";
		this.address = "null";
		this.creditRating = 0;
		this.discountRating = 0;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setCreditRating(float creditRating) {
		this.creditRating = creditRating;
	}
	
	public float getCreditRating() {
		return creditRating;
	}
	
	public void setDiscountRating(float discountRating) {
		this.discountRating = discountRating;
	}
	
	public float getDiscountRating() {
		return discountRating;
	}
}