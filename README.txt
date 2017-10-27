ENSE 374-092 Lab Assignment #4, “Read Me” file for Documentation  10/27/2017

REPOSITORY NOTES
————————————————

-   The entirety of Assignment #4 files are located in the master branch
-   The Product list is implemented as a list of Pharmaceuticals, found in the productList.csv file.

GENERAL USAGE NOTES
———————————————————

1.) Assignment

-   This OrderApplication has been implemented as per the design of the UML Diagram "SimpleOrderClassDiagram" and Sequence Diagram "SimpleOrderSequenceDiagram" that were included for Assignment #4.
-   The "SimpleOrderClassDiagram" was modified during the course of coding the program to account for logical changes.
	
	The changes to the classes in "SimpleOrderClassDiagram" are as follows (getter and setter methods 
	were added by default):

		1.  Class Product
			-   Now includes an argument constructor for ease of use.
		
		2.  Class OrderLine
			-   No changes were made.
			
		3.  Class Order
			-   Now includes a list of OrderLines under the logic that an order may 
			include many Products, and each Product is a line in the order. The 
			OrderLine of an order may be changed, but the products in the Product 
			Catalogue should not. The Products list implemented in OrderApplication
			is the list used by the program to be the ProductCatalogue.
			-   Includes an argument constructor to create an OrderLine, and to 
			add that OrderLine to the Order.
			-   Includes a variable Customer to link the order to a specific Customer.
			
		4.  Class PersonalCustomer
			-   Now includes an argument constructor to create an instance of a 
			PersonalCustomer, also includes a call to the superclass, Class Customer, 
			and its constructor.
			
		5.  Class CorporateCustomer
			-   Now includes an argument constructor to create an instance of a 
			CorporateCustomer, also includes a call to the superclass, Class Customer, 
			and its constructor.
			
		6.  Class Customer
			-   Now includes a list of Orders under the logic that a customer may 
			make many orders.
			-   Includes an argument constructor for ease of use.
			
		7.  Class OrderApplication
			-   Updated to include the public method checkoutCustomer to generalize the 
			process of processing a customer's payment.
			
		8. Class ProductCatalogue
			-   Now changed to a list of Products created and destroyed in main.
			-   This was done under the logic that the Product Catalogue shouldn't be 
			modified in main as a real product catalogue shouldn't be modified by the system that uses it.
	
2.) Requirements
	
-   The site used for revision control on this assignment is GitHub.
-   All the code and files for this assignment were made using the Eclipse IDE, available at https://www.eclipse.org/.
		
	
INSTALL INFORMATION
———————————————————

-   Please ensure you have a Java Developer Kit (JDK) installed on your
    system to build/run these .java files.
-   Please run these files from a terminal/command line/IDE on your system.
-   To download the code here for your own use, please follow the below instructions:

	1.) CLick the big green "Clone or download" button to the right side of your window.
	2.) Download these files into your local repository, or,
	3.) Copy the HTTPS link and checkout these files through your local repository 
	    as a remote repository

—————————————————————————————————————————————————————————————————————————————
—————————————————————————————————————————————————————————————————————————————

AUTHOR
———————

Kelly Holtzman
University of Regina
I.D.: 200366225.
E-mail: holtzmak@uregina.ca
———————————————————————————
