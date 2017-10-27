package Order;

import Customer.Customer;
import java.util.Date;
import java.util.LinkedList;

public class Order {
	
	LinkedList<OrderLine> orderList = new LinkedList<OrderLine>();
	private Customer customer;
	private Date dateReceived;
	private Double price;
	private int orderID;
	
	public Order(Product product, int quantity, Customer customer) {
		OrderLine orderline = new OrderLine(product, product.getPrice(), quantity);
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
		setPrice(0.00);
		Double productPrice = 0.00;
		int productQuantity = 0;
		
		for (int i = 0; i < orderList.size(); i++) {
			productPrice = orderList.get(i).getPrice();
			productQuantity = orderList.get(i).getQuantity();
			
			setPrice(getPrice() + (productPrice * productQuantity));
		}
		
		setPrice(getPrice() * getCustomer().getDiscountRating());
		
		return getPrice();
	}
}
