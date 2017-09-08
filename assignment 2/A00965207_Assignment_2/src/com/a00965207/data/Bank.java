package com.a00965207.data;
import java.util.HashMap;

/**
 * A00965207
 * 
 * @version 2016.05.30
 * @author Hessam Ganjian
 */

public class Bank {
	public static HashMap<String, BankCustomer> theBank;

	/**
	 * Default constructor for Bank class. Initializes the HashMap.
	 */
	public Bank() {
		theBank = new HashMap<String, BankCustomer>();
	}

	/**
	 * Add a new BankCustomer element to the HashMap.
	 * 
	 * @param newCustomer
	 *            The new element to add to the HashpMap using the account
	 *            number as the key and the new BankCustomer as the value.
	 */
	public void createAccount(BankCustomer newCustomer) {
		if (newCustomer != null) {
			theBank.put(newCustomer.getMyAccount().getAccountNumber(), newCustomer);
		}
	}

	/**
	 * Removes an BankCustomer from the HashMap.
	 * 
	 * @param accountNumber
	 *            The key of the element to remove from the HashMap.
	 */
	public void deactivate(String accountNumber) {
		if (accountNumber != null && accountNumber.length() > 0 && theBank.containsKey(accountNumber)) {
			theBank.get(accountNumber).getMyAccount().setActive(false);
			System.out.println("Account number " + accountNumber + " is deactivated.");
		} else {
			System.out.println("There is no such an account.\n");
		}
	}

	/**
	 * Gets the BankCustomer from the HashMap and adds a double amount to a
	 * BankCustomer's balance.
	 * 
	 * @param accountNumber
	 *            The account number of the BankCustomer.
	 * @param amount
	 *            The amount to deposit.
	 */
	public void deposit(String accountNumber, double amount) {
		if (accountNumber != null && accountNumber.length() > 0 && theBank.containsKey(accountNumber)) {
			theBank.get(accountNumber).getMyAccount().addToBalance(amount);
		} else {
			System.out.println("There is no such an account.\n");
		}
	}

	/**
	 * Gets the BankCustomer from the HashMap and subtracts an amount from a
	 * BankCustomer's balance as long as it does not leave a negative balance.
	 * 
	 * @param accountNumber
	 *            The account number of the BankCustomer.
	 * @param amount
	 *            The amount to subtract from a BankCustomer's balance.
	 */
	public void withdraw(String accountNumber, double amount) {
		if (accountNumber != null && accountNumber.length() > 0 && theBank.containsKey(accountNumber)) {
			theBank.get(accountNumber).getMyAccount().subtractFromBalance(amount);
		} else {
			System.out.println("There is no such an account.\n");
		}
	}

	/**
	 * Displays the details of a BankCustomer element in the HashMap. Uses
	 * BankCustomer.toString() implementation.
	 * 
	 * @param customer
	 *            the BankCustomer chosen to display.
	 */
	public static void displayCustomerInformation(BankCustomer customer) {
		if (customer != null) {
			System.out.println("ACCOUNT SUMMARY:");
			for (String key : theBank.keySet()) {
				{
					if (theBank.get(key).getMyAccount().getAccountNumber()
							.equals(customer.getMyAccount().getAccountNumber())) {
						System.out.println(theBank.get(key).toString());
					}
				}
			}
			System.out.println("Acount Activity:");
			for (String key : theBank.keySet()) {
				{
					if (theBank.get(key).getMyAccount().getAccountNumber()
							.equals(customer.getMyAccount().getAccountNumber())) {
						theBank.get(key).getMyAccount().listTransactions();
					}
				}
			}
		}
	}

	/**
	 * Displays all elements of the HashMap by using BankCustomer.toString()
	 * implementation of each.
	 */
	public static void displayAllCustomers() {
		if (!theBank.isEmpty()) {
			for (String acounts : theBank.keySet()) {
				System.out.println(theBank.get(acounts).toString());
			}
		} else {
			System.out.println("No Bank accounts yet.\n");
		}
	}

}
