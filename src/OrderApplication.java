/*
 * OrderApplication.java
 *
 * DESCRIPTION:
 * Class OrderApplication for Lab Assignment 5
 *
 * ENSE 374-092 Lab Assignment 5
 * 
 * @author Kelly Holtzman
 * I.D.: 200366225
 */

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Random;
import java.util.Date;
import java.io.File;
import java.io.IOException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import Customer.*;
import Order.*;


public class OrderApplication {
	/* Class OrderApplication imports a list of Products, the productCatalogue, through 
	 * importCatalogue. The OrderApplication then stores Products from the productCatalogue into OrderLines 
	 * of a Customer's Order made by createOrder, depending on the productID the Customer is searching for.
	 * 
	 * Class OrderApplication will then proceed to checkoutCustomer, depending on the Customer, will 
	 * proceed to place the Order(s) using the Customer's information. An orderID is generated for all
	 * Orders placed at the same time.
	 */

	private static boolean importCatalogue(LinkedList<Product> productCatalogue) throws IOException {

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
					scanIn.nextLine();    // Consumes extra line break as per pattern

					productCatalogue.add(new Product(name, price, productID));
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

	public static boolean createOrder(LinkedList<Product> productCatalogue, Customer customer) {

		Scanner scanIn = new Scanner(System.in);

		int productID = -1;
		int quantity = -1;
		int numOrders = 0;
		char choice = 0;
		
		Order newOrder = new Order(customer);

		System.out.println("Welcome to the Order System.");
		System.out.println("Below is the list of products in the catalogue.");

		for (int i = 0; i < productCatalogue.size(); i++) {
			System.out.println("Name: " + productCatalogue.get(i).getName() + " Price: $" + productCatalogue.get(i).getPrice() + " Product ID: " + productCatalogue.get(i).getProductID());
		}

		System.out.println("How many orders would you like to place?");
		numOrders = scanIn.nextInt();

		for (int i = 0; i < numOrders; i++) {
			System.out.println("Please enter the productID you are looking for: ");
			productID = scanIn.nextInt();

			System.out.println("Please enter amount of products you are looking for: ");
			quantity = scanIn.nextInt();

			for (int j = 0; j < productCatalogue.size(); j++) {
				if (productCatalogue.get(j).getProductID() == productID) {
					OrderLine newOrderLine = new OrderLine(productCatalogue.get(j), productCatalogue.get(j).getPrice(), quantity);
					newOrder.setOrderLine(newOrderLine);
				}
			}
			
			customer.createOrder(newOrder);
		}
		
		LinkedList<Order> numCustOrders = customer.getOrders();
		System.out.println("The products placed for order are:");
		
		for (int i = 0; i < numCustOrders.size(); i++) {
			LinkedList<OrderLine> numCustOrderLines = numCustOrders.get(i).getOrderLine();
			System.out.println("Name: " + numCustOrderLines.get(i).getProduct().getName() + " Product ID: " + numCustOrderLines.get(i).getProduct().getProductID() + " Quantity: " + numCustOrderLines.get(i).getQuantity());
		}
		
		System.out.println("Before proceeding to checkout, do you need to change you order? (y/n)");
		choice = scanIn.next().charAt(0);
		
		switch (choice)
		{
			case 'y':
				System.out.println("What would you like to change? Remove an order (r) or change how many have been ordered (c) ");
				choice = scanIn.next().charAt(0);
				
				switch (choice)
				{
					case 'r':
						System.out.println("What is the ID of the product you would like to remove?");
						productID = scanIn.nextInt();
						
						for (int i = 0; i < numCustOrders.size(); i++) {
							if (numCustOrders.get(i).modifyOrder(productID) == true) {
								System.out.println("The product has been removed.");
							}
						}
						
						break;
					case 'c':
						System.out.println("What is the ID of the product you would like to change?");
						productID = scanIn.nextInt();
						System.out.println("What amount would you like to order?");
						quantity = scanIn.nextInt();
						
						for (int i = 0; i < numCustOrders.size(); i++) {
							if (numCustOrders.get(i).modifyOrder(productID, quantity) == true) {
								System.out.println("The product quantity has been changed.");
							}
						}
						
						break;
					default:
						System.out.println("You have cancelled changing your order.");
						break;
						
				}
				break;
			default:
				System.out.println("You have chosen not to change anything.");
				break;
				
		}
		

		scanIn.close();
		return true;
	}

	public static void checkoutCustomer(Customer customer) {

		NumberFormat formatter = new DecimalFormat("#0.00");

		Random random = new Random(); 
		int randomInt = random.nextInt(999999);

		LinkedList<Order> numCustOrders = customer.getOrders();
		
		Double price = 0.00;

		System.out.println("Proceeding to checkout. One moment please... ");
		System.out.println("The products placed for order are:");
		
		for (int i = 0; i < numCustOrders.size(); i++) {
			if (numCustOrders.get(i).getOrderLine() != null && numCustOrders.get(i).getOrderLine().isEmpty() == false) {
				LinkedList<OrderLine> numCustOrderLines = numCustOrders.get(i).getOrderLine();
				System.out.println("Name: " + numCustOrderLines.get(i).getProduct().getName() + " Product ID: " + numCustOrderLines.get(i).getProduct().getProductID() + " Quantity: " + numCustOrderLines.get(i).getQuantity());
			}
		}

		for (int i = 0; i < numCustOrders.size(); i++) {
			if (numCustOrders.get(i) != null) {
				price = price + numCustOrders.get(i).calculatePrice();
			}
		}

		System.out.println("Your order total comes to: $" + formatter.format(price));

		if (customer.getClass().equals(PersonalCustomer.class)) {
			// Confirms the type of Customer using polymorphism
			System.out.println("Paying with credit card number: " + ((PersonalCustomer) customer).getCreditCardNumber());
		} 

		if (customer.getClass().equals(CorporateCustomer.class)) {
			// Confirms the type of Customer using polymorphism
			System.out.println("Sending invoice to: " + ((CorporateCustomer) customer).getContactName());
		}

		for (int i = 0; i < numCustOrders.size(); i++) {
			if (numCustOrders.get(i) != null) {
				numCustOrders.get(i).setOrderID(randomInt);    // Generated a random orderID
			}
		}

		System.out.println("Your order's ID is: " + randomInt);

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();    // Use's the Customer's current time for placement of Order

		for (int i = 0; i < numCustOrders.size(); i++) {
			if (numCustOrders.get(i) != null) {
				numCustOrders.get(i).setDateReceived(date);
			}
		}

		System.out.println("Your order was placed on: " + dateFormat.format(date));
	}

	public static void main(String args[]) {

		try {
			LinkedList<Product> productCatalogue = new LinkedList<Product>();

			if(importCatalogue(productCatalogue) == true) {

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

					if(createOrder(productCatalogue, personalCustomer) == true) {
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

					if(createOrder(productCatalogue, corporateCustomer) == true) {
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
