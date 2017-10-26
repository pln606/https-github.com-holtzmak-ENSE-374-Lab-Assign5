import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Paths;

import Customer.Customer;
import Customer.PersonalCustomer;
import Customer.CorporateCustomer;
import Order.Order;
import Order.OrderLine;
import Order.Product;


public class OrderApplication {

	private static boolean importCatalogue(LinkedList products) throws IOException {

		String name = "null";
		Double price = 0.00;
		int productID = -1;

		System.out.println("Importing Product Catalogue, please wait a moment...");

		try {
			Scanner scanIn = new Scanner(Paths.get("productList.csv")).useDelimiter("\\|+");

			while (scanIn.hasNext())
			{
				if (scanIn.hasNextLine() == true)
				{
					name = scanIn.next().replaceAll("\\n", "|");
					price = Double.parseDouble(scanIn.next().replaceAll("\\n", "|"));
					productID = Integer.parseInt(scanIn.next().replaceAll("\\n", "|"));

					products.add(new Product(name, price, productID));
				}
			}

			System.out.println("Product Catalogue complete, opening Order System. Please wait a moment...");

			scanIn.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;
	}

	public static boolean createOrder(LinkedList products, Customer customer) {

		Scanner scanIn = new Scanner(System.in);
		int productID = -1;
		int quantity = 0;

		System.out.println("Welcome to the Order System.");
		System.out.println("Please enter the productID you are looking for: ");
		productID = scanIn.nextInt();

		System.out.println("Please enter amount of products you are looking for: ");
		quantity = scanIn.nextInt();

		ListIterator<Product> listIterator = products.listIterator();
		while (listIterator.hasNext()) {
			if (listIterator.next().getProductID() == productID) {
				Order newOrder = new Order(listIterator.next(), quantity, customer);
				customer.createOrder(newOrder);
			}
		}

		return true;
	}

	public static void main(String args[]) {

		try {
			LinkedList<Product> products = new LinkedList<Product>();
			
			if(importCatalogue(products) == true) {

				Scanner scanIn = new Scanner(System.in);

				char choice = 0;
				int creditCardNumber = 0;
				String name = "null";
				String address = "null";
				String contactName = "null";
				float creditRating = 0;
				float discountRating = 0;
				Double price = 0.00;

				System.out.println("Welcome to the Order Application.\nAre you a personal (P) or corporate customer (C)? ");
				choice = scanIn.next().charAt(0);

				switch (choice)
				{
				case 'P':
					System.out.println("Please enter your credentials\n What is your credit card number?");
					creditCardNumber = scanIn.nextInt();
					System.out.println("What is your name?");
					name = scanIn.next();
					System.out.println("What is your address?");
					address = scanIn.next();
					System.out.println("What is your creditRating?");
					creditRating = scanIn.nextFloat();
					System.out.println("What is your discountRating?");
					discountRating = scanIn.nextFloat();

					PersonalCustomer personalCustomer = new PersonalCustomer(creditCardNumber, name, address, creditRating, discountRating);

					System.out.println("Would you like to place an order? (Y/N) ");
					choice = scanIn.next().charAt(0);

					switch (choice)
					{
					case 'Y':
						createOrder(products, personalCustomer);
						break;

					default: 
						break;
					}
					
					System.out.println("Proceeding to checkout. One moment please... ");
					
					ListIterator<Order> listIterator = personalCustomer.getOrders().listIterator();
					while (listIterator.hasNext()) {
						price += listIterator.next().calculatePrice();
					}
					
					System.out.println("Your order total comes to: $" + price);
					

					break;

				case 'C':
					System.out.println("Please enter your credentials\n What is your contact name?");
					contactName = scanIn.next();
					System.out.println("What is your name?");
					name = scanIn.next();
					System.out.println("What is your address?");
					address = scanIn.next();
					System.out.println("What is your creditRating?");
					creditRating = scanIn.nextFloat();
					System.out.println("What is your discountRating?");
					discountRating = scanIn.nextFloat();

					CorporateCustomer corporateCustomer = new CorporateCustomer(contactName, name, address, creditRating, discountRating);

					System.out.println("Would you like to place an order? (Y/N) ");
					choice = scanIn.next().charAt(0);

					switch (choice)
					{
					case 'Y':
						createOrder(products, corporateCustomer);
						break;

					default: 
						break;
					}

					break;

				default: 
					break;
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.gc();
	}
}
