/*
 * Product.java
 *
 * DESCRIPTION:
 * Class Product for Lab Assignment 4
 *
 * ENSE 374-092 Lab Assignment 4
 * 
 * @author Kelly Holtzman
 * I.D.: 200366225
 */

package Order;

public class Product {
	/* Class Product holds the variables for a Product
	 */
	
	private String name;
	private Double price;
	private int productID;
	
	/**
	 * @param name
	 * 		the name of the Product
	 * @param price
	 * 		the price of the Product
	 * @param productID
	 * 		the product ID of the Product
	 **/
	
	public Product(String name, Double price, int productID) {
		setName(name);
		setPrice(price);
		setProductID(productID);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setProductID(int productID) {
		this.productID = productID;
	}
	
	public int getProductID() {
		return productID;
	}
}
