/*
 * Order.java
 *
 * DESCRIPTION:
 * Class Order for Lab Assignment 4
 *
 * ENSE 374-092 Lab Assignment 4
 * 
 * @author Kelly Holtzman
 * I.D.: 200366225
 */

package Order;

import Customer.Customer;
import java.util.Date;
import java.util.LinkedList;

public class Order {
	/* Class Order holds the variables for an Order
	 */
	
	LinkedList<OrderLine> orderList = new LinkedList<OrderLine>();
	private Customer customer;
	private Date dateReceived;
	private Double price;
	private int orderID;
	
	/**
	 * @param orderList
	 * 		the List of OrderLines in the Order, may contain zero to One Product in each line
	 * @param customer
	 * 		the Customer who created this Order
	 * @param dateReceived
	 * 		the Date the Order was received for processing
	 * @param price
	 * 		the total Price of the Order and all it's OrderLines
	 * @param orderID
	 * 		the ID of the Order for tracking purposes
	 **/
	
	public Order(OrderLine orderline, Customer customer) {
		setOrderLine(orderline);
		setCustomer(customer);
	}
	
	public void setOrderLine(OrderLine orderline) {
		orderList.add(orderline);
	}
	
	public LinkedList<OrderLine> getOrderLine() {
		return orderList;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}
	
	public void setDateReceived(Date dateReceived) {
		this.dateReceived = dateReceived;
	}
	
	public Date getDateReceived() {
		return dateReceived;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	
	public int getOrderID() {
		return orderID;
	}
	
	public Double calculatePrice() {
		setPrice(0.00);    //Initializes variables for calculation, in case of error
		Double productPrice = 0.00;
		int productQuantity = 0;
		
		for (int i = 0; i < orderList.size(); i++) {
			productPrice = orderList.get(i).getPrice();
			productQuantity = orderList.get(i).getQuantity();
			
			setPrice(getPrice() + (productPrice * productQuantity));
		}
		
		setPrice(getPrice() * (1-getCustomer().getDiscountRating()));
		
		return getPrice();
	}
}
