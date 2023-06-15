import java.util.Scanner;
import java.text.DecimalFormat;

public class Application 
{
	// Variables
	static String[] movieTitles = {"Toy Story", "Luca", "Shrek"}; // Defining an array of string and initializing it with elements.
	static String[] showTimes = {"12:00", "15:00", "18:00"};
	
	// Defining variables for counters 
	static int numTickets = 0;
	static double totalValue = 0;
	static int totalTransactions = 0;
	static double averageCash = 0;
	
	// Defining variables for prices; 
	static double adultTicket = 9.50;
	static double teenTicket = 6.99;
	static double childTicket = 4.50;

		
	static DecimalFormat currency = new DecimalFormat("0.00"); //Instance of the DecimalFormat class and storing it in a class for currency.
	static Scanner input = new Scanner(System.in);	// Allows you to store users input
	static int adminCode = 1234; // Code for admin to get in 
	
	
	public static void main(String[] args) {
		chooseMovies();
	}
	
	public static void chooseMovies() {
		System.out.println("------------------Movies------------------");
	    System.out.println("Choose a movie: ");
	    
	    for (int i = 0; i < movieTitles.length; i++) { // A loop that allows stored data to be used
    		
	    	System.out.println((i + 1) + ". " + movieTitles[i]); // Displays movies from the array loop
	    }
			System.out.println("------------------------------------------");
			
			int choice = input.nextInt(); //Capture User Choice
			
			switch(choice) {
			
				case 1: {
						chooseTime(movieTitles[choice-1]);
						break; // Used to exit a loop or a switch statement
					}
				case 2: {
						chooseTime(movieTitles[choice-1]);
						break;
					}
				case 3:	{
						chooseTime(movieTitles[choice-1]);
						break;
					}
				
				case 99: {
					// Input for the admin
					System.out.println("Enter Admin PIN:");
					int enteredPIN = input.nextInt();
					// If correct pin is used access is granted
					if (enteredPIN==adminCode) {
						System.out.println("Correct PIN. Entering Admin mode.");
							admin();
					}
					
					else {
						System.out.println("Incorrect PIN. Try again.");
					}
					
						break;
				}	
				// If non of these options are picked it resets with a message
				default: {
				System.out.println("Invalid choice. Please try again");
				break;
				}
					
			}
			chooseMovies();
		}
	
	public static void chooseTime(String movie) {
		System.out.println("------------------Times-------------------");
		System.out.println("Choose a time:");
		 
		 for (int i = 0; i < showTimes.length; i++) {
			    System.out.println((i + 1) + ". " + showTimes[i]);
		 }
		System.out.println("------------------------------------------");
	
		int choice = input.nextInt(); //Capture User Choice
		
		switch(choice) {
		
			case 1: {
					// Uses array loop to show times
					chooseTickets(movie,showTimes[choice-1]);
					break;
				}
			
			case 2:	{
					chooseTickets(movie,showTimes[choice-1]);
					break;
				}
			
			case 3:	{
					chooseTickets(movie,showTimes[choice-1]);
					break;
				}
			
			default: {
				System.out.println("Invalid choice. Please try again");
				break;
			}
		}
	}
	
	public static void chooseTickets(String movie, String time) {
		// Gives user to pick ticket type
		System.out.println("-------------Ticket Type-------------");
		System.out.println("Choose a ticket type: ");
	    System.out.println("1. Adult (€" + currency.format(adultTicket) + ")");
	    System.out.println("2. Teen (€" + currency.format(teenTicket) + ")");
	    System.out.println("3. Child (€" + currency.format(childTicket) + ")");
		System.out.println("-------------------------------------");

		int choice = input.nextInt();
		
		// Gives user to pick ticket type
		switch(choice) {
			case 1: {
				
				adultTicketQuanity();			
			    break;
			}
			
			case 2: {
				teenTicketQuanity();			
				break;
			}
			
			case 3: {
				childTicketQuanity();			
				break;
			}
			
			default: {
				System.out.println("Invalid choice. Please try again");
				break;
			}
			
		}
		
	}
	
	public static void adultTicketQuanity() {
		 System.out.println("-------------------------------------");
		 System.out.println("Choose a quantity: ");
		 System.out.println("-------------------------------------");

		 int quantity = input.nextInt();
		
		 // Creates a number for total price
		 double price = quantity * 9.50;
		 
		 // displays transaction total price
		 System.out.println("-------------------------------------");
		 System.out.println("Transaction Price = €" + currency.format(price));
		 System.out.println("Please enter your payment");
		 System.out.println("-------------------------------------");

			
			double moneyEntered = input.nextDouble(); //Holds money entered into machine
			
			// Payment method
			while(moneyEntered<price) {

				double balance = price - moneyEntered;
				
				System.out.println("-------------------------------------");
				System.out.println("Balance Remaining: " + currency.format(balance));
				System.out.println("Please enter remaining balance.");
				System.out.println("-------------------------------------");
				
				moneyEntered = moneyEntered + input.nextDouble();
			}
			// Gives change if users money is over price	
			if(moneyEntered>price)
			{
				double change = moneyEntered - price;
				System.out.println("Change due: " + currency.format(change));
				System.out.println("-------------------------------------");

			    // updates the total number of tickets and the total number of transactions
				totalTransactions++;
				numTickets++;
				
				totalValue = totalValue+price;
			    double totalCost = totalValue/totalTransactions;
			    
			    // calculates and print average cash per transaction
				 System.out.println("Total value of transactions: €" + totalValue);
				 System.out.println("Total number of transactions: " + totalTransactions);
				 System.out.println("Average cash per transaction: €" + totalCost);
			}
			
			System.out.println("-------------------------------------");
			System.out.println("Transaction Successful. Please take your Tickets.");	
			System.out.println();

		}
	
	public static void teenTicketQuanity() {
		
		 System.out.println("-------------------------------------");
		 System.out.println("Choose a quantity: ");
		 System.out.println("-------------------------------------");

		 int quantity = input.nextInt();
		
		 double price = quantity * 6.99;
		 
		 System.out.println("-------------------------------------");
		 System.out.println("Transaction Price is " + currency.format(price));
		 System.out.println("Please enter payment");
	   	 System.out.println("-------------------------------------");

		 double moneyEntered = input.nextDouble(); //Holds money entered into machine
			
		 	while(moneyEntered<price) {

		 		double balance = price - moneyEntered;
				
				System.out.println("-------------------------------------");
		 		System.out.println("Balance Remaining: " + currency.format(balance));
		 		System.out.println("Please enter remaining balance.");
				System.out.println("-------------------------------------");
				
		 		moneyEntered = moneyEntered + input.nextDouble();
		 		}
			
		 	
		 	if(moneyEntered>price) {
				double change = moneyEntered - price;
				System.out.println("Change due: " + currency.format(change));
				System.out.println("-------------------------------------");

				totalTransactions++;
				numTickets++;
				
				totalValue = totalValue+price;
				 
			    double totalCost = totalValue/totalTransactions;
				 System.out.println("Total value of transactions: €" + totalValue);
				 System.out.println("Total number of transactions: " + totalTransactions);
				 System.out.println("Average cash per transaction: €" + totalCost);
				
			}
		 	
			System.out.println("-------------------------------------");
			System.out.println("Transaction Successful. Please take your Tickets.");				
			
		}
	
		


	
	public static void childTicketQuanity() {
		System.out.println("-------------------------------------");
		 System.out.println("Choose a quantity: ");
		 System.out.println("-------------------------------------");
		 int quantity = input.nextInt();
		
		 
		 double price = quantity * 4.50;

				System.out.println("-------------------------------------");
			 	System.out.println("Transaction Price is " + currency.format(price));
				System.out.println("Please enter payment");
				System.out.println("-------------------------------------");

			double moneyEntered = input.nextDouble(); //Holds money entered into machine
			
				while(moneyEntered<price) {

					double balance = price - moneyEntered;

					System.out.println("-------------------------------------");
					System.out.println("Balance Remaining: " + currency.format(balance));
					System.out.println("Please enter remaining balance.");
					System.out.println("-------------------------------------");
				
					moneyEntered = moneyEntered + input.nextDouble();
				}
						
				if(moneyEntered>price) {
					
					double change = moneyEntered - price;
					System.out.println("Change due: " + currency.format(change));
					System.out.println("-------------------------------------");
				
					totalTransactions++;
					numTickets++;
					
					totalValue = totalValue+price;
					
			  	    double totalCost = totalValue/totalTransactions;  
			    	System.out.println("Total value of transactions: €" + totalValue);
					System.out.println("Total number of transactions: " + totalTransactions);
				 	System.out.println("Average cash per transaction: €" + totalCost);
				}
			System.out.println("-------------------------------------");
			System.out.println("Transaction Successful. Please take your Tickets.");				
		}

	public static void admin()
	{ 	// Admin mode
		System.out.println("---------------admin mode-----------------");
		System.out.println("Press 1 to change the price of the Tickets");
		System.out.println("Press 2 to view stats");
		System.out.println("Press 3 to exit Admin Mode");
		System.out.println("------------------------------------------");
		
		String choice = input.next();
			
		switch(choice)
		{
			case "1": {
				changePrice();
				break;
			}
			
			case "2": {
				viewStats();
				break;
			}
			
			case "3": {
				chooseMovies();
				break;
			}
			
		}
	}
	
	public static void viewStats() {
		// Allows user to check stats
		System.out.println("------------------stats-------------------");
		System.out.println("Total Transactions made: " + totalTransactions);
		System.out.println("Total sales: €" + currency.format(totalValue));
		System.out.println("------------------------------------------");
		admin();
	}

	public static void changePrice() {
		// Allows user to change ticket prices
		System.out.println("---------------admin mode-----------------");
		System.out.println("1. Change price of Adult Ticket");
		System.out.println("2. Change price of Teen Ticket");
		System.out.println("3. Change price of Child Ticket");
		System.out.println("4. To return to admin");
		System.out.println("------------------------------------------");
		String choice =input.next();
		
		switch(choice) {
		
			case "1": {
				System.out.println("Adult " + currency.format(adultTicket));
				adultTicket = input.nextDouble();
				System.out.println("Price changed to " + currency.format(adultTicket));
				changePrice();
			}
			
			case "2": {
				System.out.println("Teen " + currency.format(teenTicket));
				teenTicket = input.nextDouble();
				System.out.println("Price changed to " + currency.format(teenTicket));
				changePrice();
			}
			
			case "3": {
				System.out.println("Child " + currency.format(childTicket));
				childTicket = input.nextDouble();
				System.out.println("Price changed to " + currency.format(childTicket));
				changePrice();
			}
			
			case "4" : {
				admin();
				
			}
			
			default:
			{
				System.out.println("Invalid choice. Returning to Admin Mode.");
				admin();
			}	
			
		}
	}
	
	public static void convertData() {
		
		double value = 10.55;
		String stringValue = Double.toString(value); // Converts double into a String
		
		String number = "50";
		int intNumber = Integer.parseInt(number); // Converts a String into a integer
		
	}
		
	
}
