package Order;

import java.util.Date;
import java.util.LinkedList;
import java.util.ListIterator;

public class Order {
	
	LinkedList<OrderLine> orderList = new LinkedList<OrderLine>();
	private Date dateReceived;
	private Double price;
	private int orderID;
	
	public Order(Product product, int quantity) {
		
		OrderLine orderline = new OrderLine(product, product.getPrice(), quantity);
		calculatePrice();
		orderList.add(orderline);
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
		
		ListIterator<OrderLine> listIterator = orderList.listIterator();
		while (listIterator.hasNext()) {
			listIterator.next().getPrice();
			listIterator.next().getQuantity();
			
		}
	}
}
