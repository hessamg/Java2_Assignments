package com.a00965207.accounts;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * A00965207
 * 
 * @version 2016.05.30
 * @author Hessam Ganjian
 */

public class Account {
	private double balance;
	private String accountNumber;
	private boolean active;
	private ArrayList<String> transaction;
	private String accountType;

	/**
	 * Default constructor for Account.
	 */
	public Account() {
		setActive(true);
		transaction = new ArrayList<String>();
	}

	/**
	 * Constructor for Account.The supertype. It will hold information common to
	 * all the subtypes.
	 * 
	 * @param accountNumber
	 *            - String to initialize the accountNumber field
	 */
	public Account(String accountNumber) {
		setAccountNumber(accountNumber);
		setActive(true);
		transaction = new ArrayList<String>();
	}

	/**
	 * Accessor method for the the balance field.
	 * 
	 * @return the balance as a double
	 */
	public double getBalance() {
		return Double.parseDouble(new DecimalFormat("#.00").format(balance));
	}

	/**
	 * Mutator for the the balance field.
	 * 
	 * @param balance
	 *            the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * Accessor method for the accountNumber field.
	 * 
	 * @return the accountNumber as a String
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Mutator for the accountNumber field.
	 * 
	 * @param accountNumber
	 *            the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		if (accountNumber != null && accountNumber.length() > 0) {
			this.accountNumber = accountNumber;
		}
	}

	/**
	 * @return the active as boolean.
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active
	 *            the active to set as boolean.
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * Adds to a BankCustomer's balance.
	 * 
	 * @param amount
	 *            a double to add to the existing balance field
	 */
	public void addToBalance(double amount) {
		if (amount > 0) {
			balance += amount;
			setTransaction(new Date() + " - deposit: $" + amount);
		}
	}

	/**
	 * Subtracts from a BankCustomer's balance.
	 * 
	 * @param amount
	 *            a double to subtract from the balance field
	 */
	public void subtractFromBalance(double amount) {
		if (amount <= balance && amount > 0) {
			balance -= amount;
			setTransaction(new Date() + " - withdrawal: $" + amount);
		}
	}

	/**
	 * Display all the transactions.
	 */
	public void listTransactions() {
		for (String transactions : transaction) {
			System.out.println(transactions);
		}
	}

	/**
	 * Adds to the transaction information.
	 * 
	 * @param info
	 *            the information to be added as String.
	 */
	public void setTransaction(String info) {
		if (info != null && info.length() > 0) {
			transaction.add(info);
		}
	}

	/**
	 * @return the accountType as String.
	 */
	public String getAccountType() {
		return accountType;
	}

	/**
	 * @param accountType
	 *            the accountType to set as String.
	 */
	public void setAccountType(String accountType) {
		if (accountType != null && accountType.length() > 0) {
			this.accountType = accountType;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return (", toString()=Account" + " [balance=" + getBalance() + ", accountNumber=" + getAccountNumber()
				+ ", active=" + isActive() + "]");
	}

}
