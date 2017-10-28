/*
 * Customer.java
 *
 * DESCRIPTION:
 * Class Customer for Lab Assignment 4
 *
 * ENSE 374-092 Lab Assignment 4
 * 
 * @author Kelly Holtzman
 * I.D.: 200366225
 */

package Customer;

import java.util.LinkedList;

import Order.Order;

public class Customer {
	/* Class Customer holds the variables 
	 * for a Customer.
	 */
	
	LinkedList<Order> orders = new LinkedList<Order>();
	private String name;
	private String address;
	private float creditRating;
	private float discountRating;
	
	/**
	 * @param orders
	 * 		the list of the Customer's orders, may be separate from one another
	 * @param name
	 * 		the Customer's name
	 * @param address
	 * 		the Customer's address
	 * @param creditRating
	 * 		the Customer's credit rating
	 * @param discountRating
	 * 		the Cutomer's discount rating, if any
	 **/
	
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