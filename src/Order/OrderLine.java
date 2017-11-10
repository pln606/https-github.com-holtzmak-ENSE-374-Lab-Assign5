/*
 * OrderLine.java
 *
 * DESCRIPTION:
 * Class OrderLine for Lab Assignment 5
 *
 * ENSE 374-092 Lab Assignment 5
 * 
 * @author Kelly Holtzman
 * I.D.: 200366225
 */

package Order;

public class OrderLine {
	/* Class OrderLine holds the variables for an OrderLine
	 */
	
	private Product product;
	private Double price;
	private int quantity;
	
	/**
	 * @param product
	 * 		the Product in the OrderLine
	 * @param price
	 * 		the price of the Product in the OrderLine
	 * @param quantity
	 * 		the quantity of a Product in the OrderLine
	 **/
	
	public OrderLine(Product product, Double price, int quantity) {
		setProduct(product);
		setPrice(price);
		setQuantity(quantity);
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getQuantity() {
		return quantity;
	}
}
