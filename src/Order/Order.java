package Order;

import Customer.Customer;
import java.util.Date;
import java.util.LinkedList;
import java.util.ListIterator;

public class Order {
	
	LinkedList<OrderLine> orderList = new LinkedList<OrderLine>();
	private Customer customer;
	private Date dateReceived;
	private Double price;
	private int orderID;
	
	public Order(Product product, int quantity, Customer customer) {
		
		OrderLine orderline = new OrderLine(product, product.getPrice(), quantity);
		calculatePrice();
		orderList.add(orderline);
		setCustomer(customer);
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
	
	public Double calculatePrice() {
		setPrice(0.00);
		
		ListIterator<OrderLine> listIterator = orderList.listIterator();
		while (listIterator.hasNext()) {
			setPrice(getPrice() + (listIterator.next().getPrice() * listIterator.next().getQuantity()));
		}
		
		setPrice(getPrice() * getCustomer().getDiscountRating());
	
		return getPrice();
	}
}
