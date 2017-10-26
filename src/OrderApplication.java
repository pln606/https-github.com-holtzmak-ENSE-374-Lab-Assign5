import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import Customer.Customer;
import Order.Order;
import Order.OrderLine;
import Order.Product;


public class OrderApplication {
	
	public boolean createOrder() {
	
		Scanner scanIn = new Scanner(System.in);
		int productID = -1;
		int quantity = 0;
		
		System.out.println("Please enter the productID you are looking for: ");
		productID = scanIn.nextInt();
		
		System.out.println("Please enter amount of products you are looking for: ");
		quantity = scanIn.nextInt();
		
		ListIterator<Product> listIterator = products.listIterator();
		while (listIterator.hasNext()) {
			if (listIterator.next().getProductID() == productID) {
				Order newOrder = new Order(listIterator.next(), quantity);
			}
		}
		
		return true;
	}
}
