package com.a00965207.data;

import java.util.HashMap;

/**
 * Bank class.
 * Supports a HashMap of customer accounts.
 * A00965207
 * 
 * @version 2016.06.27
 * @author Hessam Ganjian
 */
public class Bank {

	public static HashMap<String, BankCustomer> theBank;

	/**
	 * Default constructor for Bank class. Initializes the HashMap
	 */
	public Bank() {
		super();
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
			theBank.put(newCustomer.getAccount().getAccountNumber(),
					newCustomer);
		}
	}

	/**
	 * Deactivates a customer's account.
	 * 
	 * @param accountNumber
	 *            the account to be deactivated.
	 * 
	 */
	public void deactivate(String accountNumber) {

		if (accountNumber != null && !accountNumber.isEmpty()) {

			theBank.get(accountNumber).getAccount().setActive(false);

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

		if (accountNumber != null && amount > 0.0) {

			theBank.get(accountNumber).getAccount().addToBalance(amount);

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

		if (accountNumber != null && !accountNumber.isEmpty()) {

			if (amount != 0.0) {

				theBank.get(accountNumber).getAccount()
						.subtractFromBalance(amount);
			}
		}

	}

	/**
	 * Displays the details of a BankCustomer element in the HshMap. Uses
	 * BankCustomer.toString() implementation.
	 * 
	 * @param customer
	 *            the BankCustomer chosen to display.
	 */
	public static void displayCustomerInformation(BankCustomer customer) {
		if (customer != null) {
			System.out.println(customer);
		}
	}

	/**
	 * Displays all elements of the HashMap by using BankCustomer.toString()
	 * implementation of each.
	 */
	public static void displayAllCustomers() {

		for (BankCustomer customer : theBank.values()) {

			System.out.println(customer);

		}
	}

}
