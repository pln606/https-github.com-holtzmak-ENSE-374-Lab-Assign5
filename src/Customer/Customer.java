package Customer;

import java.util.LinkedList;

import Order.Order;

public class Customer {
	
	LinkedList<Order> orders = new LinkedList<Order>();
	private String name;
	private String address;
	private float creditRating;
	private float discountRating;
	
	public Customer(String name, String address, float creditRating, float discountRating) {
		setName(name);
		setAddress(address);
		setCreditRating(creditRating);
		setDiscountRating(discountRating);
	}
	
	public void createOrder(Order order) {
		orders.add(order);
	}
	
	public LinkedList<Order> getOrders() {
		return orders;
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