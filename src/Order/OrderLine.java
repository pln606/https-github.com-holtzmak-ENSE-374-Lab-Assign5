package Order;

public class OrderLine {
	
	private Product product;
	private Double price;
	private int quantity;
	
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
