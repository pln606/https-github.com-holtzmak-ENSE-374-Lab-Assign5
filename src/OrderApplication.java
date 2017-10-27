import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import Customer.Customer;
import Customer.PersonalCustomer;
import Customer.CorporateCustomer;
import Order.Order;
import Order.Product;


public class OrderApplication {

	private static boolean importCatalogue(LinkedList<Product> products) throws IOException {

		String name = "null";
		Double price = 0.00;
		int productID = -1;

		System.out.println("Importing Product Catalogue, please wait a moment...");

		try {
			File file = new File("productList.csv");
			Scanner scanIn = new Scanner(file);
			scanIn.useDelimiter("\\|");

			while (scanIn.hasNext())
			{
				if (scanIn.hasNextLine() == true)
				{
					name = scanIn.next();
					price = Double.parseDouble(scanIn.next());
					productID = Integer.parseInt(scanIn.next());
					scanIn.nextLine();
					
					products.add(new Product(name, price, productID));
				}
			}

			System.out.println("Product Catalogue complete, opening Order System. Please wait a moment...");

			scanIn.close();

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public static boolean createOrder(LinkedList<Product> products, Customer customer) {

		Scanner scanIn = new Scanner(System.in);
		
		int productID = -1;
		int quantity = -1;

		System.out.println("Welcome to the Order System.");
		System.out.println("Below is the list of products in the catalogue.");
		
		for (int i = 0; i < products.size(); i++) {
			System.out.println("Name: " + products.get(i).getName() + " Price: $" + products.get(i).getPrice() + " Product ID: " + products.get(i).getProductID());
		}
		
		System.out.println("Please enter the productID you are looking for: ");
		productID = scanIn.nextInt();

		System.out.println("Please enter amount of products you are looking for: ");
		quantity = scanIn.nextInt();

		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getProductID() == productID) {
				Order newOrder = new Order(products.get(i), quantity, customer);
				customer.createOrder(newOrder);
				
				scanIn.close();
				return true;
			}
		}
		
		scanIn.close();
		return false;
	}

	public static void checkoutCustomer(Customer customer) {
		
		NumberFormat formatter = new DecimalFormat("#0.00");
		
		Random random = new Random(); 
		int randomInt = random.nextInt(999999);
		
		Double price = 0.00;

		System.out.println("Proceeding to checkout. One moment please... ");

		for (int i = 0; i < customer.getOrders().size(); i++) {
			price = price + customer.getOrders().get(i).calculatePrice();
		}

		System.out.println("Your order total comes to: $" + formatter.format(price));

		if (customer.getClass().equals(PersonalCustomer.class)) {
			System.out.println("Paying with credit card number: " + ((PersonalCustomer) customer).getCreditCardNumber());
		} 

		if (customer.getClass().equals(CorporateCustomer.class)) {
			System.out.println("Sending invoice to: " + ((CorporateCustomer) customer).getContactName());
		}

		for (int i = 0; i < customer.getOrders().size(); i++) {
			customer.getOrders().get(i).setOrderID(randomInt);
		}

		System.out.println("Your order's ID is: " + randomInt);

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();

		for (int i = 0; i < customer.getOrders().size(); i++) {
			customer.getOrders().get(i).setDateReceived(date);
		}

		System.out.println("Your order was placed on: " + dateFormat.format(date));
	}

	public static void main(String args[]) {

		try {
			LinkedList<Product> products = new LinkedList<Product>();

			if(importCatalogue(products) == true) {

				Scanner scanIn = new Scanner(System.in);

				char choice = 0;
				int creditCardNumber = 0;
				float creditRating = 0;
				float discountRating = 0;
				String name = "null";
				String address = "null";
				String contactName = "null";

				System.out.println("Welcome to the Order Application.\nAre you a personal (P) or corporate customer (C)? ");
				choice = scanIn.next().charAt(0);

				switch (choice)
				{
				case 'P':
					System.out.println("Please enter your credentials\nWhat is your credit card number? (In the format XXXXXX)");
					creditCardNumber = scanIn.nextInt();
					System.out.println("What is your name? (No spaces)");
					name = scanIn.next();
					System.out.println("What is your address?");
					address = scanIn.next();
					System.out.println("What is your creditRating? (In the format XXX)");
					creditRating = scanIn.nextFloat();
					System.out.println("What is your discountRating? (In the format X.XX) ");
					discountRating = scanIn.nextFloat();

					PersonalCustomer personalCustomer = new PersonalCustomer(creditCardNumber, name, address, creditRating, discountRating);

					System.out.println("Placing an order. One moment please... ");

					if(createOrder(products, personalCustomer) == true) {
						checkoutCustomer(personalCustomer);
					}

					break;

				case 'C':
					System.out.println("Please enter your credentials\nWhat is your contact name? (No spaces)");
					contactName = scanIn.next();
					System.out.println("What is your name? (No spaces)");
					name = scanIn.next();
					System.out.println("What is your address?");
					address = scanIn.next();
					System.out.println("What is your creditRating? (In the format XXX)");
					creditRating = scanIn.nextFloat();
					System.out.println("What is your discountRating? (In the format X.XX) ");
					discountRating = scanIn.nextFloat();

					CorporateCustomer corporateCustomer = new CorporateCustomer(contactName, name, address, creditRating, discountRating);

					System.out.println("Placing an order. One moment please... ");

					if(createOrder(products, corporateCustomer) == true) {
						checkoutCustomer(corporateCustomer);
					}
					
					break;

				default:
					System.out.println("You have chosen not to input credentials. The application will now close.");
					break;
				}

				scanIn.close();

			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Ending Order Application. Have a nice day!");
		System.gc();
	}
}
