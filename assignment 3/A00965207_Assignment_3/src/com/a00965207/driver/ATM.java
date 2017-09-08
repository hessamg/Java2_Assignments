package com.a00965207.driver;
import com.a00965207.util.InputReader;
import com.a00965207.data.*;
import com.a00965207.accounts.*;
/**
 * ATM class, The COMP 1451 Assignment application driver. A00965207
 * 
 * @version 2016.06.27
 * @author Hessam Ganjian
 */
public class ATM {
	private InputReader reader;
	private String accountNumber;
	private String passcode;
	private boolean customerVerified;
	private boolean admin;

	private Bank theBank;
	private BankCustomer currentCustomer;
	private Account currentAccount;
	private BankReport bankReport;

	private final int GOLD_AGE = 65;

	/**
	 * Default constructor. Calls the initialize() method to seed the Bank with
	 * some BankCustomers. Calls the run() method to perform the primary program
	 * functions.
	 */
	public ATM() {
		theBank = new Bank();
		initialize();
		run();
	}

	/**
	 * Main method calls the class default constructor.
	 * 
	 * @param args
	 *            for program arguments (not used)
	 */
	public static void main(String[] args) {
		new ATM();
	}

	/**
	 * The primary application processor. All application functions are called
	 * from here. Starts by seeding the Bank class HashMap with BankCustomers,
	 * and display a menu of choices. Uses a loop to prompt users to perform
	 * banking transactions. Must use switch/case selection to determine uses
	 * choices.
	 */
	public void run() {

		reader = new InputReader();
		boolean exit = false;

		System.out.println("Welcome to Bullwinkle's Bank.");

		while (!exit) {
			System.out.println("");
			System.out.println("Choose one of the following options:");
			System.out.println("1 - Sign In");
			System.out.println("2 - Deposit");
			System.out.println("3 - Withdraw");
			System.out.println("4 - Display Account Info");
			System.out.println("5 - Exit");
			System.out.print("> ");
			int choice = reader.getIntInput();
			if (!admin) {
				switch (choice) {
				case 1:
					verifyCustomer();
					break;
				case 2:
					transactDeposit();
					break;
				case 3:
					transactWithdraw();
					break;
				case 4:
					displayAccountInformation();
					break;
				case 5:
					shutDown();
				default:
					System.out.println("KA-BOOM!!!");
					System.exit(0);
				}
			}
			while (admin) {
				System.out.println("");
				System.out.println("Hello Bank Employee.Choose one of the following options:");
				System.out.println("1 - Display By Code");
				System.out.println("2 - Display All Codes");
				System.out.println("3 - Display Inactive Codes");
				System.out.println("4 - Display Account Totals");
				System.out.println("5 - Admin Exit");
				System.out.print("> ");
				int adminChoice = reader.getIntInput();
				switch (adminChoice) {
				case 1:
					System.out.println("Which account type do you want to see (eg. use prefix gl/sa/ch)?");
					bankReport.displayByCode(theBank, reader.getStringInput());
					break;
				case 2:
					bankReport.displayAllCodes(theBank);
					break;
				case 3:
					bankReport.displayInactiveCodes(theBank);
					break;
				case 4:
					bankReport.displayAccountTotals(theBank);
					break;
				case 5:
					admin = false;
					break;
				}
			}
		}
	}

	/**
	 * Adds Customer references to the Bank HashMap as seed data for testing.
	 */
	public void initialize() {
		BankCustomer[] customers = { new BankCustomer("Darby", "Dog", "123", 35),
				new BankCustomer("Myia", "Dog", "456", 12), new BankCustomer("Freckle", "Cat", "789", 65),
				new BankCustomer("Sam", "Ganjian", "admin", 65) };

		Account[] accounts = { new SavingsAccount(100.0, "SA-123"), new ChequingAccount(50.0, "CH-123"),
				new GoldAccount(200.0, "GL-123"), new SavingsAccount(0.0, "admin") };

		for (int i = 0; i < customers.length; i++) {

			if (accounts[i] instanceof GoldAccount && customers[i].getAge() < GOLD_AGE) {

				customers[i].setAccount(new SavingsAccount(0.0, "SA-DEFAULT"));
				System.out.println("ERROR: Customer is too young to have a GoldAccount.\n"
						+ "SavingsAccount opened. Try again after your next birthday.");

			} else {
				customers[i].setAccount(accounts[i]);
			}

		}

		for (BankCustomer customer : customers) {
			theBank.createAccount(customer);
		}
		bankReport = new BankReport();
	}

	/**
	 * Performs a deposit into a BankCustomer's account. Checks to see if the
	 * user has signed in. If not, then verifyCustomer() is called and the menu
	 * is displayed again.
	 */
	public void transactDeposit() {

		if (customerVerified) {
			System.out.println("Enter the amount to deposit: ");
			double amount = reader.getDoubleInput();
			currentCustomer.getAccount().addToBalance(amount);

		} else {

			System.out.println("ERROR: You must LOGIN before you can perform a transaction.");
			verifyCustomer();
		}
	}

	/**
	 * Performs a withdrawal from a BankCustomer's account. Checks to see if the
	 * user has signed in. If not, then verifyCustomer() is called and the menu
	 * is displayed again.
	 */
	public void transactWithdraw() {

		if (customerVerified) {
			System.out.println("Enter the amount to withdraw: ");
			double amount = reader.getDoubleInput();

			currentCustomer.getAccount().subtractFromBalance(amount);

		} else {

			System.out.println("ERROR: You must LOGIN before you can perform a transaction.");
			verifyCustomer();
		}

	}

	/**
	 * Performs a withdrawal from a BankCustomer's account. Checks to see if the
	 * user has signed in. If not, then verifyCustomer() is called and the menu
	 * is displayed again.
	 */
	public void displayAccountInformation() {

		if (customerVerified) {
			System.out.println("Here is your information.");
			Bank.displayCustomerInformation(currentCustomer);
		} else {

			System.out.println("ERROR: You must LOGIN before you can perform a transaction.");
			verifyCustomer();
		}

	}

	/**
	 * To confirm a BankCustomer's account number and passcode. Called when the
	 * user is required to sign in to the application. Will set a boolean so the
	 * user does not have to sign in again during the session.
	 */
	public void verifyCustomer() {
		if (customerVerified) {
			System.out.println("You are already Signed In.Do you wish to Sign out?(Y/N)");
			String input = reader.getStringInput();
			if (input.equals("y") || input.equals("Y")) {
				customerVerified = false;
				System.out.println("You are signed out from your account.");
				System.out.println("Welcome to Bullwinkle's Bank.");
			}
		} else {
			System.out.println("Enter Account Number: ");
			accountNumber = reader.getStringInput();
			System.out.println("Enter Passcode: ");
			passcode = reader.getStringInput();
			currentCustomer = Bank.theBank.get(accountNumber);
			if (accountNumber.equals("admin") && passcode.equals("admin")) {
				customerVerified = true;
				admin = true;
			} else {
				
				if (currentCustomer != null) {
					if (passcode.equals(Bank.theBank.get(accountNumber).getPasscode())) {
						admin = false;
						customerVerified = true;
						currentAccount = currentCustomer.getAccount();
					} else {
						System.out.println("ERROR: Either account number or passcode is not correct.");
						run();
					}
				} else {
					System.out.println("ERROR: Either account number or passcode is not correct.");
					run();

				}
			}
		}
	}

	/**
	 * Displays the final information for the current account along with the
	 * account transaction history. Then displays all the account data for all
	 * bank customer and terminates the program run.
	 */
	public void shutDown() {

		System.out.println("Thank you for banking at Bullwinkle's Bank");

		System.out.println("ACCOUNT SUMMARY:");
		Bank.displayCustomerInformation(currentCustomer);
		if(currentAccount!=null){
			currentAccount.displayAccountRecords();
		}
		System.out.println("");

		System.out.println("Displaying all the accounts in the bank.");
		Bank.displayAllCustomers();
		System.exit(0);
	}
}
