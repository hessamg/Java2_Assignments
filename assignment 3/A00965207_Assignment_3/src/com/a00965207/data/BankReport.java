package com.a00965207.data;

import java.util.Arrays;

/**
 * A00965207
 * 
 * @version 2016.06.27
 * @author Hessam Ganjian
 */
public class BankReport implements Reporter {

	/**
	 * Default constructor of BankReport.
	 */
	public BankReport() {

	}

	/**
	 * Will take a reference to the HashMap that contains all the Accounts in
	 * the bank and the prefix code that we used to identify each Account
	 * subtype. eg call. displayByCode(theBank, "gl") Only the account numbers
	 * that hold the prefix code specified will be displayed.
	 * 
	 * @param records
	 *            to set as Bank.
	 * @param prefix
	 *            to set as String.
	 */

	public void displayByCode(Bank records, String prefix) {
		if (prefix.equals("gl")) {
			for (BankCustomer customer : Bank.theBank.values()) {
				if (customer.getAccount().getAccountNumber().substring(0, 2).equals("GL")) {
					System.out.println(customer);
				}
			}
		} else if (prefix.equals("ch")) {
			for (BankCustomer customer : Bank.theBank.values()) {
				if (customer.getAccount().getAccountNumber().substring(0, 2).equals("CH")) {
					System.out.println(customer);
				}
			}
		} else if (prefix.equals("sa")) {
			for (BankCustomer customer : Bank.theBank.values()) {
				if (customer.getAccount().getAccountNumber().substring(0, 2).equals("SA")) {
					System.out.println(customer);
				}
			}
		} else {
			System.out.println("Wrong input.");
		}
	}

	/**
	 * Will display all the active Accounts in the bank. The output will be
	 * displayed sorted by account number.
	 * 
	 * @param records
	 *            to set as Bank.
	 */
	public void displayAllCodes(Bank records) {
		int count = 0;
		int i = 0;

		for (BankCustomer customer : Bank.theBank.values()) {
			if (customer.getAccount().isActive()) {
				count++;
			}
		}
		String[] accounts = new String[count];
		for (BankCustomer customer : Bank.theBank.values()) {
			if (customer.getAccount().isActive()) {
				accounts[i] = customer.getAccount().getAccountNumber();
				i++;
			}
		}
		Arrays.sort(accounts);
		System.out.println("The following account(s) is(are) active sorted by account number:");
		if (accounts.length == 0)
			System.out.println("No active accounts!");
		for (int j = 0; j < i; j++) {
			System.out.println(accounts[j]);
		}
	}

	/**
	 * Will display only the inactive accounts in the bank, sorted by account
	 * number descending.
	 * 
	 * @param records
	 *            to set as Bank.
	 */
	public void displayInactiveCodes(Bank records) {
		int count = 0;
		int i = 0;

		for (BankCustomer customer : Bank.theBank.values()) {
			if (!customer.getAccount().isActive()) {
				count++;
			}
		}
		String[] accounts = new String[count];
		for (BankCustomer customer : Bank.theBank.values()) {
			if (!customer.getAccount().isActive()) {
				accounts[i] = customer.getAccount().getAccountNumber();
				i++;
			}
		}
		Arrays.sort(accounts);
		System.out.println("The following account(s) is(are) inactive sorted by account number:");
		if (accounts.length == 0)
			System.out.println("All accounts are active!");
		for (int j = 0; j < i; j++) {
			System.out.println(accounts[j]);
		}
	}

	/**
	 * will display a formatted dollar value which is the sum of all account
	 * balances in the bank.
	 * 
	 * @param theBank
	 *            to set as Bank.
	 */
	public void displayAccountTotals(Bank theBank) {
		double sum = 0;
		for (BankCustomer customer : Bank.theBank.values()) {
			sum += customer.getAccount().getBalance();
		}
		System.out.println(String.format("The sum of all account balances in bank: $%1.2f", sum));
	}
}
